/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
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
    }

    public void apresentaAssentos() {
        System.out.println("||| Assentos Disponíveis |||");
        
        for (int i = assentos.length - 1; i >= 0; i--) { 
            //negativo pq n ta add ta tirando e começa de tras p frente
            
            if (assentos[i]) { 
                System.out.print("XX "); //ocupado
            } else { 
                System.out.printf("%02d ", (i + 1)); //livre
            }

            //pra ter 10 fileiras ai tem condição de i divido por 10 resto 0 da ln
            if (i % 10 == 0) { 
                System.out.println();
            }
        }
    }

    public Entrada novaEntrada(int tipo, int assento) {
        if (assento < 1 || assento > 50) {
            System.out.print("INVALIDO. TENTE DE NOVO.");
            return null;
        }
        if (assentos[assento - 1]) { 
            System.out.println("ASSENTO OCUPADO!");
            return null;
        }

        this.marcarAssento(assento);

        if (tipo == 1) {
            return new EntradaInteira(this.preco, assento);
        } else if (tipo == 2) {
            return new EntradaMeia(this.preco, assento);
        } else if (tipo == 3) {
            return new EntradaProfessor(this.preco, assento);
        } else {
            System.out.println("Tipo de entrada inválido!");
            this.assentos[assento - 1] = false; 
            return null;
        }
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
        return "Nome do Espetáculo: " + nome + "\r\n" +
               "Data: " + data + "\r\n" +
               "Hora: " + hora + "\r\n" +
               "Preço da Entrada Inteira: " + preco;
    }

    private void marcarAssento(int assento) {
        this.assentos[assento - 1] = true;
    }
}