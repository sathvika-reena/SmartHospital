package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public final class DoctorRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html");
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

     response.setContentType("text/html");
     String uname=request.getParameter("name");
     String specialization = request.getParameter("specialization");
     String brief_profile = request.getParameter("brief_profile");
     String availability = request.getParameter("availability");
     String passwd=request.getParameter("passwd");
     String confirmpasswd=request.getParameter("confirmpasswd");
     String emailid=request.getParameter("email");
     long phno=Long.parseLong(request.getParameter("phno"));
     Class.forName("oracle.jdbc.driver.OracleDriver");
     //out.println("Driver Loaded...");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1208");
     //out.println("Connected to database");
     PreparedStatement ps=con.prepareStatement("insert into doctorRegister_table values(?,?,?,?,?,?,?,?)");
     ps.setString(1,uname);
     ps.setString(2,specialization);
     ps.setString(3,brief_profile);
     ps.setString(4,availability);
     ps.setString(5,passwd);
     ps.setString(6,confirmpasswd); 
     ps.setString(7,emailid);
     ps.setLong(8,phno);
     int n=ps.executeUpdate(); 
    if(n>0) {//out.println("Registered successfully!!");
    response.sendRedirect("index.html");
    }
     
   
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("  ");
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
