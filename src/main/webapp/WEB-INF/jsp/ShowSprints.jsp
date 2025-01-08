<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Sprints</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #f5f5f5, #e8eaf6);
            color: #333333;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            background: #ffffff;
            color: #333333;
            border-radius: 12px;
            padding: 40px 30px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
            max-width: 90%;
            width: 100%;
        }

        h1 {
            color: #1e88e5;
            margin-bottom: 30px;
            text-transform: uppercase;
            text-align: center;
            font-weight: bold;
        }

        .table-container {
            max-height: 400px;
            overflow-y: auto;
            margin-bottom: 20px;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #1976d2;
            color: #ffffff;
            text-align: center;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #1565c0;
        }

        .btn-submit {
            max-width: 200px;
            margin: 0 auto;
        }

        .btn-warning {
            background-color: #ff7043;
            color: #ffffff;
        }

        .btn-warning:hover {
            background-color: #e64a19;
        }

        .btn-success {
            background-color: #66bb6a;
            color: #ffffff;
        }

        .btn-success:hover {
            background-color: #388e3c;
        }
    </style>
</head>
<body>
    <%@ include file="common/Navigation.jspf" %>

    <div class="container mt-4">
        <h1>Welcome, ${name}!</h1>
        <p class="text-center">Here is a list of your current sprints:</p>

        <!-- Table Container with Scroll -->
        <div class="table-container">
            <table class="table table-bordered">
                <thead class="table-light">
                    <tr>
                        <th class="text-center">SprintID</th>
                        <th class="text-center">Sprint Name</th>
                        <th class="text-center">Goal</th>
                        <th class="text-center">Start Date</th>
                        <th class="text-center">End Date</th>
                        <th class="text-center">Status</th>
                        <th class="text-center">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sprints}" var="sprint">
                        <tr>
                            <td class="text-center">${sprint.id}</td>
                            <td class="text-center">${sprint.sprintName}</td>
                            <td class="text-center">${sprint.goal}</td>
                            <td class="text-center">${sprint.startDate}</td>
                            <td class="text-center">${sprint.endDate}</td>
                            <td class="text-center">${sprint.status ? 'Completed' : 'In-Progress'}</td>
                            <td class="text-center">
                                <div class="d-flex justify-content-center">
                                    <a href="update-sprint?id=${sprint.id}" class="btn btn-sm mx-1">
                                        <i class="bi bi-pencil"></i> Edit
                                    </a>
                                    <a href="delete-sprint?id=${sprint.id}" class="btn btn-sm mx-1">
                                        <i class="bi bi-trash"></i> Delete
                                    </a>

                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>



        <a href="add-sprint" class="btn btn-submit">Add Sprint</a>
    </div>
</body>
<%@ include file="common/Footer.jspf" %>
</html>
