/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */

public class EntradaMeia extends Entrada {

    public EntradaMeia(double precoBase, int numeroDoAssento) {
        super(precoBase, numeroDoAssento);
    }

    public double calculaValor() {
        return this.precoBase * 0.50;
    }
}