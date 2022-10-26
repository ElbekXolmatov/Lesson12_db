package com.company.studentCRUD;


import com.company.util.ScannerUtil;

import java.sql.*;

public class InsertExample2 {
    static final String user = "postgres";
    static final String password = "0";
    static final String url = "jdbc:postgresql://localhost:5432/lesson12_db";

    public static void main(String[] args) {

        try {
            System.out.print("Enter full name: ");
            String fullName = ScannerUtil.SCANNER_STR.nextLine();

            System.out.print("Enter course: ");
            short course = ScannerUtil.SCANNER_NUM.nextShort();

            System.out.print("Enter university: ");
            String university = ScannerUtil.SCANNER_STR.nextLine();

            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            String query = """
                    insert into student(ful_name, course, university)
                    values(?, ?, ?);
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, fullName);
            preparedStatement.setShort(2, course);
            preparedStatement.setString(3, university);

            int execute = preparedStatement.executeUpdate();
            System.out.println("execute = " + execute);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Created!");
    }
}
