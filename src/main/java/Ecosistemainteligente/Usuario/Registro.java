package Ecosistemainteligente.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    private List<String> registros;

    public Registro() {
        this.registros = new ArrayList<>();
    }

    public void agregarRegistro(String registro) {
        registros.add(registro);
        escribirRegistro(registro);
    }

    public List<String> obtenerRegistros() {
        return registros;
    }

    private void escribirRegistro(String registro) {
        try {
            // Crear el directorio "logs" si no existe
            File directory = new File("logs");
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Crear el archivo de log
            File logFile = new File("logs/registro.txt");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            // Escribir el registro en el archivo de log
            FileWriter writer = new FileWriter(logFile, true); // true para append
            writer.write(registro + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}