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

    /**
        Even with HTML - things are getting complex -> For Building web applications -> Go For "Views"
        Most popular / Earliest view technology is "JSP" -> "Java-Server-Pages"
        Folder : src/main/resources/META-INF/resources/WEB-INF/jsp/GreetingsPage.jsp
        "jsp" folder -> View Folder & "GreetingsPage.jsp" -> View File

        Review :
        1. Sending request to /greetings-jsp
        2. Handled by GreetingsController
        3. greetingsJsp methods is mapped/handling the request to this URL
        4. It is returned Name of JSP
        5. Spring MVC makes use of "View Resolver" & view resolver is configured in application.properties by prefix and suffix
        6. Finally the request is then redirected to this specific Jsp.
     */

    @RequestMapping("greetings-jsp")
    public String greetingsJsp()
    {
        return "GreetingsPage";
        //      JSP Name / View Name -> Name is changing mostly, that's why we want to store the constant part in properties file.
    }


}
