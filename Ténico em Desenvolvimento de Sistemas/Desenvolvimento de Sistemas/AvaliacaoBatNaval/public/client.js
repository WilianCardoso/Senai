let socket;

function connectServer() {
    const serverIp = document.getElementById('serverIp').value;
    const username = document.getElementById('username').value;

    socket = new WebSocket(`ws://${serverIp}:3000`);

    // Evento disparado quando a conexão é estabelecida
    socket.onopen = () => {
        socket.send(JSON.stringify({ type: 'login', username }));
    };

    // Evento disparado quando um tiro é recebido do servidor
    socket.onmessage = (event) => {
        const data = JSON.parse(event.data);

        if (data.type === 'updateUsers') {
            updateUserList(data.users);
        }

        if (data.type === 'shot') {
            registerShot(data.from, data.row, data.col);
        }
    };
}
// Função para enviar um tiro
function shoot(event) {
    // Envia o tiro para o servidor
    const toUser = document.getElementById('userList').value; // Usuário alvo
    const username = document.getElementById('username').value; // Usuário que atira

    socket.send(JSON.stringify({
        type: 'shoot',
        from: username,
        to: toUser,
        row: row,
        col: col
    }));

    // Exibe a mensagem de confirmação do tiro
    alert(`${username} atirou em ${toUser}: \nLinha: ${row} \nColuna: ${col} \nCoordenada: ${coordinate}`);

    // Registra e exibe o tiro disparado no histórico
    updateHistory(`${username}: ${coordinate}`);
}

// Atualiza a lista de jogadores
function updateUserList(users) {
    const userList = document.getElementById('userList');
    userList.innerHTML = ''; // Limpa a lista existente

    users.forEach((user) => {
        if (user.username !== "allusers") {
            const option = document.createElement('option');
            option.value = user.username;
            option.innerText = `${user.username} (${user.ip})`;
            userList.appendChild(option);
        }
    });

    const option = document.createElement('option');
    option.value = "Todos";
    option.innerText = "Todos";
    userList.appendChild(option);
}



// Atualiza o histórico de tiros no container 3
function updateHistory(text) {
    const chatBox = document.querySelector("chat-box");
    const message = document.createElement("p");
    message.textContent = text;
    chatBox.appendChild(message);
}