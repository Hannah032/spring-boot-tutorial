package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example01Controller {
    @GetMapping("/exam01")
    public String requestMethod1(Model model) {
        Logger logger = LoggerFactory.getLogger(Example01Controller.class);

        logger.trace("Trace 메세지");
        logger.debug("debug 메세지");
        logger.info("info 메세지");
        logger.warn("warn 메세지");
        logger.error("error 메세지");

        model.addAttribute("data", "Slf4j example");
        return "viewPage";
    }
}
