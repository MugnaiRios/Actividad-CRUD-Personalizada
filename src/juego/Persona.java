package juego;

import java.util.Scanner;

public class Persona {

    Scanner teclado = new Scanner(System.in);
    //atributos
    private String nombre = "Nombre predeterminado";
    private Integer velocidad = 10;

    //constructor
    public Persona(String nombre, Integer velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
    }

    Persona() {

    }

    public void menu() {
        boolean salir = true;
        while (salir) {
            System.out.println("Bienvenido a gestor de personas"
                    + "\n Seleccionar opciones"
                    + "\n0 Regresar a menu principal"
                    + "\n1 ver nombre"
                    + "\n2 Cambiar nombre"
                    + "\n3 ver velocidad"
                    + "\n4 Cambiar velocidad"
            );
            //cambiar velocidad
            switch (this.teclado.nextInt()) {
                case 0 ->
                    salir = false;
                case 1 ->
                    System.out.println("El Nombre Es " + this.getNombre());
                case 2 -> {
                    System.out.println("Ingresa nombre...");
                    this.setNombre(this.teclado.next());
                }
                case 3 ->
                    System.out.println("Velocidad :" + this.getVelocidad());
                case 4 -> {
                    System.out.println("Ingresa velocidad...");
                    this.setVelocidad(this.teclado.nextInt());
                }
                default ->
                    System.out.println("opcion no valida");
            }
        }
    }

    //get y set
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    //metodos
    public void gritar(Perro perro) {
        System.out.println(this.nombre + ": AYUDA AHI VIENE " + perro.getNombre());
    }

    public void correr() {
        System.out.println(this.nombre + " esta corriendo a " + this.velocidad + " km por hora");
    }

    public void huir(Perro perro) {
        System.out.println(this.nombre + " logro escapar de " + perro.getNombre());
    }
}
