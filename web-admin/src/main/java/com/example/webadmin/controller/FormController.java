package com.example.webadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 */
@Slf4j
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }


    /**
     * MultipartFile或自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName")String username,

                         //获取文件的注解
                         @RequestPart("headerImg")MultipartFile  headerImg,
                         //获取多个文件
                         @RequestPart("photos")MultipartFile[]  photos, HttpSession session

                         ) throws IOException {

        log.info("上传的信息:email={},username={},headerImg={},photos={}",email,username,headerImg.getSize(),photos.length);

        /*把文件保存到电脑里*/
        if (!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();

            //防止文件重名 通过uuid设置文件名的前缀为随机字符
            String suffixFileName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString().replaceAll("-","")+suffixFileName;

            headerImg.transferTo(new File("C:\\Users\\23500\\Desktop\\测试文件\\ss\\"+fileName));
        }
        if (photos.length>0){
            for (MultipartFile photo: photos) {
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    //防止文件重名 通过uuid设置文件名的前缀为随机字符
                    String suffixFileName = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String fileName = UUID.randomUUID().toString().replaceAll("-","")+suffixFileName;
                    photo.transferTo(new File("C:\\Users\\23500\\Desktop\\测试文件\\ss\\"+fileName));
                }
            }
        }
        return "redirect:/main";

    }
}
