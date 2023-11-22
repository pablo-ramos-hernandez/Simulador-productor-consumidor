package huerto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Huerto {

    /**
     * Importante poner todos los metodos synchronized porque no pueden ir en los
     * hilos debido a que no pueden ir en el punto de fractura
     */
    private final int CAPACIDADALMACEN;
    private final List<String> ALMACEN;

    // Creamos el constructor y nos obliga a implementar el ArrayList dentro del
    // constructor
    public Huerto(int capacidadAlmacen) {
        this.CAPACIDADALMACEN = capacidadAlmacen;
        this.ALMACEN = new ArrayList<>();
    }

    /**
     * Indicamos que tiene un nombre y la verdura que vamos a llamar, decimos que si
     * el almacen esta lleno que espere y despues lo dormimos un numero random y lo
     * almacenamos dentro del array, hacemos sout y con el notifyAll despertamos
     * todo lo dormido
     */
    public synchronized void plantarVerdura(String nombreGranjero, String verdura) throws InterruptedException {
        while (ALMACEN.size() >= CAPACIDADALMACEN) {
            wait();
        }
        Thread.sleep(new Random().nextInt(1000));
        ALMACEN.add(nombreGranjero + ": " + verdura);
        System.out.println(nombreGranjero + " ha plantado " + verdura);
        notifyAll();
    }

    /**
     * Indicamos que tiene un nombre y si el almacen esta vacion entonces espera,
     * creamos una variable donde borre la palabra que esta en la posicion 0 del
     * arrayList se guarde ahi, hacemos el sout y con el notifyAll despertamos todos
     * y devolvemos la palabra
     */
    public synchronized String comerVerdura(String cliente) throws InterruptedException {
        while (ALMACEN.isEmpty()) {
            wait();
        }

        String verdura = ALMACEN.remove(0);
        System.out.println(cliente + " ha consumido " + verdura);
        notifyAll();
        return verdura;
    }
}
