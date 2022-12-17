import java.util.Scanner;

public class JavaDaVelha {
    public static void main (String[] args) {
        System.out.println("JOGO DA VELHA");
        System.out.println("Escolha números de 1 a 9 para fazer sua jogada!\nUtilize o guia abaixo: \n");
        System.out.println("[ 1 ] [ 2 ] [ 3 ]\n[ 4 ] [ 5 ] [ 6 ]\n[ 7 ] [ 8 ] [ 9 ]\n");
        Scanner sc = new Scanner(System.in);
        Character[][] tabuleiro = new Character[3][3];

        jogadaPlayerUm(tabuleiro,sc);
        mostraTabuleiro(tabuleiro);
        jogadaPlayerUm(tabuleiro,sc);
        mostraTabuleiro(tabuleiro);



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
    }

    public static void jogadaPlayerUm (Character[][] tabuleiro, Scanner sc) {
        System.out.println("Faça sua jogada!");
        String escolha = sc.nextLine();
        switch (escolha) {
            case "1" -> tabuleiro[0][0] = 'X';
            case "2" -> tabuleiro[0][1] = 'X';
            case "3" -> tabuleiro[0][2] = 'X';
            case "4" -> tabuleiro[1][0] = 'X';
            case "5" -> tabuleiro[1][1] = 'X';
            case "6" -> tabuleiro[1][2] = 'X';
            case "7" -> tabuleiro[2][0] = 'X';
            case "8" -> tabuleiro[2][1] = 'X';
            case "9" -> tabuleiro[2][2] = 'X';
            default -> System.out.println("Jogada Inválida!");
        }
    }
}