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
            background: linear-gradient(135deg, #1a237e, #283593); /* Dark Blue Gradient */
            color: #e0e0e0; /* Light text color */
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
            color: #cfd8dc; /* Light gray-blue for contrast */
            max-width: 600px;
            line-height: 1.6;
            text-align: center;
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
<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</html>
