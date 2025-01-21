<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<script>

  // JavaScript code for carousel image transitions (1-second interval)

  let currentIndex = 0;
  const images = document.querySelectorAll('.carousel-image');
  const totalImages = images.length;

  function showNextImage() {
    images[currentIndex].style.transform = 'translateX(-100%)';
    currentIndex = (currentIndex + 1) % totalImages;
    images[currentIndex].style.transform = 'translateX(0)';
  }

  // Set interval to automatically change images every 1 second
  setInterval(showNextImage, 1000);

  // Optional: add event listeners for manual control of the carousel (e.g., buttons)


</script>
<head>
  <meta charset="UTF-8">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>PetSmart Promo Page</title>
  <link rel="stylesheet" href="/pub/css/style.css">
  <style>

    .navbar {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 2px 10px;
      border-bottom: 1px solid #ddd;
      background-color: white;
    }

    .nav-left img {
      height: 35px;
    }

    .nav-right {
      display: flex;
      align-items: center;
      gap: 20px;
    }

    .nav-right a {
      text-decoration: none;
      color: #0056b3;
      font-size: 16px;
      font-weight: bold;
    }

    /* Dropdown Menu */
    .dropdown {
      position: relative;
    }

    .dropdown-content {
      display: none;
      position: absolute;
      top: 100%;
      right: 0;
      background-color: white;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      z-index: 1;
    }

    .dropdown-content a {
      display: block;
      padding: 12px 15px;
      text-decoration: none;
      color: #333;
    }

    .dropdown-content a:hover {
      background-color: #f1f1f1;
    }

    .dropdown:hover .dropdown-content {
      display: block;
    }

    /* Blue Navigation Line */
    .blue-line {
      background-color: #4caf50;
      color: white;
      padding: 10px 0;
    }

    .nav-container {
      padding: 0px 125px;
    }

    .nav-list {
      list-style: none;
      display: flex;
      justify-content: space-between;
      gap: 20px;
      padding: 0;
      margin: 0;
    }

    .nav-list a {
      color: white;
      text-decoration: none;
      font-size: 14px;
      font-weight: bold;
    }

    /* Carousel Styles */
    .carousel {
      position: relative;
      display: flex;
      overflow: hidden;
      width: 300px;
      height: 200px;
      border-radius: 10px;
    }

    .carousel-image {
      width: 100%;
      flex-shrink: 0;
      object-fit: cover;
      transition: transform 1s ease-in-out;
    }

    /* Promo Section */
    .promo-banner {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: #e31b23;
      color: white;
      padding: 20px;
    }

    .promo-text h1 {
      font-size: 3rem;
    }

    .promo-text p {
      font-size: 1.2rem;
    }

    .btn {
      background-color: white;
      color: #e31b23;
      padding: 10px 20px;
      border-radius: 5px;
      font-weight: bold;
      text-decoration: none;
      cursor: pointer;
    }

    /* Animated Images */
    .animated-images {
      background-color: #0066cc;
      color: white;
      text-align: center;
      padding: 20px;
    }

    .animated-images img {
      width: 200px;
      margin: 10px;
      transition: transform 0.3s, opacity 0.3s;
    }

    .animated-images img:hover {
      transform: scale(1.1);
      opacity: 0.8;
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
<!-- Top Navigation Bar -->
<header>
  <nav>
    <ul class="menu">
      <li><a href="/">Home</a></li>
      <li><a href="/allpetservices">Services</a></li>
      <li><a href="/contact">Contact Us</a></li>
      <li><a href="/aboutme">About Me</a></li>
      <li><a href="/login">Sign In</a></li>
      <li><a href="/registration">Create Account</a></li>
    </ul>
  </nav>

</header>


<!-- Promo Section -->
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

    </tr>
    </thead>
    <tbody>
    <!-- Iterate over the list of appointments -->
    <c:forEach var="service" items="${servicesList}">
      <tr>
        <td>${service.name}</td>
        <td>${service.description}</td>
        <td>${service.price}</td>

      </tr>
    </c:forEach>
    </tbody>
  </table>

</div>

<!-- Footer -->
<footer>
  <p>2025 Purrfect Paws Grooming. All rights reserved. | <a href="#">Privacy Policy</a> | <a href="#">Terms of Use</a></p>
</footer>

<script src="/js/script.js"></script>
</body>
</html>
