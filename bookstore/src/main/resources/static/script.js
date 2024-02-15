
    function validateForm() {
        var name = document.getElementById('name').value.trim();
        var author = document.getElementById('author').value.trim();
        var price = document.getElementById('price').value.trim();

        if (name === '' || author === '' || price === '') {
            alert('Please fill out all required fields.');
            return false;
        }

        return true;
    }

     function clearForm() {
        document.getElementById('name').value = '';
        document.getElementById('author').value = '';
        document.getElementById('edition').value = '';
        document.getElementById('price').value = '';
        document.getElementById('publisher').value = '';
}

 document.addEventListener('DOMContentLoaded', function() {
     const navItems = document.querySelectorAll('.topnav a');
     navItems.forEach(item => {
         item.addEventListener('click', function(event) {
             event.preventDefault();
             navItems.forEach(navItem => {
                 navItem.classList.remove('topnav-selected');
             });
             this.classList.add('topnav-selected');
         });
     });
 });






