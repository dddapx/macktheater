import java.util.Scanner;
public class Macktheater {

    public static void cadastraEspetaculo() {
        System.out.println("Cadastrando espetáculo...");
        Scanner inputEsp = new Scanner(System.in);
        // Lógica para cadastrar espetáculo 
        System.out.println("Digite o nome do espetáculo:");
        String nome = inputEsp.nextLine();
        System.out.println("Digite a data do espetáculo (DD/MM/AAAA):");
        String data = inputEsp.nextLine();
        System.out.println("Digite a hora do espetáculo (HH:MM):");
        String hora = inputEsp.nextLine();
        System.out.println("Digite o preço da entrada:");
        double preco = inputEsp.nextDouble();

        Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);
        System.out.println("Espetáculo cadastrado com sucesso!");
        System.out.print(novoEspetaculo.toString());
        inputEsp.close();
    }

    public static void cadastraCliente() {
        Scanner inputCli = new Scanner(System.in);
        System.out.println("Cadastrando cliente...");
        // Lógica para cadastrar cliente
        System.out.println("Digite o nome do cliente:");
        String nome = inputCli.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = inputCli.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.print("Nome: " + novoCliente.getNome() + "\nCPF: " + novoCliente.getCpf() + "\n");
        inputCli.close();
    }
 public static void main(String[] args) {
             Scanner input = new Scanner(System.in);
        int opcao;

        while(true) {
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
                    
                    break;
                case 4:
                    System.out.println("Saindo...");
                    input.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
         }   
    }
}