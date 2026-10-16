package zoo;

import java.util.Scanner;

public class Zoo {

    Scanner teclado = new Scanner(System.in);
    Tigre trigre;
    Leon leon;
    Pato pato;
    Ornitorinco orni;

    Zoo() {
        this.leon = new Leon();
        this.trigre = new Tigre();
        this.pato = new Pato();
        this.orni = new Ornitorinco();
        this.menu();

    }

    public void menu() {
        do {
            System.out.println("Welcome to juego, selecciona la opcion "
                    + "\n0. salir"
                    + "\n1. gestor de tigre"
                    + "\n2. gestor de leon"
                    + "\n3. geator de pato"
                    +"\n3. gestor de ornitorinco"
            );
            //gestor de perrito
            switch (this.teclado.nextInt()) {
                case 0 ->
                    System.exit(0);
                case 1 ->
                    this.trigre.menu();
                case 2 ->
                    this.leon.menu();
                case 3 -> 
                    this.pato.menu();
                    case 4 -> 
                        this.orni.menu();
                default ->
                    System.out.println("Opcion no valida ");
            }
        } while (true);
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
    }
}
