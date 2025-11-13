/* Nome e RA: Lara Arthuso 10444811, FELIPE PRIOSTE 10418916, DAVI PAIVA 10385766 */

//porque pode ter + de 1 pedido por isso array!!
import java.util.ArrayList;
import java.util.List;


public class Pedido {

    
    private List<Entrada> entradas;  /*varios pedidos */

  
    public Pedido() {
        entradas = new ArrayList<>();
    }

    public void adicionaEntrada(Entrada entrada){
        entradas.add(entrada);
    }


public double calculaValorTotal(){
        double total = 0;
        for (Entrada e : entradas) {
            total += e.calculaValor();
        }
        return total;
    }
}