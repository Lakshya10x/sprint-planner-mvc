package com.project.sprintplanner.JavaWebApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingsController {

    /**
        @RequestMapping : Mapping web requests onto methods in request-handling classes with flexible method signature.

        Note : What Spring MVC does is, when you return a string back, it will be looking for a "view" with the specific name.
                It will not return this string back as ease.

        @ResponseBody : Indicates a methods return value should be bound to the web response body. (Supported for annotated handler methods)
                        It return whatever returned by this message as is to the browser.
     */
    @RequestMapping("greetings")
    @ResponseBody
    public String sayHello()
    {
        return "Hello there ! Happy Learning";
    }

    @RequestMapping("greetingsUsingHTML")
    @ResponseBody
    public String sayHelloUsingHTML()
    {
        /**
            For HTML -> use string directly, however appending strings is not efficient
            USE "StringBuffer" & "StringBuilder"
         **/

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>First Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Greeting Web Page");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }
}
