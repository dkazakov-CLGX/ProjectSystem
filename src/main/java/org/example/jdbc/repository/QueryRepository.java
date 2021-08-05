package org.example.jdbc.repository;

import org.example.jdbc.model.BaseModel;

import java.util.List;

public interface QueryRepository <ID,T extends BaseModel<ID>>{

    List<T> getDevelopersByActivity(String activity);

    List<T> getDevelopersByLevel(String level);

    Object getSumSalariesByProjectID(Long id);

    List<String> projectsWithCountDevelopers();

    List<Long> getDevelopersByProjectID(Long id);

}
