package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public final class appointment_jsp extends org.apache.jasper.runtime.HttpJspBase
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

     try {
        response.setContentType("text/html");
        String patient_id = request.getParameter("patient_id");
        String patient_name = request.getParameter("patient_name");
        String patient_phone = request.getParameter("patient_phone");
        String doctor = request.getParameter("doctor");
        String prefer_date = request.getParameter("prefer_date");
        String prefer_time = request.getParameter("prefer_time");
        String remarks = request.getParameter("remarks");

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1232");
        
        // Check if patient_id already exists
        PreparedStatement psCheck = con.prepareStatement("SELECT COUNT(*) FROM appointment_table WHERE patient_id = ?");
        psCheck.setString(1, patient_id);
        ResultSet rsCheck = psCheck.executeQuery();
        rsCheck.next();
        int count = rsCheck.getInt(1);
        
        if(count > 0) {
            out.println("Error: Patient ID already exists.");
        } else {
            PreparedStatement ps = con.prepareStatement("insert into appointment_table (patient_id, patient_name, patient_phone, doctor, prefer_date, prefer_time, remarks) values(?,?,?,?,?,?,?)");
        
            ps.setString(1, patient_id);
            ps.setString(2, patient_name);
            ps.setString(3, patient_phone);
            ps.setString(4, doctor);
            ps.setString(5, prefer_date);
            ps.setString(6, prefer_time);
            ps.setString(7, remarks);
            
            int n = ps.executeUpdate(); 
            if(n > 0) {
                  out.println("Registered successfully!!");
                    //response.sendRedirect("appointment_details.jsp");
                }
        }
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
    
      out.write("\n");
      out.write(" \n");
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
