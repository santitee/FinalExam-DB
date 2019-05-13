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

public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*         req.setAttribute("name", "Codecamp 3!");
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
 */
try {
            DriverManager.registerDriver(new Driver());
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "S@nt!851900");
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select e.id, e.first_name, e.last_name, j.job_name "+
            "from employee as e "+
            "left join job as j on j.id = e.id "+
            "order by e.id;");
           ArrayList<Employee> employees = new ArrayList<Employee>();
           while (resultSet.next()) {
               Employee employee = new Employee();
               int id = resultSet.getInt("id");
               String first_name = resultSet.getString("first_name");
               String last_name = resultSet.getString("last_name");
               String job_name = resultSet.getString("job_name");
               //String firstname = resultSet.getString("firstname");
               //String lastname = resultSet.getString("lastname");

               employee.setId(id);
               employee.setFirst_name(first_name);
               employee.setLast_name(last_name);
               employee.setJob_name(job_name);
               employees.add(employee);

               //System.out.println(String.format("ID=%s, Name=%s", id, name));

               //student.setStudentid(studentId);
               //student.setFirstname(firstname);
               //student.setLastname(lastname);
               //students.add(student);
               //System.out.println(String.format("ID=%s, Firstname=%s, Lastname=%s", studentId, firstname, lastname));
           }
            statement.close();
            connection.close();
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("/jsp/employee.jsp").forward(req, resp);

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
