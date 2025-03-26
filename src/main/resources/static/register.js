document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("register-form");
    if (!form) {
        console.error("Register form not found!");
        return;
    }

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const userData = {
            username: document.getElementById("username").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        };

        fetch("http://localhost:3000/users/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
        })
            .then(response => {
                if (!response.ok) throw new Error("Registration failed");
                return response.text();
            })
            .then(() => alert("User registered successfully!"))
            .catch(error => alert(error));
    });
});
