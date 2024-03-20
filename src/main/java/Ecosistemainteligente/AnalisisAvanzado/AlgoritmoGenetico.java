package Ecosistemainteligente.AnalisisAvanzado;

import Ecosistemainteligente.ModeladoIdentidades.Ambiente;
import Ecosistemainteligente.ModeladoIdentidades.Organismos;

import java.util.List;
import java.util.Random;

public class AlgoritmoGenetico implements Optimizador {
    private final Random random = new Random();

    @Override
    public void optimizar(Ambiente ambiente) {

        // 1. Inicializar una población
        // Puedes representar una solución (un individuo de la población) como un array de booleanos
        boolean[][] poblacion = inicializarPoblacion(100, ambiente.getOrganismos().size());

        // 2. Evaluar la población
        int[] fitness = evaluarPoblacion(poblacion, ambiente);

        for (int generacion = 0; generacion < 1000; generacion++) {
            // 3. Seleccionar padres para el cruce
            boolean[][] padres = seleccionarPadres(poblacion, fitness);

            // 4. Realizar el cruce para generar hijos
            boolean[][] hijos = cruzar(padres);

            // 5. Realizar la mutación en los hijos
            mutar(hijos);

            // 6. Evaluar la nueva población (padres e hijos)
            boolean[][] nuevaPoblacion = combinar(poblacion, hijos);
            fitness = evaluarPoblacion(nuevaPoblacion, ambiente);

            // 7. Seleccionar la próxima generación
            poblacion = seleccionarProximaGeneracion(nuevaPoblacion, fitness);
        }

        // Al final del algoritmo, puedes obtener la mejor solución de la última población
        boolean[] mejorSolucion = obtenerMejorSolucion(poblacion, fitness);

        // Aplicar la mejor solución al ambiente
        aplicarSolucion(mejorSolucion, ambiente);
    }

    private boolean[][] inicializarPoblacion(int tamanoPoblacion, int tamanoSolucion) {
        boolean[][] poblacion = new boolean[tamanoPoblacion][tamanoSolucion];
        for (int i = 0; i < tamanoPoblacion; i++) {
            for (int j = 0; j < tamanoSolucion; j++) {
                poblacion[i][j] = random.nextBoolean();
            }
        }
        return poblacion;
    }

    private int[] evaluarPoblacion(boolean[][] poblacion, Ambiente ambiente) {
        int[] fitness = new int[poblacion.length];
        for (int i = 0; i < poblacion.length; i++) {
            fitness[i] = evaluarIndividuo(poblacion[i], ambiente);
        }
        return fitness;
    }

    private int evaluarIndividuo(boolean[] individuo, Ambiente ambiente) {
        int fitness = 0;
        for (boolean gen : individuo) {
            if (gen) {
                fitness++;
            }
        }
        return fitness;
    }

    private boolean[][] seleccionarPadres(boolean[][] poblacion, int[] fitness) {
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < poblacion.length; i++) {
            if (fitness[i] > fitness[idx1]) {
                idx2 = idx1;
                idx1 = i;
            } else if (fitness[i] > fitness[idx2]) {
                idx2 = i;
            }
        }
        return new boolean[][]{poblacion[idx1], poblacion[idx2]};
    }

    private boolean[][] cruzar(boolean[][] padres) {
        int puntoCruce = random.nextInt(padres[0].length);
        boolean[][] hijos = new boolean[2][padres[0].length];
        System.arraycopy(padres[0], 0, hijos[0], 0, puntoCruce);
        System.arraycopy(padres[1], puntoCruce, hijos[0], puntoCruce, padres[0].length - puntoCruce);
        System.arraycopy(padres[1], 0, hijos[1], 0, puntoCruce);
        System.arraycopy(padres[0], puntoCruce, hijos[1], puntoCruce, padres[0].length - puntoCruce);
        return hijos;
    }

    private void mutar(boolean[][] hijos) {
        for (boolean[] hijo : hijos) {
            int puntoMutacion = random.nextInt(hijo.length);
            hijo[puntoMutacion] = !hijo[puntoMutacion];
        }
    }

    private boolean[][] combinar(boolean[][] poblacion, boolean[][] hijos) {
        boolean[][] nuevaPoblacion = new boolean[poblacion.length + hijos.length][];
        System.arraycopy(poblacion, 0, nuevaPoblacion, 0, poblacion.length);
        System.arraycopy(hijos, 0, nuevaPoblacion, poblacion.length, hijos.length);
        return nuevaPoblacion;
    }

    private boolean[][] seleccionarProximaGeneracion(boolean[][] poblacion, int[] fitness) {
        boolean[][] proximaGeneracion = new boolean[poblacion.length / 2][];
        for (int i = 0; i < proximaGeneracion.length; i++) {
            int idxMax = 0;
            for (int j = 1; j < poblacion.length; j++) {
                if (fitness[j] > fitness[idxMax]) {
                    idxMax = j;
                }
            }
            proximaGeneracion[i] = poblacion[idxMax];
            fitness[idxMax] = Integer.MIN_VALUE; // Para no seleccionarlo de nuevo
        }
        return proximaGeneracion;
    }

    private boolean[] obtenerMejorSolucion(boolean[][] poblacion, int[] fitness) {
        int idxMax = 0;
        for (int i = 1; i < poblacion.length; i++) {
            if (fitness[i] > fitness[idxMax]) {
                idxMax = i;
            }
        }
        return poblacion[idxMax];
    }

    private void aplicarSolucion(boolean[] mejorSolucion, Ambiente ambiente) {
        List<Organismos> organismos = ambiente.getOrganismos();
        for (int i = 0; i < mejorSolucion.length; i++) {
            if (mejorSolucion[i]) {
                // Si el gen es true, aumentamos la población del organismo
                organismos.get(i).aumentarPoblacion();
            } else {
                // Si el gen es false, disminuimos la población del organismo
                organismos.get(i).disminuirPoblacion();
            }
        }
    }
}
