package com.pw3.persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pw3.model.Pessoa;

public class PessoaDAO {

    public void save(Pessoa p) throws SQLException{
        final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        final Statement stmt = connection.createStatement();

        String sql = "INSERT INTO product (id, name, email, phone) values (?,?,?,?)";
        stmt.addBatch(String.format(sql, p.getId(), p.getName(), p.getEmail(), p.getPhone()));
        
        stmt.close();
        connection.close();
    }
        
    
}
