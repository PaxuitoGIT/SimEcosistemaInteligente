package Ecosistemainteligente.Usuario;

public class Usuario {
    private final String nombreUsuario;
    private final String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean autenticar(String nombreUsuario, String contrasena) {
        // Comprueba si el nombre de usuario y la contraseña ingresados coinciden con los almacenados
        return this.nombreUsuario.equals(nombreUsuario) && this.contrasena.equals(contrasena);
    }

    public boolean autenticar(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
}
