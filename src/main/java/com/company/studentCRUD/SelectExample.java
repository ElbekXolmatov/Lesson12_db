package com.company.studentCRUD;

import com.company.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectExample {
    static final String user = "postgres";
    static final String password = "0";
    static final String url = "jdbc:postgresql://localhost:5432/lesson12_db";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String query = """
                    select * from student order by id;
                    """;

            ResultSet resultSet = statement.executeQuery(query);

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String fullname = resultSet.getString("ful_name");
                short course = resultSet.getShort("course");
                String university = resultSet.getString(4);

                System.out.printf("%d. %-10s %d %s %n", id, fullname,course,university);

                studentList.add(new Student(id,fullname,course,university));
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}