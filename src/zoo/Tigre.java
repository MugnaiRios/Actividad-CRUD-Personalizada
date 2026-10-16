package zoo;

public class Tigre extends Animal implements Terrestre {
// atributos
    private boolean esSalvaje;


    //metodos
    public void cazar() {
        System.out.print("El trigre esta asechando.....");
    }

    // sobreescritos
    @Override
    public void emitirSonido() {
       System.out.println("prrrrrrrrrrrrrrrrrrrrrrrr");
    }

    @Override
    public void moverse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void caminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void correr() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
