package com.example.webadmin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class Junit参数化测试 {
    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})/*传递值  */
    void testParameterizedTest(int i){/*接收*/
        System.out.println(i);
    }

/*   参数从方法里面来 */
    @ParameterizedTest
    @DisplayName("参数化测试")
    @MethodSource("stringProvider")
    void testParameterizedTest2(String str){/*接收*/
        System.out.println(str);
    }
/*  传递参数   @MethodSource("stringProvider")  */
    static Stream<String> stringProvider(){
        return Stream.of("ssss","dddd","fffff");
    }
}
