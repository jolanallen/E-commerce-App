document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("login-form");

    if (!form) {
        console.error("Login form not found!");
        return;
    }

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const credentials = {
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        };

        fetch("http://localhost:3000/users/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(credentials)
        })
            .then(response => {
                if (!response.ok) throw new Error("Login failed");
                return response.text();
            })
            .then(() => alert("Login successful!"))
            .catch(error => alert(error));
    });
});
