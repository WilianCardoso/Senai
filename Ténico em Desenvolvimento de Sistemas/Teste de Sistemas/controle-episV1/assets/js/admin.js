document.addEventListener('DOMContentLoaded', () => {
    const usuario = JSON.parse(localStorage.getItem('usuarioLogado'));
    const nomeAdmin = document.getElementById('adminNome');
  
    // 🔐 Verifica se o usuário está logado e é admin
    if (!usuario || usuario.tipo !== 'admin') {
      alert('Acesso restrito. Faça login como administrador.');
      window.location.href = 'index.html';
      return;
    }
  
    nomeAdmin.textContent = `Olá, ${usuario.nome} (Administrador)`;
  
    // 🎯 CADASTRO DE NOVO USUÁRIO
    const formUsuario = document.getElementById('formNovoUsuario');
    formUsuario.addEventListener('submit', (e) => {
      e.preventDefault();
      const nome = document.getElementById('novoNome').value.trim();
      const email = document.getElementById('novoEmail').value.trim();
      const senha = document.getElementById('novoSenha').value;
      const tipo = document.getElementById('novoTipo').value;
      const msg = document.getElementById('msgNovoUsuario');
  
      if (!nome || !email || !senha || !tipo) {
        msg.textContent = 'Preencha todos os campos.';
        msg.style.color = 'red';
        return;
      }
  
      const usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];
  
      if (usuarios.some(u => u.email === email)) {
        msg.textContent = 'Email já cadastrado.';
        msg.style.color = 'red';
        return;
      }
  
      usuarios.push({ nome, email, senha, tipo });
      localStorage.setItem('usuarios', JSON.stringify(usuarios));
      msg.textContent = 'Usuário cadastrado com sucesso!';
      msg.style.color = 'green';
      formUsuario.reset();
    });
  
    // 🎯 CADASTRO DE EPI
    const formEpi = document.getElementById('formNovoEpi');
    formEpi.addEventListener('submit', (e) => {
      e.preventDefault();
      const nome = document.getElementById('epiNome').value.trim();
      const quantidade = parseInt(document.getElementById('epiQuantidade').value);
      const msg = document.getElementById('msgNovoEpi');
  
      if (!nome || isNaN(quantidade) || quantidade < 1) {
        msg.textContent = 'Dados inválidos.';
        msg.style.color = 'red';
        return;
      }
  
      const epis = JSON.parse(localStorage.getItem('epis')) || [];
  
      if (epis.some(e => e.nome === nome)) {
        msg.textContent = 'EPI já cadastrado.';
        msg.style.color = 'red';
        return;
      }
  
      epis.push({ nome, quantidade });
      localStorage.setItem('epis', JSON.stringify(epis));
      msg.textContent = 'EPI cadastrado com sucesso!';
      msg.style.color = 'green';
      formEpi.reset();
    });
  
    // 🧾 LISTA DE EMPRÉSTIMOS PENDENTES
    function listarEmprestimos() {
      const container = document.getElementById('listaEmprestimosPendentes');
      const emprestimos = JSON.parse(localStorage.getItem('emprestimos')) || [];
  
      const pendentes = emprestimos.filter(e => !e.autorizado);
  
      if (pendentes.length === 0) {
        container.innerHTML = '<p>Nenhum empréstimo pendente.</p>';
        return;
      }
  
      container.innerHTML = '';
      pendentes.forEach((emp, index) => {
        const div = document.createElement('div');
        div.innerHTML = `
          <p><strong>${emp.colaborador}</strong> solicitou <strong>${emp.item}</strong> para ${emp.dataHora} (Previsão: ${emp.previsao})</p>
          <button onclick="autorizarEmprestimo(${index})">Autorizar</button>
          <hr>
        `;
        container.appendChild(div);
      });
    }
  
    // ✅ Autorizar empréstimo
    window.autorizarEmprestimo = function (index) {
      const emprestimos = JSON.parse(localStorage.getItem('emprestimos')) || [];
      const epis = JSON.parse(localStorage.getItem('epis')) || [];
  
      const emp = emprestimos.filter(e => !e.autorizado)[index];
      const epi = epis.find(e => e.nome === emp.item);
  
      if (!epi || epi.quantidade <= 0) {
        alert('Estoque insuficiente para autorizar esse empréstimo.');
        return;
      }
  
      epi.quantidade -= 1;
      localStorage.setItem('epis', JSON.stringify(epis));
  
      const empIndex = emprestimos.findIndex(e =>
        e.colaborador === emp.colaborador &&
        e.item === emp.item &&
        e.dataHora === emp.dataHora
      );
  
      if (empIndex >= 0) {
        emprestimos[empIndex].autorizado = true;
        localStorage.setItem('emprestimos', JSON.stringify(emprestimos));
        listarEmprestimos();
      }
    };
  
    // 🔁 LISTA DE DEVOLUÇÕES PENDENTES
    function listarDevolucoes() {
      const container = document.getElementById('listaDevolucoesPendentes');
      const devolucoes = JSON.parse(localStorage.getItem('devolucoes')) || [];
  
      const pendentes = devolucoes.filter(d => !d.confirmado);
  
      if (pendentes.length === 0) {
        container.innerHTML = '<p>Nenhuma devolução pendente.</p>';
        return;
      }
  
      container.innerHTML = '';
      pendentes.forEach((dev, index) => {
        const div = document.createElement('div');
        div.innerHTML = `
          <p><strong>${dev.colaborador}</strong> devolveu <strong>${dev.item}</strong> em ${dev.dataHora}</p>
          <button onclick="confirmarDevolucao(${index})">Confirmar</button>
          <hr>
        `;
        container.appendChild(div);
      });
    }
  
    // ✅ Confirmar devolução
    window.confirmarDevolucao = function (index) {
      const devolucoes = JSON.parse(localStorage.getItem('devolucoes')) || [];
      const epis = JSON.parse(localStorage.getItem('epis')) || [];
  
      const dev = devolucoes.filter(d => !d.confirmado)[index];
      const epi = epis.find(e => e.nome === dev.item);
  
      if (epi) {
        epi.quantidade += 1;
        localStorage.setItem('epis', JSON.stringify(epis));
      }
  
      const devIndex = devolucoes.findIndex(d =>
        d.colaborador === dev.colaborador &&
        d.item === dev.item &&
        d.dataHora === dev.dataHora
      );
  
      if (devIndex >= 0) {
        devolucoes[devIndex].confirmado = true;
        localStorage.setItem('devolucoes', JSON.stringify(devolucoes));
        listarDevolucoes();
      }
    };
  
    // 👋 Logout
    window.logout = function () {
      localStorage.removeItem('usuarioLogado');
      window.location.href = 'index.html';
    };
  
    // Inicializa listas
    listarEmprestimos();
    listarDevolucoes();
  });
  
  window.confirmarReset = function () {
    const confirmar = confirm('⚠️ Isso apagará TODOS os dados do sistema (usuários, EPIs, empréstimos, devoluções). Deseja continuar?');
  
    if (confirmar) {
      localStorage.clear();
      alert('Sistema resetado com sucesso.');
      window.location.href = 'index.html';
    }
  };
  