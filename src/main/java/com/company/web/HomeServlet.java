package com.company.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*         req.setAttribute("name", "Codecamp 3!");
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
 */
try {
     
           DriverManager.registerDriver(new Driver());
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codecamp3", "root", "S@nt!851900");
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * FROM students;");
           ArrayList<Student> students = new ArrayList<Student>();
           while (resultSet.next()) {
               Student student = new Student();
               String studentId = resultSet.getString("studentid");
               String firstname = resultSet.getString("firstname");
               String lastname = resultSet.getString("lastname");

               student.setStudentid(studentId);
               student.setFirstname(firstname);
               student.setLastname(lastname);
               students.add(student);
               System.out.println(String.format("ID=%s, Firstname=%s, Lastname=%s", studentId, firstname, lastname));
           }
            statement.close();
            connection.close();
            req.setAttribute("students", students);
            req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}

