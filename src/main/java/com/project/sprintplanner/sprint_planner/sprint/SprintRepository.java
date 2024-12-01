package com.project.sprintplanner.sprint_planner.sprint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint,Integer> {
    List<Sprint> findByUsername(String username);
}
