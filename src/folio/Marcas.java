/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package folio;

/**
 *
 * @author anamr
 */
public class Marcas {

    private String nombre;
    private Integer id;

    public Marcas(String nombre, Integer id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

}
