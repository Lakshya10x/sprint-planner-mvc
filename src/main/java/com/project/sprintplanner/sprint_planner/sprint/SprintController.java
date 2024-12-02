package com.project.sprintplanner.sprint_planner.sprint;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@Controller
//@SessionAttributes("name")
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
        String name = getLoggedInUsername(modelMap);
        List<Sprint> sprints = sprintService.findByUsername(name);
        modelMap.put("sprints",sprints);
        return "ShowSprints";
    }

    @RequestMapping(value = "add-sprint",method = RequestMethod.GET)
    public String showNewSprintPage(ModelMap modelMap)
    {
        String username = (String) modelMap.get("name");
        Sprint sprint1 = new Sprint(null,username,"","", LocalDate.now(),LocalDate.now(),false);
        modelMap.put("sprint",sprint1);
//        modelMap.addAttribute("sprint",new Sprint());
        return "NewSprint";
    }

    @RequestMapping(value = "add-sprint",method = RequestMethod.POST)
    public String addNewSprint(ModelMap modelMap, @Valid Sprint sprint, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "NewSprint";
        }
        String username = getLoggedInUsername(modelMap);
        sprintService.addSprint(username,sprint.getSprintName(),sprint.getGoal(),sprint.getStartDate(),sprint.getEndDate(),sprint.isStatus());
        return "redirect:show-sprints";
    }

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
        String username = getLoggedInUsername(modelMap);
        sprint.setUsername(username);
        sprintService.updateSprint(sprint);
        return "redirect:show-sprints";
    }

    private String getLoggedInUsername(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}
