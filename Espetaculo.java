/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
public class Espetaculo {
    private String nome;
    private String hora;
    private String data;
    private double preco;
    private boolean[] assentos = new boolean[50];


    public Espetaculo(String nome, String hora, String data, double preco) {
        this.nome = nome;
        this.hora = hora;
        this.data = data;
        this.preco = preco;
        for (int i = 0; i < this.assentos.length; i++) {
            assentos[i] = false; // Inicializa todos os assentos como disponíveis
        }
    }

    public String getNome() {
        return nome;
    }

    public String getHora() {
        return hora;
    }

    public String getData() {
        return data;
    }

    public double getPreco() {
        return preco;
    }

    public void apresentaAssentos() {
        System.out.println("Assentos disponíveis para o espetáculo " + nome + ":");
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i] == false) {
                System.out.print((i + 1) + " ");
            }
            else {
                System.out.print("XX ");
            }
            if (i % 10 == 0) { //pra ter 10 fileiras ai tem condição de i divido por 10 resto 0 da ln
            System.out.println();
            }
        }
    }

    public Entrada novaEntrada(int tipo, int asssento){
        for(int i = 0; i < assentos.length; i++){
            if(assentos[i] == false && i == asssento -1){
                assentos[i] = true;
                if(tipo == 1){
                    return new EntradaInteira(preco);
                } else if (tipo == 2) {
                    return new EntradaMeia(preco);
                } else if (tipo == 3){
                    return new EntradaProfessor(preco);
                } else {
                    System.out.println("Tipo de entrada inválido.");
                    return null;
                }
            }
        }
        return null;
    }

    public void marcarAssento(int numeroAssento){ // temos que fazer com que caso o assento ja esteja marcado ele avise que é invalido e pergunte novamente qual assento deseja
        if (assentos[numeroAssento - 1] == true){
            System.out.println("Número de assento inválido.");
        } else if (numeroAssento >= 1 && numeroAssento <= assentos.length) {
            assentos[numeroAssento - 1] = true;
        } else {
            System.out.println("Número de assento inválido.");
        }
    }

        @Override
        public String toString() {
            return "Nome do Espetáculo: " + nome + "\r\n" + "Data: " + data + "\r\n" + "Hora: " + hora + "\r\n" + "Preço da Entrada Inteira: " + preco;
        }
    }
