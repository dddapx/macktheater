/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
public class EntradaInteira extends Entrada {
    private double valor;

    public EntradaInteira(double valor) {
        this.valor = valor;
    }

    @Override
    public double calculaValor() {
        return valor;
    }
}