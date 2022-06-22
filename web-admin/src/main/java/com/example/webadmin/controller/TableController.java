package com.example.webadmin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.webadmin.mapper.UserspringbootMapper;
import com.example.webadmin.pojo.User;
import com.example.webadmin.pojo.Userspringboot;
import com.example.webadmin.serveice.UserspringbootServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    UserspringbootServeice userspringbootServeice;


    @GetMapping("/basic_table")
    public String basic_table(){
        System.out.println("kkkk");
//        int x=10/0;
        return "table/basic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn" ,defaultValue = "1")Integer pn, Model model){
        /*
        * 从数据库中查出userspringboot表的数据
        * */
//        List<Userspringboot> list = userspringbootServeice.list();
//        model.addAttribute("list",list);
/**
 * mybatis-plus 进行分页查询 （需要配置分页插件功能）
 */
        /*分页查询数据*/
        Page<Userspringboot> page = new Page<>(pn, 2);

        /*分页查询的结果*/
        Page<Userspringboot> page1 = userspringbootServeice.page(page, null);

        model.addAttribute("page",page1);
        return "table/dynamic_table";
    }


    @GetMapping("deleteById")
    public String deleteById(@RequestParam("id")Integer id,
                             @RequestParam("pn")Integer pn,
                             RedirectAttributes redirectAttributes){
    userspringbootServeice.removeById(id);

        /*重定向后的页面有参数 这里通过删除后携带当前页的页码，删除后页面还是跳转至当前页*/
        redirectAttributes.addAttribute("pn",pn);

    //回到当前页
    return "redirect:/dynamic_table";

    }








    @GetMapping("/responsive_table")
    public String responsive_table(){
        System.out.println("llll");
        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
