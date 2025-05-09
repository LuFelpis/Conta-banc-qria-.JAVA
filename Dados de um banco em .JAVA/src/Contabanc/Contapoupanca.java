package Contabanc;

// Classe que representa uma conta poupança e herda de ContaBancaria

import javax.swing.JOptionPane;

public class Contapoupanca extends ContaBancaria {
    private double taxarendimento;

    // Construtor que inicializa os atributos da conta poupança
    public Contapoupanca(String senha, int numero, double saldo, double taxaRendimento) {
        super(senha, numero, saldo);
        this.taxarendimento = taxaRendimento;
    }

    // Método para realizar o saque em uma conta poupança
    @Override
    public void saca(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        }
    }
}
