package zoo;

public class Ornitorinco extends Animal implements Acuatico, Terrestre {

    private boolean esVenesozo;

 

    @Override
    public void emitirSonido() {
        System.out.print("grrrggrggrgggr");
    }

    @Override
    public void nadar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void caminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moverse() {
      System.out.print("se mueve en 4 patas ");
    }

    @Override
    public void correr() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
