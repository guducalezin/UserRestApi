const button = document.getElementById("enviar");
const buttonLimpar = document.getElementById("limpar");
const buttonListar = document.getElementById("listar");
const modal = document.getElementById("modalUsuarios");
const listaUsuarios = document.getElementById("listaUsuarios");
const fecharModal = document.getElementById("fecharModal");
button.addEventListener("click", enviar);
buttonLimpar.addEventListener("click", limpar);
buttonListar.addEventListener("click", listar);
async function enviar() {
    const nome = document.getElementById("nome");
    const email = document.getElementById("email");
    const mensagem = document.getElementById("mensagem");
    const usuarios = {
        nome: nome.value,
        email: email.value,
        mensagem: mensagem.value
    };
    if(nome.value === "" || email.value === "" || mensagem.value === "") {
        alert("Preencha todos os campos.");
        return;
    }
    try {
        const response = await fetch("http://localhost:8080/usuarios", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuarios)
        });
        if (!response.ok) {
            throw new Error("Erro ao enviar dados");
        }
        const resultado = await response.text();
        console.log(resultado);
    } catch (error) {
        console.error(error);
        if (error.message === "Erro ao enviar dados") {
            alert("email repetido, tente outro.");
        }
    }
}
async function listar() {
    modal.style.display = "block";
    listaUsuarios.innerHTML = "Carregando...";

    try {
        const response = await fetch("http://localhost:8080/usuarios");
        if (!response.ok) {
            throw new Error("Erro ao listar usuários");
        }
        const usuarios = await response.json();
        listaUsuarios.innerHTML = "";
        if (usuarios.length === 0) {
            listaUsuarios.innerHTML = "<p>Nenhum usuário cadastrado.</p>";
            return;
        }
        usuarios.forEach(usuario => {
        listaUsuarios.innerHTML += `<div class="usuario"><p>Id: ${usuario.id}<br><p>Nome: ${usuario.nome}<br>Email: ${usuario.email}<br>Mensagem: ${usuario.mensagem}</p></div>`;
        });
        console.log(usuarios);
    } catch (error) {
        console.error(error);
    }
}

function limpar() {
    const nome = document.getElementById("nome");
    const email = document.getElementById("email");
    const mensagem = document.getElementById("mensagem");
    nome.value = "";
    email.value = "";
    mensagem.value = "";
}
fecharModal.addEventListener("click", () => {
    modal.style.display = "none";
});
