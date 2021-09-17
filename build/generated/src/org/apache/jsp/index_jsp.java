package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.ejb.EJB;
import java.util.List;
import javax.naming.InitialContext;
import utils.ListaCarritoRemote;
import utils.Productos;
import utils.ListaCarritos;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write('\n');
 
    
     if (request.getParameter("agregarProducto") != null) {
        String nombreDelProducto = request.getParameter("nproducto");
        int precioDelProducto = Integer.parseInt(request.getParameter("pproducto"));
        int cantidadDelProducto = Integer.parseInt(request.getParameter("cproducto"));
        
        items.agprod(new Productos(nombreDelProducto, precioDelProducto, cantidadDelProducto));
    }
   

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\"/>\n");
      out.write("        <link href=\"resources/style.css\" rel=\"stylesheet\"> \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Bienvenido al carrito de compras JEE</h1>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("        <form name=\"abc\" method=\"get\">\n");
      out.write("            <label>Nombre del producto:</label>\n");
      out.write("            <input class=\"form-control\" type=\"text\" placeholder=\"Nombre del producto\" name=\"nproducto\"><br>\n");
      out.write("            <label>Precio del producto:</label>\n");
      out.write("            <input class=\"form-control\" type=\"text\" placeholder=\"$\" name=\"pproducto\"><br>\n");
      out.write("            <label>Cantidad:</label>\n");
      out.write("            <input class=\"form-control\" type=\"text\" placeholder=\"\" name=\"cproducto\"><br>\n");
      out.write("            <button type=\"submit\" id=\"agregarProducto\" class=\"btn btn-dark\" value=\"agregarProducto\" name=\"agregarProducto\">Agregar </button>\n");
      out.write("            <!--<button type=\"submit\" class=\"btn btn-dark\" value=\"Remove\" name=\"remItem\"> Remover</button>-->\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        ");
 
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
                
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
