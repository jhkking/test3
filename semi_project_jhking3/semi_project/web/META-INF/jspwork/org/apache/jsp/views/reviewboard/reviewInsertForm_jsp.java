/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.30
 * Generated at: 2018-02-08 07:25:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.reviewboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class reviewInsertForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/reviewboard/../../header.jsp", Long.valueOf(1518027934000L));
    _jspx_dependants.put("/views/reviewboard/../../footer.jsp", Long.valueOf(1517555554000L));
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>reviewListView</title>\r\n");
      out.write("\r\n");
      out.write("     <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"css/1-col-portfolio.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("<style>\r\n");
      out.write("button.bt{\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("\theight:40px;\r\n");
      out.write("\tborder:1px dotted #369;\r\n");
      out.write("\tborder-radius:20px;\r\n");
      out.write("\tbackground-color:#f3f6f7;\r\n");
      out.write("\tcolor:#369;\r\n");
      out.write("}\r\n");
      out.write("table.type09 {\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tline-height: 1.5;\r\n");
      out.write("\t/* width:100%; */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.type09 thead th {\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("\tcolor: #369;\r\n");
      out.write("\tborder-bottom: 3px solid #036;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.type09 tbody th {\r\n");
      out.write("\twidth: 150px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("\tborder-bottom: 1px solid #ccc;\r\n");
      out.write("\tbackground: #f3f6f7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table.type09 td {\r\n");
      out.write("\twidth: 350px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("\tborder-bottom: 1px solid #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Member member = (Member) session.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"css/1-col-portfolio.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);\r\n");
      out.write("\r\n");
      out.write("* {\r\n");
      out.write("\tfont-family: 'Nanum Pen Script', cursive;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\tborder-collapse: separate;\r\n");
      out.write("\tborder-spacing: 0px 4px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".modal-dialog {\r\n");
      out.write("\twidth: 450px;\r\n");
      out.write("\theight: 350px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);\r\n");
      out.write("\r\n");
      out.write(".npss {\r\n");
      out.write("\tfont-family: 'Nanum Pen Script', cursive;\r\n");
      out.write("\tfont-size: 25px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".nps {\r\n");
      out.write("\tfont-family: 'Nanum Pen Script', cursive;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a.linkcolor {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #888;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("a.linkcolor:hover {\r\n");
      out.write("\tcolor:#369;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav\r\n");
      out.write("\t\tclass=\"navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<a class=\"navbar-brand npss\" href=\"intro.jsp\">WhybiS</a>\r\n");
      out.write("\t\t\t<button class=\"navbar-toggler navbar-toggler-right\" type=\"button\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#navbarResponsive\"\r\n");
      out.write("\t\t\t\taria-controls=\"navbarResponsive\" aria-expanded=\"false\"\r\n");
      out.write("\t\t\t\taria-label=\"Toggle navigation\">\r\n");
      out.write("\t\t\t\t<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse nps\" id=\"navbarResponsive\">\r\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/semi/intro.jsp\">HOME</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\">\r\n");
      out.write("\t\t\t\t\t\t");

							if (member != null) {
						
      out.write(" <a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/semi/vrimg?place=홍대&title=홍대정문&userid=");
      out.print(member.getSmemberId());
      out.write("&bno=23\">PLACE</a>\r\n");
      out.write("\t\t\t\t\t\t");

							} else {
						
      out.write(" <a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"javascript:alert('회원만 사용 가능 합니다 !\\n로그인을 해주세요!');\">PLACE</a>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t");

						if (member != null) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/semi/bestplace?page=1\">BEST</a></li>\r\n");
      out.write("\t\t\t\t\t");

						} else {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/semi/bestplace?page=1\">BEST</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"\" id=\"navbarDropdownBlog\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">BOARD</a>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-menu dropdown-menu-right\"\r\n");
      out.write("\t\t\t\t\t\t\taria-labelledby=\"navbarDropdownBlog\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"/semi/rblist?page=1\">리뷰 게시판</a>\r\n");
      out.write("\t\t\t\t\t\t\t");

								if ((member != null && member.getSmemberWorkerYN().equals("y"))
										|| (member != null && member.getSmemberAdminYN().equals("y"))) {
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"/semi/wblist?page=1\">사업자게시판</a>\r\n");
      out.write("\t\t\t\t\t\t\t");

								} else {
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"javascript:alert('사업자와 관리자만 게시판 열람 가능합니다 !');\">사업자게시판</a>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/semi/nlist?page=1\"> NOTICE </a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/semi/qlist?page=1\"> Q&A </a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t\t\t\t\t");

							if (member == null) { //로그인하지 않았다면
						
      out.write(" <a class=\"nav-link dropdown-toggle\" href=\"\"\r\n");
      out.write("\t\t\t\t\t\tid=\"navbarDropdownBlog\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\t\taria-haspopup=\"true\" aria-expanded=\"false\"> MY PAGE </a>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-menu dropdown-menu-right\"\r\n");
      out.write("\t\t\t\t\t\t\taria-labelledby=\"navbarDropdownBlog\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"javascript:alert('로그인이 필요합니다!');\">내\r\n");
      out.write("\t\t\t\t\t\t\t\t정보 보기 및 수정</a> <a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"javascript:alert('로그인이 필요합니다!');\">나의 관심 장소 보기</a> <a\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-item\" href=\"javascript:alert('로그인이 필요합니다!');\">내가\r\n");
      out.write("\t\t\t\t\t\t\t\t쓴 글 보기</a>\r\n");
      out.write("\t\t\t\t\t\t</div> ");

 	} else {
 
      out.write(" <a class=\"nav-link dropdown-toggle\" href=\"\" id=\"navbarDropdownBlog\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t\t\tMY PAGE </a>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-menu dropdown-menu-right\"\r\n");
      out.write("\t\t\t\t\t\t\taria-labelledby=\"navbarDropdownBlog\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/semi/myinfo?userid=");
      out.print(member.getSmemberId());
      out.write("\">내 정보\r\n");
      out.write("\t\t\t\t\t\t\t\t보기 및 수정</a> <a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/semi/mlikeplacelist?userid=");
      out.print(member.getSmemberId());
      out.write("\">나의\r\n");
      out.write("\t\t\t\t\t\t\t\t관심 장소 보기</a> <a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/semi/rmblist?myId=");
      out.print(member.getSmemberId());
      out.write("\">내가 쓴 글\r\n");
      out.write("\t\t\t\t\t\t\t\t보기</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div> ");

 	}
 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					if (member == null) { //로그인하지 않았다면
				
      out.write("\r\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#myModal\"> LOGIN </a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"views/member/JoinworkerCheck.jsp\"> JOIN </a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#myModal\"> <font color=\"white\"><b>");
      out.print(member.getSmemberName());
      out.write("</b>\r\n");
      out.write("\t\t\t\t\t\t\t\t님</font></a></li> &nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/semi/logout\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					if (member.getSmemberId().equals("admin01")) {
				
      out.write("\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;<a href=\"/semi/mlist?page=1\" class=\"linkcolor\">회원 정보\r\n");
      out.write("\t\t\t\t\t전체보기</a>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t");

				if (member != null && member.getSmemberId().equals("admin01")) {
			
      out.write("\r\n");
      out.write("\t\t\t<a href=\"/semi/views/vrBoard/workerWriter.jsp\"><input\r\n");
      out.write("\t\t\t\ttype=\"submit\" class=\"btn btn-primary\" value=\"사업자 글 올리기\"></a> <a\r\n");
      out.write("\t\t\t\thref=\"/semi/vrworkerlist?page=1\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\tclass=\"btn btn-primary\" value=\"올린 글 목록 보기\"></a> <br> <br>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div align=\"center\" id=\"divv\">\r\n");
      out.write("\t\t\t<form action=\"/semi/searchall\">\r\n");
      out.write("\t\t\t\t<select name=\"searchoption\">\r\n");
      out.write("\t\t\t\t\t<option value=\"all\">검색 옵션</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"명소\">장소</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"편의시설\">편의 시설</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"숙소\">숙소</option>\r\n");
      out.write("\t\t\t\t</select> &nbsp;&nbsp;&nbsp; <input type=\"hidden\" name=\"page\" value=\"1\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"searchkey\"> &nbsp;&nbsp; <input\r\n");
      out.write("\t\t\t\t\ttype=\"submit\" class=\"btn btn-primary\" value=\"검색\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<Br>\r\n");
      out.write("\t<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">로그인</h4>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">×</span><span class=\"sr-only\">Close</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--모달 바디-->\r\n");
      out.write("\t\t\t\t<form action=\"login\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<table width=\"250\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>아이디</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"userid\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>암 호</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"password\" name=\"userpwd\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\"><a href=\"#\">아이디/암호 찾기</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\"><a href=\"#\">회원가입</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">로그인</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<!--    <script src=\"http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg\"></script>\r\n");
      out.write("   ie10-viewport-bug-workaround.js\r\n");
      out.write("   <script src=\"http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg\"></script> -->\r\n");
      out.write("\t<!-- holder.js -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<h2 align=\"center\">리뷰 작성</h2>\r\n");
      out.write("<hr style=\"clear:both;\"><br>\r\n");
      out.write("<!--그냥 전송했을 때는 request로 받지만 multipart로 전송시에는 multipart로 받음  -->\r\n");
      out.write("<form action=\"/semi/rinsert\" method=\"post\"  enctype=\"multipart/form-data\">\r\n");
      out.write("\t<table class=\"type09\" align=\"center\" width=\"90%\" cellspacing=\"0\" border=\"1\">\r\n");
      out.write("\t<tr><th>제목</th>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"btitle\"></td></tr>\r\n");
      out.write("\t<tr><th>작성자</th>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"bwriter\" readonly value=\"");
      out.print( member.getSmemberId() );
      out.write("\"></td></tr>\r\n");
      out.write("\t<tr><th>첨부파일</th>\r\n");
      out.write("\t\t\t<td><input type=\"file\" name=\"bupfile\"></td></tr>\r\n");
      out.write("\t<tr><th>내용</th>\r\n");
      out.write("\t\t\t<td><textarea rows=\"5\" cols=\"50\" name=\"bcontent\"></textarea></td></tr>\r\n");
      out.write("\t<tr><th id=\"c\"colspan=\"2\"><input type=\"submit\" value=\" 등록하기 \" width=\"200px\"></th></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);\r\n");
      out.write("p{ font-family: 'Nanum Pen Script', cursive; font-size:30px; }\r\n");
      out.write("</style>\r\n");
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
