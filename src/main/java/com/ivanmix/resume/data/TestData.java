package com.ivanmix.resume.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

/**
 * Created by ivan on 28.04.2016.
 */
public class TestData {

    private static final String[] FOREGIN_LANGUAGES = { "Spanish", "French", "German", "Italian" };
    private static List<String> FOREGIN_LANGUAGES_LIST = new ArrayList<>(Arrays.asList(FOREGIN_LANGUAGES));

    private static final Random r = new Random();

    public static void main(String args[]) {
        String trim = "i am a very very long String";
        System.out.println(trim.split("\\s+").length);

        StringTokenizer st = new StringTokenizer("i am a very very long String");
        for(int i = 0; i < 10 && st.hasMoreTokens(); i++) {

            System.out.println(st.nextToken());
        }
        /*
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(4));

        System.out.println(FOREGIN_LANGUAGES_LIST.get(3)+FOREGIN_LANGUAGES_LIST.size());*/
        /*
        r.nextInt(10)
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/my-resume",
                            "my-resume", "my-resume");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO member values (nextval('member_seq'),'22','33','44','44','00');";
            stmt.executeUpdate(sql);



            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");*/
    }
}
