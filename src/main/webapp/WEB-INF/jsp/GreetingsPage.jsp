<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Greetings</title>
    <style>
        /* Global Styles */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100vh;
            background: linear-gradient(135deg, #f5f5f5, #e8eaf6); /* Light Blue Gradient */
            color: #333333; /* Dark text color for contrast */
        }

        /* Header Styling */
        h1 {
            font-size: 36px;
            color: #5a9bfc; /* Soft blue for highlights */
            margin-bottom: 20px;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        /* Paragraph Styling */
        p {
            font-size: 18px;
            color: #555555; /* Darker gray for better readability */
            max-width: 600px;
            line-height: 1.6;
            text-align: center;
        }

        /* Button Styling */
        a {
            display: inline-block;
            padding: 12px 20px;
            background-color: #5a9bfc; /* Soft blue background */
            color: #fff; /* White text color */
            font-size: 18px;
            text-decoration: none;
            font-weight: bold;
            border-radius: 6px; /* Rounded corners */
            margin-top: 20px;
            transition: all 0.3s ease-in-out; /* Smooth transition on hover */
        }

        /* Button Hover Effect */
        a:hover {
            background-color: ##5a9bfc;
            color: #fff; /* Keep text white */
            text-decoration: none; /* Remove underline */
            transform: scale(1.05); /* Slight zoom effect */
        }

        /* Responsive Design */
        @media (max-width: 480px) {
            h1 {
                font-size: 28px;
            }

            p {
                font-size: 16px;
                padding: 0 15px;
            }
        }
    </style>
</head>
<body>
    <h1>Hello, ${name}!</h1>
    <p>Welcome to SprintPlanner! Stay productive and take charge of your tasks with a clear focus and planning.</p>
    <a href="show-sprints">View Sprints</a>
</body>
<%@ include file="common/Footer.jspf" %>
</html>
