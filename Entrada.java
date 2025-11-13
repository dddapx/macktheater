/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */

//lista de entradas(?), na uml ta * em entradas tipo tem muitas
public abstract class Entrada {
    
    private int numeroDoAssento;
    protected double precoBase; 

    public Entrada(double precoBase, int numeroDoAssento) {
        this.precoBase = precoBase;
        this.numeroDoAssento = numeroDoAssento;
    }
    public int getNumeroDoAssento() { //como o cliente vai saber o numero do assento? por isso coloquei mas pesquiseie nao necessariamente um get precisa estar explicito na uml
        return numeroDoAssento;
    }
    public abstract double calculaValor();
}