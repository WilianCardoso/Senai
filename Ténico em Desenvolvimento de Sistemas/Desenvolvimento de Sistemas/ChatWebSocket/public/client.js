// Lógica de negócio do client

let socket;

function connectServer() {
    const serverIp = document.getElementById('serverIp').value;
    const username = document.getElementById('username').value;

    socket = new WebSocket(`ws://${serverIp}:3000`);
    //evento disparo quando a conexão é estabelecida
    socket.onopen = () => {
        socket.send(JSON.stringify({ type: 'login', username }));
    };

    // Evento disparado quando uma mensagem é recebida do servidor
    socket.onmessage = (event) => {
        const data = JSON.parse(event.data);

        if (data.type === 'updateUsers') {
            const userList = document.getElementById('userList');
            userList.innerHTML = ''; // Limpa a lista existente

            data.users.forEach((user) => {
                if (user.username != "allusers") {
                    const option = document.createElement('option');
                    option.value = user.username;
                    // Exibe nome do usuário seguido do IP
                    option.innerText = `${user.username} (${user.ip})`;
                    userList.appendChild(option);
                }
            });
            const option = document.createElement('option');
            option.value = "Todos";
            option.innerText = "Todos";
            userList.appendChild(option);
        }

        if (data.from && data.message) {
            const chat = document.getElementById('chat');
            chat.innerHTML += `<p><strong>${data.from}:</strong> ${data.message}</p>`;
        }
    };
}

function sendMessage() {
    const message = document.getElementById('message').value;
    const toUser = document.getElementById('userList').value;
    const username = document.getElementById('username').value;

    socket.send(JSON.stringify({
        type: 'message',
        from: username,
        to: toUser,
        message: message
    }));

    document.getElementById('message').value = '';
}

function disconnetServer() {
    if (socket) {
        // Evento disparado quando a conexão é fechada
        socket.close(); // Fecha a conexão WebSocket
        console.log("Desconectado do servidor");

        // Atualiza a interface, removendo a lista de usuários e chat
        const userList = document.getElementById('userList');
        userList.innerHTML = '';
        const chat = document.getElementById('chat');
        chat.innerHTML = `<p><strong>Você foi desconectado.</strong></p>`;
    }
}