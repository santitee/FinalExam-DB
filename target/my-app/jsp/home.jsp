<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Document</title>

  <link href="<c:url value="/css/styles.css" />" rel="stylesheet">
  <script src="<c:url value="/js/app.js" />"></script>

  <style>
    #student {
      font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 50%;
    }
  
    #student td,
    #student th {
      border: 1px solid #ddd;
      padding: 8px;
    }
  
    #student tr:nth-child(even) {
      background-color: #f2f2f2;
    }
  
    #student tr:hover {
      background-color: #ddd;
    }
  
    #student th {
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: left;
      background-color: #4CAF50;
      color: white;
    }
  </style>

</head>
<table border="1" id="student">
  <thead>
    <th>student id</th>
    <th>First Name</th>    
    <th>Last Name</th>
  </thead>

  <!-- Result = ${students[0].firstname} -->
  <c:forEach var="user" items="${students}">
    <tr>
      <td>
        <c:out value="${user.studentid}" />
      </td>
      <td>
        <c:out value="${user.firstname}" />
      </td>
      <td>
        <c:out value="${user.lastname}" />
      </td>
    </tr>
  </c:forEach>

<tbody>
  
</tbody>
</table>

</html>
