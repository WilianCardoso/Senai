const boardSize = 16;
const boardSize2 = 16;
const board = [];
const board_2 = [];

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

let jogoIniciado = true;
let currentDirection = 'HORIZONTAL';


// Cria tabuleiro
function createBoard() {
    const boardContainer = document.getElementById('board');
    boardContainer.innerHTML = '';
    // Cria a matriz 16x16 do tabuleiro
    for (let row = 0; row < boardSize; row++) {
        board[row] = [];
        for (let col = 0; col < boardSize; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            cell.dataset.row = row;
            cell.dataset.col = col;

            if (row === 0 && col > 0) {
                cell.textContent = String.fromCharCode(64 + col);
                cell.classList.add('title');
            }
            if (col === 0 && row > 0) {
                cell.textContent = row;
                cell.classList.add('title');
            }

            cell.addEventListener('mousedown', (event) => onCellClick(event, row, col));
            board[row].push(cell);
            boardContainer.appendChild(cell);
        }
    }
}

function createBoard2() {
    const boardContainer2 = document.getElementById('board_2');
    boardContainer2.innerHTML = '';
    // Cria a matriz 16x16 do tabuleiro
    for (let row = 0; row < boardSize2; row++) {
        board_2[row] = [];
        for (let col = 0; col < boardSize2; col++) {
            const cell_2 = document.createElement('div'); // Corrigido
            cell_2.classList.add('cell_2');

            cell_2.dataset.row = row;
            cell_2.dataset.col = col;

            if (row === 0 && col > 0) {
                cell_2.textContent = String.fromCharCode(64 + col);
                cell_2.classList.add('title_2');
            }
            if (col === 0 && row > 0) { // Corrigido
                cell_2.textContent = row;
                cell_2.classList.add('title_2');
            }
            // Adiciona o evento de clique para disparo
            cell_2.addEventListener('mousedown', (event) => shoot(event));
            board_2[row].push(cell_2);
            boardContainer2.appendChild(cell_2);
        }
    }
}

// Mudar barco atual
function changeItem() {
    const shipOrder = ["submarino", "cruzador", "hidroaviao", "encouracado", "portaAvioes"];
    const currentIndex = shipOrder.indexOf(itemEsquadraAtual);

    itemEsquadraAtual = shipOrder[(currentIndex + 1) % shipOrder.length];
    alert(`Agora coloque o ${itemEsquadraAtual}.`);
}


// Alterar direção do barco através do mouse
function onCellClick(event, row, col) {
    let qtd = esquadra[itemEsquadraAtual].count;

    if (event.button === 0) {
        currentDirection = "HORIZONTAL";
        //alert(currentDirection + "\nLinha: " + row + "\nColuna: " + col);
    } else if (event.button === 2) {
        currentDirection = "VERTICAL";
        //alert(currentDirection + "\nLinha: " + row + "\nColuna: " + col);
    }

    if (esquadra[itemEsquadraAtual].count === 0) {
        alert("Toda a esquadra já está posicionada.")
        return;
    } else {
        alert(currentDirection + ": " + "\nLinha: " + row + "\nColuna: " + col + "\n" + itemEsquadraAtual + "\n Posicionado 1 " + itemEsquadraAtual + " restam " + (qtd - 1));
        esquadra[itemEsquadraAtual].count--;
        placePart(row, col);
        if (esquadra[itemEsquadraAtual].count === 0) {
            changeItem();
        }
    }
}

// Colocar barco
function placePart(row, col) {
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
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.add('ship');  // Ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).classList.add('ship'); // Asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa direita
            // Pinta a cor do hidroavião
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).style.backgroundColor = itemColor;  // Cor da ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).style.backgroundColor = itemColor; // Cor da asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa direita

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
            if (row + itemSize - 1 >= boardSize || (col < 1) || (row < 1)) {
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
            if (col + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
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
            if (row + itemSize - 1 >= boardSize || (row < 1) || (col < 1)) {
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

window.onload = () => createBoard();
window.onload = () => createBoard2();