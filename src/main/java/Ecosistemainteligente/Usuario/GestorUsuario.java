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
         try {
         Usuario usuario = usuarios.get(nombreUsuario);
         if (usuario != null && usuario.autenticar(contrasena)) {
             return true;
         } else {
             return false;
         }
     } catch (Exception e) {
         return false;
     }
 }
 }