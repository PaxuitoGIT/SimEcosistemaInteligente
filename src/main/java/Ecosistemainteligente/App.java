package Ecosistemainteligente;

import Ecosistemainteligente.ModeladoIdentidades.Ambiente;
import Ecosistemainteligente.ModeladoIdentidades.Animal;
import Ecosistemainteligente.ModeladoIdentidades.Planta;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        // Crear instancias de Ambiente, Animal y Planta
        Ambiente ambiente = new Ambiente("Tropical", "Bosque", 100);
        Animal carnivoro = new Animal(0, 0, 5, 100, true, "León", true, true, "Felino", true);
        Animal herbivoro = new Animal(1, 1, 3, 80, true, "Conejo", true, false, "Lagomorfo", false);
        Planta planta = new Planta(2, 2, 1, 50, true, "Arbol", true, false, "Roble");

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("1. Simular interacción");
            System.out.println("2. Simular competencia por recursos");
            System.out.println("3. Simular polinización");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Submenú para la depredación
                    int opcionDepredacion = 0;

                    while (opcionDepredacion != 4) {
                        System.out.println("1. León depreda al conejo");
                        System.out.println("2. Conejo come la planta");
                        System.out.println("3. Planta poliniza al ambiente");
                        System.out.println("4. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcionDepredacion = scanner.nextInt();

                    switch (opcionDepredacion) {
                        case 1:
                            // León depreda al conejo
                            System.out.println("Antes de la depredación, la salud del conejo es: " + herbivoro.getSalud());
                            carnivoro.predar(herbivoro);
                            System.out.println("Después de la depredación, la salud del conejo es: " + herbivoro.getSalud());
                            break;
                        case 2:
                            // Conejo come la planta
                            System.out.println("Antes de la depredación, la salud de la planta es: " + planta.getSalud());
                            herbivoro.comerPlanta(planta);
                            System.out.println("Después de la depredación, la salud de la planta es: " + planta.getSalud());
                            break;
                        case 3:
                            // Planta poliniza al ambiente
                            System.out.println("Antes de la polinización, los recursos disponibles son: " + ambiente.getRecursosDisponibles());
                            planta.polinizar(ambiente);
                            System.out.println("Después de la polinización, los recursos disponibles son: " + ambiente.getRecursosDisponibles());
                            break;
                        case 4:
                            System.out.println("Saliendo del submenú de depredación...");
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción entre 1.1 y 1.3.");
                            break;
                    }
                    }
                    break;
                case 2:
                    System.out.println("Antes de la competencia por recursos, los recursos disponibles son: " + ambiente.getRecursosDisponibles());
                    carnivoro.competirRecursos(ambiente);
                    herbivoro.competirRecursos(ambiente);
                    System.out.println("Después de la competencia por recursos, los recursos disponibles son: " + ambiente.getRecursosDisponibles());
                    break;
                case 3:
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
                    break;
            }
        }

        scanner.close();
    }
}