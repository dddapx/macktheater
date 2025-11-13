import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Teatro meuTeatro = new Teatro();
        int opcao;
        
        do {
            System.out.println("\n*** MACK THEATHER ***");
            System.out.println("1) Cadastrar Espetáculo");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("*** CADASTRO DE ESPETÁCULO ***");
                    System.out.print("Nome do Espetáculo: ");
                    String nomeEsp = scanner.nextLine();
                    System.out.print("Data: ");
                    String dataEsp = scanner.nextLine();
                    System.out.print("Hora: ");
                    String horaEsp = scanner.nextLine();
                    System.out.print("Preço da Entrada Inteira: ");
                    double precoEsp = scanner.nextDouble();
                    scanner.nextLine(); 
                    
                    meuTeatro.cadastraEspetaculo(nomeEsp, dataEsp, horaEsp, precoEsp);
                    break;
                case 2:
                    System.out.println("*** CADASTRO DE CLIENTE ***");
                    System.out.print("Nome do Cliente: ");
                    String nomeCli = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfCli = scanner.nextLine();
                    
                    meuTeatro.cadastraCliente(nomeCli, cpfCli);
                    break;
                case 3:
                    System.out.println("*** VENDA DE ENTRADAS ***");
                    meuTeatro.novaCompra();
                    
                    meuTeatro.apresentaEspetaculos();
                    System.out.print("Selecione um espetáculo: ");
                    int numEsp = scanner.nextInt();
                    scanner.nextLine(); // Limpando o buffer
                    
                    if (meuTeatro.selecionaEspetaculo(numEsp)) {
                        String continuar;
                        do {
                            System.out.print("Selecione um assento: ");
                            int assento = scanner.nextInt();
                            
                            System.out.println("||| Tipos de Entrada |||");
                            System.out.println("1) Inteira");
                            System.out.println("2) Meia");
                            System.out.println("3) Professor");
                            System.out.print("Selecione um tipo de entrada: ");
                            int tipo = scanner.nextInt();
                            scanner.nextLine(); 

                            meuTeatro.novaEntrada(tipo, assento);

                            System.out.print("Deseja comprar outra entrada (S/N)? ");
                            continuar = scanner.nextLine();
                        
                        } while (continuar.toLowerCase().equals("s")); 

                        System.out.print("Informe o CPF do Cliente Cadastrado: ");
                        String cpfCompra = scanner.nextLine();
                        
                        double total = meuTeatro.finalizaCompra(cpfCompra);
                        
                        if (total > 0) { 
                            System.out.println("Valor Total: R$ " + total);
                        }
                        System.out.println(">>> Retornar ao menu principal <<<");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}