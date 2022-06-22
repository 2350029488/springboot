package com.example.webadmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试断言机制
 *
 * 前面的断言失败，后面的断言会不执行
 */
@SpringBootTest
public class JunitAssertionsTest {
    @Test
    void testSimpleAssertions(){
        int cal = cal(2, 3);
/* assertEquals 断言相等  expected预期值 与实际值相比是否相等, 不相等返回消息 */
        assertEquals(5,cal,"两个数值不相等");

     Object obj1=new Object();
     Object  obj2=new Object();
/*assertSame 判断对象是否相等*/
     assertSame(obj1,obj1,"这两个对象不相等");

    }
/*   assertArrayEquals 测试数组是否相等*/
    @Test
    public void testArray(){
        assertArrayEquals(new int[]{1,2},new int[]{1,2},"数组不相等");
    }


/**组合断言   断言全部成功才能往下走*/
    @Test
    @DisplayName("组合断言")
    public void all(){
        assertAll("test",
                ()->assertTrue(true&&true,"结果不为true"),
                ()->assertEquals(1,1,"结果不是1"));
        System.out.println("========");
    }


  /**异常断言 assertThrows  断言业务逻辑一定出现异常 （这里是有异常才不显示）*/
    @Test
    @DisplayName("异常断言")
    public void testException(){
        assertThrows(ArithmeticException.class,()->{
            int i=1/0;
            },
                "业务逻辑是否正常?");
    }

/** fail 测试失败 */
    @Test
    @DisplayName("快速失败")
    void testFail(){
        if (2==1){
            fail("测试失败");
        }
    }

    public int cal(int x,int y){
        return x+y;
    }

    /**
     * 测试前置条件  假设的意思
     */
    @DisplayName("测试前置条件")
    @Test
    void testassumptions(){
        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("1111111");
    }
}
