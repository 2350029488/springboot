package com.example.web01.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.reactive.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @RequestMapping("/1.jpg")
    public String method(){
        return "aaaaa";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE-张三";
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> mehtod(
            @PathVariable("id")Integer id,
            @PathVariable("username")String username,
                                      /*可以直接键值对形式获取占位符的参数*/
                                      @PathVariable Map<String,String> pv,/*map只能是String类型*/
                                      /*获取请求头*/
                                      @RequestHeader("User-Agent") String herder,
                                      /*获取请求头的集合*/
                                      @RequestHeader() Map<String,String> herders,
                                      /*获取Cookie的值*/
                                      @CookieValue("Webstorm-3a25bc2f") String Webstorm,
            //测试页面index的链接
            @RequestParam("age")Integer age,
            @RequestParam("inters")List<String> inters,
            @RequestParam MultiValueMap<String,String> params//MultiValueMap获取多个参数


            )


    {
        Map<String,Object> map=new HashMap<>();
//        map.put("id",id);
//        map.put("username",username);
//        map.put("pv",pv);       //{"pv":{"id":"2","username":"张三"}}
//        map.put("herder",herder);
//        map.put("map",herders);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("Webstorm",Webstorm);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(          /*请求体，争对post的表单提交*/
                               @RequestBody String content
                                           ){
        Map<String,Object> map=new HashMap<>();
        map.put("content",content);
        return map;
    }


    /*   ; 后面表示参数名     */
//1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
//2、SpringBoot默认是禁用了矩阵变量的功能
//      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
//              removeSemicolonContent（移除分号内容）支持矩阵变量的
//3、矩阵变量必须有url路径变量才能被解析
    //     <a href="/cars/sell;low=34;brand=byd,audi,yd">
    @GetMapping("/cars/{path}")  //矩阵变量应当绑定在路径变量中 所以这里写{path}
    public Map methods( @MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand ,
                         @PathVariable("path")String path){
        Map<String,Object> map=new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
//<a href="/boss/1;age=20/2;age=10">
    //如果两个地址的参数名一致    pathVar ="one" 表示第几个参数
    @GetMapping("/boss/{one}/{two}")
    public Map methodss(
                     @MatrixVariable(name = "age",pathVar ="one" )String age1,
                     @MatrixVariable(value = "age",pathVar = "two")String age2
    ){
        Map<String,Object> map=new HashMap<>();
        map.put("age1",age1);
        map.put("age2",age2);
        return map;
    }

}

