public class Espetaculo {
    //lista de espetaculos (?)
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];

    public Espetaculo (String nome, String data, String hora, double preco){
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
    }

    public void apresentaAssentos (){

    }

    public Entrada novaEntrada (int tipo, int assento){

    }

    public double getPreco (){
        return preco;
    }

    @Override
    public String toString(){
        return "*** CADASTRO DE ESPETÁCULO ***\r\n" + //
                        "Nome do Espetáculo: "+nome\r\n + //
                        "Data: "+data\r\n + //
                        "Hora: "+hora\r\n + //
                        "Preço da Entrada Inteira: "+preco;
    }

    private void marcarAssento(int assento){
        
    }
}
