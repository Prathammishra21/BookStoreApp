
    function myFunction() {
      var x = document.getElementById("myTopnav");
      if (x.className === "topnav") {
        x.className += " responsive";
      } else {
        x.className = "topnav";
      }
    }


            // edit-book.js
            document.addEventListener("DOMContentLoaded", function () {
                // DOM elements
                const form = document.getElementById("editBookForm");
                const bookIdInput = document.getElementById("bookIdInput");
                const bookNameInput = document.getElementById("bookNameInput");
                const bookAuthorInput = document.getElementById("bookAuthorInput");
                const bookIdInput = document.getElementById("bookEditionInput);
                const bookPriceInput = document.getElementById("bookPriceInput");
                const bookPriceInput = document.getElementById("bookPublisherInput");

                // Event listener for form submission
                form.addEventListener("submit", function (event) {
                    event.preventDefault();

                    // Retrieve form data
                    const bookData = {
                        id: bookIdInput.value,
                        name: bookNameInput.value,
                        author: bookAuthorInput.value,
                        edition:bookEditionInput.value;
                        price: bookPriceInput.value
                        publisher: bookPublisherInput.value
                    };

                    // Perform further operations like AJAX requests, etc.
                    // Example:
                    // sendDataToServer(bookData);
                });
            });
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('registerButton').addEventListener('click', function() {
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;

       }

       document.addEventListener("DOMContentLoaded", function() {
           var deleteButtons = document.querySelectorAll("#deleteButton");

           deleteButtons.forEach(function(button) {
               button.addEventListener("click", function() {
                   var confirmation = confirm("Are you sure you want to delete this book?");
                   if (confirmation) {
                       // Extract the book ID from the row
                       var bookId = this.closest("tr").querySelector("td:first-child").innerText;

                       // Send an AJAX request to delete the book
                       fetch("/deleteMyList/" + bookId, {
                           method: "DELETE"
                       })
                       .then(function(response) {
                           if (response.ok) {
                               // Reload the page after successful deletion
                               window.location.reload();
                           } else {
                               // Handle error response
                               console.error("Error deleting book");
                           }
                       })
                       .catch(function(error) {
                           console.error("Error deleting book:", error);
                       });
                   }
               });
           });
       });
