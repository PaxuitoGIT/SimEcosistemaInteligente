package Ecosistemainteligente;

import Ecosistemainteligente.ModeladoIdentidades.Ambiente;
import Ecosistemainteligente.ModeladoIdentidades.Animal;
import Ecosistemainteligente.ModeladoIdentidades.Organismos;
import Ecosistemainteligente.ModeladoIdentidades.Planta;
import Ecosistemainteligente.Usuario.GestorUsuario;
import Ecosistemainteligente.Usuario.Usuario;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main( String[] args ) {
        GestorUsuario gestorUsuario = new GestorUsuario();

        Usuario usuario1 = new Usuario("user", "admin");
        gestorUsuario.registrarUsuario(usuario1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (gestorUsuario.autenticarUsuario(nombreUsuario, contrasena)) {
            System.out.println("Bienvenido al ecosistema inteligente");
        } else {
            System.out.println("Usuario o contraseña incorrectos");
            return;
        }

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

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("1. Simular interacción");
            System.out.println("2. Simular competencia por recursos");
            System.out.println("3. Simular eventos");
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
                    int opcionSimulacion = 0;

                    while (opcionSimulacion != 4) {
                        System.out.println("3.1. Crecer población (Aumentar salud)");
                        System.out.println("3.2. Reproducir población (Aumentar población)");
                        System.out.println("3.3. Evento aleatorio (Desastre natural, enfermedad, etc.)");
                        System.out.println("3.4. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcionSimulacion = scanner.nextInt();

                        switch (opcionSimulacion) {
                            case 1:
                                // Crecer población
                                carnivoro.crecer();
                                herbivoro.crecer();
                                System.out.println("Salud media de los organismos: " + ambiente.calcularSaludMedia());
                                System.out.println("Población total: " + ambiente.calcularPoblacionTotal());
                                System.out.println("Recursos disponibles: " + ambiente.getRecursosDisponibles());
                                break;
                            case 2:
                                // Reproducir población
                                carnivoro.reproducir();
                                herbivoro.reproducir();
                                System.out.println("Salud media de los organismos: " + ambiente.calcularSaludMedia());
                                System.out.println("Población total: " + ambiente.calcularPoblacionTotal());
                                System.out.println("Recursos disponibles: " + ambiente.getRecursosDisponibles());
                                break;
                            case 3:
                                // Evento aleatorio
                                carnivoro.eventoAleatorio();
                                herbivoro.eventoAleatorio();
                                System.out.println("Salud media de los organismos: " + ambiente.calcularSaludMedia());
                                System.out.println("Población total: " + ambiente.calcularPoblacionTotal());
                                System.out.println("Recursos disponibles: " + ambiente.getRecursosDisponibles());
                                break;
                            case 4:
                                System.out.println("Saliendo del submenú de simulación...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción entre 3.1 y 3.4.");
                                break;
                        }
                    }
                    break;
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