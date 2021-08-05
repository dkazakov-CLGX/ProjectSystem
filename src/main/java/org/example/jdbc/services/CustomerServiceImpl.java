package org.example.jdbc.services;

import lombok.SneakyThrows;
import org.example.jdbc.model.Customer;
import org.example.jdbc.repository.CrudRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class CustomerServiceImpl extends SqlConnection<Customer> implements CrudRepository<Long, Customer> {

    public CustomerServiceImpl() {
        super( "customers", "name", "budget", "company_id");
    }

    @SneakyThrows
    @Override
    public List<Customer> findAll() {
        return parse(getFindAllPreparedStatement().executeQuery());
    }

    @SneakyThrows
    @Override
    public Customer findByID(Long id) {
     //   List<Customer> parse = parse(getFindByIDPreparedStatement().executeQuery());
        return null;//parse.get(Math.toIntExact(id));
    }

    @SneakyThrows
    @Override
    public Customer creat(Customer customer) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MySqlGoItHomeWork.customers (id,name,budget,company_id) VALUES (?,?,?,?)");
        preparedStatement.setLong(1, customer.getId());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setLong(3, customer.getBudget());
        preparedStatement.setLong(4, customer.getCompanyID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return customer;
    }

    @SneakyThrows
    @Override
    public Customer update(Long id, Customer customer) {
        PreparedStatement customerUpdate = connection.prepareStatement("UPDATE MySqlGoItHomeWork.customers set name=?, budget=?, company_id=? WHERE id=" + id + ";");
        customerUpdate.setString(1, customer.getName());
        customerUpdate.setLong(2, customer.getBudget());
        customerUpdate.setLong(3, customer.getCompanyID());
        customerUpdate.executeUpdate();
        customerUpdate.close();
        return customer;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
       // parse(getDeletePreparedStatement().executeQuery());
    }
}
