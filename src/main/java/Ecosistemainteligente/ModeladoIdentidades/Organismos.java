package Ecosistemainteligente.ModeladoIdentidades;

public class Organismos {
    protected int posicionX;
    protected int posicionY;
    protected int edad;
    protected int salud;
    protected boolean esReproductivo;
    protected String nombre;
    protected boolean estaVivo;
    protected boolean esDepredador;
    protected int poblacion;

    public Organismos(int posicionX, int posicionY, int edad, int salud, boolean esReproductivo, String nombre, boolean estaVivo, boolean esDepredador) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.edad = edad;
        this.salud = salud;
        this.esReproductivo = esReproductivo;
        this.nombre = nombre;
        this.estaVivo = estaVivo;
        this.esDepredador = esDepredador;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Salud: " + getSalud());
        System.out.println("Posicion X: " + getPosicionX());
        System.out.println("Posicion Y: " + getPosicionY());
    }

        public int getPosicionX() {
            return posicionX;
        }

        public void setPosicionX(int posicionX) {
            this.posicionX = posicionX;
        }

        public int getPosicionY() {
            return posicionY;
        }

        public void setPosicionY(int posicionY) {
            this.posicionY = posicionY;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public int getSalud() {
            return salud;
        }

        public void setSalud(int salud) {
            this.salud = salud;
        }

        public boolean isEsReproductivo() {
            return esReproductivo;
        }

        public void setEsReproductivo(boolean esReproductivo) {
            this.esReproductivo = esReproductivo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public boolean isEstaVivo() {
            return estaVivo;
        }

        public void setEstaVivo(boolean estaVivo) {
            this.estaVivo = estaVivo;
        }

        public boolean isEsDepredador() {
            return esDepredador;
        }

        public void setEsDepredador(boolean esDepredador) {
            this.esDepredador = esDepredador;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public void aumentarPoblacion() {
        this.poblacion++;
    }

    public void disminuirPoblacion() {
        if (this.poblacion > 0) {
            this.poblacion--;
        }
    }
}
