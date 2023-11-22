package granjero;

import java.util.Random;

import huerto.Huerto;

public class Granjero extends Thread {
    private final String NOMBRE;
    private final Huerto HUERTO;
    private final int CANTIDADVERDURAS;

    /**
     * Creamos el constructor y tenemos que implementar una clase Huerto para poder
     * llamarlo sin necesidad de crear clases estaticas
     */
    public Granjero(String nombre, Huerto huerto, int cantidaVerduras) {
        this.NOMBRE = nombre;
        this.HUERTO = huerto;
        this.CANTIDADVERDURAS = cantidaVerduras;
    }

    /**
     * Hacemos override al run donde le indicamos un bucle que pare cuando llegue
     * hasta la cantidad de verduras y que intente hacer: Crear una variable donde
     * va guardar la verdura aleatoria apartir del metodo getRadomVegetable, y que
     * haga el metodo plantarVerdura
     */
    @Override
    public void run() {
        for (int i = 0; i < CANTIDADVERDURAS; i++) {
            try {
                String verdura = getRandomVegetable();
                HUERTO.plantarVerdura(NOMBRE, verdura);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Sirve para sacar un vegetal del array de forma aleatoria
     */
    private String getRandomVegetable() {
        String[] verduras = { "lechuga", "papa", "apio", "espárragos", "rábano",
                "brócoli", "alcachofa", "tomate", "pepino", "berenjena", "zanahoria" };

        return verduras[new Random().nextInt(verduras.length)];
    }
}
