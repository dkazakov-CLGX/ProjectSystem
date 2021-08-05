package org.example.jdbc.services;

import lombok.SneakyThrows;
import org.example.jdbc.model.DeveloperSkill;
import org.example.jdbc.repository.CrudRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class DeveloperSkillServiceImpl extends SqlConnection<DeveloperSkill> implements CrudRepository<Long, DeveloperSkill> {

    public DeveloperSkillServiceImpl() {
        super( "developers_projects", "developer_id","project_id");
    }

    @SneakyThrows
    @Override
    public List<DeveloperSkill> findAll() {
        return parse(getFindAllPreparedStatement().executeQuery());
    }

    @SneakyThrows
    @Override
    public DeveloperSkill findByID(Long id) {
       // List<DeveloperSkill> parse = parse(getFindByIDPreparedStatement().executeQuery());
        return null; //parse.get(Math.toIntExact(id));
    }

    @SneakyThrows
    @Override
    public DeveloperSkill creat(DeveloperSkill developerSkill) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MySqlGoItHomeWork.developers_skills (developer_id, skill_id) VALUES (?,?)");
        preparedStatement.setLong(1, developerSkill.getDeveloperID());
        preparedStatement.setLong(2, developerSkill.getSkillID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return developerSkill;
    }

    @SneakyThrows
    @Override
    public DeveloperSkill update(Long id, DeveloperSkill developerSkill) {
        PreparedStatement developerSkillUpdate = connection.prepareStatement("UPDATE MySqlGoItHomeWork.developers_skills set skill_id=? WHERE developer_id=" + id + ";");
        developerSkillUpdate.setLong(1, developerSkill.getSkillID());
        developerSkillUpdate.executeUpdate();
        developerSkillUpdate.close();
        return developerSkill;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
      //  parse(getDeletePreparedStatement().executeQuery());
    }
}
