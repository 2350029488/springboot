package com.example.webadmin.controller;

import com.example.webadmin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
//    设置首页方式1 通过thyealf请求处理 / 的方式返回视图名称
    @GetMapping("/")
    public String loginPage(Model model){
        model.getAttribute("msg");
        return "login";
    }

    @PostMapping("/login")
    public String mainPages(User user, Model model, HttpSession session){
if (StringUtils.hasLength(user.getUserName())&&StringUtils.hasLength(user.getPassword())){
 //密码和用户名都不为空才跳转
    //        重定向到main 防止重复提交
    session.setAttribute("loginUser",user);//注意是一次会话 通过Session

    /*  前端行内写法不在标签中 获取值  [[${session.loginUser.userName}]]*/

    return "redirect:/main";
}else {
//    传递错误信息用model
    model.addAttribute("msg","填的信息错误");
    return "login";
}
    }



    /*解决form表单重复提交*/
    @GetMapping("/main")
    public String mainPage(HttpSession session,Model model){
        return "main";
    }


    /**
     * 测试jdbc返回数据 StatViewServlet视图信息  还要在数据库连接中配置   dataSource.setFilters("stat");
      */

    @Autowired
    @Qualifier(value = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @ResponseBody
            @RequestMapping(value = "/sql",method = RequestMethod.GET)
            public String queryFormBook(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select *from book");
        return maps.toString();
    }

}
