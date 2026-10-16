package zoo;

public class Leon extends Animal implements Terrestre {

    public void setTamañoManada(Integer tamañoManada) {
        this.tamañoManada = tamañoManada;
    }

    private Integer tamañoManada;

    public void rugir() {
        System.out.print("raaaaaaaaararrararararar");
    }


    public Integer getTamañoManada() {
        return tamañoManada;
    }

    @Override
    public void emitirSonido() {
        System.out.println("RAAAARR");
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
