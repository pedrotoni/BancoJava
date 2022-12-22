import java.util.Scanner;

public class ExercicioConta {
    public static void main (String[] args) {

        ContaCorrente conta1 = new ContaCorrente("Pedro","7132");
        ContaCorrente conta2 = new ContaCorrente("Fernanda","4839");
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao Banco Java!\nEscolha sua opção abaixo:");
        System.out.println("1-Deposito\n2-Saque\n3-Transferência\n4-Sair");

        menu : while (true) {
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Quanto deseja depositar?");
                    double deposito = sc.nextDouble();
                    conta1.depositar(deposito);
                    System.out.println("Saldo Conta 1: "+conta1.getSaldo());
                    System.out.println("Deseja realizar alguma outra operação?");
                    break;
                case 2:
                    System.out.println("Quanto deseja sacar?");
                    double saque = sc.nextDouble();
                    conta1.sacar(saque);
                    System.out.println("Saldo Conta1: "+conta1.getSaldo());
                    System.out.println("Deseja realizar alguma outra operação?");
                    break;
                case 3:
                    System.out.println("Quanto deseja transferir?");
                    double transferencia = sc.nextDouble();
                    conta1.transferir(transferencia,conta2);
                    System.out.println("Saldo Conta1: "+conta1.getSaldo());
                    System.out.println("Saldo Conta2: "+conta2.getSaldo());
                    System.out.println("Deseja realizar alguma outra operação?");
                    break;
                case 4:
                    System.out.println("Até a próxima!");
                    break menu;
                default:
                    System.out.println("Opção Inválida!");
            }
        }




    }
}
