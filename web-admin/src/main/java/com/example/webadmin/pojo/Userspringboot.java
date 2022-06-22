package com.example.webadmin.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/* mybatis-plus和其他一样，默认类名就是表名 如果哪天表名改了，
* 但不想改pojo 那么就在这张表上注解  @TableName("userspringboot")*/
//@TableName("userspringboot")
public class Userspringboot {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
