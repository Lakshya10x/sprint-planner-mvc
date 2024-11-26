package com.project.sprintplanner.sprint_planner;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public void deleteById(int id) {

        Predicate<? super Sprint> predicate = sprint -> sprint.getId()==id;
        sprints.removeIf(predicate);
    }


    public Sprint findById(int id) {
        Predicate<? super Sprint> predicate = sprint -> sprint.getId()==id;
        Sprint sprint = sprints.stream().filter(predicate).findFirst().get();
        return sprint;
    }

    public void updateSprint(@Valid Sprint sprint) {
        deleteById(sprint.getId());
        sprints.add(sprint);
    }
}
