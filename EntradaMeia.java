/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
public class EntradaMeia extends Entrada {
    private double valor;

    public EntradaMeia(double valor) {
        this.valor = valor;
    }

    @Override
    public double calculaValor() {
        return valor / 2;
    }
    
}
