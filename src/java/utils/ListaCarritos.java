
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

  
}
