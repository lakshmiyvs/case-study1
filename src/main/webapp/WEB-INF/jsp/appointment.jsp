<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Appointment Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #4CAF50;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
            display: block;
        }
        input, textarea, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
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
            width: 94%; /* Full width for the exit button */
            margin-top: 20px; /* Space above the exit button */
        }
        .exit-button:hover {
            background-color: #d32f2f; /* Darker red on hover */
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Book Your Doctor's Appointment</h2>
    <form action="/addappointment" method="post" modelAttribute="appointments">
        <div class="form-group">
            <label for="name">Pet Name:</label>
            <select name="petid" id="petid">
                <option value="">-----</option>
                <c:forEach var="pet" items="${petList}">
                    <option value="${pet.petid}" ${pet.petid == appointment.petid ? 'selected' : ''}>${pet.name}</option>
                </c:forEach>
            </select>


            <div class="form-group">
                <label for="name">Service Name:</label>
                <select name="serviceid" id="serviceid">
                    <option value="">-----</option>
                    <c:forEach var="service" items="${serviceList}">
                        <option value="${service.serviceid}" ${service.serviceid == appointment.serviceid ? 'selected' : ''}>${service.name}</option>

                    </c:forEach>




                </select>


                <div class="form-group">
                    <label for="date">Preferred Appointment Date:</label>
                    <input type="date" id="date" name="date" value="${appointment.date}" required>
                    <input type="hidden" id="appointmentid" name="appointmentid" value="${appointment.appointmentid}" >
                </div>
                <div class="form-group">
                    <label for="time">Preferred Appointment Time:</label>
                    <input type="time" id="time" name="time" value="${appointment.time}" required>
                </div>

                <div class="form-group">
                    <label for="message">Message (Optional):</label>
                    <textarea id="message" name="message" rows="4" placeholder="Describe your symptoms or concern">${appointment.message}</textarea>
                </div>
                <button type="submit">Book Appointment</button>
                <a href="/dashboardback" class="exit-button">Exit</a>
    </form>

</div>

<div class="footer">
    <p>&copy; 2025 Purrfect Paws Grooming | All rights reserved</p>
</div>

</body>
</html>
