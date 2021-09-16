
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="utils.ListaCarritoRemote"%>
<%@page import="utils.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    private static ListaCarritoRemote items;

    public void jspInit()
    {
        try
        {
               InitialContext ic = new InitialContext();
               items = (ListaCarritoRemote)ic.lookup("java:global/CarritoCompras_JEE/ListaCarrito");
        }
        catch(Exception e) { System.out.println(e);}
    }
%>
<% 
    /*if(request.getParameter("addItem")!=null)
    {
        String n = request.getParameter("nproducto");
        int p = Integer.parseInt(request.getParameter("pproducto")); 
        int c = Integer.parseInt(request.getParameter("cproducto"));
        values.agprod(setNombreProducto(n));
        
    }*/
    /*if(request.getParameter("nproducto")!=null)
    {
        String n = request.getParameter("nproducto");
        int p = Integer.parseInt(request.getParameter("pproducto")); 
        int c = Integer.parseInt(request.getParameter("cproducto"));
        Productos newProductos = new Productos(); //Se crea constructor
        newProductos.setNombreProducto(n); //Se setea la variable de formulario en la clase productos - nombre del producto
        newProductos.setPrecio(p);
        newProductos.setCantidad(c);
        items.agprod(newProductos);
        
    }*/
     if (request.getParameter("agregarProducto") != null) {
        String nombreDelProducto = request.getParameter("nombreDelProducto");
        int precioDelProducto = Integer.parseInt(request.getParameter("precioDelProducto"));
        int cantidadDelProducto = Integer.parseInt(request.getParameter("cantidadDelProducto"));
        
        items.agprod(new Productos(nombreDelProducto, precioDelProducto, cantidadDelProducto));
    }
   
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous"></link>
        <link href="resources/style.css" rel="stylesheet"> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido al carrito de compras JEE</h1>
        <div class="form-group">
        <form name="abc" method="get">
            <label>Nombre del producto:</label>
            <input class="form-control" type="text" placeholder="Nombre del producto" name="nproducto"><br>
            <label>Precio del producto:</label>
            <input class="form-control" type="text" placeholder="$" name="pproducto"><br>
            <label>Cantidad:</label>
            <input class="form-control" type="text" placeholder="" name="cproducto"><br>
            <button type="submit" class="btn btn-dark" value="Add" name="addItem">Agregar </button>
            <!--<button type="submit" class="btn btn-dark" value="Remove" name="remItem"> Remover</button>-->
        </form>
        </div>
        <hr class="my-12"/>
        
        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nombre del Producto</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Total precio</th>
                    </tr>
                </thead>         
                <tbody>
<%  
                if(items!=null)
                {
                    
                    
                    List<Productos> volados = items.Productos();
                    for (Productos productos : volados)
                    {
                        out.println("<tr>");
                        out.println("<td>" + productos.getNombreProducto() + "</td>");
                        out.println("<td>" + 34 + "</td>");
                        out.println("<td>" + 45 + "</td>");
                        out.println("<td>" + 45 + "</td>");
                        out.println("</tr>");
                    }
                    
                }
 %>
    
                    
         
                    
                </tbody>
         </table>
        </div>
    </body>
</html>
