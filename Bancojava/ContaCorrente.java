public class ContaCorrente {
    private String nome;
    private String agencia;
    private double saldo;

    public ContaCorrente (String nome, String agencia) {
        this.nome = nome;
        this.agencia = agencia;
        this.saldo = 0;
    }

    public void depositar(double valorDeposito) {
        if (valorDeposito > 0) {
            this.saldo += valorDeposito;
            System.out.printf("Depósito de R$%.2f realizado com sucesso!\n",valorDeposito);
        } else {
            System.err.println("Quantidade depositada deve ser maior que R$0\n");
        }
    }

    public void sacar(double valorSaque) {
        if (valorSaque > 0) {
            if (valorSaque > this.saldo) {
                System.err.println("Saldo insuficiente para saque.\n");
            } else {
                this.saldo -= valorSaque;
                System.out.printf("Saque de R$%.2f realizado com sucesso.\n", valorSaque);
            }
        } else {
            System.err.println("Quantidade sacada deve ser maior que R$0.\n");
        }
    }

    public void transferir(double valorTransferencia, ContaCorrente conta) {
        if (valorTransferencia > this.saldo) {
            System.err.println("Saldo insuficiente para transferência.\n");
        } else {
            this.saldo -= valorTransferencia;
            conta.saldo  += valorTransferencia;
        }
    }
    public double getSaldo() {
        return this.saldo;
    }
}
