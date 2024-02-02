
    function myFunction() {
      var x = document.getElementById("myTopnav");
      if (x.className === "topnav") {
        x.className += " responsive";
      } else {
        x.className = "topnav";
      }
    }
            function clearForm() {
                document.getElementById("myForm").reset();
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

