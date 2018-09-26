package com.github.gxboard.springdatajdbcmybatis;


import com.github.gxboard.springdatajdbcmybatis.lego.domain.model.LegoSet;
import com.github.gxboard.springdatajdbcmybatis.lego.domain.model.LegoSetRepository;
import com.github.gxboard.springdatajdbcmybatis.lego.domain.model.Manual;
import com.github.gxboard.springdatajdbcmybatis.lego.domain.model.Output;
import com.github.gxboard.springdatajdbcmybatis.springconfig.MyBatisConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisConfiguration.class)
@AutoConfigureJdbc
@MybatisTest
public class SpringDataJdbcMybatisApplicationTests {

    @Autowired
    LegoSetRepository repository;

    private static LegoSet createLegoSet() {

        LegoSet smallCar = new LegoSet();
        smallCar.setName("Small Car 01");
        return smallCar;
    }

    @Test
    public void contextLoads() {

        LegoSet smallCar = createLegoSet();

        smallCar.setManual(new Manual("Just put all the pieces together in the right order", "Jens Schauder"));
        smallCar.addModel("suv", "SUV with sliding doors.");
        smallCar.addModel("roadster", "Slick red roadster.");
        repository.save(smallCar);

        assertThat(smallCar.getId()).isNotNull();
        assertThat(repository.findById(smallCar.getId()).get().getModels()).hasSize(2);

        Output.list(repository.findAll(), "Original LegoSet");

        smallCar.getManual().setText("Just make it so it looks like a car.");
        smallCar.addModel("pickup", "A pickup truck with some tools in the back.");

        repository.save(smallCar);

        Output.list(repository.findAll(), "Updated");

        smallCar.setManual(new Manual("One last attempt: Just build a car! Ok?", "Jens Schauder"));

        repository.save(smallCar);

        Output.list(repository.findAll(), "Manual replaced");

    }

}
