document.addEventListener('DOMContentLoaded', atualizarRelatorios);

function atualizarRelatorios() {
  const filtro = document.getElementById('filtroColaborador').value.trim().toLowerCase();

  const emprestimos = JSON.parse(localStorage.getItem('emprestimos')) || [];
  const devolucoes = JSON.parse(localStorage.getItem('devolucoes')) || [];

  const tabelaEmprestimos = document.getElementById('tabelaEmprestimos');
  const tabelaDevolucoes = document.getElementById('tabelaDevolucoes');

  tabelaEmprestimos.innerHTML = `
    <tr>
      <th>Colaborador</th>
      <th>EPI</th>
      <th>Data/Hora Empréstimo</th>
      <th>Previsão</th>
      <th>Status</th>
    </tr>
  `;
  tabelaDevolucoes.innerHTML = `
    <tr>
      <th>Colaborador</th>
      <th>EPI</th>
      <th>Data/Hora Devolução</th>
    </tr>
  `;

  const hoje = new Date().toISOString().split('T')[0];

  const emprestimosFiltrados = emprestimos.filter(e =>
    e.colaborador.toLowerCase().includes(filtro)
  );

  if (emprestimosFiltrados.length === 0) {
    tabelaEmprestimos.innerHTML += `<tr><td colspan="5">Nenhum registro encontrado.</td></tr>`;
  } else {
    emprestimosFiltrados.forEach(emp => {
      const devolvido = devolucoes.some(dev =>
        dev.colaborador === emp.colaborador &&
        dev.item === emp.item &&
        dev.dataHora >= emp.dataHora
      );

      let status = '';
      let linhaStyle = '';

      if (devolvido) {
        status = 'Devolvido';
        linhaStyle = 'background-color: #d4edda;'; // verde
      } else if (emp.previsao < hoje) {
        status = 'Pendente (Atrasado)';
        linhaStyle = 'background-color: #f8d7da;'; // vermelho
      } else {
        status = 'Pendente';
        linhaStyle = 'background-color: #fff3cd;'; // amarelo
      }

      tabelaEmprestimos.innerHTML += `
        <tr style="${linhaStyle}">
          <td>${emp.colaborador}</td>
          <td>${emp.item}</td>
          <td>${emp.dataHora}</td>
          <td>${emp.previsao}</td>
          <td>${status}</td>
        </tr>`;
    });
  }

  const devolucoesFiltradas = devolucoes.filter(d =>
    d.colaborador.toLowerCase().includes(filtro)
  );

  if (devolucoesFiltradas.length === 0) {
    tabelaDevolucoes.innerHTML += `<tr><td colspan="3">Nenhum registro encontrado.</td></tr>`;
  } else {
    devolucoesFiltradas.forEach(dev => {
      tabelaDevolucoes.innerHTML += `
        <tr>
          <td>${dev.colaborador}</td>
          <td>${dev.item}</td>
          <td>${dev.dataHora}</td>
        </tr>`;
    });
  }
}

// 🖨️ Exportar relatório como PDF usando jsPDF + autoTable
function exportarPDF() {
  const { jsPDF } = window.jspdf;
  const doc = new jsPDF();

  const emprestimos = JSON.parse(localStorage.getItem('emprestimos')) || [];
  const devolucoes = JSON.parse(localStorage.getItem('devolucoes')) || [];
  const hoje = new Date().toISOString().split('T')[0];

  const dadosEmprestimos = emprestimos.map(emp => {
    const devolvido = devolucoes.some(dev =>
      dev.colaborador === emp.colaborador &&
      dev.item === emp.item &&
      dev.dataHora >= emp.dataHora
    );

    let status = 'Devolvido';
    if (!devolvido) {
      status = emp.previsao < hoje ? 'Pendente (Atrasado)' : 'Pendente';
    }

    return [
      emp.colaborador,
      emp.item,
      emp.dataHora,
      emp.previsao,
      status
    ];
  });

  const dadosDevolucoes = devolucoes.map(dev => [
    dev.colaborador,
    dev.item,
    dev.dataHora
  ]);

  doc.text('Relatório de Empréstimos de EPI', 14, 15);
  doc.autoTable({
    startY: 20,
    head: [['Colaborador', 'EPI', 'Data/Hora', 'Previsão', 'Status']],
    body: dadosEmprestimos,
  });

  const yAfterFirstTable = doc.lastAutoTable.finalY + 10;
  doc.text('Relatório de Devoluções de EPI', 14, yAfterFirstTable);
  doc.autoTable({
    startY: yAfterFirstTable + 5,
    head: [['Colaborador', 'EPI', 'Data/Hora']],
    body: dadosDevolucoes,
  });

  doc.save('relatorio_epis.pdf');
}
