package juego;

import java.util.Scanner;

public class Perro extends Animal{

    Scanner teclado = new Scanner(System.in);
    //atributos
   /* private String nombre = "nombre predeterminado";
    private Integer velocidad = 15;
    private Integer precio = 20;*/

    //constructor
    public Perro(String nombre, Integer velocidad, Integer precio) {
        super.nombre = nombre;
        super.velocidad = velocidad;
        super.precio = precio;
    }

    Perro() {

    }

    //menu
    public void menu() {
        boolean salir = true;
        while (salir) {
            System.out.println("Bienvenido a gestor de perros"
                    + "\n Seleccionar opciones"
                    + "\n0 Regresar a menu principal"
                    + "\n1 ver nombre"
                    + "\n2 Cambiar nombre"
                    + "\n3 ver velocidad"
                    + "\n4 Cambiar velocidad"
                    + "\n5 ver Precio"
                    + "\n6 Cambiar precio"
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
                case 5 ->
                    System.out.println("Precio:  " + this.getPrecio());
                case 6 -> {
                    System.out.println("Ingresa precio...");
                    this.setPrecio(this.teclado.nextInt());
                }
                default ->
                    System.out.println("opcion no valida");
            }
        }
    }

    //print nombre
    public void printNombre() {
        System.out.println("nombre: " + this.nombre);
    }

 

    //metodos
    public void morder(Persona persona) {
        if (this.velocidad > persona.getVelocidad()) {
            System.out.println(this.nombre + " mordio a " + persona.getNombre());
        } else {
            System.out.println(persona.getNombre() + "  escapo");
        }
    }

    public void correr() {
        System.out.println(this.nombre + " esta corriendo a " + this.velocidad + " km por hora CUIDADOOOOOOOOOO");
    }
}
