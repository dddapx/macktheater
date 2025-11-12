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
