
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
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('registerButton').addEventListener('click', function() {
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;

        // Perform validation if needed

        // Example: Sending data to server using fetch API
        fetch('/registration', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                email: email,
                password: password
            })
        })
        .then(response => response.json())
        .then(data => {
            // Handle response
            console.log(data);
            // Optionally, redirect to another page
            // window.location.href = '/success';
        })
        .catch(error => console.error('Error:', error));
    });
});

