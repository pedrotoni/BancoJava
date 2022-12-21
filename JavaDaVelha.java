import java.util.Scanner;

public class JavaDaVelha {
    public static void main(String[] args) {
        System.out.println("JOGO DA VELHA");
        System.out.println("Digite uma coordenada para fazer sua jogada!\nUtilize o guia abaixo: \n");
        System.out.println("[ 00 ] [ 01 ] [ 02 ]\n[ 10 ] [ 11 ] [ 12 ]\n[ 20 ] [ 21 ] [ 22 ]\n");
        Scanner sc = new Scanner(System.in);
        Character[][] tabuleiro = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        while(true) {
            jogadaPlayerUm(tabuleiro,sc);
            if (confereEmpate(tabuleiro) || confereVitoria(tabuleiro)) {
                break;
            }
            mostraTabuleiro(tabuleiro);
            jogadaPlayerDois(tabuleiro,sc);
            if (confereEmpate(tabuleiro) || confereVitoria(tabuleiro)) {
                break;
            }
            mostraTabuleiro(tabuleiro);
        }
        mostraTabuleiro(tabuleiro);
        sc.close();
    }
    public static void mostraTabuleiro(Character[][] tabuleiro) {
        for (Character[] linha : tabuleiro) {
            System.out.print("[ ");

            for (int numColuna = 0; numColuna < linha.length; numColuna++) {
                Character elemento = linha[numColuna];

                if (elemento == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(elemento);
                }

                if (numColuna == linha.length - 1) {
                    System.out.print(" ]");
                } else {
                    System.out.print(" ][ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void jogadaPlayerUm(Character[][] tabuleiro, Scanner sc) {
        System.out.println("Faça sua jogada! (Player1 -> X) ");
        String escolha1;
        while (true) {
            escolha1 = sc.nextLine();
            if (verificaJogada(tabuleiro, escolha1)) {
                break;
            }
            System.out.println("Ops! Jogada inválida! Tente novamente.");
        }
        jogada(tabuleiro, escolha1, 'X');
        System.out.println("Player 1 escolheu coordenada " + escolha1);
        System.out.println();
    }
    public static void jogadaPlayerDois(Character[][] tabuleiro, Scanner sc) {
        System.out.println("Faça sua jogada! (Player2 -> O) ");
        String escolha2;
        while (true) {
            escolha2 = sc.nextLine();
            if (verificaJogada(tabuleiro, escolha2)) {
                break;
            }
            System.out.println("Ops! Jogada Inválida! Tente novamente.");
        }
        jogada(tabuleiro, escolha2, 'O');
        System.out.println("Player 2 escolheu coordenada " + escolha2);
        System.out.println();
    }
    public static void jogada(Character[][] tabuleiro, String coordenada, char XouO) {
        switch (coordenada) {
            case "00" -> tabuleiro[0][0] = XouO;
            case "01" -> tabuleiro[0][1] = XouO;
            case "02" -> tabuleiro[0][2] = XouO;
            case "10" -> tabuleiro[1][0] = XouO;
            case "11" -> tabuleiro[1][1] = XouO;
            case "12" -> tabuleiro[1][2] = XouO;
            case "20" -> tabuleiro[2][0] = XouO;
            case "21" -> tabuleiro[2][1] = XouO;
            case "22" -> tabuleiro[2][2] = XouO;
            default -> System.out.println("Jogada Inválida!\n");
        }
    }
    public static boolean verificaJogada(Character[][] tabuleiro, String coordenada) {
        return switch (coordenada) {
            case "00" -> tabuleiro[0][0] == ' ';
            case "01" -> tabuleiro[0][1] == ' ';
            case "02" -> tabuleiro[0][2] == ' ';
            case "10" -> tabuleiro[1][0] == ' ';
            case "11" -> tabuleiro[1][1] == ' ';
            case "12" -> tabuleiro[1][2] == ' ';
            case "20" -> tabuleiro[2][0] == ' ';
            case "21" -> tabuleiro[2][1] == ' ';
            case "22" -> tabuleiro[2][2] == ' ';
            default -> false;
        };
    }
    public static boolean confereSequenciaCompleta(Character[][] tabuleiro, char XouO) {
        return (tabuleiro[0][0] == XouO && tabuleiro[0][1] == XouO && tabuleiro[0][2] == XouO)
                || (tabuleiro[1][0] == XouO && tabuleiro[1][1] == XouO && tabuleiro[1][2] == XouO)
                || (tabuleiro[2][0] == XouO && tabuleiro[2][1] == XouO && tabuleiro[2][2] == XouO)
                || (tabuleiro[0][0] == XouO && tabuleiro[1][1] == XouO && tabuleiro[2][2] == XouO)
                || (tabuleiro[0][2] == XouO && tabuleiro[1][1] == XouO && tabuleiro[2][0] == XouO)
                || (tabuleiro[0][0] == XouO && tabuleiro[1][0] == XouO && tabuleiro[2][0] == XouO)
                || (tabuleiro[0][1] == XouO && tabuleiro[1][1] == XouO && tabuleiro[2][1] == XouO)
                || (tabuleiro[0][2] == XouO && tabuleiro[1][2] == XouO && tabuleiro[2][2] == XouO);
    }
    public static boolean confereEmpate(Character[][] tabuleiro) {

        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                if (tabuleiro[linha][coluna] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Empate! Jogue novamente!");
        return true;
    }
    public static boolean confereVitoria(Character[][] tabuleiro) {
        if (confereSequenciaCompleta(tabuleiro, 'X')) {
            System.out.println("Player 1 Venceu! - X\n");
            return true;
        }
        if (confereSequenciaCompleta(tabuleiro, 'O')) {
            System.out.println("Player 2 venceu! - O\n");
            return true;
        }
        return false;
    }
}
