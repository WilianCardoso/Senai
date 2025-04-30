document.addEventListener('DOMContentLoaded', function () {
    const formLogin = document.getElementById('formLogin');
  
    if (formLogin) {
      formLogin.addEventListener('submit', function (e) {
        e.preventDefault();
  
        const email = document.getElementById('loginEmail').value.trim();
        const senha = document.getElementById('loginSenha').value;
  
        const usuarios = JSON.parse(localStorage.getItem('usuarios')) || [];
  
        const usuario = usuarios.find(u => u.email === email && u.senha === senha);
  
        const mensagem = document.getElementById('mensagemLogin');
  
        if (usuario) {
          mensagem.textContent = `Bem-vindo, ${usuario.nome}! Redirecionando...`;
          mensagem.style.color = 'green';
          localStorage.setItem('usuarioLogado', JSON.stringify(usuario));
        
          setTimeout(() => {
            if (usuario.tipo === 'admin') {
              window.location.href = 'admin.html';
            } else {
              window.location.href = 'dashboard.html';
            }
          }, 1500);
        }
        else {
          mensagem.textContent = 'Email ou senha incorretos.';
          mensagem.style.color = 'red';
        }
      });
    }
  }); 
  
  function logout() {
    localStorage.removeItem('usuarioLogado');
    window.location.href = 'index.html';
  }
  