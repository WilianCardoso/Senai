document.addEventListener('DOMContentLoaded', function () {
  const form = document.getElementById('formCadastro');
  const mensagem = document.getElementById('mensagemCadastro');

  form.addEventListener('submit', function (e) {
    e.preventDefault();

    const nome = document.getElementById('nome').value.trim();
    const email = document.getElementById('email').value.trim();
    const senha = document.getElementById('senha').value;
    const tipo = document.getElementById('tipo').value;

    if (!nome || !senha || !tipo) {
      mensagem.textContent = 'Preencha todos os campos.';
      mensagem.style.color = 'red';
      return;
    }

    const usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];

    const jaExiste = usuarios.some(usuario => usuario.email === email);

    if (jaExiste) {
      mensagem.textContent = 'Email já cadastrado.';
      mensagem.style.color = 'red';
      return;
    }

    usuarios.push({ nome, email, senha, tipo });
    localStorage.setItem('usuarios', JSON.stringify(usuarios));

    mensagem.textContent = 'Usuário cadastrado com sucesso!';
    mensagem.style.color = 'green';
    form.reset();
  });
});
