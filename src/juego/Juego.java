package juego;

import java.util.Scanner;

public final class Juego {

    Scanner teclado = new Scanner(System.in);
    Persona persona;
    Perro perro;
    Gato michi;

    public Juego() {
        this.michi =new Gato();
        this.persona = new Persona();
        this.perro = new Perro();
        this.menu();
    }

    public void menu() {
        do {
            System.out.println("Welcome to juego, selecciona la opcion "
                    + "\n0. salir"
                    + "\n1. gestor de personas"
                    + "\n2. gestor de perro"
                    + "\n3. Enfrentar perro y persona"
            );
            //gestor de perrito
            switch (this.teclado.nextInt()) {
                case 0 ->
                    System.exit(0);
                case 1 ->
                    this.persona.menu();
                case 2 ->
                    this.perro.menu();
                case 3 -> {
                    this.persona.gritar(this.perro);
                    this.perro.correr();
                    this.persona.correr();
                    if (this.perro.getVelocidad() > this.persona.getVelocidad()) {
                        this.perro.morder(this.persona);
                    } else {
                        this.persona.huir(this.perro);
                    }
                }
                default ->
                    System.out.println("Opcion no valida ");
            }
        } while (true);
    }

    public static void main(String args[]) {
        Juego juego = new Juego();
    }
}
/*
        //instancias, pasas los parametros
        Persona benito = new Persona("Benico Camela", 6);
        Persona sofia = new Persona("Sofia Perez", 2);
        Perro pulgas = new Perro("Pulguitas", 4, 100);
        Perro firus = new Perro("Firulais", 5, 400);
        Perro ruta4 = new Perro("Ruta4", 2, 300);
        //netodos
        ruta4.printNombre();
        firus.printNombre();
        pulgas.printNombre();
        firus.correr();
        pulgas.correr();
        benito.correr();
        sofia.correr();
        benito.gritar(firus);
        sofia.gritar(pulgas);
        firus.morder(benito);
 */
