import cliente.Cliente;
import granjero.Granjero;
import huerto.Huerto;

public class App {
    public static void main(String[] args) throws Exception {

        /**
         * LLamamos a todos los hilos y la clase huerto
         */
        Huerto huerto = new Huerto(5);

        Granjero granjero = new Granjero("Manolo", huerto, 10);

        Granjero granjero2 = new Granjero("Pablo", huerto, 5);

        Cliente cliente = new Cliente("Pedro", huerto, 10);

        Cliente cliente2 = new Cliente("Puchipon", huerto, 5);

        granjero.start();
        granjero2.start();
        cliente.start();
        cliente2.start();
    }
}
