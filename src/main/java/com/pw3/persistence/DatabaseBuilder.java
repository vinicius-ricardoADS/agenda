package com.pw3.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {

    public static void main(String[] args) throws SQLException, IOException {
        createTables();
        System.out.println("\n\u2764 Tudo pronto \u2764");
    }

    private static void createTables() throws SQLException {
        final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        final Statement stmt = connection.createStatement();
        String sqlDeclaracao = """
                CREATE TABLE pessoa(
                    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    name TEXT,
                    email varchar(20),
                    phone TEXT
                )
                """;
        System.out.println("Gerando novas tabelas...\n");
        stmt.executeUpdate(sqlDeclaracao);
        stmt.close();
        connection.close();
    }
    
}
