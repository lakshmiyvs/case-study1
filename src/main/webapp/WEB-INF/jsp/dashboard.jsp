<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Page</title>
    <style>
        /* Basic reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
        }

        /* Header Styling */
        header {
            background-color: #4caf50;
            color: white;
            padding: 20px;
            text-align: center;
        }

        /* Footer Styling */
        footer {
            background-color: #4caf50;
            color: white;
            padding: 10px;
            text-align: center;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        /* Main content styling */
        .content {
            padding: 20px;
            text-align: left;
            margin-bottom: 60px; /* to ensure content is not hidden by footer */
        }

        h1 {
            font-size: 2.5em;
            color: #333;
        }

        p {
            font-size: 1.2em;
            color: white;
        }

        .button-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50; /* Green background */
            color: white; /* Text color */
            text-align: center;
            text-decoration: none; /* Remove underline */
            border-radius: 5px;
            border: 2px solid #4CAF50; /* Border matching background color */
            transition: background-color 0.3s, border 0.3s;
        }

        .button-link:hover {
            background-color: #45a049; /* Darker green on hover */
            border: 2px solid #45a049; /* Matching border on hover */
        }

        .button-link:active {
            background-color: #3e8e41; /* Even darker green when clicked */
        }

        .logout-button {
            display: inline-block;
            border: none;
            background: transparent;
            cursor: pointer;
        }

        .logout-button img {
            width: 20px; /* Adjust size */
            height: 20px;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        td, th {
            border: 1px solid #ddd; /* Border color for table cells */
            padding: 8px; /* Padding inside table cells */
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Light gray background for even rows */
        }

    </style>
</head>
<body>

<!-- Header Section -->
<header>
    <h1>Welcome to Pet DashBoard - ${name} </h1>

    <c:if test="${userType ==0}">
    <div>
        <div align ="left" style="margin-left:1%">
            <a href="/appointments" class="button-link">Book Appointment</a>
            <a href="/petregistration" class="button-link">Pet Registration</a></div>
        <div align ="right"><a href="/" class="logout-button">
            <img src="/images/logout-icon.png"  alt="Logout">
        </a></div>
    </div>


    <!-- Logout button with an image -->

</header>

<!-- Main Content Section -->
<div class="content">
    <h1>List of Appointment</h1>
    </br>
    <table width="100%" border="0">
        <thead>
        <tr>
            <th>Pet Name</th>
            <th>Service Name</th>
            <th>Appointment Date</th>
            <th>Status</th>
            <th>Reschedule Appointment</th>
        </tr>
        </thead>
        <tbody>
        <!-- Iterate over the list of appointments -->
        <c:forEach var="appointment" items="${appointmentList}">
            <tr>
                <td>${appointment.petName}</td>
                <td>${appointment.serviceName}</td>
                <td>${appointment.dateTime}</td>
                <td>${appointment.status}</td>
                <td><a href="/editappointments/${appointment.appointmentId}">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div> </c:if>

<c:if test="${userType ==1}">
    <div>
        <div align ="left" style="margin-left:1%">
            <a href="/petservicepage" class="button-link">Pet Service</a>
            <div align ="right"><a href="/" class="logout-button">
                <img src="/images/logout-icon.png"  alt="Logout">
            </a></div>
        </div>


        <!-- Logout button with an image -->

    </div>

    <!-- Main Content Section -->
    <div class="content">
        <h1>List of Services</h1>
        </br>
        <table width="100%" border="0">
            <thead>
            <tr>
                <th>Service Name</th>
                <th>Description</th>
                <th>Services Charges</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <!-- Iterate over the list of appointments -->
            <c:forEach var="service" items="${servicesList}">
                <tr>
                    <td>${service.name}</td>
                    <td>${service.description}</td>
                    <td>${service.price}</td>
                    <td><a href="/editservices/${service.serviceid}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div> </c:if>

<!-- Footer Section -->
<footer>
    <p>&copy; 2025 Purrfect Paws Grooming | All Rights Reserved</p>
</footer>

</body>
</html>

