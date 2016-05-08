package com.ivanmix.resume.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 27.04.2016.
 */
public class GeneratorTestData {
    // JDBC setting for database
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/my-resume";
    private static final String JDBC_USERNAME = "my-resume";
    private static final String JDBC_PASSWORD = "my-resume";
/*
    private static void clearDb(Connection c) throws SQLException {
        Statement st = c.createStatement();
        st.executeUpdate("delete from user");*/
        /*
        st.executeUpdate("delete from skill_category");
        st.executeQuery("select setval('profile_seq', 1, false)");
        st.executeQuery("select setval('hobby_seq', 1, false)");
        st.executeQuery("select setval('certificate_seq', 1, false)");
        st.executeQuery("select setval('education_seq', 1, false)");
        st.executeQuery("select setval('language_seq', 1, false)");
        st.executeQuery("select setval('practic_seq', 1, false)");
        st.executeQuery("select setval('skill_seq', 1, false)");*/
/*
        st.executeQuery("select setval('user_seq', 1, false)");
        System.out.println("Db cleared");
    }*/

    public static void main(String[] args) throws Exception {

        List<User> users = loadUser();

        try (Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
           // ResultSet resultSet = stmt.executeQuery("SELECT * FROM table ;");
            ResultSet resultSet = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while (resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println(name);
            }
            resultSet.close();
            stmt.close();
            c.close();

/*
            PreparedStatement ps = c.prepareStatement("insert into table values (?)");

            ps.setString(1,"10");
//            ps.executeUpdate();
            ps.close();

            /*clearDb(c);

            table
            for (User u : users) {
                PreparedStatement ps = c.prepareStatement("insert into user values (nextval('user_seq'),?,?,?,?,?)");
                ps.setString(1,u.login);
                ps.setString(2,u.password);
                ps.setString(3,u.firstName);
                ps.setString(4,u.lastName);
                ps.setString(5,u.email);
               ps.executeUpdate();
                ps.close();
            }
            c.commit();*/


            System.out.println("Data generated successful");
        }
    }


    private static List<User> loadUser() {

        List<User> list = new ArrayList<>();
        User user = new User("ivan","password","firstName","lastName","email");
        list.add(user);
        return list;
    }

    private static final class User{

        private final String login;
        private final String password;
        private final String firstName;
        private final String lastName;
        private final String email;


        private User(String login, String password, String firstName, String lastName, String email) {
            super();
            this.login = login;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{" +
                    "login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}
