fetch('http://localhost:3000/api/users')
    .then(response => response.json())
    .then(users => {
        const userList = document.getElementById('user-list');

        users.forEach(user => {
            const card = document.createElement('div');
            card.className = 'user-card';

            card.innerHTML = `
                <h2>User ID: ${user.id_user}</h2>
                <p>Email: ${user.email}</p>
                <p>Name: ${user.username}</p>
            `;

            userList.appendChild(card);
        });
    })
    .catch(error => {
        console.error('Error fetching users:', error);
    });
