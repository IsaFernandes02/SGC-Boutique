function formatarMoeda(valor) {
    return valor.toLocaleString('pt-BR', {
        style: 'currency',
        currency: 'BRL'
    });
}

async function gerarRelatorio() {

    try {

        const vendas = await fetch('/vendas')
            .then(r => r.json());

        const tabela = document.getElementById("relatorioTable");
        tabela.innerHTML = "";

        let total = 0;

        vendas.forEach(v => {

            total += v.valorTotal || 0;

            tabela.innerHTML += `
                <tr>
                    <td>${v.id}</td>
                    <td>${v.cliente?.nome || "Sem cliente"}</td>
                    <td>-</td>
                    <td>${formatarMoeda(v.valorTotal)}</td>
                </tr>
            `;
        });

        document.getElementById("totalRelatorio").innerText =
            formatarMoeda(total);

    } catch (erro) {

        Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: 'Erro ao carregar relatório'
        });
    }
}