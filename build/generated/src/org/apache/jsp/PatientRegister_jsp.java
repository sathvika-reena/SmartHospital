package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public final class PatientRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

     try
     {
        response.setContentType("text/html");
        String uname = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String bgrp = request.getParameter("grp");
        String weight = request.getParameter("wt");
        String passwd = request.getParameter("pwd");
        String confirmPasswd = request.getParameter("confirmpwd");
        String emailid = request.getParameter("email");
        String address =request.getParameter("address");
        String mobile =request.getParameter("phno");
        String patient_id = request.getParameter("patient_id");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1232");
        PreparedStatement ps = con.prepareStatement("insert into patientRegister_table values(?,?,?,?,?,?,?,?,?,?,?)");
        
        ps.setString(1, uname);
        ps.setString(2, gender);
        ps.setString(3, age);
        ps.setString(4, bgrp);
        ps.setString(5, weight);
        ps.setString(6, passwd);
        ps.setString(7, confirmPasswd);
        ps.setString(8, emailid);
        ps.setString(9, address);
        ps.setString(10,mobile);
        ps.setString(11, patient_id);
        int n=ps.executeUpdate(); 
        if(n>0) {//out.println("Registered successfully!!");
            response.sendRedirect("loginp.html");
        }
    }
    catch(Exception e) {
        out.println("Error:"+e.getMessage());
    }
    
      out.write("\r\n");
      out.write("   ");
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
