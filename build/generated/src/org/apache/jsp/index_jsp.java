package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import javax.naming.InitialContext;
import utils.ListaCarritoRemote;
import utils.Productos;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
   

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"></meta>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\"></link>\n");
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
      out.write("            <button type=\"submit\" class=\"btn btn-dark\" value=\"Add\" name=\"addItem\">Agregar </button>\n");
      out.write("            <!--<button type=\"submit\" class=\"btn btn-dark\" value=\"Remove\" name=\"remItem\"> Remover</button>-->\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        <hr class=\"my-12\"/>\n");
      out.write("        \n");
      out.write("        <div>\n");
      out.write("            <table class=\"table\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Nombre del Producto</th>\n");
      out.write("                        <th scope=\"col\">Precio</th>\n");
      out.write("                        <th scope=\"col\">Cantidad</th>\n");
      out.write("                        <th scope=\"col\">Total precio</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>         \n");
      out.write("                <tbody>\n");
  
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
 
      out.write("\n");
      out.write("    \n");
      out.write("                    \n");
      out.write("         \n");
      out.write("                    \n");
      out.write("                </tbody>\n");
      out.write("         </table>\n");
      out.write("        </div>\n");
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
