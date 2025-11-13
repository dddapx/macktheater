/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */
public class EntradaProfessor extends Entrada {
    private double valor;

    public EntradaProfessor(double valor) {
        this.valor = valor;
    }

    @Override
    public double calculaValor() {
        return valor * 0.4; // Professores pagam 40% do valor da entrada
    }
    
}
