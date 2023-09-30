const forms = document.querySelector(".forms"),
pwShowHide = document.querySelectorAll(".eye-icon"),
links = document.querySelectorAll(".link");

pwShowHide.forEach(eyeIcon => {
eyeIcon.addEventListener("click", () => {
  let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll(".password");
  
  pwFields.forEach(password => {
      if(password.type === "password"){
          password.type = "text";
          eyeIcon.classList.replace("bx-hide", "bx-show");
          return;
      }
      password.type = "password";
      eyeIcon.classList.replace("bx-show", "bx-hide");
  })
  
})
})    
const nav = document.querySelector(".nav"),
searchIcon = document.querySelector("#searchIcon"),
navOpenBtn = document.querySelector(".navOpenBtn"),
navCloseBtn = document.querySelector(".navCloseBtn");

searchIcon.addEventListener("click", () => {
nav.classList.toggle("openSearch");
nav.classList.remove("openNav");
if (nav.classList.contains("openSearch")) {
return searchIcon.classList.replace("uil-search", "uil-times");
}
searchIcon.classList.replace("uil-times", "uil-search");
});

navOpenBtn.addEventListener("click", () => {
nav.classList.add("openNav");
nav.classList.remove("openSearch");
searchIcon.classList.replace("uil-times", "uil-search");
});
navCloseBtn.addEventListener("click", () => {
nav.classList.remove("openNav");
});  

links.forEach(link => {
link.addEventListener("click", e => {
 e.preventDefault(); //preventing form submit
 forms.classList.toggle("show-signup");
})
})
// Get the modal and close button elements
var modal = document.getElementById("terms-modal");
var closeButton = document.getElementById("close-button");

// Get the terms and conditions link
var termsLink = document.getElementById("terms-link");

// When the user clicks the link, display the modal
termsLink.addEventListener("click", function(event) {
event.preventDefault(); // Prevent the link from navigating to another page
modal.style.display = "block";
});

// When the user clicks the close button or outside the modal, close it
closeButton.addEventListener("click", function() {
modal.style.display = "none";
});

window.addEventListener("click", function(event) {
if (event.target == modal) {
modal.style.display = "none";
}
});
