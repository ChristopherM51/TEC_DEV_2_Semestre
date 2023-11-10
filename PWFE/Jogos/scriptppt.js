atualizarPlacar();
//atuaizar placar, faz o placar iniciar em Zero
//define variaveis de saida: "vitoria", "empate", "derrota", placar da CPU e GPU
var mensagemVitoria = document.getElementById("mensagemVitoria");
var mensagemEmpate = document.getElementById("mensagemEmpate");
var mensagemDerrota = document.getElementById("mensagemDerrota");
var contadorJOGADOR = document.getElementById("contadorJOGADOR");
var contadorCPU = document.getElementById("contadorCPU");
//oculta as mensagens de vitoria, empate e derrota no inicio do jogo
mensagemEmpate.style.display = "none";
mensagemVitoria.style.display = "none";
mensagemDerrota.style.display = "none";
//Define variaveis de placar e define valor como zero
var cpuP = 0;
var J1P = 0;
var eP = 0;
//encontra no html o local do placar e abribui o valor
contadorJOGADOR.style.display = J1P;
contadorCPU.style.display = cpuP;
//Atualiza o placar
function atualizarPlacar() {
  document.getElementById("contadorJOGADOR").textContent = J1P;
  document.getElementById("contadorCPU").textContent = cpuP;
}
//Execução caso o jogador escolha Pedra
function Pedra() {
  var cpu = Math.floor(Math.random() * 10);
  // Obtém o elemento de imagem pelo ID
  var imgCPU = document.getElementById("imgCPU");
  var imgJogador = document.getElementById("imgJogador");
  var resultado = document.getElementById("resultado");
  // Atualiza o atributo src para exibir a imagem correta
  imgJogador.src = "img/pedra.png";

  if (cpu <= 3) {
    imgCPU.src = "img/pedra.png";
    mensagemEmpate.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemDerrota.style.display = "none";
    eP++;
  } else if (cpu > 3 && cpu <= 6) {
    imgCPU.src = "img/papel.png";
    mensagemDerrota.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemEmpate.style.display = "none";
    cpuP++;
  } else {
    imgCPU.src = "img/tesoura.png";
    mensagemVitoria.style.display = "block";
    mensagemEmpate.style.display = "none";
    mensagemDerrota.style.display = "none";
    J1P++;
  }
  atualizarPlacar();
//Execução caso o jogador escolha Papel
}
function Papel() {
  var cpu = Math.floor(Math.random() * 10);
  var imgCPU = document.getElementById("imgCPU");
  var imgJogador = document.getElementById("imgJogador");
  imgJogador.src = "img/papel.png";

  if (cpu <= 3) {
    imgCPU.src = "img/pedra.png";
    mensagemVitoria.style.display = "block";
    mensagemEmpate.style.display = "none";
    mensagemDerrota.style.display = "none";
    J1P++;
  } else if (cpu > 3 && cpu <= 6) {
    imgCPU.src = "img/papel.png";
    mensagemEmpate.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemDerrota.style.display = "none";
    eP++;
  } else {
    imgCPU.src = "img/tesoura.png";
    mensagemDerrota.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemEmpate.style.display = "none";
    cpuP++;
  }
  atualizarPlacar();
}
//Execução caso o jogador escolha Tesoura
function Tesoura() {
  var cpu = Math.floor(Math.random() * 10);
  var imgCPU = document.getElementById("imgCPU");
  var imgJogador = document.getElementById("imgJogador");
  imgJogador.src = "img/tesoura.png";

  if (cpu <= 3) {
    imgCPU.src = "img/pedra.png";
    mensagemDerrota.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemEmpate.style.display = "none";
    cpuP++;
  } else if (cpu > 3 && cpu <= 6) {
    imgCPU.src = "img/papel.png";
    mensagemVitoria.style.display = "block";
    mensagemEmpate.style.display = "none";
    mensagemDerrota.style.display = "none";
    J1P++;
  } else {
    imgCPU.src = "img/tesoura.png";
    mensagemEmpate.style.display = "block";
    mensagemVitoria.style.display = "none";
    mensagemDerrota.style.display = "none";
    eP++;
  }
  atualizarPlacar();
}