async function salvarCliente() {

    const cliente = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        email: document.getElementById("email").value,
        telefone: document.getElementById("telefone").value,
        endereco: document.getElementById("endereco").value
    };

    const response = await fetch('/clientes', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(cliente)
    });

    if (response.ok) {
        Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            text: 'Cliente cadastrado'
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

async function carregarClientes() {

    const clientes = await fetch('/clientes')
        .then(r => r.json());

    const tabela = document.getElementById('clientesTable');
    tabela.innerHTML = '';

    clientes.forEach(cliente => {
        tabela.innerHTML += `
        <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nome}</td>
            <td>
                <button class="btn btn-primary btn-sm"
                    onclick="editarCliente(${cliente.id})">
                    Editar
                </button>
            </td>
        </tr>
        `;
    });
}

async function editarCliente(id) {

    const cliente = await fetch(`/clientes/${id}`)
        .then(r => r.json());

    document.getElementById("editId").value = cliente.id;
    document.getElementById("editNome").value = cliente.nome || "";
    document.getElementById("editCpf").value = cliente.cpf || "";
    document.getElementById("editEmail").value = cliente.email || "";
    document.getElementById("editTelefone").value = cliente.telefone || "";
    document.getElementById("editEndereco").value = cliente.endereco || "";

    new bootstrap.Modal(document.getElementById('modalEditar')).show();
}

async function atualizarCliente() {

    const id = document.getElementById("editId").value;

    const cliente = {
        id: parseInt(id),
        nome: document.getElementById("editNome").value,
        cpf: document.getElementById("editCpf").value,
        email: document.getElementById("editEmail").value,
        telefone: document.getElementById("editTelefone").value,
        endereco: document.getElementById("editEndereco").value
    };

    const response = await fetch(`/clientes/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(cliente)
    });

    if (response.ok) {
        Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            text: 'Cliente atualizado!'
        });
        carregarClientes();
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: 'Erro ao atualizar cliente'
        });
    }
}

function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("perfil");
    window.location.href = "/login.html";
}

carregarClientes();