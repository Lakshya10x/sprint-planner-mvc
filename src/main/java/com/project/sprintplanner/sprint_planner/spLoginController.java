package com.project.sprintplanner.sprint_planner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class spLoginController {

    /**
        Entering name and password -> the values will be going as part of our query parameter.
        Inspect > Network > Doc
        Headers -> Request Method: GET
        All the info is sent as part of your URL and this is not secure
        Payload : Query parameter
        Sending info in URL is not secure, over the internet there are number of routers nd these can see this URL

        Any secure information you would want to send out to a website -> "POST"
        ALWAYS USE "POST" FOR FORMS
        Headers : Request Method: POST
        Payload : Form Data
     */

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String openLoginPage()
    {
        return "LoginPage";
    }

    /**
        For "Query Param" or "Form Data" -> Use @RequestParam
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String openGreetingsPage(@RequestParam String name,
                                    @RequestParam String password,
                                    ModelMap modelMap)
    {
        modelMap.put("name",name);
        modelMap.put("password",password);
        return "GreetingsPage";
    }

}
