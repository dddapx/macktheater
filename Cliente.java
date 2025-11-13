/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    } 
    public String getCpf() {
        return cpf;
    }  

    public void adicionaPedido(Pedido pedido) {
        // Lógica para adicionar o pedido ao cliente
    }
}
