package com.github.gxboard.springdatajdbcmybatis.lego.ui;

import com.github.gxboard.springdatajdbcmybatis.lego.domain.model.LegoSet;
import com.github.gxboard.springdatajdbcmybatis.lego.domain.model.LegoSetRepository;
import com.github.gxboard.springdatajdbcmybatis.lego.domain.model.Manual;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LegoController {
    private LegoSetRepository repository;

    @RequestMapping("/lego")
    public List<LegoSet> list() {
        return (List<LegoSet>) repository.findAll();
    }

    @RequestMapping("/lego-save")
    public void add() {
        LegoSet smallCar = new LegoSet();
        smallCar.setName("Small Car 01");
        smallCar.setManual(new Manual("Just put all the pieces together in the right order", "Jens Schauder"));
        smallCar.addModel("suv", "SUV with sliding doors.");
        smallCar.addModel("roadster", "Slick red roadster.");

        repository.save(smallCar);

    }

}
