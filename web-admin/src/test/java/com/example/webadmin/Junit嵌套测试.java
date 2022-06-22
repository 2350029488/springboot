package com.example.webadmin;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 *   被@Nested 注解了的表示是嵌套测试
 */
@DisplayName("A stack")
class Junit嵌套测试 {

    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
        //虽然写了@BeforeEach 但是是在WhenNew类里，不能执行，所以这个stack为null
        /*外出的Test不能驱动内层的Before(After)Each/All之内的方法*/
        /*内层的可以驱动外层的*/
        assertNull(stack);
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                /*  外层new了对象 内层放了元素，说明对象里面有值不为空*/

                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                /*现在是不为空的 因为 @BeforeEach
                      void pushAnElement() 放了元素{*/
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                /*上一步把栈里面的元素弹出 stack.pop() 导致对象里面又重新为空*/
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                /* stack.peek()只看元素不移除 所以里面还有*/
                assertEquals(anElement, stack.peek());

                assertFalse(stack.isEmpty());
            }
        }
    }
}
