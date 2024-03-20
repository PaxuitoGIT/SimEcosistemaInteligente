package Ecosistemainteligente.Usuario;

import java.util.HashMap;
import java.util.Map;

 public class GestorUsuario {
    private Map<String, Usuario> usuarios;

    public GestorUsuario() {
        this.usuarios = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombreUsuario(), usuario);
    }

    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        Usuario usuario = usuarios.get(nombreUsuario);
        if (usuario != null) {
            return usuario.autenticar(nombreUsuario, contrasena);
        }
        return false;
    }
}