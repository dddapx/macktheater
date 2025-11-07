
public class Espetaculo {
    //lista de espetaculos (?)
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50]; // 50 assentos, false = disponível
    }

    public void apresentaAssentos (){

    }

    public Entrada novaEntrada (int tipo, int assento){
        return null;

    }

    public void setPreco (double preco){
        this.preco = preco;
    }
    public double getPreco (){
        return preco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getHora() {
        return hora;
    }

    @Override
    public String toString(){
        return " CADASTRO DE ESPETÁCULO \n" +
               "Nome do Espetáculo: " + nome + "\n" +
               "Data: " + data + "\n" +
               "Hora: " + hora + "\n" +
               "Preço da Entrada Inteira: " + preco + "\n";
    }

    private void marcarAssento(int assento){
        
    }

}
