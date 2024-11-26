package com.project.sprintplanner.sprint_planner;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class SprintController {

    private SprintService sprintService;

    public SprintController(SprintService sprintService)
    {
        super();
        this.sprintService = sprintService;
    }

    @RequestMapping(value = "show-sprints")
    public String showAllSprints(ModelMap modelMap)
    {
        String name = (String) modelMap.get("name");
        List<Sprint> sprints = sprintService.findByUsername(name);
        modelMap.put("name",name);
        modelMap.put("sprints",sprints);
        return "ShowSprints";
    }

    /**
     Neither BindingResult nor plain target object for bean name 'sprint' available as request attribute.
     This error occurs when Spring MVC cannot find the model attribute (object) that should be used to bind form data.
     It means that the framework expects an object named sprint (as specified in the modelAttribute attribute of the form tag),
     but that object was not added to the model. As a result, Spring cannot bind the form data to any object, leading to the error.
     */
    @RequestMapping(value = "add-sprint",method = RequestMethod.GET)
    public String showNewSprintPage(ModelMap modelMap)
    {
//        String username = (String) modelMap.get("name");
//        Sprint sprint1 = new Sprint(null,username,"Hover Menu","",LocalDate.now().plusYears(1),LocalDate.now().plusDays(2),false);
//        modelMap.put("sprint",sprint1);
        modelMap.addAttribute("sprint",new Sprint());
        return "NewSprint";
    }
//    @RequestMapping(value = "add-sprint",method = RequestMethod.GET)
//    public String showNewSprintPage(@ModelAttribute("sprint") Sprint sprint)
//    {
//        return "NewSprint";
//    }

    /**
        Below, when the form fields values are entered, we're binding to "addNewSprint" method(SprintController) using @RequestParam
        But it becomes complex when you've 10 fields or more, we would need to add 10 such @RequestParam

        Solution : Directly bind to the "Sprint" bean
        For whatever form in SITE, we're using Sprint bean as the Backing Object or the Command Bean
     */
//    @RequestMapping(value = "add-sprint",method = RequestMethod.POST)
//    public String addNewSprint(@RequestParam String sprintName,
//                               @RequestParam String goal,
//                               @RequestParam LocalDate startDate,
//                               @RequestParam LocalDate endDate,
//                               @RequestParam boolean status,
//                               ModelMap modelMap)
//    {
//        sprintService.addSprint((String) modelMap.get("name"),sprintName,goal,startDate,endDate,status);
//        return "redirect:show-sprints";
//    }

    /**
        IMP Thing -> Put ModelMap as 1st parameter and Sprint bean as 2nd parameter
        Instead of binding to ModelMap, we're telling Spring MVC to bind directly to the "Sprint" Bean.

        To configure a form backing object in JSP : Use "Spring form tag libraries"
        Add this directive url present in configuration to top of your JSP Page :
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        These form tags makes jsp easy to develop and maintain.
     */
    /**
     * you do not necessarily need to specify @ModelAttribute("sprint") in the @PostMapping method
        if the parameter name matches the modelAttribute name in your form.
        Spring automatically binds the form data to the method parameter based on the form's modelAttribute
        and the name of the parameter.

        BindingResult : Is an object in Spring Framework that holds the result of data binding btw a web request and a Java Bean Object.
                        helps in capturing & handling errors that may occur during binding

     */
    @RequestMapping(value = "add-sprint",method = RequestMethod.POST)
    public String addNewSprint(ModelMap modelMap, @Valid Sprint sprint, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "NewSprint";
        }
        String username = (String) modelMap.get("name");
        sprintService.addSprint(username,sprint.getSprintName(),sprint.getGoal(),sprint.getStartDate(),sprint.getEndDate(),sprint.isStatus());
        return "redirect:show-sprints";
    }

    /**
        To send the id which we want to delete as part of our href in "ShowSprints" page as a part of our URL
        Use -> Query Parameter (Because id is not sensitive data) : delete-sprint?id=${sprint.id}
     */

    @RequestMapping("delete-sprint")
    public String deleteSprint(@RequestParam int id)
    {
        sprintService.deleteById(id);
        return "redirect:show-sprints";
    }

    @RequestMapping(value = "update-sprint",method = RequestMethod.GET)
    public String showUpdateSprintPage(@RequestParam int id, ModelMap modelMap)
    {
        Sprint sprint = sprintService.findById(id);
        modelMap.addAttribute(sprint);
        return "NewSprint";
    }

    @RequestMapping(value = "update-sprint", method = RequestMethod.POST)
    public String updateSprint(ModelMap modelMap,@Valid Sprint sprint, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "NewSprint";
        }
        String username = (String) modelMap.get("name");
        sprint.setUsername(username);
        sprintService.updateSprint(sprint);
        return "redirect:show-sprints";
    }


}
