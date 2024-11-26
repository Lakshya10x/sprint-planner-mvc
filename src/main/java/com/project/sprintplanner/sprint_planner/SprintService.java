package com.project.sprintplanner.sprint_planner;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SprintService {

    private static int sprintCount =0;
    private static List<Sprint> sprints = new ArrayList<>();
    static {
            sprints.add(new Sprint(1,"Lakshya","Hamburger-Menu","Reflects the Sprint-Planner application's functionalities and sub-functionalities under the hood", LocalDate.now().plusDays(2),LocalDate.now().plusMonths(1),false));
            sprints.add(new Sprint(2,"Madhav","Dynamic Design","Upgrade the website's design dynamically", LocalDate.now().plusDays(10),LocalDate.now().plusMonths(1),false));

    }

    public void addSprint(String username, String sprintName, String goal, LocalDate startDate, LocalDate endDate, boolean status)
    {
        Sprint sprint = new Sprint(++sprintCount, username,sprintName,goal,startDate,endDate,status);
        sprints.add(sprint);
    }
    public List<Sprint> findByUsername(String username)
    {
        return sprints;
    }

}
