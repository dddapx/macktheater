/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */ 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Macktheater {

    static List<Espetaculo> listaEspetaculos = new ArrayList<>();
    static List<Cliente> listaClientes = new ArrayList<>();


    public static void cadastraEspetaculo() {
        Scanner inputEsp = new Scanner(System.in);

        System.out.println("Cadastrando espetáculo...");

        System.out.println("Digite o nome do espetáculo:");
        String nome = inputEsp.nextLine();

        System.out.println("Digite a data do espetáculo (DD/MM/AAAA):");
        String data = inputEsp.nextLine();

        System.out.println("Digite a hora do espetáculo (HH:MM):");
        String hora = inputEsp.nextLine();

        System.out.println("Digite o preço da entrada:");
        double preco = inputEsp.nextDouble();
        inputEsp.nextLine(); 

        Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);
        listaEspetaculos.add(novoEspetaculo);  // ← FALTAVA ISSO

        System.out.println("Espetáculo cadastrado com sucesso!");
        System.out.println(novoEspetaculo.toString());
    }


    public static void cadastraCliente() {
        Scanner inputCli = new Scanner(System.in);

        System.out.println("Cadastrando cliente...");

        System.out.println("Digite o nome do cliente:");
        String nome = inputCli.nextLine();

        System.out.println("Digite o CPF do cliente:");
        String cpf = inputCli.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);
        listaClientes.add(novoCliente); // a lkista de clientes pra armazenar os clientes e aparecer no finalizar compra

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Nome: " + novoCliente.getNome());
        System.out.println("CPF: " + novoCliente.getCpf());
    }



    public static void comprarEntradas() {
        Scanner input = new Scanner(System.in);

        if (listaEspetaculos.isEmpty()) { /* para lista vazia */
            System.out.println("Nenhum espetáculo cadastrado.");
            return;
        }

        System.out.println("Escolha um espetáculo:"); /*com indice que começa no 0 */

        for (int i = 0; i < listaEspetaculos.size(); i++) {
            System.out.println(i + " - " + listaEspetaculos.get(i).toString());
        }

        System.out.print("Digite o número do espetáculo: ");
        int num = input.nextInt();
        input.nextLine();

        if (num < 0 || num >= listaEspetaculos.size()) {
            System.out.println("Espetáculo nao existe, tenta de novo");
            return;
        }

        Espetaculo esp = listaEspetaculos.get(num);

        esp.apresentaAssentos();

        Pedido pedido = new Pedido();
        boolean continuar = true;

        while (continuar) {
            System.out.print("digite o assento desejado: ");
            int assento = input.nextInt();

            System.out.println("Tipo de entrada:");
            System.out.println("1 - Inteira");
            System.out.println("2 - Meia");
            System.out.println("3 - Professor");
            System.out.print("Selecione um tipo de entrada: ");
            int tipo = input.nextInt();
            input.nextLine();

            Entrada entrada = esp.novaEntrada(tipo, assento);

            if (entrada != null) {
                pedido.adicionaEntrada(entrada);
                System.out.println("Entrada adicionada!");
            }

            System.out.print("Deseja comprar outra entrada? (s/n): ");
            String r = input.nextLine();

            continuar = r.equalsIgnoreCase("s"); /*maiúscula ou minúscula tanto faz */
        }

        System.out.print("Digite o CPF do cliente: ");
        String cpf = input.nextLine();

        Cliente cliente = null;

        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        cliente.adicionarPedido(pedido);

        System.out.println("Valor total a pagar: R$ " + pedido.calculaValorTotal());
        System.out.println("Compra finalizada");
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar espetáculo");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Comprar entradas");
            System.out.println("4. Sair");

            opcao = input.nextInt();
            input.nextLine();

            switch(opcao) {
                case 1:
                    cadastraEspetaculo();
                    break;

                case 2:
                    cadastraCliente();
                    break;

                case 3:
                    comprarEntradas();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    input.close();
                    return;

                default:
                    System.out.println("Opção inválida Tente novamente.");
            }
        }
    }
}
