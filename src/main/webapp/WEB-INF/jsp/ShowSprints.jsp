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
            background: linear-gradient(135deg, #1a237e, #283593);
            color: #ffffff;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: #ffffff;
            color: #333333;
            border-radius: 12px;
            padding: 40px 30px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.3);
            max-width: 90%;
            width: 100%;
        }

        h1 {
            color: #283593;
            margin-bottom: 30px;
            text-transform: uppercase;
            text-align: center;
            font-weight: bold;
        }

        table th {
            background-color: #5a9bfc;
            color: white;
            text-transform: uppercase;
        }

        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .table-container {
            max-height: 400px; /* Adjust the max-height as needed */
            overflow-y: auto; /* Enables vertical scrolling */
            margin-bottom: 20px;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #5a9bfc;
            color: #ffffff;
            text-align: center;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #283593;
        }

        .btn-submit {
            max-width: 200px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, ${name}!</h1>
        <p class="text-center">Here is a list of your current sprints:</p>

        <!-- Table Container with Scroll -->
        <div class="table-container">
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Sprint Name</th>
                        <th>Goal</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sprints}" var="sprint">
                        <tr>
                            <td>${sprint.id}</td>
                            <td>${sprint.username}</td>
                            <td>${sprint.sprintName}</td>
                            <td>${sprint.goal}</td>
                            <td>${sprint.startDate}</td>
                            <td>${sprint.endDate}</td>
                            <td>${sprint.status ? 'Completed' : 'Pending'}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <a href="add-sprint" class="btn btn-submit">Add Sprint</a>
    </div>
</body>
<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</html>
