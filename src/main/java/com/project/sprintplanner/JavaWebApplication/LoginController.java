package com.project.sprintplanner.JavaWebApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    /**
        Easiest Way to pass some information to specific URL -> "Query Parameter"
        @RequestParam : Indicates that a method parameter should be bound to a web request parameter
        localhost:8080/login?name=Lakshya (Does not need to use double quotes (""))
     */
    /**
        Model : Putting value which you want to pass from controller to JSP (View)
        Put the value in ModelMap -> Use the value in JSP using ${AttributeName} (Expression language)
        ModelMap : Implementation of java.util.Map for use when building model data for use with UI tools.
                    Supports chained calls and generation of model attribute names
     */
    @RequestMapping("login")
    public String goToLoginPage(@RequestParam String name, ModelMap modelmap)
    {
        System.out.println("Request Parameter is : " + name);
        // Use Logging in PROD
        //--------------------
        //          (AttributeName, Value)
        modelmap.put("name"       , name);
        return "LoginPage";
    }
}
