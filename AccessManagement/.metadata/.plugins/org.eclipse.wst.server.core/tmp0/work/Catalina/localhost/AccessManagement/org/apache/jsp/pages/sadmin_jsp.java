/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.81
 * Generated at: 2018-02-03 04:12:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Access Management</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("#loading {\r\n");
      out.write("   background-color: #fff;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   position: fixed;\r\n");
      out.write("   z-index: 999;\r\n");
      out.write("   text-align:center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write(" \r\n");
      out.write(" <link rel=\"stylesheet\" href=\"bootstrap-3.3.7/dist/css/bootstrap.min.css\">\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"dataTables/1.10.16/css/dataTables.bootstrap.min.css\"> \r\n");
      out.write("<script src=\"bootstrap/js/jquery-1.10.2.js\"></script>\r\n");
      out.write("<script src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"loading\">\r\n");
      out.write("        <img src=\"img/loadingaero.gif\" />\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write(" <nav class=\"navbar navbar-inverse\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"navbar-header\"> \r\n");
      out.write("      <a  onClick=\"refreshModal()\" class=\"navbar-brand\">ACCESS MANAGEMENT</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"nav navbar-nav\">\r\n");
      out.write("    \r\n");
      out.write("      <li id=\"addUser\" class=\"active\"><a href=\"#\">ADD USER ACCESS</a></li>\r\n");
      out.write("      <li id=\"editUser\" class=\"active\"><a href=\"#\">MANAGE USER/ACCESS</a></li> \r\n");
      out.write("      <li id=\"viewBranch\" class=\"active\"><a href=\"#\">VIEW BRANCH ACCESS</a></li>\r\n");
      out.write("      <li id=\"seacrhUser\" class=\"active\"><a href=\"#\">TRACK USER</a></li>      \r\n");
      out.write("    </ul>\r\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("      <li><a href=\"j_spring_security_logout\">Log Out</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("  \r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<div id=\"dataTest\" >\r\n");
      out.write("\r\n");
      out.write("<!-- <div  class=\"col-lg-12\" align=\"center\">\r\n");
      out.write("                        <h2><span class=\"label label-primary\">SEARCH USER AND BRANCH ACCESS</span></h2><br>\r\n");
      out.write("                 </div>  --> \r\n");
      out.write("\r\n");
      out.write("<table id=\"example\" align=\"center\" class=\"table table-striped table-bordered\" cellspacing=\"0\" style=\"width:90%;\" >\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("               <th>Branch</th>\r\n");
      out.write("                                      <th>User Name</th>\r\n");
      out.write("                                      <th>CBS ID</th>\r\n");
      out.write("                                      <th>Job Title</th>\r\n");
      out.write("                                      <th>User Group</th> \r\n");
      out.write("                                      <th>Status</th>                                         \r\n");
      out.write("                                      <th>Remarks</th> \r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("       <tbody>\r\n");
      out.write("                           \t ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t                    </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write("\r\n");
      out.write(" </div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" <br> <br>\r\n");
      out.write(" \r\n");
      out.write("<!--  \t<div class=\"footer\"><div align=\"center\"  style=\"color:#0C0E75;\"class=\"container\"><B>Designed and Developed By:<br/> IT DEPARTMENT <br/>SANIMA BANK PVT. LTD</B></div></div>\r\n");
      out.write(" --> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal fade\"  id=\"makerChk\" >\r\n");
      out.write(" <div class=\"modal-dialog\">\r\n");
      out.write("  <div class=\"modal-content\"\r\n");
      out.write("   style='padding-bottom: 0px; margin-bottom: 0px;'>\r\n");
      out.write("   <div class=\"modal-body\" style='padding: 0px;'>\r\n");
      out.write("    <div class=\"panel panel-primary\" style=\"margin-bottom: 0px;\">\r\n");
      out.write("<!--      <button type=\"button\" class=\"close\" title=\"Close\" onclick=\"refreshModal()\">\r\n");
      out.write(" -->     \r\n");
      out.write(" \r\n");
      out.write("     <button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("      aria-hidden=\"true\" title=\"Close\">\r\n");
      out.write(" \r\n");
      out.write("  <span style=\"font-size: 1.6em; padding-right: 10px;\" >&times;</span>\r\n");
      out.write("     </button>\r\n");
      out.write("     <div class=\"panel-heading\" style=\"\">\r\n");
      out.write("      <h4>\r\n");
      out.write("       <label id=\"lblHeading\">ADD CBS ACCESS TO USER</label>\r\n");
      out.write("      </h4>\r\n");
      out.write("     </div>\r\n");
      out.write("     <div class=\"panel-body\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("       <div class=\"col-sm-6\">\r\n");
      out.write("        <div id=\"divMsgs\"></div>\r\n");
      out.write("       </div>\r\n");
      out.write("      </div>      \r\n");
      out.write("      <div class=\"form-group\"> \t\t\t\r\n");
      out.write("\t  <label>BRANCH:</label>&nbsp;&nbsp;&nbsp; \r\n");
      out.write("       <select class=\"form-control\" id=\"selBranch\" name=\"selBranch\">      \r\n");
      out.write("\t        ");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("                      \r\n");
      out.write("       </select>       \r\n");
      out.write("\t  <br/>\r\n");
      out.write("        <label>USER NAME: </label>&nbsp;&nbsp;&nbsp;       \r\n");
      out.write("\t\t\t<input class=\"form-control\" type=\"text\" id=\"userAccName\">\t\t\t\t\t\r\n");
      out.write("\t <br/>\r\n");
      out.write("        <label>CBS ID: </label>&nbsp;&nbsp;&nbsp;       \r\n");
      out.write("\t\t\t<input class=\"form-control\" type=\"text\" id=\"cbsId\">\t\t  \t\r\n");
      out.write("\t  <br/>      \r\n");
      out.write("       <label>JOB TITLE:</label>&nbsp;&nbsp;&nbsp; \r\n");
      out.write("       <select class=\"form-control\" id=\"seltitle\"  onchange=\"myFunction()\">\r\n");
      out.write("       ");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("                     \r\n");
      out.write("       </select>       \r\n");
      out.write("       <br/>       \r\n");
      out.write("       \t<input  type=\"hidden\" id=\"grpAcc\"> <p id=\"grpAcc\"></p> \t      \r\n");
      out.write("       <label>REMARKS: </label>&nbsp;&nbsp;&nbsp;       \r\n");
      out.write("\t  <input class=\"form-control\" type=\"text\" id=\"userRemarks\" >\t\t\r\n");
      out.write("\t   <br/><br/>\t   \r\n");
      out.write("\t   <div align=\"center\"><a id=\"addAccess\" class=\"btn btn-primary\">ADD ACCESS</a> \r\n");
      out.write("\t   </div>\t       \r\n");
      out.write("        <br>         \r\n");
      out.write("\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ****************************UPDATE ACCESS**************************************************** -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal fade\"  id=\"updateModal\" >\r\n");
      out.write(" <div class=\"modal-dialog\">\r\n");
      out.write("  <div class=\"modal-content\"\r\n");
      out.write("   style='padding-bottom: 0px; margin-bottom: 0px;'>\r\n");
      out.write("   <div class=\"modal-body\" style='padding: 0px;'>\r\n");
      out.write("    <div class=\"panel panel-primary\" style=\"margin-bottom: 0px;\">\r\n");
      out.write("     <button type=\"button\" class=\"close\"\r\n");
      out.write("       title=\"Close\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("      aria-hidden=\"true\" title=\"Close\">\r\n");
      out.write("      <span style=\"font-size: 1.6em; padding-right: 10px;\" >&times;</span>\r\n");
      out.write("     </button>\r\n");
      out.write("     <div class=\"panel-heading\" style=\"\">\r\n");
      out.write("      <h4>\r\n");
      out.write("       <label id=\"lblHeading\">UPDATE USER AND ACCESS</label>\r\n");
      out.write("      </h4>\r\n");
      out.write("     </div>\r\n");
      out.write("     <div class=\"panel-body\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("       <div class=\"col-sm-6\">\r\n");
      out.write("        <div id=\"divMsgs\"></div>\r\n");
      out.write("       </div>\r\n");
      out.write("      </div>      \r\n");
      out.write("      <div class=\"form-group\"> \t\t\t\r\n");
      out.write("\t  <label>BRANCH:</label>&nbsp;&nbsp;&nbsp; \r\n");
      out.write("       <select class=\"form-control\" id=\"updBranch\" name=\"updBranch\">      \r\n");
      out.write("\t        ");
      if (_jspx_meth_c_005fforEach_005f3(_jspx_page_context))
        return;
      out.write("                      \r\n");
      out.write("       </select>       \r\n");
      out.write("\t  <br/>\r\n");
      out.write("        <label>USER NAME: </label>&nbsp;&nbsp;&nbsp;       \r\n");
      out.write("\t\t\t<input class=\"form-control\" type=\"text\" id=\"updAccName\" >\t\t\t\t\t\r\n");
      out.write("\t <br/>\r\n");
      out.write("        <label>CBS ID: </label>&nbsp;&nbsp;&nbsp;       \r\n");
      out.write("\t\t\t<input class=\"form-control\" type=\"text\" id=\"updcbsId\">\t\t  \t\r\n");
      out.write("\t  <br/>      \r\n");
      out.write("       <label>JOB TITLE:</label>&nbsp;&nbsp;&nbsp; \r\n");
      out.write("       <select class=\"form-control\" id=\"updTitle\"  onchange=\"updmyFunction()\">\r\n");
      out.write("       ");
      if (_jspx_meth_c_005fforEach_005f4(_jspx_page_context))
        return;
      out.write("                     \r\n");
      out.write("       </select>       \r\n");
      out.write("       <br/>       \r\n");
      out.write("       <input  type=\"hidden\" id=\"updgrpAcc\"><p id=\"updgrpAcc\"></p> \t      \r\n");
      out.write("       <label>REMARKS: </label>&nbsp;&nbsp;&nbsp;       \r\n");
      out.write("\t  <input class=\"form-control\" type=\"text\" id=\"updRemarks\" >\t\t\r\n");
      out.write("\t   <br/><br/>\t   \r\n");
      out.write("\t   <div align=\"center\"><a id=\"updateAccess\" class=\"btn btn-primary\">UPDATE ACCESS</a> \r\n");
      out.write("\t   </div>\t       \r\n");
      out.write("        <br>         \r\n");
      out.write("\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("    \t\t\r\n");
      out.write(" </body>\r\n");
      out.write(" \r\n");
      out.write("<script src=\"doaweb/all.js\"></script>\r\n");
      out.write(" \r\n");
      out.write("<!-- Core Scripts - Include with every page for modal -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"bootstrap/js/bootstrapValidator.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <script src=\"dataTables/1.10.16/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("  <script src=\"dataTables/1.10.16/js/dataTables.bootstrap.min.js\"></script>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" <script> \r\n");
      out.write(" \r\n");
      out.write(" jQuery(window).load(function () {\r\n");
      out.write("     jQuery('#loading').hide();\r\n");
      out.write(" });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" $(document).ready(function () {\r\n");
      out.write("      $('#example').dataTable();\r\n");
      out.write("  });\r\n");
      out.write(" \r\n");
      out.write(" $(\"#addUser\").click(function(){  \r\n");
      out.write("/*      $(\"#dataTest\").hide();    \r\n");
      out.write(" */      $(\"#makerChk\").modal({\r\n");
      out.write("\t         backdrop: 'static',\r\n");
      out.write("\t         keyboard: false,\r\n");
      out.write("\t     });  \r\n");
      out.write("  });   \r\n");
      out.write("    \r\n");
      out.write("  $(\"#editUser\").click(function(){\r\n");
      out.write("/* \t     $(\"#dataTest\").hide();   \r\n");
      out.write(" */         $(\"#updateModal\").modal({\r\n");
      out.write("   \t         backdrop: 'static',\r\n");
      out.write("   \t         keyboard: false,\r\n");
      out.write("   \t     });\r\n");
      out.write("  }); \r\n");
      out.write("  \r\n");
      out.write("  $(\"#seacrhUser\").click(function () {\r\n");
      out.write("\t  $(\"#dataTest\").hide();\r\n");
      out.write("  });\r\n");
      out.write("</script>      \r\n");
      out.write(" </html>\r\n");
      out.write(" \r\n");
      out.write(" ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /pages/sadmin.jsp(82,29) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("test");
      // /pages/sadmin.jsp(82,29) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${listUserAcc}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t                      <tr>\r\n");
            out.write("\t\t\t\r\n");
            out.write("\t\t                        \t<td align=\"center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${test.branchName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t                            <td align=\"center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${test.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\t\t                        \t\r\n");
            out.write("\t\t                        \t<td align=\"center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${test.cbsId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t                            <td align=\"center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${test.jobTitle}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t                           \t<td align=\"center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${test.cbsAccess}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t                           \t<td align=\"center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${test.status}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t                           \t<td align=\"center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${test.remarks}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</td>\r\n");
            out.write("\t\t                           \t\r\n");
            out.write("\t\t                           \r\n");
            out.write("\t\t\t                    \t</tr>\r\n");
            out.write("\t\t                       \t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /pages/sadmin.jsp(136,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("brnch");
      // /pages/sadmin.jsp(136,9) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lb}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("      \r\n");
            out.write("\t        \t<option value=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${brnch.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${brnch.branch}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</option>        \r\n");
            out.write("\t        ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f2_reused = false;
    try {
      _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f2.setParent(null);
      // /pages/sadmin.jsp(149,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f2.setVar("accss");
      // /pages/sadmin.jsp(149,7) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${la}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
        if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("      \r\n");
            out.write("\t        \t<option value=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accss.group}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accss.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</option>        \r\n");
            out.write("\t        ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f2.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
      _jspx_th_c_005fforEach_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f3_reused = false;
    try {
      _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f3.setParent(null);
      // /pages/sadmin.jsp(199,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f3.setVar("brnch");
      // /pages/sadmin.jsp(199,9) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lb}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
        if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("      \r\n");
            out.write("\t        \t<option value=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${brnch.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${brnch.branch}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</option>        \r\n");
            out.write("\t        ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f3.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
      _jspx_th_c_005fforEach_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f3_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f4_reused = false;
    try {
      _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f4.setParent(null);
      // /pages/sadmin.jsp(212,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f4.setVar("accss");
      // /pages/sadmin.jsp(212,7) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${la}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
        if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("      \r\n");
            out.write("\t        \t<option value=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accss.group}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${accss.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</option>        \r\n");
            out.write("\t        ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f4.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f4);
      _jspx_th_c_005fforEach_005f4_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f4, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f4_reused);
    }
    return false;
  }
}
