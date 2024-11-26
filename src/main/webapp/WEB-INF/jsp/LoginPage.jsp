<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SprintPlanner - Login</title>
    <style>

        body {
            font-family: 'Roboto', Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, #2e3b4e, #1c252e);
            color: #ffffff;
        }


        form {
            background: #1f2a37;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
            width: 350px;
            text-align: center;
        }


        form h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #e6efff;
            font-weight: bold;
        }


        form label {
            display: block;
            text-align: left;
            font-size: 14px;
            color: #aab4c5;
            margin-bottom: 8px;
        }

        form input[type="text"],
        form input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #3a4757;
            border-radius: 6px;
            background: #2a3647;
            color: #e6efff;
            font-size: 14px;
        }


        form input[type="text"]:focus,
        form input[type="password"]:focus {
            outline: none;
            border-color: #5a9bfc;
            box-shadow: 0 0 8px rgba(90, 155, 252, 0.5);
        }


        form input[type="submit"] {
            width: 100%;
            padding: 12px;
            background: #5a9bfc;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            color: #ffffff;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s ease, transform 0.2s ease;
        }

        form input[type="submit"]:hover {
            background: #4a89e8;
            transform: translateY(-2px);

    </style>
</head>
<body>
    <form method="post">
        <h1>Sprint Planner Login</h1>
        <pre>${errorMessage}</pre>
        <label for="name">Username:</label>
        <input type="text" id="name" name="name" placeholder="Enter your username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>

        <input type="submit" value="Login">

    </form>
</body>
</html>
