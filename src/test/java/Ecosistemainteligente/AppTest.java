package Ecosistemainteligente;

import Ecosistemainteligente.AnalisisAvanzado.AlgoritmoGenetico;
import Ecosistemainteligente.ModeladoIdentidades.Ambiente;
import Ecosistemainteligente.ModeladoIdentidades.Animal;
import Ecosistemainteligente.ModeladoIdentidades.Organismos;
import Ecosistemainteligente.ModeladoIdentidades.Planta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    public void testSimularInteraccion() {
        // Crear instancias de Animal y Planta
        Animal carnivoro = new Animal(0, 0, 5, 100, true, "León", true, true, "Felino", true);
        Animal herbivoro = new Animal(1, 1, 3, 80, true, "Conejo", true, false, "Lagomorfo", false);
        Planta planta = new Planta(2, 2, 1, 50, true, "Arbol", true, false, "Roble");

        // Crear instancia de Ambiente
        List<Organismos> organismos = new ArrayList<>();
        organismos.add(carnivoro);
        organismos.add(herbivoro);
        organismos.add(planta);
        Ambiente ambiente = new Ambiente("Tropical", "Selva", 100, organismos);

        // Simular interacción
        double saludInicialConejo = herbivoro.getSalud();
        carnivoro.predar(herbivoro);
        double saludFinalConejo = herbivoro.getSalud();

        // Verificar que la salud del conejo disminuyó
        assertTrue(saludFinalConejo < saludInicialConejo);
    }

    @Test
    public void testSimularCompetenciaPorRecursos() {
        // Crear instancias de Animal
        Animal carnivoro = new Animal(0, 0, 5, 100, true, "León", true, true, "Felino", true);
        Animal herbivoro = new Animal(1, 1, 3, 80, true, "Conejo", true, false, "Lagomorfo", false);

        // Crear instancia de Ambiente
        List<Organismos> organismos = new ArrayList<>();
        organismos.add(carnivoro);
        organismos.add(herbivoro);
        Ambiente ambiente = new Ambiente("Tropical", "Selva", 100, organismos);

        // Simular competencia por recursos
        double recursosIniciales = ambiente.getRecursosDisponibles();
        carnivoro.competirRecursos(ambiente);
        herbivoro.competirRecursos(ambiente);
        double recursosFinales = ambiente.getRecursosDisponibles();

        // Verificar que los recursos disponibles disminuyeron
        assertTrue(recursosFinales < recursosIniciales);
    }

    @Test
    public void testSimularEventos() {
        // Crear instancias de Animal
        Animal carnivoro = new Animal(0, 0, 5, 100, true, "León", true, true, "Felino", true);
        Animal herbivoro = new Animal(1, 1, 3, 80, true, "Conejo", true, false, "Lagomorfo", false);

        // Crear instancia de Ambiente
        List<Organismos> organismos = new ArrayList<>();
        organismos.add(carnivoro);
        organismos.add(herbivoro);
        Ambiente ambiente = new Ambiente("Tropical", "Selva", 100, organismos);

        // Simular crecimiento de la población
        double saludInicialCarnivoro = carnivoro.getSalud();
        carnivoro.crecer();
        double saludFinalCarnivoro = carnivoro.getSalud();

        // Verificar que la salud del carnívoro aumentó
        assertTrue(saludFinalCarnivoro > saludInicialCarnivoro);

        // Simular reproducción de la población
        int poblacionInicial = ambiente.calcularPoblacionTotal();
        carnivoro.reproducir();
        herbivoro.reproducir();
        int poblacionFinal = ambiente.calcularPoblacionTotal();

        // Verificar que la población total aumentó
        assertTrue(poblacionFinal > poblacionInicial);

        // Simular evento aleatorio
        double saludInicialHerbivoro = herbivoro.getSalud();
        herbivoro.eventoAleatorio();
        double saludFinalHerbivoro = herbivoro.getSalud();

        // Verificar que la salud del herbívoro cambió
        assertTrue(saludFinalHerbivoro != saludInicialHerbivoro);
    }

    @Test
    public void testOptimizarAmbiente() {
        Animal carnivoro = new Animal(0, 0, 5, 100, true, "León", true, true, "Felino", true);
        Animal herbivoro = new Animal(1, 1, 3, 80, true, "Conejo", true, false, "Lagomorfo", false);
        Planta planta = new Planta(2, 2, 1, 50, true, "Arbol", true, false, "Roble");

        // Crear instancia de Ambiente
        List<Organismos> organismos = new ArrayList<>();
        organismos.add(carnivoro);
        organismos.add(herbivoro);
        organismos.add(planta);
        Ambiente ambiente = new Ambiente("Tropical", "Selva", 100, organismos);

        // Crear instancia de AlgoritmoGenetico
        AlgoritmoGenetico optimizador = new AlgoritmoGenetico();

        // Simular optimización del ambiente
        double saludMediaInicial = ambiente.calcularSaludMedia();
        optimizador.optimizar(ambiente);
        double saludMediaFinal = ambiente.calcularSaludMedia();

        // Verificar que la salud media de los organismos aumentó
        assertTrue(saludMediaFinal > saludMediaInicial);
    }
    @Test
    public void testMostrarDatosOrganismosYAmbiente() {
        // Crear instancias de Animal y Planta
        Animal carnivoro = new Animal(0, 0, 5, 100, true, "León", true, true, "Felino", true);
        Animal herbivoro = new Animal(1, 1, 3, 80, true, "Conejo", true, false, "Lagomorfo", false);
        Planta planta = new Planta(2, 2, 1, 50, true, "Arbol", true, false, "Roble");

        // Crear instancia de Ambiente
        List<Organismos> organismos = new ArrayList<>();
        organismos.add(carnivoro);
        organismos.add(herbivoro);
        organismos.add(planta);
        Ambiente ambiente = new Ambiente("Tropical", "Selva", 100, organismos);

        // Simular la visualización de los datos de los organismos y el ambiente
        String datosCarnivoro = carnivoro.toString();
        String datosHerbivoro = herbivoro.toString();
        String datosPlanta = planta.toString();
        String datosAmbiente = ambiente.toString();

        // Verificar que los datos de los organismos y el ambiente se imprimieron correctamente
        assertEquals("Animal{posicionX=0, posicionY=0, nivelEnergia=5, salud=100.0, vivo=true, nombre='León', carnivoro=true, herbivoro=true, especie='Felino', adulto=true}", datosCarnivoro);
        assertEquals("Animal{posicionX=1, posicionY=1, nivelEnergia=3, salud=80.0, vivo=true, nombre='Conejo', carnivoro=true, herbivoro=false, especie='Lagomorfo', adulto=false}", datosHerbivoro);
        assertEquals("Planta{posicionX=2, posicionY=2, nivelEnergia=1, salud=50.0, vivo=true, nombre='Arbol', carnivoro=true, herbivoro=false, especie='Roble'}", datosPlanta);
        assertTrue(datosAmbiente.contains("Ambiente{tipo='Tropical', nombre='Selva', recursosDisponibles=100, organismos="));
    }
}