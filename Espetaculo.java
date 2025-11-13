/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
public class Espetaculo {

    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos;

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50]; // false = livre
    }

    public void apresentaAssentos() {
        System.out.println("||| Assentos Disponíveis |||");

        for (int i = assentos.length - 1; i >= 0; i--) {

            if (assentos[i]) {
                System.out.print("XX "); // ocupados
            } else {
                System.out.print((i + 1) + "  "); // livres
            }

            //quebra a linha a cada 10 assentos com div
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public Entrada novaEntrada(int tipo, int assento) {
        if (assento < 1 || assento > 50) {
            System.out.println("ASSENTO INVÁLIDO, TENTE DE NOVOO!");
            return null;
        }

        if (assentos[assento - 1]) {
            System.out.println("ASSENTO OCUPADO!");
            return null;
        }

        Entrada e = null;

        switch (tipo) {
            case 1:
                e = new EntradaInteira(preco, assento);
                break;
            case 2:
                e = new EntradaMeia(preco, assento);
                break;
            default:
                System.out.println("TIPO DE ENTRADA INVÁLIDO!");
                return null;
        }

        marcarAssento(assento);
        return e;
    }

    private void marcarAssento(int assento) {
        assentos[assento - 1] = true;
    }

    public double getPreco() {
        return preco;
    }
    
    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "CADASTRO DE ESPETÁCULO" +
               "Nome: " + nome + "\n" +
               "Data: " + data + "\n" +
               "Hora: " + hora + "\n" +
               "Preço da Entrada Inteira: " + preco;
    }
}

