package com.project.sprintplanner.sprint_planner.extras;

//@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password)
    {
        boolean isValidUsername = username.equalsIgnoreCase("Lakshya");
        boolean isValidPassword = password.equalsIgnoreCase("Sharma");

        return isValidUsername && isValidPassword;
    }

}
