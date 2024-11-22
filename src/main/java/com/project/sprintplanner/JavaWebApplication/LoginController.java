package com.project.sprintplanner.JavaWebApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class LoginController {

    /**
        Easiest Way to pass some information to specific URL -> "Query Parameter"
        @RequestParam : Indicates that a method parameter should be bound to a web request parameter
        localhost:8080/login?name=Lakshya (Does not need to use double quotes (""))
     */
    /**
        Model : Putting value which you want to pass from controller to JSP (View)
        Put the value in ModelMap -> Use the value in JSP using ${VariableName} (Expression language)
        ModelMap : Implementation of java.util.Map for use when building model data for use with UI tools.
                    Supports chained calls and generation of model attribute names
     */
//    @RequestMapping("login")
    public String goToLoginPage(@RequestParam String name, ModelMap modelmap)
    {
        System.out.println("Request Parameter is : " + name);
        // Use Logging in PROD
        //--------------------
        //          (AttributeName, Value)
        modelmap.put("name"       , name);
        return "LoginPage";
    }

    /**
        Right imports : org.slf4j.Logger; & org.slf4j.LoggerFactory;
        Based on the logging level defined in application.properties, all the things below that level will be printed.
        However, Logger -> Able to control the level.
        Don't want to use debug information -> Change the logging level
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("login")
    public String openLoginPage(@RequestParam String name, ModelMap modelmap)
    {
        modelmap.put("name", name);
        logger.info("Printed at INFO level");
        logger.warn("Printed at WARN level");
        logger.debug("Request Param is {}",name);

        // By SOP, you cannot configure the level's or anything like that
        return "LoginPage";
    }
}
