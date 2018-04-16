<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>JOIN_member</title>
<style>
   table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table.type09 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
table.type09 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
table.type09 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
button#btn11{
   border : 1px solid skyblue;
   color: white;
    text-align: center;
    background: #007bff;
    border-radius: 12px;
}
</style>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">

</head>

<body>

   <!-- Navigation -->
   <%@ include file="../../header.jsp"%>

   <!-- Page Content -->
   <div class="container">

      <!-- Page Heading -->
      <h1 class="my-4">
         회원가입 <small>사용자</small>
         <hr color = "gray">
      </h1>
      <br><br>
      <div align = "center">
   <div class="col-md-7">
      <form action="/semi/minsert" method="post">
         <table width="90%" class="type09">
            <tr align = "center">
               <th colspan="2">회원 가입 양식</th>
            </tr>
            <tr>
               <th>1. 아이디
               </th>
               <td><input type="text" name="smemberId">
               &nbsp;&nbsp;&nbsp;
                  <button id = "btn11">중복확인</button></td>
            </tr>
            <tr>
               <th>2. 비밀번호</th>
               <td><input type="password" name="smemberPwd"
                  placeholder="ex)영문 + 숫자 6자리이상"></td>
            </tr>
            <tr>
               <th>3. 비밀번호 힌트</th>
               <td><select name="smemberPwdHint">
                     <option>비밀번호 찾기용 힌트선택</option>
                     <option>좋아하는 숫자는?</option>
                     <option>제일 좋아하는 것은?</option>
                     <option>내가 살던 동네는?</option>
               </select></td>
            </tr>
            <tr>
               <th>4. 비밀번호 힌트답</th>
               <td><input type="text" name="smemberPwdAns"></td>
            </tr>
            <tr>
               <th>5. 성 명</th>
               <td><input type="text" name="smemberName"></td>
            </tr>
            <tr>
               <th>6. 주민등록번호(앞6자리)</th>
               <td><input type="text" maxlength="6" size="6"
                  name="smemberIdNumber"></td>
            </tr>
            <tr>
               <th>7. 주 소</th>
               <td><input type="text" name="smemberAddress"></td>
            </tr>
            <tr>
               <th>8. 성 별</th>
               <td><input type="radio" name="smemberGender" value="남"> 남 <input
                  type="radio" name="smemberGender" value="여"> 여</td>
            </tr>
            <tr>
               <th>9. 연락처</th>
               <td><select name="smemberPhone">
                     <option value="010">010</option>
                     <option value="011">011</option>
                     <option value="016">016</option>
                     <option value="017">017</option>
                     <option value="019">019</option>
               </select> 
                  - <input type="text" name="smemberPhone1" maxlength="4" size="4" /> 
                  - <input type="text" name="smemberPhone2" maxlength="4" size="4" />
               </td>
            </tr>

            <tr>
               <th>10. 이메일</th>
               <td><input type="email" name="smemberEmail"></td>
            </tr>
            <tr>
               <th>11. 회원분류</th>
               <td><input type="radio" name="smemberYN" value="y"> 사업자
                   <input type="radio" name="smemberYN" value="n"> 일반
               </td>
            </tr>
         </table>
         <br><br>
         <input type="submit" class="btn btn-primary" value="가입하기">
        <input type="button" class="btn btn-primary" onclick="location.href='javascript:history.go(-1);'" value="취소하기">
   
         <!-- <a class="btn btn-primary" href="#">가입</a>
         <a class="btn btn-primary" href="javascript:history.go(-1);">취소</a> -->
      </form>
<br><br><br><br><br><br>
</div>
</div>

      <!-- Footer -->
      <%@ include file="../../footer.jsp"%>


</body>

</html>