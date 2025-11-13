/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private Pedido carrinho;
    private Espetaculo espetaculoSelecionado;
    private List<Espetaculo> espetaculos;
    private List<Cliente> clientes;

    public Teatro() {
        this.espetaculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.carrinho = null;
        this.espetaculoSelecionado = null;
    }

    public void cadastraEspetaculo(String nome, String data, String hora, double preco) {
        Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);
        this.espetaculos.add(novoEspetaculo);
        System.out.println("Espetáculo cadastrado com sucesso!");
    }

    public void cadastraCliente(String nome, String cpf) {
        Cliente novoCliente = new Cliente(nome, cpf);
        this.clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void novaCompra() {
        this.carrinho = new Pedido();
        this.espetaculoSelecionado = null;
    }

    public void apresentaEspetaculos() {
        System.out.println("*** ESPETÁCULOS ***");
        for (int i = 0; i < espetaculos.size(); i++) {
            Espetaculo esp = espetaculos.get(i); 
            
            System.out.println( (i + 1) + ") "+esp.getNome()+" "+esp.getData()+" "+esp.getHora()+" R$ "+esp.getPreco() );
        }
    }

    public boolean selecionaEspetaculo(int numero) {
        int indice = numero - 1; 
        
        if (indice >= 0 && indice < espetaculos.size()) {
            this.espetaculoSelecionado = espetaculos.get(indice);
            System.out.println("Espetáculo selecionado: " + espetaculoSelecionado.getNome());
            this.espetaculoSelecionado.apresentaAssentos();
            return true;
        } else {
            System.out.println("Número de espetáculo inválido.");
            this.espetaculoSelecionado = null;
            return false;
        }
    }

    public boolean novaEntrada(int tipo, int assento) {
        if (this.espetaculoSelecionado == null) {
            System.out.println("Erro: Nenhum espetáculo selecionado.");
            return false;
        }
        
        Entrada entrada = espetaculoSelecionado.novaEntrada(tipo, assento);

        if (entrada != null) {
            this.carrinho.adicionaEntrada(entrada);
            System.out.println("Entrada adicionada ao carrinho.");
            return true;
        } else {
            return false;
        }
    }

    public double finalizaCompra(String cpf) {
        Cliente cliente = null;
        
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Erro: CPF não encontrado.");
            return 0.0; 
        }

        cliente.adicionarPedido(this.carrinho);
        double total = this.carrinho.calculaValorTotal();

        this.carrinho = null;
        this.espetaculoSelecionado = null;

        return total;
    }
}