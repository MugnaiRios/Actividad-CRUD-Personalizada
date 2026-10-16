package juego;

public class Animal {

    //atributos
    protected String nombre = "nombre predeterminado";
    protected Integer velocidad = 15;
    protected Integer precio = 20;
    //set y get

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getVelocidad() {
        return this.velocidad;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getPrecio() {
        return this.precio;
    }
}
