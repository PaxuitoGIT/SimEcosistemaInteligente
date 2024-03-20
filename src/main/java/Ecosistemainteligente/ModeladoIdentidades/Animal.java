package Ecosistemainteligente.ModeladoIdentidades;

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
}