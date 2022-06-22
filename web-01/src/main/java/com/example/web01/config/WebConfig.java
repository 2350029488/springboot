package com.example.web01.config;

import com.example.web01.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {
    //自定义 filter
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter=new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
   return new WebMvcConfigurer() {
       /**
        * 设置矩阵变量 不移除 ; 后面的内容  矩阵变量功能就可以生效
        * @param configurer
        */
         @Override
         public void configurePathMatch(PathMatchConfigurer configurer) {
            UrlPathHelper urlPathHelper=new UrlPathHelper();
            //不移除 ; 后面的内容  矩阵变量功能就可以生效
            urlPathHelper.setRemoveSemicolonContent(false);
            configurer.setUrlPathHelper(urlPathHelper);
         }


       /**   这个转换器还可以转换日期格式
        * 设置转换器   宠物： <input name="pet" value="啊猫,3"/>-->
        *     当name为对象时，值为String类型的字符串 且数值对应对象的字段，将这个字符串进行分割后再赋值 需要设置转换器
        *     将 ,进行分割
        * @param registry
        */
       @Override
       public void addFormatters(FormatterRegistry registry) {
                            /*    将String类型转为Pet    */
        registry.addConverter(new Converter<String, Pet>() {
            @Override
                 /**  source就是前端传过来的值 啊猫,3*/
            public Pet convert(String source) {
                //如果不为空
                if (!StringUtils.isEmpty(source)){
                    String[] split = source.split(",");
                    //创建name的对象 也就是Pet 将值进行赋值 并返回这个对象
                    Pet pet=new Pet();
                    pet.setName(split[0]);
                    pet.setAge(Integer.parseInt(split[1]));
                    return pet;
                }
                //没有返回null
               return null;
            }
        });
       }
   };
    }


//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper=new UrlPathHelper();
//        //不移除 ; 后面的内容  矩阵变量功能就可以生效
//         urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}
