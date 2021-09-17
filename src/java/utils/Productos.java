
package utils;

/**
 *
 * @author Alexander
 */
public class Productos {
    private String nombre;
    private int precio;
    private int cantidad;
    
    public Productos() {
        this.nombre = "";
        this.precio = 0;
        this.cantidad = 0;
    }
     public Productos(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }


 public String getNombreProducto() {
        return nombre;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombre = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getPrecioTotal() {
        return cantidad * precio;
    }
}

