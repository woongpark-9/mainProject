<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장르 선택</title>
</head>
<link rel="stylesheet" href="css/member/favorite_genre.css">
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
   integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
   crossorigin="anonymous"></script>
<script>
   function myfun() {

      var a = document.getElementsByName('checkbox');
      var newvar = 0;
      var count;
      for (count = 0; count < a.length; count++) {
         if (a[count].checked == true) {
            newvar = newvar + 1;
           
         }
      }

      if (newvar > 10) {
         return false;
      }

   }
</script>

<body>
   <c:set var="prefixAddr">http://yonom.duckdns.org/movie/</c:set>

   <div class="whole">

      <div class="full-header">
         <div class="header">
            <div class="logo">
               <img alt="로고" src="images/member/LOGO.png">
            </div>
            <div class="logout">
               <div class="button">로그아웃</div>
            </div>
         </div>
      </div>

      <form action="setGenre.do" method="post">
         <div class="info-box">
            <div id="number" class="select-count">
               	선호하는 작품을 선택해주세요.
            <div class="explanation">
           		    최대 선택 개수는 10개 입니다.
            </div>
              </div>
            
            <input type="submit" class="next-button" value="제출하기">
         </div>

         <div class="wrapper-poster-list">
            <div class="container">

               <c:forEach var="movieList" items="${movieList }">
                  <label class="option_item"> <input type="checkbox"
                     name="checkbox" onclick="return myfun()" class="checkbox"
                     value="${movieList.genre_name}">
                     <div class="option_inner">
                        <div class="tickmark"></div>
                        <div class="icon">
                           <img style=" z-index:-600; width: 176px; height: 260px;" alt="돈의맛"
                              src="${prefixAddr }${movieList.movie_path }/poster2.png">
                        </div>
                     </div>
                  </label>
               </c:forEach>




            </div>
         </div>
      </form>
   </div>


</body>
</html>