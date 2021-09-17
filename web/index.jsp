<%@page import="javax.ejb.EJB"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="utils.ListaCarritoRemote"%>
<%@page import="utils.Productos"%>
<%@page import="utils.ListaCarritos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    private static ListaCarritoRemote items;

    public void jspInit()
    {
        try
        {
               InitialContext ic = new InitialContext();
               items = (ListaCarritoRemote)ic.lookup("java:global/CarritoCompras_JEE/ListaCarritos");//AQUI ME ESTABA FALTANDO UNA S
        }
        catch(Exception e) { System.out.println(e);}
    }
%>
<% 
    
     if (request.getParameter("agregarProducto") != null) {
        String nombreDelProducto = request.getParameter("nproducto");
        int precioDelProducto = Integer.parseInt(request.getParameter("pproducto"));
        int cantidadDelProducto = Integer.parseInt(request.getParameter("cproducto"));
        
        items.agprod(new Productos(nombreDelProducto, precioDelProducto, cantidadDelProducto));
    }
   
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous"/>
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
            <button type="submit" id="agregarProducto" class="btn btn-dark" value="agregarProducto" name="agregarProducto">Agregar </button>
            <!--<button type="submit" class="btn btn-dark" value="Remove" name="remItem"> Remover</button>-->
        </form>
        </div>
        <% 
                    if (!items.carritoEmpty()) {
                        List<Productos> listaProductos = items.Productos();
                        out.println("<div class=\"col-12 offset-lg-2 offset-xl-3 col-lg-8 col-xl-6 mt-5\">");
                        out.println("<table class=\"table\">");
                        out.println("<thead>");
                        out.println(" <tr>");
                        out.println("<th scope=\"col\">Nombre del producto</th>");
                        out.println("<th scope=\"col\">Precio/Unidad</th>");
                        out.println("<th scope=\"col\">Cantidad</th>");
                        out.println("<th scope=\"col\">Precio producto</th>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        for (Productos volados : listaProductos) {
                            out.println("<tr>");
                            out.println("<td>" + volados.getNombreProducto() + "</td>");
                            Integer precioProducto = volados.getPrecio();
                            String precioDolares = Integer.toString(precioProducto / 100);
                            String centavos = Integer.toString(precioProducto % 100);
                            out.println("<td  class=\"text-center\">$" + precioDolares + "." + (centavos.length() == 1 ? centavos + "0" : centavos) + "</td>");
                            out.println("<td  class=\"text-center\">" + Integer.toString(volados.getCantidad()) + "</td>");
                            Integer precioTotalProducto = volados.getPrecioTotal();
                            String precioTotalDolares = Integer.toString(precioTotalProducto / 100);
                            String centavosTotal = Integer.toString(precioTotalProducto % 100);
                            out.println("<td  class=\"text-center\">$" + precioTotalDolares + "." + (centavosTotal.length() == 1 ? centavosTotal + "0" : centavosTotal) + "</td>");
                            out.println("</tr>");
                        }
                        out.println("<thead>");
                        out.println(" <tr>");
                        out.println("<th class=\"text-end\" scope=\"col\" colspan=\"3\">Total de compra</th>");
                        Integer montoTotalEnCarrito = items.montoTotalEnCarrito();
                        String montoTotalEnCarritoEnDolares = Integer.toString(items.montoTotalEnCarrito() / 100);
                        String montoTotalEnCarritoCentavos = Integer.toString(items.montoTotalEnCarrito() % 100);
                        out.println("<th class=\"text-center\" scope=\"col\">$" + montoTotalEnCarritoEnDolares + "." + (montoTotalEnCarritoCentavos.length() == 1 ? montoTotalEnCarritoCentavos + "0" : montoTotalEnCarritoCentavos) +  "</th>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("</tbody></table></div>");
                    } else {
                        out.println("<div class=\"col-12 offset-lg-2 offset-xl-3 col-lg-8 col-xl-6 mt-5\">");
                        out.println("<h5 class=\"text-center text-primary\">No hay productos en el carrito de compras.</h5>");
                        out.println("</div>");
                    }
                %>
    </body>
</html>
