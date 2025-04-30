document.addEventListener('DOMContentLoaded', () => {
  const usuario = JSON.parse(localStorage.getItem('usuarioLogado'));
  const campoNome = document.getElementById('colaborador');
  const selectItem = document.getElementById('item');
  const form = document.getElementById('formDevolucao');
  const msg = document.getElementById('mensagemDevolucao');

  if (!usuario || usuario.tipo !== 'colaborador') {
    alert('Acesso restrito. Faça login como colaborador.');
    window.location.href = 'index.html';
    return;
  }

  campoNome.value = usuario.nome;

  const emprestimos = JSON.parse(localStorage.getItem('emprestimos')) || [];
  const devolucoes = JSON.parse(localStorage.getItem('devolucoes')) || [];

  // Filtra EPIs autorizados e ainda não devolvidos
  const episAutorizadosPendentes = emprestimos.filter(emp => {
    return emp.colaborador === usuario.nome &&
      emp.autorizado &&
      !devolucoes.some(dev =>
        dev.colaborador === emp.colaborador &&
        dev.item === emp.item &&
        dev.dataHora >= emp.dataHora
      );
  });

  if (episAutorizadosPendentes.length === 0) {
    const opt = document.createElement('option');
    opt.disabled = true;
    opt.textContent = 'Nenhum EPI pendente de devolução';
    selectItem.appendChild(opt);
    selectItem.disabled = true;
  } else {
    episAutorizadosPendentes.forEach(emp => {
      const opt = document.createElement('option');
      opt.value = emp.item;
      opt.textContent = `${emp.item} (Emprestado em: ${emp.dataHora})`;
      selectItem.appendChild(opt);
    });
  }

  form.addEventListener('submit', (e) => {
    e.preventDefault();

    const colaborador = campoNome.value;
    const item = selectItem.value;
    const dataHora = document.getElementById('dataHora').value;

    if (!item || !dataHora) {
      msg.textContent = 'Preencha todos os campos.';
      msg.style.color = 'red';
      return;
    }

    const devolucoesAtualizadas = [...devolucoes, {
      colaborador,
      item,
      dataHora,
      confirmado: false
    }];

    localStorage.setItem('devolucoes', JSON.stringify(devolucoesAtualizadas));

    msg.textContent = 'Devolução registrada. Aguardando confirmação do administrador.';
    msg.style.color = 'green';
    form.reset();
    campoNome.value = colaborador;

    setTimeout(() => window.location.reload(), 1000);
  });
});
