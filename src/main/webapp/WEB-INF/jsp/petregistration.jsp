<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Insert title here</title>
    <script type="text/javascript">

        function  onFunction(){
            var email = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
            var emailvalue=document.getElementById('email').value;
            if (email.test(emailvalue) == false)
            {
                alert('Invalid Email Address');
                return false;
            }else{
                alert("Email is correct");
            }
        }

    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .main {
            background-color: #fff;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 300px;
        }

        .main h2 {
            color: #4caf50;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }

        input[type="text"], input[type="email"], input[type="password"], select
        {
            width: 100%;
            margin-bottom: 15px;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        button[type="submit"] {
            padding: 15px;
            border-radius: 10px;
            border: none;
            background-color: #4caf50;
            color: white;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }

        /* Styling for Exit Button */
        .exit-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #f44336; /* Red background */
            color: white;
            text-align: center;
            text-decoration: none; /* Remove underline */
            border-radius: 4px;
            width: 85%; /* Full width for the exit button */
            margin-top: 20px; /* Space above the exit button */
        }
        .exit-button:hover {
            background-color: #d32f2f; /* Darker red on hover */
        }
    </style>
</head>

<body>
<div class="main">
    <h2>Pet Registration </h2>
    <form action="/addpet" method="post" modelAttribute="pet" >
        <label for="first">Name:</label>
        <input type="text" id="name" name="name" required />

        <label for="first">Type:</label>
        <input type="text" id="type" name="type" required />

        <label for="email">Breed:</label>
        <input type="text" id="Breed" name="Breed" required />


        <label for="mobile">age:</label>
        <input type="text" id="age" name="age" maxlength="10" required />

        <button type="submit">Submit</button>
        <a href="/dashboardback" class="exit-button">Exit</a>
    </form>
</div>
</body>

</html>




</body>
</html>