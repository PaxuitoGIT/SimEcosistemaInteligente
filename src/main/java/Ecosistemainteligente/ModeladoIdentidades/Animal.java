package Ecosistemainteligente.ModeladoIdentidades;

import java.util.Random;

public class Animal extends Organismos {
    private String especies;
    private boolean isPredator;

    public Animal(int posicionX, int posicionY, int edad, int salud, boolean esReproductivo, String nombre, boolean estaVivo, boolean esDepredador, String especies, boolean isPredator) {
        super(posicionX, posicionY, edad, salud, esReproductivo, nombre, estaVivo, esDepredador);
        this.especies = especies;
        this.isPredator = isPredator;
    }

    public String getSpecies() {
        return especies;
    }

    public void setSpecies(String species) {
        this.especies = species;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean isPredator) {
        this.isPredator = isPredator;
    }
    public void predar(Organismos presa) {
        if (this.esDepredador) {
            presa.setSalud(presa.getSalud() - 10); // Asume que 10 es el daño que hace el depredador
            if (presa.getSalud() <= 0) {
                presa.setEstaVivo(false);
            }
        }
    }

    public void comerPlanta(Planta planta) {
        planta.setSalud(planta.getSalud() - 10); // Asume que 10 es el daño que hace el herbívoro
        if (planta.getSalud() <= 0) {
            planta.setEstaVivo(false);
        }
    }

    public void competirRecursos(Ambiente ambiente) {
       int recursosActuales = ambiente.getRecursosDisponibles();
       if (recursosActuales > 0) {
           ambiente.setRecursosDisponibles(recursosActuales - 10); // Asume que 10 es la cantidad de recursos que se consumen
        }
    }

    public void crecer() {
        this.setSalud(this.getSalud() + 10); // Asume que 10 es la cantidad de salud que se añade al animal
    }

    public void reproducir() {
        this.setPoblacion(this.getPoblacion() + 1); // Asume que 1 es la cantidad de hijos que se añaden al animal
    }

    public void eventoAleatorio() {
        Random random = new Random();
        int evento = random.nextInt(3);

        switch (evento) {
            case 0:
                // Desastre natural
                this.setSalud(this.getSalud() - 20); // Asume que 20 es la cantidad de salud que el animal pierde en un desastre natural
                break;
            case 1:
                // Enfermedad
                this.setSalud(this.getSalud() - 10); // Asume que 10 es la cantidad de salud que el animal pierde por una enfermedad
                break;
            case 2:
                // Cambio climático
                this.setSalud(this.getSalud() - 15); // Asume que 15 es la cantidad de salud que el animal pierde por un cambio climático
                break;
        }
    }
}