package com.company.studentCRUD;

import com.company.util.ScannerUtil;

import java.sql.*;

public class DeleteExample {
    static final String user = "postgres";
    static final String password = "0";
    static final String url = "jdbc:postgresql://localhost:5432/lesson12_db";
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.print("Enter id: ");
            int id = ScannerUtil.SCANNER_NUM.nextInt();

            String query = """
                    delete from student where id = ?;
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int execute = preparedStatement.executeUpdate();
            System.out.println("execute = " + execute);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
