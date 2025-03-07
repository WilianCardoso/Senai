//------------------------------------------------------------------------------------------------
// Importação de frameworks e bibliotecas
//------------------------------------------------------------------------------------------------
const express = require('express');
const http = require('http');
const WebSocket = require('ws');

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

let clients = {}; // Alterado para um objeto para armazenar { nomeUsuario: { ws, ip } }

//------------------------------------------------------------------------------------------------
// Quando um cliente se conectar
//------------------------------------------------------------------------------------------------
wss.on('connection', (ws, req) => {
    console.log('Novo cliente conectado');

    // Captura o IP do cliente a partir do cabeçalho do pedido
    const clientIp = req.socket.remoteAddress;
    const clientIpv4 = clientIp.includes('::ffff:') ? clientIp.split('::ffff:')[1] : clientIp;

    // Evento para receber mensagens
    ws.on('message', (message) => {
        const data = JSON.parse(message);

        if (data.type === 'login') {
            clients[data.username] = { ws, ip: clientIpv4 };
            console.log(`Usuário ${data.username} conectado de IP: ${clientIpv4}`);
            broadcastClients();
        }
    });

    // Evento para quando um cliente desconectar
    ws.on('close', () => {
        for (let user in clients) {
            if (clients[user].ws === ws) {
                console.log(`Usuário ${user} desconectado`);
                delete clients[user];
                broadcastClients();
                break;
            }
        }
    });
});


//------------------------------------------------------------------------------------------------
// Função para atualizar a lista de usuários conectados
//------------------------------------------------------------------------------------------------
function broadcastClients() {
    const userDetails = Object.keys(clients).map((username) => ({
        username: username,
        ip: clients[username].ip
    }));

    console.log('Usuários online:', userDetails);

    wss.clients.forEach((client) => {
        if (client.readyState === WebSocket.OPEN) {
            client.send(JSON.stringify({ type: 'updateUsers', users: userDetails }));
        }
    });
}

//------------------------------------------------------------------------------------------------
// Configura o Express para servir arquivos estáticos
//------------------------------------------------------------------------------------------------
app.use(express.static(__dirname + '/public'));

// Iniciando o servidor WebSocket na porta 3000
server.listen(3000, () => {
    console.log('Servidor WebSocket rodando na porta 3000');
});

function broadcastClients() {
    const userDetails = Object.keys(clients).map((username) => {
        return { username: username, ip: clients[username].ip };
    });

    console.log('Usuários online:', userDetails); // Verifique se a lista de usuários está sendo criada corretamente

    wss.clients.forEach((client) => {
        if (client.readyState === WebSocket.OPEN) {
            client.send(JSON.stringify({ type: 'updateUsers', users: userDetails }));
        }
    });
}