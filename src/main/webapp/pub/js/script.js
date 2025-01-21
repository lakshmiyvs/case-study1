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

// Display confirmation message
const confirmationMessage = $("#reviewConfirmation");
if (confirmationMessage.length) {
    confirmationMessage.html(
        `Thank you, ${name}! Your review has been submitted successfully.`
    );
    confirmationMessage.removeClass("hidden").show();
}

// Clear form fields after successful submission
$("#reviewForm")[0].reset();


