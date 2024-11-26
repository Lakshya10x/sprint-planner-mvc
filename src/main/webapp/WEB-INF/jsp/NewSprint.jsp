<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Sprint</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            background: linear-gradient(135deg, #f5f5f5, #e8eaf6); /* Blue Gradient */
            color: #333333;
        }

        .form-container {
            background: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
            max-width: 600px;
            width: 100%;
            margin-top: 20px; /* Add some space below navbar */
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: 100%;
        }

        .form-container h2 {
            color: #0066cc; /* Bright blue for headings */
            margin-bottom: 20px;
            text-align: center;
            font-weight: bold;
        }

        .form-container .form-group label {
            color: #333333; /* Darker text for labels */
            font-weight: 600;
        }

        .form-container .form-control {
            border-radius: 6px;
            border: 1px solid #ddd;
        }

        .form-container .btn-primary {
            background-color: #4CAF50; /* Green background for the primary button */
            border: none;
            border-radius: 6px;
            width: 100%;
            padding: 10px;
            font-size: 16px;
            font-weight: bold;
            transition: all 0.3s ease-in-out;
        }

        .form-container .btn-primary:hover {
            background-color: #45a049; /* Darker green on hover */
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
            margin-top: 20px; /* Push the button to the bottom */
        }

        .form-container .btn-back:hover {
            background-color: #aaa;
            color: #fff;
        }

        .form-container .text-muted {
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
            color: #777; /* Muted text color */
        }
    </style>
</head>
<body>
    <%@ include file="common/Navigation.jspf" %>

    <!-- Form Container -->
    <div class="form-container">
        <h2>Add New Sprint</h2>
        <form:form method="post" modelAttribute="sprint">
            <!-- Sprint Name -->
            <fieldset class="form-group mb-3">
                <label for="sprintName">Sprint Name <span class="text-danger">*</span></label>
                <form:input path="sprintName" class="form-control" id="sprintName" placeholder="Enter sprint name" />
                <form:errors path="sprintName" cssClass="text-danger" />
            </fieldset>

            <!-- Goal -->
            <fieldset class="form-group mb-3">
                <label for="goal">Goal</label>
                <form:input path="goal" class="form-control" id="goal" placeholder="Describe the sprint goal" />
                <form:errors path="goal" cssClass="text-danger" />
            </fieldset>

            <!--StartDate-->
            <fieldset class="form-group mb-3">
                <label for="startDate">StartDate<span class="text-danger">*</span></label>
                <form:input path="startDate" class="form-control" id="startDate" name="startDate"/>
                <form:errors path="startDate" cssClass="text-danger"/>
            </fieldset>

            <!--EndDate-->
            <fieldset class="form-group mb-3">
                <label for="endDate">EndDate<span class="text-danger">*</span></label>
                <form:input path="endDate" class="form-control" id="endDate" name="endDate" />
                <form:errors path="endDate" cssClass="text-danger"/>
            </fieldset>

            <!-- Status -->
            <fieldset class="form-group mb-3">
                <label>Status <span class="text-danger">*</span></label>
                <div class="form-check">
                    <form:radiobutton path="status" class="form-check-input" id="statusCompleted" value="true"  />
                    <label for="statusCompleted" class="form-check-label">Completed</label>
                </div>
                <div class="form-check">
                    <form:radiobutton path="status" class="form-check-input" id="statusNotCompleted" value="false" />
                    <label for="statusNotCompleted" class="form-check-label">In-Progress</label>
                </div>
            </fieldset>

            <!-- Submit Button -->
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save Sprint</button>
            </div>
        </form:form>

        <!-- Back to Sprints button placed at the bottom -->
        <a href="show-sprints" class="btn-back text-center">&larr; Back to Sprints</a>

        <p class="text-muted">Ensure all required fields are filled before submitting.</p>
    </div>

    <%@ include file="common/Footer.jspf" %>
    <script type="text/javascript">$('#startDate').datepicker({
                                       format: 'yyyy-mm-dd',
                                       startDate: '-1d'
                                   });</script>
    <script type="text/javascript">$('#endDate').datepicker({
                                           format: 'yyyy-mm-dd',
                                           startDate: '-1d'
                                       });</script>
</body>
</html>
