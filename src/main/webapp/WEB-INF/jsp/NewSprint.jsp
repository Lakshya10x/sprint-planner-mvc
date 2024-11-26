<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Sprint</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: linear-gradient(135deg, #283593, #5c6bc0); /* Blue Gradient */
            color: #ffffff;
        }

        .form-container {
            background: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
            max-width: 600px;
            width: 100%;
        }

        .form-container h2 {
            color: #283593; /* Deep blue */
            margin-bottom: 20px;
            text-align: center;
            font-weight: bold;
        }

        .form-container .form-group label {
            color: #555555;
            font-weight: 600;
        }

        .form-container .form-control {
            border-radius: 6px;
            border: 1px solid #ddd;
        }

        .form-container .btn-primary {
            background-color: #5a9bfc;
            border: none;
            border-radius: 6px;
            width: 100%;
            padding: 10px;
            font-size: 16px;
            font-weight: bold;
            transition: all 0.3s ease-in-out;
        }

        .form-container .btn-primary:hover {
            background-color: #283593;
        }

        .form-container .form-group:last-of-type {
            margin-top: 20px;
        }

        .form-container .btn-back {
            font-size: 14px;
            background-color: #ccc;
            color: #555;
            text-decoration: none;
            border-radius: 6px;
            padding: 8px 12px;
            font-weight: bold;
            display: inline-block;
            margin-bottom: 20px;
        }

        .form-container .btn-back:hover {
            background-color: #aaa;
            color: #fff;
        }

        .form-container .text-muted {
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <a href="show-sprints" class="btn-back">&larr; Back to Sprints</a>
        <h2>Add New Sprint</h2>
        <form:form method="post" modelAttribute="sprint">
            <!-- Sprint Name -->
            <div class="form-group mb-3">
                <label for="sprintName">Sprint Name <span class="text-danger">*</span></label>
                <form:input path="sprintName" class="form-control" id="sprintName" placeholder="Enter sprint name" />
                <form:errors path="sprintName" cssClass="text-danger" />
            </div>

            <!-- Goal -->
            <div class="form-group mb-3">
                <label for="goal">Goal</label>
                <form:input path="goal" class="form-control" id="goal" placeholder="Describe the sprint goal" />
                <form:errors path="goal" cssClass="text-danger" />
            </div>

            <!--StartDate-->
            <div class="form-group mb-3">
            <label for="startDate">StartDate<span class="text-danger">*</span></label>
            <form:input path="startDate" class="form-control" id="startDate" name="startDate" type="date"/>
            <form:errors path="startDate" cssClass="text-danger"/>
            </div>

            <!--EndDate-->
            <div class="form-group mb-3">
            <label for="endDate">EndDate<span class="text-danger">*</span></label>
            <form:input path="endDate" class="form-control" id="endDate" name="endDate" type="date"/>
            <form:errors path="endDate" cssClass="text-danger"/>
            </div>

            <!-- Status -->
            <div class="form-group mb-3">
                <label>Status <span class="text-danger">*</span></label>
                <div class="form-check">
                    <form:radiobutton path="status" class="form-check-input" id="statusCompleted" value="true"  />
                    <label for="statusCompleted" class="form-check-label">Completed</label>
                </div>
                <div class="form-check">
                    <form:radiobutton path="status" class="form-check-input" id="statusNotCompleted" value="false" />
                    <label for="statusNotCompleted" class="form-check-label">Not Completed</label>
                </div>
            </div>

            <!-- Submit Button -->
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save Sprint</button>
            </div>
        </form:form>

        <p class="text-muted">Ensure all required fields are filled before submitting.</p>
    </div>
    <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>
