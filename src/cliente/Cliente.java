package cliente;

import huerto.Huerto;

public class Cliente extends Thread {

    private final String NOMBRE;
    private final Huerto huerto;
    private final int CANTIDADVERDURAS;

    // Creamos el constructor de la clase Cliente y tenemos que implementar Huerto
    // porque tenemos que llamarlo mas abajo y asi no tenemos que crear un metodo
    // estatico
    public Cliente(String nombre, Huerto huerto, int cantidaVerduras) {
        this.NOMBRE = nombre;
        this.huerto = huerto;
        this.CANTIDADVERDURAS = cantidaVerduras;
    }

    /**
     * Override al metodo run y hago el metodo comerVerdura de la clase huerto que
     * tengo inicializada antes
     */

    @Override
    public void run() {
        for (int i = 0; i < CANTIDADVERDURAS; i++) {
            try {
                huerto.comerVerdura(NOMBRE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}