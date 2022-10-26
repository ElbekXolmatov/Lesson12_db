package com.company;

import com.company.util.ScannerUtil;

import java.sql.*;

public class CallFunctionExample {
    static final String user = "postgres";
    static final String password = "0";
    static final String url = "jdbc:postgresql://localhost:5432/lesson12_db";

    public static void main(String[] args) {

        System.out.print("Enter university: ");
        String university = ScannerUtil.SCANNER_STR.nextLine();

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "{ ? = call get_count_by_university(?) }";

            CallableStatement callableStatement = connection.prepareCall(sql);

            callableStatement.registerOutParameter(1,Types.VARCHAR);
            callableStatement.setString(2,university);

            callableStatement.execute();

            String result = callableStatement.getString(1);
            System.out.println("result = " + result);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
