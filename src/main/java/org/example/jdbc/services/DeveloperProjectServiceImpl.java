package org.example.jdbc.services;

import lombok.SneakyThrows;
import org.example.jdbc.model.DeveloperProject;
import org.example.jdbc.repository.CrudRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class DeveloperProjectServiceImpl extends SqlConnection<DeveloperProject> implements CrudRepository<Long, DeveloperProject> {

    public DeveloperProjectServiceImpl() {
        super("developers_projects", "developer_id","project_id");
    }

    @SneakyThrows
    @Override
    public List<DeveloperProject> findAll() {
        return parse(getFindAllPreparedStatement().executeQuery());
    }

    @SneakyThrows
    @Override
    public DeveloperProject findByID(Long id) {
       // List<DeveloperProject> parse = parse(getFindByIDPreparedStatement().executeQuery());
        return null; //parse.get(Math.toIntExact(id));
    }

    @SneakyThrows
    @Override
    public DeveloperProject creat(DeveloperProject developerProject) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MySqlGoItHomeWork.developers_projects (developer_id, project_id) VALUES (?,?)");
        preparedStatement.setLong(1, developerProject.getDeveloperID());
        preparedStatement.setLong(2, developerProject.getProjectID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return developerProject;
    }

    @SneakyThrows
    @Override
    public DeveloperProject update(Long id, DeveloperProject developerProject) {
        PreparedStatement developerProjectUpdate = connection.prepareStatement("UPDATE MySqlGoItHomeWork.developers_projects set project_id=? WHERE developer_id=" + id + ";");
        developerProjectUpdate.setLong(1, developerProject.getProjectID());
        developerProjectUpdate.executeUpdate();
        developerProjectUpdate.close();
        return developerProject;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
       // parse(getDeletePreparedStatement().executeQuery());
    }
}
