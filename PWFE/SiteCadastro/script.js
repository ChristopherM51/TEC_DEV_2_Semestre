function Analisar() {
    var Nome = document.getElementById('pNome').value;
    var Email = document.getElementById('pEmail').value;
    var ConfEmail = document.getElementById('pConfEmail').value;
    var Senha = document.getElementById('pSenha').value;
    var ConfSenha = document.getElementById('pConfSenha').value;

    if (Nome == '') {
        alert('Campo "Nome:" é obrigatorio');
    }
    if (Email == '') {
        alert('Campo "E-mail:" é obrigatorio');
    }
    if (ConfEmail == '') {
        alert('Campo "Confirmar E-mail:" é obrigatorio');
    } else if (Email != ConfEmail) {
        alert('Os endereços de E-mail informados são diferentes');
    }
    if (Senha == '') {
        alert('Campo "Senha:" é obrigatorio');
    }
    if (ConfSenha == '') {
        alert('Campo "Confirmar senha:" é obrigatorio');
    } else if (Senha != ConfSenha) {
        alert('As senhas informadas são diferentes');
    }

}