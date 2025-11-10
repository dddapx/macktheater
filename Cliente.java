/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */

public class Cliente {
    //lista de clientes(?)
    private String nome;
    private String cpf;

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
    public void adicionaPedido(Pedido pedido){
        
    }
}
