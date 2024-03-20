package Ecosistemainteligente.ModeladoIdentidades;

public class Planta extends Organismos {
    private String tipoPlanta;

    public Planta(int posicionX, int posicionY, int edad, int salud, boolean esReproductivo, String nombre, boolean estaVivo, boolean esDepredador, String tipoPlanta) {
        super(posicionX, posicionY, edad, salud, esReproductivo, nombre, estaVivo, esDepredador);
        this.tipoPlanta = tipoPlanta;
    }

    public String getPlantType() {
        return tipoPlanta;
    }

    public void setPlantType(String plantType) {
        this.tipoPlanta = plantType;
    }
}