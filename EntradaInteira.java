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