document.addEventListener("DOMContentLoaded", function () {
    setTimeout(() => {
        document.querySelector(".pre-loader").style.display = "none";
    }, 2000); // Wait for 2 seconds before hiding the pre-loader
});




// document.addEventListener("DOMContentLoaded", function () {
//     const loadingText = document.querySelectorAll(".loading-text span");
//     let index = 0;

//     function animateText() {
//         if (index < loadingText.length) {
//             loadingText[index].style.animation = "fadeOut 0.5s ease forwards";
//             index++;
//             if (index < loadingText.length) {
//                 setTimeout(animateText, 300);
//             } else {
//                 setTimeout(() => {
//                     document.querySelector(".pre-loader").style.display = "none";
//                 }, 500);
//             }
//         }
//     }

//     animateText();
// });
