/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.48
 * Generated at: 2018-02-01 13:43:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.qnaboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import qnaBoard.model.vo.QnaBoard;
import member.model.vo.Member;

public final class qnaModify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/qnaboard/../../header.jsp", Long.valueOf(1517397470805L));
    _jspx_dependants.put("/views/qnaboard/../../footer.jsp", Long.valueOf(1517224153540L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("qnaBoard.model.vo.QnaBoard");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    ");

       QnaBoard board = (QnaBoard)request.getAttribute("board");
       int currentPage = ((Integer) request.getAttribute("page")).intValue();
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta  charset=\"UTF-8\">\r\n");
      out.write("<title>QnaModify</title>\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"css/1-col-portfolio.css\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("button.bt{\r\n");
      out.write("   width:150px;\r\n");
      out.write("   height:40px;\r\n");
      out.write("   border:1px dotted #369;\r\n");
      out.write("   border-radius:20px;\r\n");
      out.write("   background-color:#f3f6f7;\r\n");
      out.write("   color:#369;\r\n");
      out.write("}\r\n");
      out.write("a{\r\n");
      out.write("   text-decoration:none;\r\n");
      out.write("}\r\n");
      out.write("table.type09 {\r\n");
      out.write("   border-collapse: collapse;\r\n");
      out.write("   text-align: left;\r\n");
      out.write("   line-height: 1.5;\r\n");
      out.write("   width:100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.type09 thead th {\r\n");
      out.write("   padding: 10px;\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("   vertical-align: top;\r\n");
      out.write("   color: #369;\r\n");
      out.write("   border-bottom: 3px solid #036;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.type09 tbody th {\r\n");
      out.write("   width: 150px;\r\n");
      out.write("   padding: 10px;\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("   vertical-align: top;\r\n");
      out.write("   border-bottom: 1px solid #ccc;\r\n");
      out.write("   background: #f3f6f7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.type09 td {\r\n");
      out.write("   width: 350px;\r\n");
      out.write("   padding: 10px;\r\n");
      out.write("   vertical-align: top;\r\n");
      out.write("   border-bottom: 1px solid #ccc;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<br>\r\n");
      out.write("<h3 align=\"center\">리뷰 수정</h3>\r\n");
      out.write("\r\n");
      out.write("    \r\n");

	Member member = (Member)session.getAttribute("member");

      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write(" table{\r\n");
      out.write("    border-collapse: separate;\r\n");
      out.write("   border-spacing:0px 4px\r\n");
      out.write(" }\r\n");
      out.write(" .modal-dialog{\r\n");
      out.write("      width:450px;\r\n");
      out.write("      height:350px;\r\n");
      out.write(" }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav\r\n");
      out.write("\t\tclass=\"navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"intro.jsp\">WhybiS</a>\r\n");
      out.write("\t\t\t<button class=\"navbar-toggler navbar-toggler-right\" type=\"button\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#navbarResponsive\"\r\n");
      out.write("\t\t\t\taria-controls=\"navbarResponsive\" aria-expanded=\"false\"\r\n");
      out.write("\t\t\t\taria-label=\"Toggle navigation\">\r\n");
      out.write("\t\t\t\t<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/semi/intro.jsp\">HOME</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/semi/vrimg\">PLACE</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/semi/views/best/best.jsp\">BEST</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/semi/rblist?page=1\"> BOARD </a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/semi/qlist?page=1\"> Q&A </a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"\" id=\"navbarDropdownBlog\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t\t\tMY PAGE </a>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-menu dropdown-menu-right\"\r\n");
      out.write("\t\t\t\t\t\t\taria-labelledby=\"navbarDropdownBlog\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"full-width.html\">내 정보 보기 및 수정</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"sidebar.html\">나의 관심 장소 보기</a> <a\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-item\" href=\"faq.html\">내가 쓴 글 보기</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");
 if(member == null){  //로그인하지 않았다면 
      out.write("\r\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" data-toggle=\"modal\" data-target=\"#myModal\"> LOGIN </a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"views/member/memberEnroll.jsp\"> JOIN </a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<tr><td>");
      out.print( member.getSmemberName() );
      out.write(" 님 &nbsp;&nbsp;</td>\r\n");
      out.write("\t   <td><a href=\"/semi/logout\">로그아웃</a></td></tr>\r\n");
      out.write("\t   <tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
 if(member.getSmemberId().equals("admin01")){ 
      out.write(" \r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;<a href=\"/semi/mlist\">회원 정보 전체보기</a> ");
 }
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("         aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("         <div class=\"modal-dialog\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("               <div class=\"modal-header\">\r\n");
      out.write("               <h4 class=\"modal-title\" id=\"myModalLabel\">로그인</h4>\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n");
      out.write("                     <span aria-hidden=\"true\">×</span><span class=\"sr-only\">Close</span>\r\n");
      out.write("                  </button>\r\n");
      out.write("                  \r\n");
      out.write("               </div>\r\n");
      out.write("         <!--모달 바디-->\r\n");
      out.write("          <form action=\"login\" method =\"post\">\r\n");
      out.write("               <div class=\"modal-body\">\r\n");
      out.write("               \r\n");
      out.write("                  <table width=\"250\" cellpadding=\"0\" cellspacing=\"0\"  align = \"center\">\r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td>아이디</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"userid\"></td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("                     \r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td>암     호</td>\r\n");
      out.write("                        <td><input type=\"password\" name=\"userpwd\"></td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("                     <tr align = \"center\">\r\n");
      out.write("                        <td colspan=\"2\"><a href=\"#\">아이디/암호 찾기</a></td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("                     <tr align = \"center\">\r\n");
      out.write("                     <td colspan=\"2\"><a href=\"#\">회원가입</a></td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("                  </table>\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("                 \r\n");
      out.write("                  <button type=\"submit\" class=\"btn btn-primary\">로그인</button>\r\n");
      out.write("                  </form>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("   <script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("   <script\r\n");
      out.write("      src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!--    <script src=\"http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg\"></script>\r\n");
      out.write("   ie10-viewport-bug-workaround.js\r\n");
      out.write("   <script src=\"http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg\"></script> -->\r\n");
      out.write("   <!-- holder.js -->\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<hr style=\"clear:both;\">\r\n");
      out.write("<br>\r\n");
      out.write("<!--그냥 전송했을 때는 request로 받지만 multipart로 전송시에는 multipart로 받음  -->\r\n");
 if(board.getQnalevel() >0){ 
      out.write("\r\n");
      out.write("<form action=\"/semi/qreplyup\" method=\"post\" >\r\n");
      out.write("   <table  class=\"type09\" align=\"center\" width=\"600\" border=\"1\">\r\n");
      out.write("   \r\n");
      out.write("   <input type=\"hidden\" name=\"bnum\" value=\"");
      out.print(board.getQnano() );
      out.write("\">\r\n");
      out.write("   <input type=\"hidden\" name=\"page\" value=\"");
      out.print(currentPage);
      out.write("\">\r\n");
      out.write("   \r\n");
      out.write("  <thead><tr><th scope=\"cols\">번호</th><th scope=\"cols\">");
      out.print(board.getQnano());
      out.write("</th></tr></thead>\r\n");
      out.write("  <tbody> <tr><th>제목</th>\r\n");
      out.write("         <td><input type=\"text\" name=\"btitle\"  value=\"");
      out.print(board.getTitle() );
      out.write("\"></td></tr>\r\n");
      out.write("   <tr><th>작성자</th>         <td><input type=\"text\" name=\"bwriter\" readonly value=\"");
      out.print(board.getQnawriter() );
      out.write("\"></td></tr>\r\n");
      out.write("   <tr><th>첨부파일</th>\r\n");
      out.write("         <td><input type=\"file\" name=\"bupfile\">\r\n");
      out.write("         ");
 if(board.getQnaoriginalfilename() != null){ 
      out.write("\r\n");
      out.write("            ");
      out.print(board.getQnaoriginalfilename());
      out.write("\r\n");
      out.write("            <input type=\"hidden\" name=\"boldfile\" value=\"");
      out.print(board.getQnaoriginalfilename());
      out.write("\">\r\n");
      out.write("         ");
} 
      out.write("\r\n");
      out.write("         </td></tr>\r\n");
      out.write("   <tr><th>내용</th>\r\n");
      out.write("         <td><textarea rows=\"5\" cols=\"50\" name=\"bcontent\"  >");
      out.print(board.getContent());
      out.write("</textarea></td></tr>\r\n");
      out.write("  <tr><th colspan=\"2\"><input type=\"submit\" value=\" 수정하기 \"></th></tr>\r\n");
      out.write("   </table>\r\n");
      out.write("</form>\r\n");
}else{ 
      out.write("\r\n");
      out.write("<form action=\"/semi/qmodify\" method=\"post\"  enctype=\"multipart/form-data\">\r\n");
      out.write("   <table  class=\"type09\" align=\"center\" width=\"600\" cellspacing=\"0\" border=\"1\">\r\n");
      out.write("   \r\n");
      out.write("      <input type=\"hidden\" name=\"bnum\" value=\"");
      out.print(board.getQnano() );
      out.write("\">\r\n");
      out.write("   <input type=\"hidden\" name=\"page\" value=\"");
      out.print(currentPage);
      out.write("\">\r\n");
      out.write("   \r\n");
      out.write("   <tr><th>번호</th><th>");
      out.print(board.getQnano());
      out.write("</th></tr>\r\n");
      out.write("   <tr><th>제목</th>\r\n");
      out.write("         <td><input type=\"text\" name=\"btitle\"  value=\"");
      out.print(board.getTitle() );
      out.write("\"></td></tr>\r\n");
      out.write("   <tr><th>작성자</th>         <td><input type=\"text\" name=\"bwriter\" readonly value=\"");
      out.print(board.getQnawriter() );
      out.write("\"></td></tr>\r\n");
      out.write("   <tr><th>첨부파일</th>\r\n");
      out.write("         <td><input type=\"file\" name=\"bupfile\">\r\n");
      out.write("         ");
 if(board.getQnaoriginalfilename() != null){ 
      out.write("\r\n");
      out.write("            ");
      out.print(board.getQnaoriginalfilename());
      out.write("\r\n");
      out.write("            <input type=\"hidden\" name=\"boldfile\" value=\"");
      out.print(board.getQnaoriginalfilename());
      out.write("\">\r\n");
      out.write("         ");
} 
      out.write("\r\n");
      out.write("         </td></tr>\r\n");
      out.write("   <tr><th>내용</th>\r\n");
      out.write("         <td><textarea rows=\"5\" cols=\"50\" name=\"bcontent\"  >");
      out.print(board.getContent());
      out.write("</textarea></td></tr>\r\n");
      out.write("   <tr><th colspan=\"2\"><input type=\"submit\" value=\" 수정하기 \"></th></tr></tbody>\r\n");
      out.write("   </table>\r\n");
      out.write("</form>\r\n");
} 
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("   <a href=\"/semi/qblist?page=1\">목록으로 이동</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script src=\"jquery/jquery.min.js\"></script>\r\n");
      out.write("   <script src=\"jquery/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("   <script src=\"jqueryintro/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("   \r\n");
      out.write("\t<!-- Footer -->\r\n");
      out.write("\t<footer class=\"py-5 bg-dark\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<p class=\"m-0 text-center text-white\">Copyright &copy; Your\r\n");
      out.write("\t\t\t\tWebsite 2018</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.container -->\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}
