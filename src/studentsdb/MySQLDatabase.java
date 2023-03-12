package studentsdb;

import studentsdb.Student;

import java.io.*;
import java.sql.*;

class MySQLDatabase {
    private Connection connection;

    public MySQLDatabase(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void addStudent(Student student) throws SQLException {
        String insertSql = "INSERT INTO students (nume, prenume, anul, optional) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, student.getNume());
            statement.setString(2, student.getPrenume());
            statement.setInt(3, student.getAnul());
            statement.setObject(4, student.getOptionale());

            statement.executeUpdate();
        }
    }
    public void close() throws SQLException {
        connection.close();
    }
}
