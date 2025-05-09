package Contabanc;

import javax.swing.JOptionPane;

// Classe que representa uma conta corrente e herda de ContaBancaria
public class Contacorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    // Construtor que inicializa os atributos da conta corrente
    public Contacorrente(String senha, int numero, double saldo, double limiteChequeEspecial) {
        super(senha, numero, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    // Método para realizar o saque em uma conta corrente
    @Override
    public void saca(double valor) {
        // Se o valor a ser sacado for maior que o saldo mais o limite do cheque especial, o saque não é permitido
        if (valor <= getSaldo() + limiteChequeEspecial) {
            setSaldo(getSaldo() - valor);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        }
    }
}
