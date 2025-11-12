import java.util.ArrayList;
import java.util.Scanner;
public class Teatro {
    //variaveis
    private static Pedido carrinho;
    public static Espetaculo espetaculoSelecionado;
    public static ArrayList<Espetaculo> espetaculos = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    // Exemplos de espetáculos para teste
    //métodos

    public Teatro() {
        Teatro.carrinho = null;
        Teatro.espetaculoSelecionado = null;
    }
    //utilizado apenas para teste
    public static void inicializarBase(){
        Espetaculo esp = new Espetaculo("Fantasma da Ópera", "25/12/2024", "20:00", 150.0);
        Espetaculo esp2 = new Espetaculo("Beetlejuice", "25/12/2024", "20:00", 100.0);
        Espetaculo esp3 = new Espetaculo("Mamma Mia", "25/12/2024", "20:00", 120.0);
        espetaculos.add(esp);
        espetaculos.add(esp2);
        espetaculos.add(esp3);
    }
    
    public static void apresentarEspetaculos() {
        System.out.println("Espetáculos disponíveis:");
        for (int i = 0; i < espetaculos.size(); i++) {
            System.out.println( i+ 1 + ": " + espetaculos.get(i).toString());
        }
    }
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
        System.out.println("***CADASTRO DO ESPETÁCULO:***");
        System.out.println(novoEspetaculo.toString());
        espetaculos.add(novoEspetaculo);
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
        clientes.add(novoCliente);
    }

    public static void selecionarEspetaculo(int indice){
        System.out.println("Selecione um Espetáculo:");
        if(indice > 1 || indice < espetaculos.size()){
            espetaculoSelecionado = espetaculos.get(indice - 1);
        } else {
            System.out.println("Índice inválido."); //programa esta quabrando quando indice é invalido
        }
    }
    
 public static void main(String[] args) {
             Scanner input = new Scanner(System.in);
        int opcao;
        int opcaoEspetaculo;
        while(true) {
            System.out.println("\nMenu:");
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
                    apresentarEspetaculos();
                    selecionarEspetaculo(opcaoEspetaculo = input.nextInt());
                    espetaculoSelecionado.apresentaAssentos();
                    System.out.println("\nDigite o número do assento que deseja comprar:");
                    int numeroAssento = input.nextInt();
                    espetaculoSelecionado.marcarAssento(numeroAssento);  //funcionando ate a parte de marcar assento
                    break;
                case 4:
                    System.out.println("Saindo...");
                    input.close();
                    return;
                case 5:
                    inicializarBase();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
         }   
    }
}