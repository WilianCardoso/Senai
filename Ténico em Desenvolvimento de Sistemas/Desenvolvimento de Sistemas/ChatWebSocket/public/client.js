let socket;

function conectar() {
    const serverIp = document.getElementById('ipServer').value;
    const username = document.getElementById('player').value;

    socket = new WebSocket(`ws://${serverIp}:3000`);

    // Evento disparado quando a conexão é estabelecida
    socket.onopen = () => {
        socket.send(JSON.stringify({ type: 'login', username }));
    };

    // Evento disparado quando uma mensagem é recebida do servidor
    socket.onmessage = (event) => {
        const data = JSON.parse(event.data);

        if (data.type === 'updateUsers') {
            const userList = document.getElementById('player2');
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
            const chat = document.getElementById('msgShoot');
            chat.innerHTML += `<p><strong>${data.from}:</strong> ${data.message}</p>`;
            const partes = data.message.split(":");
            const linha = parseInt(partes[1].substring(1));
            const coluna = parseInt(partes[0].substring(1));
            const shoot = partes[2];




            if (shoot.includes('FOGO')) {
                //alert("FOGO");
                marcaShoot(linha, coluna, "F");
            } else if (shoot.includes('AGUA')) {
                //alert("AGUA");
                marcaShoot(linha, coluna, "A");
            } else if (shoot.includes('TIRO')) {
                //alert("TIRO");
                checarBomba(linha, coluna);
            }
        }
    };
}

function shoot() {
    const coordenadaTiro = document.getElementById('shoot').value;
    const toUser = document.getElementById('player2').value;
    const username = document.getElementById('player').value;

    socket.send(JSON.stringify({
        type: 'message',
        from: username,
        to: toUser,
        message: coordenadaTiro + ":TIRO"
    }));

    document.getElementById('shoot').value = '';
}

function infoShoot(msg) {
    const toUser = document.getElementById('player2').value;
    const username = document.getElementById('player').value;

    socket.send(JSON.stringify({
        type: 'message',
        from: username,
        to: toUser,
        message: msg
    }));

    document.getElementById('shoot').value = '';
}

// Criar o tabuleiro 16x16
const boardSize = 16;
const board = [];

let esquadra = {
    submarino: { size: 1, count: 4, color: 'blue' },
    cruzador: { size: 2, count: 3, color: 'green' },
    hidroaviao: { size: 3, count: 5, color: 'red' },
    encouracado: { size: 4, count: 2, color: 'purple' },
    portaAvioes: { size: 5, count: 1, color: 'orange' }
};

let itemEsquadraAtual = "submarino";
const playerEsquadra = [];
let qtdItemEsquadra = [4, 3, 5, 2, 1];

let jogoIniciado = false;
let currentDirection = 'horizontal'; // Direção inicial (horizontal)

// Criar o tabuleiro Jogador 1
function createBoard() {

    const boardContainer = document.getElementById('board');
    boardContainer.innerHTML = ''; // Limpar o tabuleiro antes de recriar
    // Criar a matriz 16x16 do tabuleiro
    for (let row = 0; row < boardSize; row++) {
        board[row] = [];
        for (let col = 0; col < boardSize; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            cell.dataset.row = row;
            cell.dataset.col = col;

            // Adicionar os títulos das linhas e colunas
            if (row === 0 && col > 0) {
                cell.textContent = String.fromCharCode(64 + col); // Coloca Letras do alfabeto como título para as colunas
                cell.classList.add('title');
            }
            if (col === 0 && row > 0) {
                cell.textContent = row; // Coloca Números como títulos das linhas
                cell.classList.add('title');
            }

            cell.addEventListener('mousedown', (event) => onCellClick(event, row, col));
            board[row].push(cell);
            boardContainer.appendChild(cell);


        }
    }
}

// Criar o tabuleiro Jogador 2
function createBoard2() {

    const boardContainer = document.getElementById('board-player2');
    boardContainer.innerHTML = ''; // Limpar o tabuleiro antes de recriar
    // Criar a matriz 16x16 do tabuleiro
    for (let row = 0; row < boardSize; row++) {
        board[row] = [];
        for (let col = 0; col < boardSize; col++) {
            const cell2 = document.createElement('div');
            cell2.classList.add('cell2');
            cell2.dataset.row = row;
            cell2.dataset.col = col;

            // Adicionar os títulos das linhas e colunas
            if (row === 0 && col > 0) {
                cell2.textContent = String.fromCharCode(64 + col); // Coloca Letras do alfabeto como título para as colunas
                cell2.classList.add('title');
            }
            if (col === 0 && row > 0) {
                cell2.textContent = row; // Coloca Números como títulos das linhas
                cell2.classList.add('title');
            }

            cell2.addEventListener('mousedown', (event) => onCellClick2(event, row, col));
            board[row].push(cell2);
            boardContainer.appendChild(cell2);


        }
    }
}

// Função para mudar o barco atual
function trocaItem() {
    const shipOrder = ["submarino", "cruzador", "hidroaviao", "encouracado", "portaAvioes"];
    const currentIndex = shipOrder.indexOf(itemEsquadraAtual);

    itemEsquadraAtual = shipOrder[(currentIndex + 1) % shipOrder.length];
    alert(`Agora coloque o ${itemEsquadraAtual}.`);

}


// Função para alterar a direção do barco baseado no botão do mouse
function onCellClick(event, row, col) {
    // Definir direção com base no botão do mouse

    let qtd = esquadra[itemEsquadraAtual].count;

    if (event.button === 0) {
        // Botão esquerdo (horizontal)
        currentDirection = "HORIZONTAL";
    } else if (event.button === 2) {
        // Botão direito (vertical)
        currentDirection = "VERTICAL";
    }



    if (esquadra[itemEsquadraAtual].count === 0) {
        alert("Toda a esquadra já está posicionada.");
        return;
    }
    else {

        alert(currentDirection + ": " + "\nLinha: " + row + "\nColuna: " + col + "\n" + itemEsquadraAtual + "\nPosicionado 1 " + itemEsquadraAtual + " restam " + (qtd - 1));

        esquadra[itemEsquadraAtual].count--;

        colocaPeca(row, col);

        if (esquadra[itemEsquadraAtual].count === 0) {

            trocaItem();

        }
    }

}

function onCellClick2(event, row, col) {

    let qtd = esquadra[itemEsquadraAtual].count;

    if (event.button === 0) {
        // Botão esquerdo (horizontal)
        currentDirection = "HORIZONTAL";
    } else if (event.button === 2) {
        // Botão direito (vertical)
        currentDirection = "VERTICAL";
    }

    // Exibindo a coordenada do tiro
    const shoot = document.getElementById('shoot');
    shoot.value = "C" + col + ":L" + row;

}

// Função para marcar o tiro
 function marcaTiro(row, col, shoot) {

    const newBomb = [];
    const msgShoot = shoot;

    document.querySelector(`.cell2[data-row="${row}"][data-col="${col}"]`).classList.add('shoot');
    const cell = document.querySelector(`.cell2[data-row="${row}"][data-col="${col}"]`);

    if (cell) {
        if (msgShoot === 'F') {
            cell.style.backgroundColor = 'green';

        } else if (msgShoot === 'A') {
            cell.style.backgroundColor = 'gray';
        }
    }

    else {
        alert("Célula não existe...")
    }

    newBomb.push({ row, col: col });


}

// Função para colocar o barco
function colocaPeca(row, col) {
    const itemSize = esquadra[itemEsquadraAtual].size;
    const itemColor = esquadra[itemEsquadraAtual].color;
    const newItem = [];

    // Lógica para o hidroavião
    if (itemEsquadraAtual === "hidroaviao") {
        if (currentDirection === "HORIZONTAL") {
            if (col + 1 >= boardSize || row + 1 >= boardSize || col - 1 < 1 || row < 1) {
                alert("Não é possível colocar o hidroavião aqui.");

                esquadra[itemEsquadraAtual].count++;

                return;
            }

            if (
                document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.contains('ship')
            ) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }
            // Marca no tabuleiro como célula em uso
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.add('ship');            // Ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).classList.add('ship');    // Asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.add('ship');    // Asa direita

            // Pinta a cor do hidroavião
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).style.backgroundColor = itemColor;            // Cor da ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).style.backgroundColor = itemColor;    // Cor da asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor;    // Cor da asa direita

            newItem.push({ row, col }, { row: row + 1, col: col - 1 }, { row: row + 1, col: col + 1 });


        } else if (currentDirection === "VERTICAL") {
            if (row + 1 >= boardSize || row - 1 < 1 || col < 1 || col + 1 >= boardSize) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            if (
                document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + 1}"]`).classList.contains('ship')
            ) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.add('ship'); // Ponta
            document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa superior
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa inferior
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).style.backgroundColor = itemColor; // Cor da ponta
            document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa superior
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa inferior
            newItem.push({ row, col }, { row: row - 1, col: col + 1 }, { row: row + 1, col: col + 1 });
        }
    }

    else if (itemEsquadraAtual === "submarino") {
        if (currentDirection === "HORIZONTAL") {
            if ((col + itemSize - 1) >= boardSize || (row < 1) || (col < 1)) {
                alert("Não é possível colocar o submarino aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o submarino aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }

        } else if (currentDirection === "VERTICAL") {
            if ((row + itemSize - 1) >= boardSize || (col < 1) || (row < 1)) {
                alert("Não é possível colocar o submarino aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o submarino aqui.");

                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
    else if (itemEsquadraAtual === "cruzador") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
                alert("Não é possível colocar o cruzador aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o cruzador aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
                alert("Não é possível colocar o cruzador aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o cruzador aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }

    else if (itemEsquadraAtual === "encouracado") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
                alert("Não é possível colocar o encouraçado aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o encouraçado aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
                alert("Não é possível colocar o encouraçado aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o encouraçado aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
    else if (itemEsquadraAtual === "portaAvioes") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
                alert("Não é possível colocar o porta-aviões aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o porta-aviões aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
                alert("Não é possível colocar o porta-aviões aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o porta-aviões aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
}

function checarBomba(row, col) {
    if (document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship')) {
        infoShoot('C' + col + ':L' + row + ':FOGO');
       // alert("Fogo: Alvo atingido.");

    }
    else {
        infoShoot('C' + col + ':L' + row + ':AGUA');
    //    alert("Agua: Alvo não atingido.");
    }
}

// Inicializar o tabuleiro ao carregar a página
window.onload = () => createBoard(), createBoard2();