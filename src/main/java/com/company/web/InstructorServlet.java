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

public class InstructorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*         req.setAttribute("name", "Codecamp 3!");
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
 */
try {
            DriverManager.registerDriver(new Driver());
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codecamp3", "root", "S@nt!851900");
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select i.name as instructor_name "+
           "from courses as c "+
           "right join instructors as i on i.id = c.teach_by "+
           "where c.name is null "+
           "order by c.id;");
           ArrayList<Instructor> instructors = new ArrayList<Instructor>();
           while (resultSet.next()) {
               Instructor instructor = new Instructor();
               //int id = resultSet.getInt("id");
               //String course_name = resultSet.getString("course_name");
               String instructor_name = resultSet.getString("instructor_name");
               //String studentId = resultSet.getString("studentid");
               //String firstname = resultSet.getString("firstname");
               //String lastname = resultSet.getString("lastname");

               //instructor.setId(id);
               //instructor.setName(course_name);
               instructor.setName(instructor_name);
               instructors.add(instructor);

               //System.out.println(String.format("ID=%s, Name=%s", id, name));

               //student.setStudentid(studentId);
               //student.setFirstname(firstname);
               //student.setLastname(lastname);
               //students.add(student);
               //System.out.println(String.format("ID=%s, Firstname=%s, Lastname=%s", studentId, firstname, lastname));
           }
            statement.close();
            connection.close();
            req.setAttribute("instructors", instructors);
            req.getRequestDispatcher("/jsp/instructor.jsp").forward(req, resp);

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
