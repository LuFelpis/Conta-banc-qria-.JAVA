import javax.swing.*;

import Contabanc.*;

import java.util.ArrayList;

// Classe principal do aplicativo que simula o caixa eletrônico.
public class App5EX {
    public static void main(String[] args) {
        // Lista para armazenar as contas bancárias (ContaCorrente e ContaPoupanca)
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        boolean sair = false;

        // Loop para exibir o menu e permitir que o usuário faça as escolhas
        while (!sair) {
            // Exibe o menu de opções
            String opcao = JOptionPane.showInputDialog(
                "Escolha uma opção:\n" +
                "1. Criar conta corrente\n" +
                "2. Criar conta poupança\n" +
                "3. Sacar\n" +
                "4. Depositar\n" +
                "5. Verificar Saldo\n" +
                "6. Sair"
            );

            // Ação a ser tomada de acordo com a opção escolhida
            switch (opcao) {
                case "1":
                    // Cria uma conta corrente
                    criarContaCorrente(contas);
                    break;
                case "2":
                    // Cria uma conta poupança
                    criarContaPoupanca(contas);
                    break;
                case "3":
                    // Realiza o saque de uma conta
                    sacar(contas);
                    break;
                case "4":
                    // Realiza o depósito em uma conta
                    depositar(contas);
                    break;
                case "5":
                    // Verifica o saldo de uma conta
                    verificarSaldo(contas);
                    break;
                case "6":
                    // Se o usuário escolher a opção 6, sai do loop e encerra o programa
                    sair = true;
                    break;
                default:
                    // Exibe mensagem de erro se a opção for inválida
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }

    // Método para criar uma conta corrente
    private static void criarContaCorrente(ArrayList<ContaBancaria> contas) {
        // Solicita os dados da conta corrente
        String senha = JOptionPane.showInputDialog("Digite a senha da conta corrente:");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta corrente:"));
        double limiteChequeEspecial = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite do cheque especial:"));

        // Cria a conta corrente e a adiciona na lista de contas
        Contacorrente conta = new Contacorrente(senha, numero, 0, limiteChequeEspecial);
        contas.add(conta);
        
        // Exibe mensagem de sucesso
        JOptionPane.showMessageDialog(null, "Conta corrente criada com sucesso.");
    }

    // Método para criar uma conta poupança
    private static void criarContaPoupanca(ArrayList<ContaBancaria> contas) {
        // Solicita os dados da conta poupança
        String senha = JOptionPane.showInputDialog("Digite a senha da conta poupança:");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta poupança:"));
        double taxaRendimento = Double.parseDouble(JOptionPane.showInputDialog("Digite a taxa de rendimento:"));

        // Cria a conta poupança e a adiciona na lista de contas
        Contapoupanca conta = new Contapoupanca(senha, numero, 0, taxaRendimento);
        contas.add(conta);

        // Exibe mensagem de sucesso
        JOptionPane.showMessageDialog(null, "Conta poupança criada com sucesso.");
    }

    // Método para sacar de uma conta
    private static void sacar(ArrayList<ContaBancaria> contas) {
        // Solicita o número e a senha da conta
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        String senha = JOptionPane.showInputDialog("Digite a senha da conta:");
        
        // Procura a conta correspondente
        ContaBancaria conta = procurarConta(contas, numero, senha);
        
        // Verifica se a conta foi encontrada
        if (conta != null) {
            // Solicita o valor a ser sacado
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a sacar:"));
            // Chama o método saca() da conta para realizar o saque
            conta.saca(valor);
            // Exibe mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.");
        } else {
            // Se a conta não for encontrada, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    // Método para depositar em uma conta
    private static void depositar(ArrayList<ContaBancaria> contas) {
        // Solicita o número da conta e o valor a ser depositado
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar:"));
        
        // Procura a conta correspondente
        ContaBancaria conta = procurarConta(contas, numero);
        
        // Verifica se a conta foi encontrada
        if (conta != null) {
            // Atualiza o saldo da conta com o valor depositado
            conta.setSaldo(conta.getSaldo() + valor);
            // Exibe mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso.");
        } else {
            // Se a conta não for encontrada, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    // Método para verificar saldo de uma conta
    private static void verificarSaldo(ArrayList<ContaBancaria> contas) {
        // Solicita o número da conta e a senha
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        String senha = JOptionPane.showInputDialog("Digite a senha da conta:");
        
        // Procura a conta correspondente
        ContaBancaria conta = procurarConta(contas, numero, senha);
        
        // Verifica se a conta foi encontrada
        if (conta != null) {
            // Exibe o número da conta e o saldo
            JOptionPane.showMessageDialog(null, "Número: " + conta.getNumero() + "\nSaldo: " + conta.getSaldo());
        } else {
            // Se a conta não for encontrada, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    // Método auxiliar para procurar a conta através do número e da senha
    private static ContaBancaria procurarConta(ArrayList<ContaBancaria> contas, int numero, String senha) {
        // Itera pela lista de contas procurando uma conta com o número e a senha correspondentes
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero && conta.getSenha().equals(senha)) {
                return conta;
            }
        }
        // Retorna null se não encontrar a conta
        return null;
    }

    // Método auxiliar para procurar a conta apenas através do número (sem a senha)
    private static ContaBancaria procurarConta(ArrayList<ContaBancaria> contas, int numero) {
        // Itera pela lista de contas procurando uma conta com o número correspondente
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        // Retorna null se não encontrar a conta
        return null;
    }
}
