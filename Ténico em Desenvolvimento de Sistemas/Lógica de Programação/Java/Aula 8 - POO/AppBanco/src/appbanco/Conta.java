package appbanco;

/**
 *
 * @author wilian_g_cardoso
 */
public class Conta {

    // Definição dos Atributos de Classe
    private boolean estado = true; // Ativo - !Ativo
    private int tipo; // 0 - Corrente, 1 - Salário, 2 - Poupança
    private int numConta;
    private float limite = 500.00f;
    private float limiteMax = 1500.0f;
    private float saldo = 0.00f;
    private String titular;

    // Getters e Setters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    // Métodos
    public void sacar(float valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }

        if (this.tipo == 0) { // Conta Corrente
            if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.println("Saque Realizado...");
            } else if (this.saldo + this.limite >= valor) {
                float valorUsarLimite = valor - this.saldo;
                this.saldo = 0;
                this.limite -= valorUsarLimite;
                System.out.println("Saque Realizado usando limite...");
            } else {
                System.out.println("Saldo insuficiente...");
            }
        } else {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.println("Saque Realizado...");
            } else {
                System.out.println("Saldo insuficiente...");
            }
        }
    }

    public void depositar(float valor) {
        if (valor <= 0) {
            System.out.println("Valor de deposito invalido.");
            return;
        }

        this.saldo += valor;

        if (this.limite < this.limiteMax) {
            float diferenca = this.limiteMax - this.limite;
            if (valor >= diferenca) {
                this.limite = this.limiteMax;
            } else {
                this.limite += valor;
            }
        }

        System.out.println("Deposito realizado...");
    }

    public void transferir(float valor, Conta destino) {
        if (valor <= 0) {
            System.out.println("Valor de transferencia invalido.");
            return;
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferencia realizada...");
        } else {
            System.out.println("Saldo insuficiente...");
        }
    }

    public void extrato() {
        System.out.println("Titular: " + this.titular);
        System.out.println("Numero da Conta: " + this.numConta);
        System.out.println("Tipo de Conta: " + (this.tipo == 0 ? "Corrente" : this.tipo == 1 ? "Salsrio" : "Poupanca"));
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("Estado: " + (this.estado ? "Ativo" : "Inativo"));
    }
}
