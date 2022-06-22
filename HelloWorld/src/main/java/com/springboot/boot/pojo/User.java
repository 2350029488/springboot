package com.springboot.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get set toString
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造  查看点击左边Structrue
public class User {
    private String name;
    private Integer age;
    private Animal animal;

}
