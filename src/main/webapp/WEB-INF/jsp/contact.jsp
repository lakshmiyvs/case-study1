<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us | Purrfect Paws Grooming</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/pub/css/style.css">
</head>
<body>
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
<h1>Contact Us</h1>
<!-- Contact Information -->
<div class="contact-info">
    <h3>Other Ways to Reach Us</h3>
    <p>If you'd like to reach us directly, feel free to use the following contact details:</p>
    <p>Email: <a href="mailto:support@purrfectpaws.com">support@petapplication.com</a></p>
    <p>Phone: <a href="tel:+1234567890">+123 456 7890</a></p>
</div>
<section id="customer-reviews">
    <h2>Customer Reviews</h2>
    <p>We value your feedback! Please let us know how we did.</p>
    <form id="reviewForm">
        <label for="reviewerName">Name:</label>
        <input type="text" id="reviewerName" name="reviewerName" placeholder="Enter your name" required>

        <label for="reviewerEmail">Email:</label>
        <input type="email" id="reviewerEmail" name="reviewerEmail" placeholder="Enter your email" required>

        <label for="serviceRating">Rating:</label><br>
        <input type="radio" id="rating5" name="serviceRating" value="5" required>
        <label for="rating5">5 - Excellent</label>
        <input type="radio" id="rating4" name="serviceRating" value="4">
        <label for="rating4">4 - Good</label>
        <input type="radio" id="rating3" name="serviceRating" value="3">
        <label for="rating3">3 - Average</label>
        <input type="radio" id="rating2" name="serviceRating" value="2">
        <label for="rating2">2 - Poor</label>
        <input type="radio" id="rating1" name="serviceRating" value="1">
        <label for="rating1">1 - Terrible</label><br>

        <label for="reviewText">Your Review:</label>
        <textarea id="reviewText" name="reviewText" rows="4" placeholder="Share your experience with us" required></textarea>

        <fieldset>
            <legend>Which services did you use?</legend>
            <input type="checkbox" id="service1" name="servicesUsed" value="grooming">
            <label for="service1">Grooming</label><br>
            <input type="checkbox" id="service2" name="servicesUsed" value="boarding">
            <label for="service2">Playtime</label><br>

        </fieldset>

        <button type="submit">Submit Review</button>
    </form>
    <div id="reviewConfirmation" class="hidden" style="display: none; margin-top: 20px; color: green; font-weight: bold;"></div>
</section>

<footer>
    <p>&copy; 2025 Purrfect Paws Grooming</p>
</footer>
<script src="script.js"></script>
</body>
</html>
