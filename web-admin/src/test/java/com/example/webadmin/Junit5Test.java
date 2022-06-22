package com.example.webadmin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@DisplayName("测试DisplayName注解")
public class Junit5Test {

    /*测试注解显示名称 DisplayName*/
    @DisplayName("测试DisplayName注解")
    @Test
    void TestDisplayName(){
        System.out.println(1);
    }

     @Disabled//表示这个方法不执行测试 类似注释掉   输出:void com.example.webadmin.Junit5Test.test2() is @Disabled
     @DisplayName("测试2")
     @Test
      void  test2(){
     System.out.println(2);
 }
 /*RepeatedTest重复测试 数值表示测试次数*/
 @RepeatedTest(value = 5)
   @Test
   void test3(){
       System.out.println(5);
   }



/*在测试运行之前 先运行这个注解的方法*/
    @BeforeEach
    void testBeforeEach(){
        System.out.println("在测试运行之前，，，");
    }

/*在测试运行之后 后运行这个注解的方法*/
    @AfterEach
    void testAfterEach(){
        System.out.println("在测试运行之后。。。。");
    }
/*在所有测试之前运行 要是静态的 */
    @BeforeAll
    static void  testBeforeAll(){
        System.out.println("在所有测试之前运行");
    }
    /*在所有测试之运后行 要是静态的 */
    @AfterAll
    static void testAfterAll(){
        System.out.println("在所有测试之后运行");
    }

    /*超时时间 数值+单位  超出时间 出现异常TimeoutException */
    @Timeout(value = 500,unit = TimeUnit.HOURS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(50);
    }
}
