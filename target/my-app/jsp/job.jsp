<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>JOb</title>

    <link href="<c:url value="/css/styles.css" />" rel="stylesheet">
    <script src="<c:url value="/js/app.js" />"></script>

    <style>
        #course {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        #course td,
        #course th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #course tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #course tr:hover {
            background-color: #ddd;
        }

        #course th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>

</head>
<table border="1" id="job">
    <thead>
        <th>id</th>
        <th>Job Name</th>
    </thead>

    <!-- Result = ${instructors[0].name} -->
    <c:forEach var="job" items="${jobs}">
        <tr>
            <td>
                <c:out value="${job.id}" />
            </td>
            <td>
                <c:out value="${job.job_name}" />
            </td>
        </tr>
    </c:forEach>

    <tbody>

    </tbody>
</table>

</html>