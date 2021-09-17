
package utils;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Alexander
 */
@Stateful
public class ListaCarritos implements ListaCarritoRemote{
    
    List<Productos> items = new ArrayList<>();

    @Override
    public void agprod(utils.Productos productos) 
    {
       items.add(productos); 
    }

    @Override
    public List<utils.Productos> Productos() 
    {
       return items;
    }

    @Override
    public Boolean carritoEmpty() {
         return this.items.isEmpty();
    }

    @Override
    public int montoTotalEnCarrito() {
       int Total = 0;
        for (Productos producto : items) {
            Total = Total + producto.getPrecioTotal();
        }
        return Total;
    }

    @Override
    public void vaciarCarrito() {
        items.clear();
    }
}