document.addEventListener('DOMContentLoaded', () => {
  const usuario = JSON.parse(localStorage.getItem('usuarioLogado'));
  const campoNome = document.getElementById('colaborador');
  const form = document.getElementById('formEmprestimo');
  const msg = document.getElementById('mensagemEmprestimo');
  const selectItem = document.getElementById('item');

  if (!usuario || usuario.tipo !== 'colaborador') {
    alert('Acesso restrito. Faça login como colaborador.');
    window.location.href = 'index.html';
    return;
  }

  campoNome.value = usuario.nome;

  form.addEventListener('submit', (e) => {
    e.preventDefault();

    const colaborador = campoNome.value;
    const item = selectItem.value;
    const dataHora = document.getElementById('dataHora').value;
    const previsao = document.getElementById('previsao').value;

    if (!item || !dataHora || !previsao) {
      msg.textContent = 'Preencha todos os campos obrigatórios.';
      msg.style.color = 'red';
      return;
    }

    const emprestimos = JSON.parse(localStorage.getItem('emprestimos')) || [];
    emprestimos.push({
      colaborador,
      item,
      dataHora,
      previsao,
      autorizado: false
    });
    localStorage.setItem('emprestimos', JSON.stringify(emprestimos));

    msg.textContent = 'Solicitação de empréstimo enviada para aprovação.';
    msg.style.color = 'green';
    form.reset();
    campoNome.value = colaborador;
  });
});
