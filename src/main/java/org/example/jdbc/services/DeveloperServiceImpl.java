package org.example.jdbc.services;

import lombok.SneakyThrows;
import org.example.jdbc.model.Developer;
import org.example.jdbc.repository.CrudRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class DeveloperServiceImpl extends SqlConnection<Developer> implements CrudRepository<Long, Developer> {

    public DeveloperServiceImpl() {
        super( "developers", "id","name","age","gender","email","number_phone", "company_id","salary");
    }

    @SneakyThrows
    @Override
    public List<Developer> findAll() {
        return parse(getFindAllPreparedStatement().executeQuery());
    }

    @SneakyThrows
    @Override
    public Developer findByID(Long id) {
     //   List<Developer> parse = parse(getFindByIDPreparedStatement().executeQuery());
        return null;//parse.get(Math.toIntExact(id));
    }

    @SneakyThrows
    @Override
    public Developer creat(Developer developer) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MySqlGoItHomeWork.developers (id,name,age,gender,email,numberPhone,company_id,salary) VALUES (?,?,?,?,?,?,?,?)");
        preparedStatement.setLong(1, developer.getId());
        preparedStatement.setString(2, developer.getName());
        preparedStatement.setLong(3, developer.getAge());
        preparedStatement.setString(4, developer.getGender());
        preparedStatement.setString(5, developer.getEmail());
        preparedStatement.setLong(6, developer.getNumberPhone());
        preparedStatement.setLong(7, developer.getCompanyID());
        preparedStatement.setLong(8, developer.getSalary());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return developer;
    }

    @SneakyThrows
    @Override
    public Developer update(Long id, Developer developer) {
        PreparedStatement developerUpdate = connection.prepareStatement("UPDATE MySqlGoItHomeWork.developers set name=?,age=?,gender=?,email=?,numberPhone=?,company_id=?,salary=? WHERE id=" + id + ";");
        developerUpdate.setString(1, developer.getName());
        developerUpdate.setLong(2, developer.getAge());
        developerUpdate.setString(3, developer.getGender());
        developerUpdate.setString(4, developer.getEmail());
        developerUpdate.setLong(5, developer.getNumberPhone());
        developerUpdate.setLong(6, developer.getCompanyID());
        developerUpdate.setLong(7, developer.getSalary());
        developerUpdate.executeUpdate();
        developerUpdate.close();
        return developer;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
      //  parse(getDeletePreparedStatement().executeQuery());
    }
}
