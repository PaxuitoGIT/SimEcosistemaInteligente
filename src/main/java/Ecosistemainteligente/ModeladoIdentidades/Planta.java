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
    public void polinizar(Ambiente ambiente) {
        if (this.esReproductivo) {
            ambiente.setRecursosDisponibles(ambiente.getRecursosDisponibles() + 10); // Asume que 10 es la cantidad de recursos que se añaden al ambiente
        }
    }

    @Override
    public String toString() {
        return "Planta{" +
                "tipoPlanta='" + tipoPlanta + '\'' +
                ", posicionX=" + posicionX +
                ", posicionY=" + posicionY +
                ", edad=" + edad +
                ", salud=" + salud +
                ", esReproductivo=" + esReproductivo +
                ", nombre='" + nombre + '\'' +
                ", estaVivo=" + estaVivo +
                ", esDepredador=" + esDepredador +
                ", poblacion=" + poblacion +
                '}';
    }
}