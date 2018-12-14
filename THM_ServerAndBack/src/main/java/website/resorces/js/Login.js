var attempt = 3; // Variable to count number of attempts.

// Below function Executes on click of login button.
function validate() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', "http://localhost:8080/api/hello/" + username, true);
    xhr.send();
    xhr.onreadystatechange = processRequest;

    if (username == "123" && password == "123") {
        alert("Login successfully");
        window.location = "Options.html"; // Redirecting to other page.
        return false;
    } else {
        attempt--; // Decrementing by one.
        alert("You have left " + attempt + " attempt;");
        // Disabling fields after 3 attempts.
        if (attempt == 0) {
            document.getElementById("username").disabled = true;
            document.getElementById("password").disabled = true;
            return false;
        }
    }
}


function processRequest(e) {
    if (this.readyState == 4 && this.status == 200) {
        alert(this.responseText);
    }
}
