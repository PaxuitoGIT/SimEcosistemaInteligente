package Ecosistemainteligente.ModeladoIdentidades;

import java.util.List;

public class Ambiente {
    private String clima;
    private String terreno;
    private int recursosDisponibles;
    private final List<Organismos> organismos;

    public Ambiente(String clima, String terreno, int recursosDisponibles, List<Organismos> organismos) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursosDisponibles = recursosDisponibles;
        this.organismos = organismos;
    }

    public List<Organismos> getOrganismos() {
        return organismos;
    }

    public double calcularSaludMedia() {
        double saludTotal = 0;
        for (Organismos organismo : this.getOrganismos()) {
            saludTotal += organismo.getSalud();
        }
        return saludTotal / this.getOrganismos().size();
    }

    public int calcularPoblacionTotal() {
        int poblacionTotal = 0;
        for (Organismos organismo : this.getOrganismos()) {
            poblacionTotal += organismo.getPoblacion();
        }
        return poblacionTotal;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public void setRecursosDisponibles(int recursosDisponibles) {
        this.recursosDisponibles = recursosDisponibles;
    }

    @Override
    public String toString() {
        return "Ambiente{" +
                "clima='" + clima + '\'' +
                ", terreno='" + terreno + '\'' +
                ", recursosDisponibles=" + recursosDisponibles +
                '}';
    }
}