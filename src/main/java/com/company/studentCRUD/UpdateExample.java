package com.company.studentCRUD;


import com.company.util.ScannerUtil;

import java.sql.*;

public class UpdateExample {
    static final String user = "postgres";
    static final String password = "0";
    static final String url = "jdbc:postgresql://localhost:5432/lesson12_db";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.print("Enter id: ");
            int id = ScannerUtil.SCANNER_NUM.nextInt();

            System.out.print("Enter new full name: ");
            String fullName = ScannerUtil.SCANNER_STR.nextLine();

            System.out.print("Enter new course: ");
            short course = ScannerUtil.SCANNER_NUM.nextShort();

            System.out.print("Enter new university: ");
            String university = ScannerUtil.SCANNER_STR.nextLine();

            String query = """
                    update student set ful_name =?, course = ?, university = ? where id = ?;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(4, id);
            preparedStatement.setString(1, fullName);
            preparedStatement.setShort(2, course);
            preparedStatement.setString(3, university);

            int execute = preparedStatement.executeUpdate();
            System.out.println("execute = " + execute);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
