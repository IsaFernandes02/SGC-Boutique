async function carregarProdutos() {

    const produtos = await fetch('/produtos')
        .then(r => r.json());

    const tabela = document.getElementById('produtosTable');
    tabela.innerHTML = '';

    produtos.forEach(produto => {
        tabela.innerHTML += `
        <tr>
            <td>${produto.id}</td>
            <td>${produto.nome}</td>
            <td>${produto.descricao}</td>
            <td>${formatarMoeda(produto.preco)}</td>
            <td>${produto.quantidadeEstoque}</td>
        </tr>
        `;
    });
}

async function salvarProduto() {

    const produto = {
        nome: document.getElementById("nome").value,
        descricao: document.getElementById("descricao").value,
        preco: parseFloat(document.getElementById("preco").value),
        quantidadeEstoque: parseInt(document.getElementById("estoque").value)
    };

    const response = await fetch('/produtos', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(produto)
    });

    if (response.ok) {
        Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            text: 'Produto cadastrado'
        });
        location.reload();
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: 'Erro ao cadastrar'
        });
    }
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

carregarProdutos();