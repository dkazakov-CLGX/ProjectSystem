package org.example.jdbc.services;

import lombok.SneakyThrows;
import org.example.jdbc.model.Project;
import org.example.jdbc.repository.CrudRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class ProjectServiceImpl extends SqlConnection<Project> implements CrudRepository<Long, Project> {

    public ProjectServiceImpl() {
        super("projects", "name", "company_id", "customer_id", "cost","firstDate");
    }

    @SneakyThrows
    @Override
    public List<Project> findAll() {
        return parse(getFindAllPreparedStatement().executeQuery());
    }

    @SneakyThrows
    @Override
    public Project findByID(Long id) {
      //  List<Project> parse = parse(getFindByIDPreparedStatement().executeQuery());
        return null;//parse.get(Math.toIntExact(id));
    }

    @SneakyThrows
    @Override
    public Project creat(Project project) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MySqlGoItHomeWork.projects(id,name,company_id,customer_id,cost,firstDate) VALUES (?,?,?,?,?,?)");
        preparedStatement.setLong(1, project.getId());
        preparedStatement.setString(2, project.getName());
        preparedStatement.setLong(3, project.getCompanyID());
        preparedStatement.setLong(4, project.getCustomerID());
        preparedStatement.setLong(5, project.getCost());
        preparedStatement.setString(5, project.getFirstDate());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return project;
    }

    @SneakyThrows
    @Override
    public Project update(Long id, Project project) {
        PreparedStatement projectUpdate = connection.prepareStatement("UPDATE MySqlGoItHomeWork.projects set name=?,company_id=?,customer_id=?,cost=? WHERE id=" + id + ";");
        projectUpdate.setString(1, project.getName());
        projectUpdate.setLong(2, project.getCompanyID());
        projectUpdate.setLong(3, project.getCustomerID());
        projectUpdate.setLong(4, project.getCost());
        projectUpdate.executeUpdate();
        projectUpdate.close();
        return project;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
       // parse(getDeletePreparedStatement().executeQuery());
    }
}
