/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.48
 * Generated at: 2018-01-31 11:23:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class intro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1517224153540L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1517397470805L));
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("   content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<title>Modern Business - Start Bootstrap Template</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"cssintro/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"cssintro/modern-business.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("   <!-- Navigation -->\r\n");
      out.write("   ");
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
      out.write("\r\n");
      out.write("   <header>\r\n");
      out.write("      <div id=\"carouselExampleIndicators\" class=\"carousel slide\"\r\n");
      out.write("         data-ride=\"carousel\">\r\n");
      out.write("         <ol class=\"carousel-indicators\">\r\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\"\r\n");
      out.write("               class=\"active\"></li>\r\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\r\n");
      out.write("            <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\r\n");
      out.write("         </ol>\r\n");
      out.write("         <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("            <!-- Slide One - Set the background image for this slide in the line below -->\r\n");
      out.write("            <div class=\"carousel-item active\"\r\n");
      out.write("               style=\"background-image: url('http://tong.joins.com/wp-content/uploads/sites/3/2017/04/DSC_9812_.jpg')\">\r\n");
      out.write("               <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                  <h3>장소</h3>\r\n");
      out.write("                  <p>This is a description for the first slide.</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Slide Two - Set the background image for this slide in the line below -->\r\n");
      out.write("            <div class=\"carousel-item\"\r\n");
      out.write("               style=\"background-image: url('http://www.prima.co.kr/layouts/prima/images/main/ms_img0.jpg')\">\r\n");
      out.write("               <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                  <h3>숙소</h3>\r\n");
      out.write("                  <p>This is a description for the second slide.</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Slide Three - Set the background image for this slide in the line below -->\r\n");
      out.write("            <div class=\"carousel-item\"\r\n");
      out.write("               style=\"background-image: url('https://i.ytimg.com/vi/BhgDfatZQ04/maxresdefault.jpg')\">\r\n");
      out.write("               <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                  <h3>편의시설</h3>\r\n");
      out.write("                  <p>This is a description for the third slide.</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\"\r\n");
      out.write("            role=\"button\" data-slide=\"prev\"> <span\r\n");
      out.write("            class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span> <span\r\n");
      out.write("            class=\"sr-only\">Previous</span>\r\n");
      out.write("         </a> <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\"\r\n");
      out.write("            role=\"button\" data-slide=\"next\"> <span\r\n");
      out.write("            class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span> <span\r\n");
      out.write("            class=\"sr-only\">Next</span>\r\n");
      out.write("         </a>\r\n");
      out.write("      </div>\r\n");
      out.write("   </header>\r\n");
      out.write("<div class = \"container\" height = \"300\" width = \"100%\" align = \"center\">\r\n");
      out.write("   날씨 시간 출력 div\r\n");
      out.write("</div>\r\n");
      out.write("   <!-- Page Content -->\r\n");
      out.write("   <div class=\"container\" border = \"1\">\r\n");
      out.write("\r\n");
      out.write("      <h1 class=\"my-4\" align = \"center\" color = \"gray\">BEST 3</h1>\r\n");
      out.write("\r\n");
      out.write("      <!-- Marketing Icons Section -->\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("         <div class=\"col-lg-4 mb-4\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <h4 class=\"card-header\">장소</h4>\r\n");
      out.write("               <div class=\"card-body\" align = \"center\">\r\n");
      out.write("                  <img src = \"images/tower.jpg\" width = \"100%\" height = \"220\">\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"card-footer\" align = \"center\">\r\n");
      out.write("               <b>1위</b><br>\r\n");
      out.write("                  <a href=\"#\" class=\"btn btn-primary\">롯데타워</a>\r\n");
      out.write("                  <br>\r\n");
      out.write("                  <hr color = \"lightgray\">\r\n");
      out.write("                  <b>2위&nbsp;&nbsp;&nbsp;</b><a href=\"#\" class=\"btn btn-sec\"><b>강남</b></a>\r\n");
      out.write("                  <hr color = \"lightgray\">\r\n");
      out.write("                  <b>3위&nbsp;&nbsp;&nbsp;</b><a href=\"#\" class=\"btn btn-sec\"><b>역삼</b></a>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-4 mb-4\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <h4 class=\"card-header\">편의 시설</h4>\r\n");
      out.write("               <div class=\"card-body\" align = \"center\">\r\n");
      out.write("                  <img src = \"images/res.jpg\" width = \"100%\" height = \"220\">\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"card-footer\" align = \"center\">\r\n");
      out.write("               <b>1위</b><br>\r\n");
      out.write("                  <a href=\"#\" class=\"btn btn-primary\">코코이치방야</a>\r\n");
      out.write("                  <br>\r\n");
      out.write("                  <hr color = \"lightgray\">\r\n");
      out.write("                  <b>2위&nbsp;&nbsp;&nbsp;</b><a href=\"#\" class=\"btn btn-sec\"><b>강남</b></a>\r\n");
      out.write("                  <hr color = \"lightgray\">\r\n");
      out.write("                  <b>3위&nbsp;&nbsp;&nbsp;</b><a href=\"#\" class=\"btn btn-sec\"><b>역삼</b></a>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-4 mb-4\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <h4 class=\"card-header\">숙소</h4>\r\n");
      out.write("               <div class=\"card-body\" align = \"center\">\r\n");
      out.write("                  <img src = \"images/hotel.jpg\" width = \"100%\" height = \"220\">\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"card-footer\" align = \"center\">\r\n");
      out.write("               <b>1위</b><br>\r\n");
      out.write("                  <a href=\"#\" class=\"btn btn-primary\">아만티 호텔</a>\r\n");
      out.write("                  <br>\r\n");
      out.write("                  <hr color = \"lightgray\">\r\n");
      out.write("                  <b>2위&nbsp;&nbsp;&nbsp;</b><a href=\"#\" class=\"btn btn-sec\"><b>강남</b></a>\r\n");
      out.write("                  <hr color = \"lightgray\">\r\n");
      out.write("                  <b>3위&nbsp;&nbsp;&nbsp;</b><a href=\"#\" class=\"btn btn-sec\"><b>역삼</b></a>\r\n");
      out.write("               </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("      <!-- Portfolio Section -->\r\n");
      out.write("      <h2>Portfolio Heading</h2>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("         <div class=\"col-lg-4 col-sm-6 portfolio-item\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <a href=\"#\"><img class=\"card-img-top\"\r\n");
      out.write("                  src=\"http://placehold.it/700x400\" alt=\"\"></a>\r\n");
      out.write("               <div class=\"card-body\">\r\n");
      out.write("                  <h4 class=\"card-title\">\r\n");
      out.write("                     <a href=\"#\">Project One</a>\r\n");
      out.write("                  </h4>\r\n");
      out.write("                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("                     adipisicing elit. Amet numquam aspernatur eum quasi sapiente\r\n");
      out.write("                     nesciunt? Voluptatibus sit, repellat sequi itaque deserunt,\r\n");
      out.write("                     dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-4 col-sm-6 portfolio-item\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <a href=\"#\"><img class=\"card-img-top\"\r\n");
      out.write("                  src=\"http://placehold.it/700x400\" alt=\"\"></a>\r\n");
      out.write("               <div class=\"card-body\">\r\n");
      out.write("                  <h4 class=\"card-title\">\r\n");
      out.write("                     <a href=\"#\">Project Two</a>\r\n");
      out.write("                  </h4>\r\n");
      out.write("                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("                     adipiscing elit. Nam viverra euismod odio, gravida pellentesque\r\n");
      out.write("                     urna varius vitae.</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-4 col-sm-6 portfolio-item\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <a href=\"#\"><img class=\"card-img-top\"\r\n");
      out.write("                  src=\"http://placehold.it/700x400\" alt=\"\"></a>\r\n");
      out.write("               <div class=\"card-body\">\r\n");
      out.write("                  <h4 class=\"card-title\">\r\n");
      out.write("                     <a href=\"#\">Project Three</a>\r\n");
      out.write("                  </h4>\r\n");
      out.write("                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("                     adipisicing elit. Quos quisquam, error quod sed cumque, odio\r\n");
      out.write("                     distinctio velit nostrum temporibus necessitatibus et facere\r\n");
      out.write("                     atque iure perspiciatis mollitia recusandae vero vel quam!</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-4 col-sm-6 portfolio-item\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <a href=\"#\"><img class=\"card-img-top\"\r\n");
      out.write("                  src=\"http://placehold.it/700x400\" alt=\"\"></a>\r\n");
      out.write("               <div class=\"card-body\">\r\n");
      out.write("                  <h4 class=\"card-title\">\r\n");
      out.write("                     <a href=\"#\">Project Four</a>\r\n");
      out.write("                  </h4>\r\n");
      out.write("                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("                     adipiscing elit. Nam viverra euismod odio, gravida pellentesque\r\n");
      out.write("                     urna varius vitae.</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-4 col-sm-6 portfolio-item\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <a href=\"#\"><img class=\"card-img-top\"\r\n");
      out.write("                  src=\"http://placehold.it/700x400\" alt=\"\"></a>\r\n");
      out.write("               <div class=\"card-body\">\r\n");
      out.write("                  <h4 class=\"card-title\">\r\n");
      out.write("                     <a href=\"#\">Project Five</a>\r\n");
      out.write("                  </h4>\r\n");
      out.write("                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("                     adipiscing elit. Nam viverra euismod odio, gravida pellentesque\r\n");
      out.write("                     urna varius vitae.</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-4 col-sm-6 portfolio-item\">\r\n");
      out.write("            <div class=\"card h-100\">\r\n");
      out.write("               <a href=\"#\"><img class=\"card-img-top\"\r\n");
      out.write("                  src=\"http://placehold.it/700x400\" alt=\"\"></a>\r\n");
      out.write("               <div class=\"card-body\">\r\n");
      out.write("                  <h4 class=\"card-title\">\r\n");
      out.write("                     <a href=\"#\">Project Six</a>\r\n");
      out.write("                  </h4>\r\n");
      out.write("                  <p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("                     adipisicing elit. Itaque earum nostrum suscipit ducimus nihil\r\n");
      out.write("                     provident, perferendis rem illo, voluptate atque, sit eius in\r\n");
      out.write("                     voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("      <!-- Features Section -->\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("         <div class=\"col-lg-6\">\r\n");
      out.write("            <h2>Modern Business Features</h2>\r\n");
      out.write("            <p>The Modern Business template by Start Bootstrap includes:</p>\r\n");
      out.write("            <ul>\r\n");
      out.write("               <li><strong>Bootstrap v4</strong></li>\r\n");
      out.write("               <li>jQuery</li>\r\n");
      out.write("               <li>Font Awesome</li>\r\n");
      out.write("               <li>Working contact form with validation</li>\r\n");
      out.write("               <li>Unstyled page elements for easy customization</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n");
      out.write("               Corporis, omnis doloremque non cum id reprehenderit, quisquam totam\r\n");
      out.write("               aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis\r\n");
      out.write("               quia dolorum ducimus unde.</p>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-6\">\r\n");
      out.write("            <img class=\"img-fluid rounded\" src=\"http://placehold.it/700x450\"\r\n");
      out.write("               alt=\"\">\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("      <hr>\r\n");
      out.write("\r\n");
      out.write("      <!-- Call to Action Section -->\r\n");
      out.write("      <div class=\"row mb-4\">\r\n");
      out.write("         <div class=\"col-md-8\">\r\n");
      out.write("            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n");
      out.write("               Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum\r\n");
      out.write("               neque nemo praesentium cum alias asperiores commodi.</p>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-md-4\">\r\n");
      out.write("            <a class=\"btn btn-lg btn-secondary btn-block\" href=\"#\">Call to\r\n");
      out.write("               Action</a>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("   </div>\r\n");
      out.write("   <!-- /.container -->\r\n");
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
      out.write("   <!-- Bootstrap core JavaScript -->\r\n");
      out.write("   <script src=\"jqueryintro/jquery.min.js\"></script>\r\n");
      out.write("   <script src=\"jqueryintro/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
