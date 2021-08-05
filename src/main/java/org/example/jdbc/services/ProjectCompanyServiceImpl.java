package org.example.jdbc.services;

import lombok.SneakyThrows;
import org.example.jdbc.model.ProjectCompany;
import org.example.jdbc.repository.CrudRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class ProjectCompanyServiceImpl extends SqlConnection<ProjectCompany> implements CrudRepository<Long, ProjectCompany> {

    public ProjectCompanyServiceImpl() {
        super( "developers_projects", "developer_id","project_id");
    }

    @SneakyThrows
    @Override
    public List<ProjectCompany> findAll() {
        return parse(getFindAllPreparedStatement().executeQuery());
    }

    @SneakyThrows
    @Override
    public ProjectCompany findByID(Long id) {
      //  List<ProjectCompany> parse = parse(getFindByIDPreparedStatement().executeQuery());
        return null;// parse.get(Math.toIntExact(id));
    }

    @SneakyThrows
    @Override
    public ProjectCompany creat(ProjectCompany projectCompany) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MySqlGoItHomeWork.projects_companies (project_id, company_id) VALUES (?,?)");
        preparedStatement.setLong(1, projectCompany.getProjectID());
        preparedStatement.setLong(2, projectCompany.getCompanyID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return projectCompany;
    }

    @SneakyThrows
    @Override
    public ProjectCompany update(Long id, ProjectCompany projectCompany) {
        PreparedStatement projectCompanyProjectUpdate = connection.prepareStatement("UPDATE MySqlGoItHomeWork.projects_companies set company_id=? WHERE project_id=" + id + ";");
        projectCompanyProjectUpdate.setLong(1, projectCompany.getCompanyID());
        projectCompanyProjectUpdate.executeUpdate();
        projectCompanyProjectUpdate.close();
        return projectCompany;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
      //  parse(getDeletePreparedStatement().executeQuery());
    }
}
