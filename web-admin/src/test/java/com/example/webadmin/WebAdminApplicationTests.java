package com.example.webadmin;

import com.example.webadmin.mapper.UserspringbootMapper;
import com.example.webadmin.pojo.Userspringboot;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
/**@SpringBootTest的底层注解
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 */
@SpringBootTest
class WebAdminApplicationTests {

    /**
     * 爆红是idea的检查机制  不影响  (这个是spring自己的，不是我写的所以idea会以为没有)
     */
    @Autowired
    @Qualifier(value = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserspringbootMapper userspringbootMapper;


    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from book", Long.class);
        log.info("记录总数:{}",aLong);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select *from book");
        log.info("数据:{}",maps);

        log.info("数据源类型:{}",dataSource.getClass());
        //class com.alibaba.druid.pool.DruidDataSource
    }

    /***
     * 测试mybatis-plus
     */
    @Test
    public void testuserspringbootMapper(){
        Userspringboot userspringboot = userspringbootMapper.selectById(1);
        log.info("用户信息:{}",userspringboot);
    }
}
