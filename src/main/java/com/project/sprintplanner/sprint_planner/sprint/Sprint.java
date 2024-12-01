package com.project.sprintplanner.sprint_planner.sprint;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Sprint {

    private Integer id;

//    @NotNull
    private String username;
    @Size(min = 1,max = 100,message = "Sprint Name must be between 1 and 100 characters")
    private String sprintName;
    @Size(max = 255, message = "Goal must not exceed 255 characters")
    private String goal;
    @NotNull(message = "Date must not be null")
    @FutureOrPresent(message = "Date must be in the present or in future")
    private LocalDate startDate;
    @NotNull(message = "Date must not be null")
    @FutureOrPresent(message = "Date must be in the present or in future")
    private LocalDate endDate;
    private boolean status;

    public Sprint() {
    }

    public Sprint(Integer id, String username, String sprintName, String goal, LocalDate startDate, LocalDate endDate, boolean status) {
        this.id = id;
        this.username = username;
        this.sprintName = sprintName;
        this.goal = goal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sprintName='" + sprintName + '\'' +
                ", goal='" + goal + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
