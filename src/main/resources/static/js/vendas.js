let clientes = [];
let produtos = [];
let itens = [];
let total = 0;

function formatarMoeda(valor) {
    return valor.toLocaleString('pt-BR', {
        style: 'currency',
        currency: 'BRL'
    });
}

async function abrirVenda() {

    itens = [];
    total = 0;
    document.getElementById("itensTabela").innerHTML = "";
    document.getElementById("total").innerText = "0";

    clientes = await fetch('/clientes').then(r => r.json());
    produtos = await fetch('/produtos').then(r => r.json());

    const clienteSelect = document.getElementById("clienteSelect");
    const produtoSelect = document.getElementById("produtoSelect");

    clienteSelect.innerHTML = "";
    produtoSelect.innerHTML = "";

    clientes.forEach(c => {
        clienteSelect.innerHTML += `<option value="${c.id}">${c.nome}</option>`;
    });

    produtos.forEach(p => {
        produtoSelect.innerHTML += `<option value="${p.id}">${p.nome}</option>`;
    });

    new bootstrap.Modal(document.getElementById('modalVenda')).show();
}

function addItem() {

    const produtoId = document.getElementById("produtoSelect").value;
    const quantidade = parseInt(document.getElementById("quantidade").value);

    if (!quantidade || quantidade <= 0) {
        Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: 'Quantidade inválida'
        });
        return;
    }

    const produto = produtos.find(p => p.id == produtoId);
    const subtotal = produto.preco * quantidade;

    total += subtotal;

    itens.push({
        produto,
        quantidade,
        preco: produto.preco
    });

    document.getElementById("itensTabela").innerHTML += `
        <tr>
            <td>${produto.nome}</td>
            <td>${quantidade}</td>
            <td>${formatarMoeda(subtotal)}</td>
        </tr>
    `;

    document.getElementById("total").innerText = formatarMoeda(total);
}

async function salvarVenda() {

    let clienteId = document.getElementById("clienteSelect").value;

    if (!clienteId) {
        Swal.fire({
            icon: 'warning',
            title: 'Atenção',
            text: 'Selecione um cliente'
        });
        return;
    }

    const usuario = await fetch('/usuarios')
        .then(r => r.json());

    const venda = {
        cliente: { id: parseInt(clienteId) },
        usuario: { id: usuario[0].id },
        itens: itens.map(i => ({
            produto: { id: i.produto.id },
            quantidade: parseInt(i.quantidade),
            preco: i.preco
        })),
        valorTotal: total
    };

    const response = await fetch('/vendas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(venda)
    });

    if (response.ok) {
        Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            text: 'Venda cadastrada com sucesso!'
        });

        carregarVendas();
        document.getElementById("itensTabela").innerHTML = "";
        document.getElementById("total").innerText = "0";
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: 'Erro ao salvar venda'
        });
    }
}

async function carregarVendas() {

    const vendas = await fetch('/vendas')
        .then(r => r.json());

    const tabela = document.getElementById('vendasTable');
    tabela.innerHTML = '';

    vendas.forEach(v => {
        tabela.innerHTML += `
        <tr>
            <td>${v.id}</td>
            <td>${v.cliente ? v.cliente.nome : "Sem cliente"}</td>
            <td>${formatarMoeda(v.valorTotal)}</td>
        </tr>
        `;
    });
}

function logout() {
    localStorage.clear();
    window.location.href = "/login.html";
}

carregarVendas();