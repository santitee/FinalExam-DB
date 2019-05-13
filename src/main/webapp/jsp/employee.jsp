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
        #instructor {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        #instructor td,
        #instructor th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #instructor tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #instructor tr:hover {
            background-color: #ddd;
        }

        #instructor th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>

</head>
<table border="1" id="employee">
    <thead>
        <th>Employee Id</th>
        <th>Employee First Name</th>
        <th>Employee Last Name</th>
        <th>Job Name</th>
    </thead>

    <!-- Result = ${instructors[0].name} -->
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>
                <c:out value="${employee.id}" />
            </td>
            <td>
                <c:out value="${employee.first_name}" />
            </td>
            <td>
                <c:out value="${employee.last_name}" />
            </td>
            <td>
                <img src = "<c:url value="/assets/img/${employee.job_name}.jpg"/>" />
            </td>
        </tr>
    </c:forEach>

    <tbody>

    </tbody>
</table>

</html>