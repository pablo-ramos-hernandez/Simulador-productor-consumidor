package granjero;

import java.util.Random;

import huerto.Huerto;

public class Granjero extends Thread {
    private final String nombre;
    private final Huerto huerto;
    private final int cantidaVerduras;

    /**
     * Creamos el constructor y tenemos que implementar una clase Huerto para poder
     * llamarlo sin necesidad de crear clases estaticas
     */
    public Granjero(String nombre, Huerto huerto, int cantidaVerduras) {
        this.nombre = nombre;
        this.huerto = huerto;
        this.cantidaVerduras = cantidaVerduras;
    }

    /**
     * Hacemos override al run donde le indicamos un bucle que pare cuando llegue
     * hasta la cantidad de verduras y que intente hacer: Crear una variable donde
     * va guardar la verdura aleatoria apartir del metodo getRadomVegetable, y que
     * haga el metodo plantarVerdura
     */
    @Override
    public void run() {
        for (int i = 0; i < cantidaVerduras; i++) {
            try {
                String verdura = getRandomVegetable();
                huerto.plantarVerdura(nombre, verdura);
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
