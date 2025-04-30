document.addEventListener('DOMContentLoaded', function () {
  const form = document.getElementById('formLogin');
  const mensagem = document.getElementById('mensagemLogin');

  form.addEventListener('submit', function (e) {
    e.preventDefault();

    const email = document.getElementById('email').value.trim();
    const senha = document.getElementById('senha').value;

    if (!email || !senha) {
      mensagem.textContent = 'Preencha todos os campos.';
      mensagem.style.color = 'red';
      return;
    }

    const usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];

    const usuario = usuarios.find(u => u.email === email && u.senha === senha);

    if (usuario) {
      mensagem.textContent = `Bem-vindo, ${usuario.nome}!`;
      mensagem.style.color = 'green';
      localStorage.setItem('usuarioLogado', JSON.stringify(usuario));

    } else {
      mensagem.textContent = 'Email ou senha inválidos.';
      mensagem.style.color = 'red';
    }
  });
});