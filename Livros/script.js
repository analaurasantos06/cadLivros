document.getElementById('cadastroForm').addEventListener('submit', cadastrarJogo);
var result = 0;
function cadastrarJogo(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const plataform = document.getElementById('plataform').value;

    fetch('http://localhost:8080/jogos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, idsn }),
    })
        .then(response => response.json())
        .then(data => {
            alert('livro cadastrado com sucesso!');
            document.getElementById('cadastroForm').reset();            
        })
        .catch(error => {
            console.error('Erro ao cadastrar livro:', error);
        });
}
function pesquisarJogo() {
    const searchId = document.getElementById('searchId').value;

    fetch(`http://localhost:8080/jogos/${searchId}`)
        .then(response => {
            if (response.status === 404) {
                return Promise.reject('Livro não encontrado');
                result = 0;
            }
            return response.json();
        })
        .then(data => {
            result = 1;
            document.getElementById('name').value = `${data.name}`;
            document.getElementById('plataform').value = `${data.plataform}`;
        })
        .catch(error => {
            console.error('Erro ao pesquisar livro:', error);
            const resultadoPesquisa = document.getElementById('resultadoPesquisa');
            resultadoPesquisa.innerHTML = 'Livro não encontrado.';
            var timer = window.setTimeout(atualizarPagina, 3000);

        });
}
function atualizarJogo() {
    pesquisarJogo();
    if (result == 1) {
        const name = document.getElementById('name').value;
        const plataform = document.getElementById('plataform').value;
        const searchId = document.getElementById('searchId').value;

        fetch(`http://localhost:8080/jogos/${searchId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name, plataform }),
        })
            .then(response => response.json())
            .then(data => {
                alert('Livro atualizado com sucesso!');
                document.getElementById('cadastroForm').reset();                
            })
            .catch(error => {
                console.error('Erro ao atualizar livro:', error);
            });
    } else {
        alert('ID não encontrado na base de dados. Nenhum livro foi alterado. Favor pesquisar livro a ser alterado !!!');
    }
}
