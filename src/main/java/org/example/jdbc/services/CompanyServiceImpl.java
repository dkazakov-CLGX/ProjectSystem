package org.example.jdbc.services;

import lombok.SneakyThrows;
import org.example.jdbc.model.Company;
import org.example.jdbc.repository.CrudRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class CompanyServiceImpl extends SqlConnection<Company> implements CrudRepository<Long, Company> {

    public CompanyServiceImpl() {
        super( "companies", "name", "total_project_cost");
    }

    @SneakyThrows
    @Override
    public List<Company> findAll() {
        return parse(getFindAllPreparedStatement().executeQuery());
    }

    @SneakyThrows
    @Override
    public Company findByID(Long id) {
       // List<Company> parse = parse(getFindByIDPreparedStatement().executeQuery());
       return null;//parse.get(Math.toIntExact(id));
    }

    @SneakyThrows
    @Override
    public Company creat(Company company) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MySqlGoItHomeWork.companies (id,name) VALUES (?,?)");
        preparedStatement.setLong(1, company.getId());
        preparedStatement.setString(2, company.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return company;
    }

    @SneakyThrows
    @Override
    public Company update(Long id, Company company) {
        PreparedStatement companyUpdate = connection.prepareStatement("UPDATE MySqlGoItHomeWork.companies set name=?,total_project_cost=? WHERE id=" + id + ";");
        companyUpdate.setString(1, company.getName());
        companyUpdate.setLong(2, company.getTotalCostOfProjects());
        companyUpdate.execute();
        return company;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
     //   parse(getDeletePreparedStatement().executeQuery());
    }
}
