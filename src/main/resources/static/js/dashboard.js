async function carregarDashboard() {

    const clientes = await fetch('/clientes').then(r => r.json());
    const produtos = await fetch('/produtos').then(r => r.json());
    const vendas = await fetch('/vendas').then(r => r.json());

    document.getElementById('totalClientes').innerText = clientes.length;
    document.getElementById('totalProdutos').innerText = produtos.length;
    document.getElementById('totalVendas').innerText = vendas.length;

    let faturamento = 0;

    vendas.forEach(v => {
        faturamento += v.valorTotal || 0;
    });

    document.getElementById('faturamento').innerText =
        formatarMoeda(faturamento);
}

function formatarMoeda(valor) {
    return valor.toLocaleString('pt-BR', {
        style: 'currency',
        currency: 'BRL'
    });
}

function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("perfil");
    window.location.href = "/login.html";
}

carregarDashboard();