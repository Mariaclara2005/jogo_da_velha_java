package jogodavelha;

/**
 * ******************************************************************
 */
/**
 * Centro Universitario Senac *
 */
/**
 * TADS - 1o semestre de 2024 *
 * Projeto SEMESTRAL II *
 */
/**
 * Arquivo: <Jogo da Velha> *
/**
 * *
 */
//Importações projeto:
import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {

    static int[] pontos = new int[2];

    public static char[][] inicializarTabuleiro() {
        char[][] matrizVelha = new char[3][3];
        //Criação da matriz principal 3x3 do tipo CHAR.
        for (int i = 0; i < matrizVelha.length; i++) {
            for (int j = 0; j < matrizVelha[i].length; j++) {
                matrizVelha[i][j] = ' ';
            }
        }
        return matrizVelha;
    }

    public static void imprimirTabuleiro(char[][] matrizVelha) {

        System.out.println("=-=-=-TABULEIRO-=-=-=");
        //Desenho do tabuleiro
        for (int i = 0; i < matrizVelha.length; i++) {
            for (int j = 0; j < matrizVelha[i].length; j++) {
                System.out.printf("| %c ", matrizVelha[i][j]);
            }
            System.out.println("|");
            //Condição adicionada para separar os quadrantes do tabuleiro
            if (i < matrizVelha.length) {
                System.out.println("-------------");
            }
        }
    }

    //Função que recebe a opção do modo de jogo que o usuário deseja
    public static int modoDeJogo() {
        Scanner input = new Scanner(System.in);

        System.out.printf("=-=-=-JOGO DA VELHA-=-=-=\n");
        System.out.printf("Bem-vindo(a) ao Jogo da Velha. Selecione o modo de jogo:\n");
        System.out.printf("1 = Jogador x Jogador\n2 = Jogador X Máquina\n");
        System.out.printf("Informe a opção: ");

        int opcaoJogador = input.nextInt();

        return opcaoJogador;
    }

    /*
    Essa função é responsável por selecionar a dificuldade da máquina.
    Se o usuário optar pela máquina no modo fácil, é aqui que ela é selecionada.
    */
    public static int qualMaquina(int opcaoJogador, char[][] matrizVelha) {
        switch (opcaoJogador) {
            case 1:
                jogador(matrizVelha);
            break;

            case 2:
                modoFacil(matrizVelha, opcaoJogador);
                break;
                
            case 3:
                modoDificil(matrizVelha);
                break;
            
        }

        return opcaoJogador;
    }

    /*Função responsável por imprimir o menu de jogo e as opções de jogo para o
    usuário. Nessa função existem tratamentos de erro caso o usuário selecione
    uma opção inválida, utilizando o laço while.
     */
    public static int imprimeMenuPrincipal(int opcaoJogador, char[][] m) {
        Scanner input = new Scanner(System.in);
        int contador = 0;

        // Válidação caso o usuário selecione a opção correta;
        if (opcaoJogador == 2) {

            System.out.printf("\n=-=-=-JOGADOR X MÁQUINA-=-=-=\n");
            System.out.printf("2 = Nível fácil\n3 = Nível Difícil\n");
            System.out.printf("Selecione a dificultade: ");
            opcaoJogador = input.nextInt();

            switch (opcaoJogador) {
                case 2:
                    System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL FÁCIL-=-=-=\n");
                    imprimirTabuleiro(m);
                    modoFacil(m, opcaoJogador);
                    break;

                case 3:
                    System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL DIFÍCIL-=-=-=\n");
                    break;
            }

            // Tratamento de erro caso o usuário informe a opção errada.
            while (opcaoJogador <= 0 || opcaoJogador > 3) {
                System.err.printf("Opção inválida\n");
                System.out.printf("Selecione a dificuldade novamente: ");
                opcaoJogador = input.nextInt();

                switch (opcaoJogador) {
                    case 2:
                        System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL FÁCIL-=-=-=\n");
                        imprimirTabuleiro(m);
                        modoFacil(m, opcaoJogador);
                        break;

                    case 3:
                        System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL DIFÍCIL-=-=-=\n");
                        break;
                }

                contador++;
            }
        } else if (opcaoJogador == 1) {
            System.out.printf("\n=-=-=-JOGADOR X JOGADOR-=-=-=\n");
            modoJogador(m, opcaoJogador);
        }

        // Validação caso o usuário selecione uma opção inexistente
        while (opcaoJogador <= 0 || opcaoJogador > 3) {
            System.err.printf("Opção inválida\n");
            System.out.printf("Informe a opção novamente: ");
            opcaoJogador = input.nextInt();

            if (opcaoJogador == 2) {

                System.out.printf("\n=-=-=-JOGADOR X MÁQUINA-=-=-=\n");
                System.out.printf("1 = Nível fácil\n2 = Nível Difícil\n");
                System.out.printf("Selecione a dificultade: ");
                opcaoJogador = input.nextInt();

                switch (opcaoJogador) {
                    case 2:
                        System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL FÁCIL-=-=-=\n");
                        imprimirTabuleiro(m);
                        modoFacil(m, opcaoJogador);
                        break;

                    case 3:
                        System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL DIFÍCIL-=-=-=\n");
                        break;
                }
                // Tratamento de erro caso o usuário informe a dificuldade errada
                while (opcaoJogador <= 0 || opcaoJogador > 3) {
                    System.err.printf("Opção inválida\n");
                    System.out.printf("Informe a dificuldade novamente: ");
                    opcaoJogador = input.nextInt();

                    switch (opcaoJogador) {
                        case 2:
                            System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL FÁCIL-=-=-=\n");
                            imprimirTabuleiro(m);
                            modoFacil(m, opcaoJogador);
                            break;

                        case 3:
                            System.out.printf("\nOPÇÃO SELECIONADA\n=-=-=-NÍVEL DIFÍCIL-=-=-=\n");
                            break;
                    }
                    contador++;
                }
            } else if (opcaoJogador == 1) {
                System.out.printf("\n=-=-=-JOGADOR X JOGADOR-=-=-=\n");
                modoJogador(m, opcaoJogador);
            }
            contador++;
        }
        return opcaoJogador;
    }

    public static int leiaCoordenadaLinha() {
        Scanner input = new Scanner(System.in);
        int linha = input.nextInt();
        return linha;
    }

    public static int leiaCoordenadaColuna() {
        Scanner input = new Scanner(System.in);
        int coluna = input.nextInt();
        return coluna;
    }

    //Função que recebe as jogadas e atualiza o tabuleiro
    public static void modoJogador(char[][] m, int opJ) {
        imprimirTabuleiro(m);
        jogadaUsuario(m, opJ);
    }

    /*Função que recebe as coordenadas de linha e coluna do usúario(Nesse caso,
    recebe as coordenadas do primeiro jogador).*/
    public static int[] jogador(char[][] matrizVelha) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Informe a linha: ");

        //Validação caso o usuário informe uma linha maior que o tamanho da matriz
        int linha = leiaCoordenadaLinha();
        while (linha < 0 || linha > 2) {
            System.err.printf("Posição inválida!\nDigite a linha novamente: ");
            linha = input.nextInt();
        }

        System.out.printf("Informe a coluna: ");
        int coluna = leiaCoordenadaColuna();
        System.out.println();

        //Validação caso o jogador informe uma coluna maior que o tamanho da matriz
        while (coluna < 0 || coluna > 2) {
            System.err.printf("Posição inválida!\nDigite a coluna novamente: ");
            coluna = input.nextInt();
        }

        int[] posicao = {linha, coluna};

        return posicao;
    }

    public static boolean posicaoValida(char[][] matrizVelha, int[] linhaColuna) {

        int linha = linhaColuna[0];
        int coluna = linhaColuna[1];

        if (linha < 0 || linha >= matrizVelha.length || coluna < 0 || coluna >= matrizVelha[0].length) {
            return false;
        }
        return matrizVelha[linha][coluna] == ' ';
    }

    public static void jogadaUsuario(char[][] m, int opJ) {
        jogar(m, opJ);
    }

    // Função responsável por adicionar 'X' ou 'O' no tabuleiro de jogo.
    public static char jogar(char[][] matrizVelha, int opcaoJogador) {
        //Variáveis controladoras
        int vezJogador = 0;
        int linha = 0, coluna = 0;
        char vencedor = ' ';
        

        //Laço que repete o jogo até alguem completar 3 pontos
        while (pontos[0] < 3 && pontos[1] < 3) {
            
            //Laço de repetição responsável por fazer com que a partida não exceda os limites do tabuleiro
            for (int i = vezJogador; i < 9; i++) {
                
                //Condicional colocada para parar o laço assim que algum jogador chegar a 3 pontos
                if (pontos[0] == 3 || pontos[1] == 3) {
                    break;
                }
                
                if (i % 2 == 0) {
                    System.out.printf("\n=-=-=-JOGADOR 1-=-=-=\n");
                    int[] linhaColuna = jogador(matrizVelha);

                    linha = linhaColuna[0];
                    coluna = linhaColuna[1];

                    //Condicional colocada para validar se a posição indicada não está preenchida.
                    if (posicaoValida(matrizVelha, linhaColuna)) {
                        // Atualiza a matriz com 'X'
                        matrizVelha[linha][coluna] = 'X';
                    } else {
                        System.err.println("Posição já existente. Informe novamente a jogada!");

                        //Caso a posição indicada seja inválida, o contador do jogador reinicia fazendo com que o próprio coloque uma posição válida.
                        i--;
                    }

                } else if (i % 2 != 0) {
                    
                    //Condicional imposta para selecionar o oponente
                    if(opcaoJogador == 1){
                        System.out.printf("\n=-=-=-JOGADOR 2-=-=-=\n");
                        int[] linhaColuna = jogador(matrizVelha);
                        linha = linhaColuna[0];
                        coluna = linhaColuna[1];

                        //Condicional colocada para validar se a posição indicada não está preenchida.
                        if (posicaoValida(matrizVelha, linhaColuna)) {
                            // Atualiza a matriz com 'O'
                            matrizVelha[linha][coluna] = 'O';
                        } else {
                            System.err.println("Posição já existente. Informe novamente a jogada!");

                            //Caso a posição indicada seja inválida, o contador do jogador reinicia fazendo com que o próprio coloque uma posição válida.
                            i--;
                        }
                    }
                        else if (opcaoJogador == 2) {
                        System.out.printf("\n=-=-=-MÁQUINA FÁCIL-=-=-=\n");
                        int[] linhaColuna = jogadaMaquinaFacil(matrizVelha);

                        linha = linhaColuna[0];
                        coluna = linhaColuna[1];

                        //Condicional colocada para validar se a posição indicada não está preenchida.
                        if (posicaoValida(matrizVelha, linhaColuna)) {
                            // Atualiza a matriz com 'O'
                            matrizVelha[linha][coluna] = 'O';
                        } else {
                            System.err.println("Posição já existente. Informe novamente a jogada!");

                            //Caso a posição indicada seja inválida, o contador do jogador reinicia fazendo com que o próprio coloque uma posição válida.
                            i--;
                        }
                    } else if (opcaoJogador == 3) {
                        System.out.printf("\n=-=-=-MÁQUINA DIFÍCIL-=-=-=\n");
                        int[] linhaColuna = jogadaMaquinaDificil(matrizVelha);
                        linha = linhaColuna[0];
                        coluna = linhaColuna[1];

                        //Condicional colocada para validar se a posição indicada não está preenchida.
                        if (posicaoValida(matrizVelha, linhaColuna)) {
                            // Atualiza a matriz com 'O'
                            matrizVelha[linha][coluna] = 'O';
                        } else {
                            System.err.println("Posição já existente. Informe novamente a jogada!");

                            //Caso a posição indicada seja inválida, o contador do jogador reinicia fazendo com que o próprio coloque uma posição válida.
                            i--;
                        }
                    } 
                }

                imprimirTabuleiro(matrizVelha);
                vencedor = verificaVencedor(matrizVelha);
                //Condicional que identifica o vencedor da rodada e reinicia o tabuleiro
                if (vencedor != ' ') {
                    imprimePontuacao(vencedor);
                    System.out.printf("\nNova Rodada Iniciada\n");
                    reiniciarTabuleiro(matrizVelha);
                }
                //Condicional que verifica se o jogo deu "VELHA" e reinicia o tabuleiro
                if (empate(matrizVelha)) {
                    System.out.printf("=-=-=-VELHA-=-=-=\n");
                    imprimePontuacao(vencedor);
                    System.out.printf("\nNova Rodada Iniciada\n");
                    reiniciarTabuleiro(matrizVelha);
                }
            }
        }
        if (pontos[0] == 3) {
            System.out.printf("   X venceu!!!!\n");
            imprimePontuacao(vencedor);
        } else if (pontos[1] == 3) {
            System.out.printf("   O venceu!!!!\n");
            imprimePontuacao(vencedor);
        }

        return matrizVelha[linha][coluna];
    }

    public static void reiniciarTabuleiro(char[][] matrizVelha) {
        // Limpar o tabuleiro
        for (int i = 0; i < matrizVelha.length; i++) {
            for (int j = 0; j < matrizVelha[i].length; j++) {
                matrizVelha[i][j] = ' ';
            }
        }
    }

    public static char verificaVencedor(char[][] m) {
        //Variável vencedor inicializa vazia para o laço percorrer as condições e retornar apenas quando uma for concluída.
        char vencedor = ' ';

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                //Possibilidades de vitória jogador X
                if ((m[0][0] == 'X' && m[1][0] == 'X' && m[2][0] == 'X')
                        || (m[0][1] == 'X' && m[1][1] == 'X' && m[2][1] == 'X')
                        || (m[0][2] == 'X' && m[1][2] == 'X' && m[2][2] == 'X')
                        || (m[0][0] == 'X' && m[0][1] == 'X' && m[0][2] == 'X')
                        || (m[1][0] == 'X' && m[1][1] == 'X' && m[1][2] == 'X')
                        || (m[2][0] == 'X' && m[2][1] == 'X' && m[2][2] == 'X')
                        || (m[0][0] == 'X' && m[1][1] == 'X' && m[2][2] == 'X')
                        || (m[2][0] == 'X' && m[1][1] == 'X' && m[0][2] == 'X')) {
                    vencedor = 'X';
                }//Possibilidades de vitória jogador O 
                else if ((m[0][0] == 'O' && m[1][0] == 'O' && m[2][0] == 'O')
                        || (m[0][1] == 'O' && m[1][1] == 'O' && m[2][1] == 'O')
                        || (m[0][2] == 'O' && m[1][2] == 'O' && m[2][2] == 'O')
                        || (m[0][0] == 'O' && m[0][1] == 'O' && m[0][2] == 'O')
                        || (m[1][0] == 'O' && m[1][1] == 'O' && m[1][2] == 'O')
                        || (m[2][0] == 'O' && m[2][1] == 'O' && m[2][2] == 'O')
                        || (m[0][0] == 'O' && m[1][1] == 'O' && m[2][2] == 'O')
                        || (m[2][0] == 'O' && m[1][1] == 'O' && m[0][2] == 'O')) {
                    vencedor = 'O';
                }
            }
        }

        if (vencedor == 'X') {
            System.out.println("Vencedor da rodada: X");
        } else if (vencedor == 'O') {
            System.out.println("Vencedor da rodada: O");
        }

        return vencedor;
    }

    public static void imprimePontuacao(char vencedor) {
        //Variáveis que acumulam os pontos dos jogadores;
        //Variavel global é um array que recebe a pontuação a cada rodada
        int pontosX = pontos[0];
        int pontosO = pontos[1];

        if (vencedor == 'O') {
            //Atribui pontos ao jogador que joga com o 'O'.
            pontosO++;
        } else if (vencedor == 'X') {
            //Atribui pontos ao jogador que joga com o 'X'.
            pontosX++;
        }

        pontos[0] = pontosX;
        pontos[1] = pontosO;

        System.out.printf("=-=-=-PLACAR-=-=-=\n    X %d | O %d\n", pontosX, pontosO);
    }

    public static void modoDificil(char[][] matrizVelha) {

        //Variáveis controladoras
        int vezJogador = 0;
        int linha = 0, coluna = 0;

        /*Laço de repetição responsável por limitar o número de jogadas no jogo 
        até 9. Ou seja, caso não haja um vencedor, o tabuleiro é preenchido por
        completo. */
        while (vezJogador < 9) {

            if (vezJogador % 2 == 0) {
                System.out.printf("\n=-=-=-JOGADOR 1-=-=-=\n");
                int[] linhaColuna = jogador(matrizVelha);

                linha = linhaColuna[0];
                coluna = linhaColuna[1];

                //Condicional colocada para validar se a posição indicada não está preenchida.
                if (posicaoValida(matrizVelha, linhaColuna) == true) {
                    // Atualiza a matriz com 'X'
                    matrizVelha[linha][coluna] = 'X';
                } else {
                    System.err.println("Posição já existente! Você perdeu a jogada!");
                }

            } else if (vezJogador % 2 != 0) {

                System.out.printf("\n=-=-=-MAQUINA-=-=-=\n");

                jogadaMaquinaDificil(matrizVelha);
            }

            imprimirTabuleiro(matrizVelha);
            vezJogador++;
            //Empate(matrizVelha);

        }
    }

    public static int[] jogadaMaquinaFacil(char[][] matrizVelha) {

        Random gerador = new Random();

        //Limitador
        int linha = gerador.nextInt(3);

        //Validação caso o usuário informe uma linha maior que o tamanho da matriz
        while (linha < 0 || linha > 2) {
            System.err.printf("Posição inválida!\nDigite a linha novamente: ");
            linha = gerador.nextInt(3);
        }

        int coluna = gerador.nextInt(3);
        System.out.println();

        //Validação caso o jogador informe uma coluna maior que o tamanho da matriz
        while (coluna < 0 || coluna > 2) {
            System.err.printf("Posição inválida!\nDigite a coluna novamente: ");
            coluna = gerador.nextInt(3);
        }

        int[] posicao = {linha, coluna};

        return posicao;
    }

    public static void modoFacil(char[][] matrizVelha, int opJ) {
        jogar(matrizVelha, opJ);
 
    }

    public static boolean empate(char[][] matrizVelha) {
        for (int i = 0; i < matrizVelha.length; i++) {
            for (int j = 0; j < matrizVelha[i].length; j++) {
                //Se há espaço vazio entao ainda nao é empate
                if (matrizVelha[i][j] == ' ') {

                    return false;
                }
            }
        }
        return true;
    }

    public static int[] jogadaMaquinaDificil(char[][] matrizVelha) {

        //priorizando o centro na jogada perfeita
        if (matrizVelha[1][1] == ' ') {
            matrizVelha[1][1] = 'O';
        } //ganhar
        else if ((matrizVelha[0][0] == 'O' && matrizVelha[0][1] == 'O' && matrizVelha[0][2] == ' ')) {
            matrizVelha[0][2] = 'O';
        } else if ((matrizVelha[0][0] == 'O' && matrizVelha[0][1] == ' ' && matrizVelha[0][2] == 'O')) {
            matrizVelha[0][1] = 'O';
        } else if ((matrizVelha[0][0] == ' ' && matrizVelha[0][1] == 'O' && matrizVelha[0][2] == 'O')) {
            matrizVelha[0][0] = 'O';
        } else if ((matrizVelha[1][0] == 'O' && matrizVelha[1][1] == 'O' && matrizVelha[1][2] == ' ')) {
            matrizVelha[1][2] = 'O';
        } else if ((matrizVelha[1][0] == 'O' && matrizVelha[1][1] == ' ' && matrizVelha[1][2] == 'O')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[1][0] == ' ' && matrizVelha[1][1] == 'O' && matrizVelha[1][2] == 'O')) {
            matrizVelha[1][0] = 'O';
        } else if ((matrizVelha[2][0] == 'O' && matrizVelha[2][1] == 'O' && matrizVelha[2][2] == ' ')) {
            matrizVelha[2][2] = 'O';
        } else if ((matrizVelha[2][0] == 'O' && matrizVelha[2][1] == ' ' && matrizVelha[2][2] == 'O')) {
            matrizVelha[2][1] = 'O';
        } else if ((matrizVelha[2][0] == ' ' && matrizVelha[2][1] == 'O' && matrizVelha[2][2] == 'O')) {
            matrizVelha[2][0] = 'O';
        } else if ((matrizVelha[0][0] == 'O' && matrizVelha[1][0] == 'O' && matrizVelha[2][0] == ' ')) {
            matrizVelha[2][0] = 'O';
        } else if ((matrizVelha[0][0] == 'O' && matrizVelha[1][0] == ' ' && matrizVelha[2][0] == 'O')) {
            matrizVelha[1][0] = 'O';
        } else if ((matrizVelha[0][0] == ' ' && matrizVelha[1][0] == 'O' && matrizVelha[2][0] == 'O')) {
            matrizVelha[0][0] = 'O';
        } else if ((matrizVelha[0][1] == 'O' && matrizVelha[1][1] == 'O' && matrizVelha[2][1] == ' ')) {
            matrizVelha[2][1] = 'O';
        } else if ((matrizVelha[0][1] == 'O' && matrizVelha[1][1] == ' ' && matrizVelha[2][1] == 'O')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[0][1] == ' ' && matrizVelha[1][1] == 'O' && matrizVelha[2][1] == 'O')) {
            matrizVelha[0][1] = 'O';
        } else if ((matrizVelha[0][2] == 'O' && matrizVelha[1][2] == 'O' && matrizVelha[2][2] == ' ')) {
            matrizVelha[2][2] = 'O';
        } else if ((matrizVelha[0][2] == 'O' && matrizVelha[1][2] == ' ' && matrizVelha[2][2] == 'O')) {
            matrizVelha[1][2] = 'O';
        } else if ((matrizVelha[0][2] == ' ' && matrizVelha[1][2] == 'O' && matrizVelha[2][2] == 'O')) {
            matrizVelha[0][2] = 'O';
        } else if ((matrizVelha[0][0] == 'O' && matrizVelha[1][1] == 'O' && matrizVelha[2][2] == ' ')) {
            matrizVelha[2][2] = 'O';
        } else if ((matrizVelha[0][0] == 'O' && matrizVelha[1][1] == ' ' && matrizVelha[2][2] == 'O')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[0][0] == ' ' && matrizVelha[1][1] == 'O' && matrizVelha[2][2] == 'O')) {
            matrizVelha[0][0] = 'O';
        } else if ((matrizVelha[0][2] == 'O' && matrizVelha[1][1] == 'O' && matrizVelha[2][0] == ' ')) {
            matrizVelha[2][0] = 'O';
        } else if ((matrizVelha[0][2] == 'O' && matrizVelha[1][1] == ' ' && matrizVelha[2][0] == 'O')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[0][2] == ' ' && matrizVelha[1][1] == 'O' && matrizVelha[2][0] == 'O')) {
            matrizVelha[0][2] = 'O';
        } //bloquear
        else if ((matrizVelha[0][0] == 'X' && matrizVelha[0][1] == 'X' && matrizVelha[0][2] == ' ')) {
            matrizVelha[0][2] = 'O';
        } else if ((matrizVelha[0][0] == 'X' && matrizVelha[0][1] == ' ' && matrizVelha[0][2] == 'X')) {
            matrizVelha[0][1] = 'O';
        } else if ((matrizVelha[0][0] == ' ' && matrizVelha[0][1] == 'X' && matrizVelha[0][2] == 'X')) {
            matrizVelha[0][0] = 'O';
        } else if ((matrizVelha[1][0] == 'X' && matrizVelha[1][1] == 'X' && matrizVelha[1][2] == ' ')) {
            matrizVelha[1][2] = 'O';
        } else if ((matrizVelha[1][0] == 'X' && matrizVelha[1][1] == ' ' && matrizVelha[1][2] == 'X')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[1][0] == ' ' && matrizVelha[1][1] == 'X' && matrizVelha[1][2] == 'X')) {
            matrizVelha[1][0] = 'O';
        } else if ((matrizVelha[2][0] == 'X' && matrizVelha[2][1] == 'X' && matrizVelha[2][2] == ' ')) {
            matrizVelha[2][2] = 'O';
        } else if ((matrizVelha[2][0] == 'X' && matrizVelha[2][1] == ' ' && matrizVelha[2][2] == 'X')) {
            matrizVelha[2][1] = 'O';
        } else if ((matrizVelha[2][0] == ' ' && matrizVelha[2][1] == 'X' && matrizVelha[2][2] == 'X')) {
            matrizVelha[2][0] = 'O';
        } else if ((matrizVelha[0][0] == 'X' && matrizVelha[1][0] == 'X' && matrizVelha[2][0] == ' ')) {
            matrizVelha[2][0] = 'O';
        } else if ((matrizVelha[0][0] == 'X' && matrizVelha[1][0] == ' ' && matrizVelha[2][0] == 'X')) {
            matrizVelha[1][0] = 'O';
        } else if ((matrizVelha[0][0] == ' ' && matrizVelha[1][0] == 'X' && matrizVelha[2][0] == 'X')) {
            matrizVelha[0][0] = 'O';
        } else if ((matrizVelha[0][1] == 'X' && matrizVelha[1][1] == 'X' && matrizVelha[2][1] == ' ')) {
            matrizVelha[2][1] = 'O';
        } else if ((matrizVelha[0][1] == 'X' && matrizVelha[1][1] == ' ' && matrizVelha[2][1] == 'X')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[0][1] == ' ' && matrizVelha[1][1] == 'X' && matrizVelha[2][1] == 'X')) {
            matrizVelha[0][1] = 'O';
        } else if ((matrizVelha[0][2] == 'X' && matrizVelha[1][2] == 'X' && matrizVelha[2][2] == ' ')) {
            matrizVelha[2][2] = 'O';
        } else if ((matrizVelha[0][2] == 'X' && matrizVelha[1][2] == ' ' && matrizVelha[2][2] == 'X')) {
            matrizVelha[1][2] = 'O';
        } else if ((matrizVelha[0][2] == ' ' && matrizVelha[1][2] == 'X' && matrizVelha[2][2] == 'X')) {
            matrizVelha[0][2] = 'O';
        } else if ((matrizVelha[0][0] == 'X' && matrizVelha[1][1] == 'X' && matrizVelha[2][2] == ' ')) {
            matrizVelha[2][2] = 'O';
        } else if ((matrizVelha[0][0] == 'X' && matrizVelha[1][1] == ' ' && matrizVelha[2][2] == 'X')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[0][0] == ' ' && matrizVelha[1][1] == 'X' && matrizVelha[2][2] == 'X')) {
            matrizVelha[0][0] = 'O';
        } else if ((matrizVelha[0][2] == 'X' && matrizVelha[1][1] == 'X' && matrizVelha[2][0] == ' ')) {
            matrizVelha[2][0] = 'O';
        } else if ((matrizVelha[0][2] == 'X' && matrizVelha[1][1] == ' ' && matrizVelha[2][0] == 'X')) {
            matrizVelha[1][1] = 'O';
        } else if ((matrizVelha[0][2] == ' ' && matrizVelha[1][1] == 'X' && matrizVelha[2][0] == 'X')) {
            matrizVelha[0][2] = 'O';
        } //cantos    
        else if (matrizVelha[0][0] == ' ') {
            matrizVelha[0][0] = 'O';
        } else if (matrizVelha[0][2] == ' ') {
            matrizVelha[0][2] = 'O';
        } else if (matrizVelha[2][0] == ' ') {
            matrizVelha[2][0] = 'O';
        } else if (matrizVelha[2][2] == ' ') {
            matrizVelha[2][2] = 'O';
        } //bordas
        else if (matrizVelha[1][0] == ' ') {
            matrizVelha[1][0] = 'O';
        } else if (matrizVelha[2][1] == ' ') {
            matrizVelha[2][1] = 'O';
        } else if (matrizVelha[1][2] == ' ') {
            matrizVelha[1][2] = 'O';
        } else if (matrizVelha[0][1] == ' ') {
            matrizVelha[0][1] = 'O';
        }

        int linha = 0, coluna = 0;
        int[] posicao = {linha, coluna};

        return posicao;
    }

    public static void main(String[] args) {
        char[][] m = inicializarTabuleiro();
        int opcao = modoDeJogo();
        imprimeMenuPrincipal(opcao, m);
        qualMaquina(opcao, m);

        jogadaMaquinaDificil(m);
    }
}
