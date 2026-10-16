package zoo;

import java.util.Scanner;

public abstract class Animal {
    //atributos

    Scanner teclado = new Scanner(System.in);
    protected String nombre = "default";
    protected Integer edad = 0;
    protected Double peso = 0.0;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Double getPeso() {
        return peso;
    }

    //metodos
    public void menu() {
        boolean salir = true;
        while (salir) {
            System.out.println("Bienvenido a gestor del animal seleccionado"
                    + "\n Seleccionar opciones"
                    + "\n0 Regresar a menu principal"
                    + "\n1 ver nombre"
                    + "\n2 Cambiar nombre"
                    + "\n3 ver edad"
                    + "\n4 Cambiar edad"
                    + "\n5 Hacer sonido"
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
                    System.out.println("Velocidad :" + this.getEdad());
                case 4 -> {
                    System.out.println("Ingresa velocidad...");
                    this.setEdad(this.teclado.nextInt());

                }
                case 5 ->
                    this.emitirSonido();
                default ->
                    System.out.println("opcion no valida");
            }
        }
    }

    public void comer(Alimento alimento) {
        System.out.print("ñamñamñam " + alimento.getNombre());
    }

    public void Dormir() {
        System.out.print("*ronquido*");
    }

    public abstract void emitirSonido();

    public abstract void moverse();
}
