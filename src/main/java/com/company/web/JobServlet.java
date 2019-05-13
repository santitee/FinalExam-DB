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

public class JobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*         req.setAttribute("name", "Codecamp 3!");
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
 */
try {
     
           DriverManager.registerDriver(new Driver());
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "S@nt!851900");
           System.out.println("Connected Database");
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select j.id, j.job_name "+
           "from employee as e "+
           "right join job as j on e.id = j.id "+
           "where e.id is null;");
           System.out.println("SQL Query");
           ArrayList<Job> jobs = new ArrayList<Job>();
           while (resultSet.next()) {
               Job job = new Job();
               int id = resultSet.getInt("id");
               String job_name = resultSet.getString("job_name");
               //String instructor_name = resultSet.getString("instructure_name");
               //String studentId = resultSet.getString("studentid");
               //String firstname = resultSet.getString("firstname");
               //String lastname = resultSet.getString("lastname");

               job.setId(id);
               job.setJob_name(job_name);
               //course.setName(instructor_name);
               jobs.add(job);

               //System.out.println(String.format("ID=%s, Name=%s, instructure_name=$%s", id, course_name, instructure_name));

               //student.setStudentid(studentId);
               //student.setFirstname(firstname);
               //student.setLastname(lastname);
               //students.add(student);
               //System.out.println(String.format("ID=%s, Firstname=%s, Lastname=%s", studentId, firstname, lastname));
           }
            statement.close();
            connection.close();
            req.setAttribute("jobs", jobs);
            req.getRequestDispatcher("/jsp/job.jsp").forward(req, resp);

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
