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

public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*         req.setAttribute("name", "Codecamp 3!");
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
 */
try {
     
           DriverManager.registerDriver(new Driver());
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codecamp3", "root", "S@nt!85190");
           System.out.println("Connected Database");
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select c.id, c.name as course_name, i.name as instructure_name "+
           "from courses as c "+
           "left join instructors as i on i.id = c.teach_by "+
           "where i.name is null  "+
           "order by c.id;");
           System.out.println("SQL Query");
           ArrayList<Course> courses = new ArrayList<Course>();
           while (resultSet.next()) {
               Course course = new Course();
               int id = resultSet.getInt("id");
               String course_name = resultSet.getString("course_name");
               //String instructor_name = resultSet.getString("instructure_name");
               //String studentId = resultSet.getString("studentid");
               //String firstname = resultSet.getString("firstname");
               //String lastname = resultSet.getString("lastname");

               course.setId(id);
               course.setName(course_name);
               //course.setName(instructor_name);
               courses.add(course);

               //System.out.println(String.format("ID=%s, Name=%s, instructure_name=$%s", id, course_name, instructure_name));

               //student.setStudentid(studentId);
               //student.setFirstname(firstname);
               //student.setLastname(lastname);
               //students.add(student);
               //System.out.println(String.format("ID=%s, Firstname=%s, Lastname=%s", studentId, firstname, lastname));
           }
            statement.close();
            connection.close();
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("/jsp/course.jsp").forward(req, resp);

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
