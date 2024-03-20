package Ecosistemainteligente;

import Ecosistemainteligente.AnalisisAvanzado.AlgoritmoGenetico;
import Ecosistemainteligente.AnalisisAvanzado.Modelo;
import Ecosistemainteligente.AnalisisAvanzado.ModeloPersonalizado;
import Ecosistemainteligente.ModeladoIdentidades.Ambiente;
import Ecosistemainteligente.ModeladoIdentidades.Animal;
import Ecosistemainteligente.ModeladoIdentidades.Organismos;
import Ecosistemainteligente.ModeladoIdentidades.Planta;
import Ecosistemainteligente.Usuario.GestorUsuario;
import Ecosistemainteligente.Usuario.Registro;
import Ecosistemainteligente.Usuario.Usuario;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    private static final List<ModeloPersonalizado> modelosPersonalizados = new ArrayList<>();
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

        Registro registro = new Registro();

        AlgoritmoGenetico optimizador = new AlgoritmoGenetico();

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

        while (opcion != 7) {
            try {
            System.out.println();
            System.out.println("1. Simular interacción");
            System.out.println("2. Simular competencia por recursos");
            System.out.println("3. Simular eventos");
            System.out.println("4. Optimizar ambiente");
            System.out.println("5. Crear modelo personalizado");
            System.out.println("6. Mostrar datos de organismos y ambiente");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            System.out.println();
            opcion = scanner.nextInt();
            System.out.println();

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
                        registro.agregarRegistro("El usuario " + nombreUsuario + " ha simulado una interacción");
                        opcionDepredacion = scanner.nextInt();

                    switch (opcionDepredacion) {
                        case 1:
                            // León depreda al conejo
                            System.out.println();
                            System.out.println("Antes de la depredación, la salud del conejo es: " + herbivoro.getSalud());
                            carnivoro.predar(herbivoro);
                            System.out.println("Después de la depredación, la salud del conejo es: " + herbivoro.getSalud());
                            registro.agregarRegistro("El usuario " + nombreUsuario + " ha depredado al conejo");
                            break;
                        case 2:
                            // Conejo come la planta
                            System.out.println();
                            System.out.println("Antes de la depredación, la salud de la planta es: " + planta.getSalud());
                            herbivoro.comerPlanta(planta);
                            System.out.println("Después de la depredación, la salud de la planta es: " + planta.getSalud());
                            registro.agregarRegistro("El usuario " + nombreUsuario + " ha comido la planta");
                            break;
                        case 3:
                            // Planta poliniza al ambiente
                            System.out.println();
                            System.out.println("Antes de la polinización, los recursos disponibles son: " + ambiente.getRecursosDisponibles());
                            planta.polinizar(ambiente);
                            System.out.println("Después de la polinización, los recursos disponibles son: " + ambiente.getRecursosDisponibles());
                            registro.agregarRegistro("El usuario " + nombreUsuario + " ha polinizado el ambiente");
                            break;
                        case 4:
                            System.out.println();
                            System.out.println("Saliendo del submenú de depredación...");
                            registro.agregarRegistro("El usuario " + nombreUsuario + " ha salido del submenú de depredación");
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
                    registro.agregarRegistro("El usuario " + nombreUsuario + " ha simulado una competencia por recursos");
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
                                System.out.println();
                                carnivoro.crecer();
                                herbivoro.crecer();
                                System.out.println("Salud media de los organismos: " + ambiente.calcularSaludMedia());
                                System.out.println("Población total: " + ambiente.calcularPoblacionTotal());
                                System.out.println("Recursos disponibles: " + ambiente.getRecursosDisponibles());
                                registro.agregarRegistro("El usuario " + nombreUsuario + " ha hecho crecer la población");
                                break;
                            case 2:
                                // Reproducir población
                                System.out.println();
                                carnivoro.reproducir();
                                herbivoro.reproducir();
                                System.out.println("Salud media de los organismos: " + ambiente.calcularSaludMedia());
                                System.out.println("Población total: " + ambiente.calcularPoblacionTotal());
                                System.out.println("Recursos disponibles: " + ambiente.getRecursosDisponibles());
                                registro.agregarRegistro("El usuario " + nombreUsuario + " ha hecho reproducir la población");
                                break;
                            case 3:
                                // Evento aleatorio
                                System.out.println();
                                carnivoro.eventoAleatorio();
                                herbivoro.eventoAleatorio();
                                System.out.println("Salud media de los organismos: " + ambiente.calcularSaludMedia());
                                System.out.println("Población total: " + ambiente.calcularPoblacionTotal());
                                System.out.println("Recursos disponibles: " + ambiente.getRecursosDisponibles());
                                registro.agregarRegistro("El usuario " + nombreUsuario + " ha simulado un evento aleatorio");
                                break;
                            case 4:
                                System.out.println();
                                System.out.println("Saliendo del submenú de simulación...");
                                registro.agregarRegistro("El usuario " + nombreUsuario + " ha salido del submenú de simulación");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción entre 3.1 y 3.4.");
                                break;
                        }
                    }
                    registro.agregarRegistro("El usuario " + nombreUsuario + " ha simulado un evento");

                    break;
                case 4:
                    optimizador.optimizar(ambiente);
                    System.out.println("Se ha optimizado el ambiente");
                    registro.agregarRegistro("El usuario " + nombreUsuario + " ha optimizado el ambiente");
                    break;
                case 5:
                    // Crear una instancia de tu modelo personalizado
                    ModeloPersonalizado miModelo = new Modelo();

                    // Agregar tu modelo personalizado a la lista de modelos personalizados
                    agregarModeloPersonalizado(miModelo);

                    // Ejecutar los modelos personalizados
                    for (ModeloPersonalizado modelo : modelosPersonalizados) {
                        modelo.ejecutar(ambiente);
                    }

                    System.out.println("Saliendo del programa...");
                    registro.agregarRegistro("El usuario " + nombreUsuario + " ha salido del programa");
                    break;
                case 6:
                    System.out.println(carnivoro.toString());
                    System.out.println(herbivoro.toString());
                    System.out.println(planta.toString());
                    System.out.println(ambiente.toString());

                    registro.agregarRegistro("El usuario " + nombreUsuario + " ha mostrado los datos de los organismos y el ambiente");
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    registro.agregarRegistro("El usuario " + nombreUsuario + " ha salido del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("Opción no válida.");
            scanner.next();
        }
        }

        System.out.println("Se ha creado un registro en la carpeta logs");

        scanner.close();
    }

    private static void agregarModeloPersonalizado(ModeloPersonalizado miModelo) {
        modelosPersonalizados.add(miModelo);
    }
}