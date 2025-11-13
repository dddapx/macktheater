/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
import java.util.ArrayList;
import java.util.List; /*mais de um pedido*/
public class Cliente {
    //lista de clientes(?)
    private String nome;
    private String cpf;

    private List<Pedido> pedidos = new ArrayList<>();


    public Cliente (String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
        
}

