package utils;

import java.util.List;
import javax.ejb.Remote;


/**
 *
 * @author Alexander
 */
@Remote
public interface ListaCarritoRemote {
    void agprod(Productos productos);
    List<Productos> Productos();
    
    //Otros intentos
    //void agprod(String n,int p, int c);
    //void removeItem(String n,int p, int c);
    //List<String> getItems = new ArrayList<>();
   
    
    //ArrayList<String> nproductos = new ArrayList<String>();
   // ArrayList<Integer> pproductos = new ArrayList<Integer>();
    //ArrayList<Integer> cproductos = new ArrayList<Integer>();
    //List<Integer> getItem();
}