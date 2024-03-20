package Ecosistemainteligente.AnalisisAvanzado;

import Ecosistemainteligente.ModeladoIdentidades.Ambiente;
import Ecosistemainteligente.ModeladoIdentidades.Organismos;

public class Modelo implements ModeloPersonalizado {
    @Override
    public void ejecutar(Ambiente ambiente) {
        // Crear un nuevo organismo
        Organismos nuevoOrganismo = new Organismos(0, 0, 0, 100, true, "Nuevo Organismo", true, false);

        // Agregar el nuevo organismo al ambiente
        ambiente.getOrganismos().add(nuevoOrganismo);

        // Imprimir la salud media de los organismos antes de la introducción del nuevo organismo
        System.out.println("Salud media de los organismos antes de la introducción del nuevo organismo: " + ambiente.calcularSaludMedia());

        // Actualizar la salud de los organismos
        for (Organismos organismo : ambiente.getOrganismos()) {
            organismo.setSalud(organismo.getSalud() + 10);
        }

        // Imprimir la salud media de los organismos después de la introducción del nuevo organismo
        System.out.println("Salud media de los organismos después de la introducción del nuevo organismo: " + ambiente.calcularSaludMedia());
    }
}
