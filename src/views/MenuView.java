package views;

import controllers.CaixaController;
import models.Lancamento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    private CaixaController controller = new CaixaController();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcao;
        try {
            do {
                System.out.println("\n==== SISTEMA DE CAIXA SIMPLES ====");
                System.out.println("1 - Registrar entrada");
                System.out.println("2 - Registrar saida");
                System.out.println("3 - Ver saldo atual");
                System.out.println("4 - Ver extrato");
                System.out.println("5 - Sair");
                System.out.print("Escolha uma opcao: ");
                opcao = sc.nextInt();
                sc.nextLine(); // limpar buffer

                switch (opcao) {
                    case 1:
                        registrarLancamento("Entrada");
                        break;
                    case 2:
                        registrarLancamento("Saida");
                        break;
                    case 3:
                        System.out.printf("Saldo atual: R$ %.2f\n", controller.calcularSaldo());
                        break;
                    case 4:
                        mostrarExtrato();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }
            } while (opcao != 5);
        }
        catch (InputMismatchException e) {
            System.out.println("Caratere inválido. Digite apenas números!");
        }
        finally {
            sc.close();
        }
    }

    private void registrarLancamento(String tipo) {
        System.out.print("Descricao: ");
        String descricao = sc.nextLine();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        sc.nextLine(); // limpar buffer
        controller.adicionarLancamento(descricao, valor, tipo);
        System.out.println(tipo + " registrada com sucesso!");
    }

    private void mostrarExtrato() {
        System.out.println("\n==== EXTRATO ====");
        for (Lancamento l : controller.getLancamentos()) {
            System.out.printf("[%s] %s - R$ %.2f\n", l.getTipo(), l.getDescricao(), l.getValor());
        }
    }

}
