package Contabanc;

// Classe abstrata que representa uma conta bancária genérica.
public abstract class ContaBancaria {
    private String senha;
    private int numero;
    private double saldo;

    // Construtor que inicializa os atributos da conta bancária
    public ContaBancaria(String senha, int numero, double saldo) {
        this.senha = senha;
        this.numero = numero;
        this.saldo = saldo;
    }

    // Getters e setters
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método abstrato que será implementado pelas subclasses para realizar o saque
    public abstract void saca(double valor);
}
