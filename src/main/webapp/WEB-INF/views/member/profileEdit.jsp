<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="position-relative" id="bodyContents" align="center"
   style="top: 5%;">
   <div class="col-md-5 mb-5">
      <div class="page-header col-md-12" align="left"
         style="color: white; font-size: 4vw; border-bottom: 1px solid grey;">프로필
         변경</div>
      <div class="col-md-12 mt-3" style="border-bottom: 1px solid grey;">
         <div class="row position-relative"
            style="height: 65%; width: 100%; padding: 0px;">
            <div class="proImg" style="height: 100%; width: 30%;">
               <a href="#" class="profileEdit"
                  onclick="acyncMovePage3('http://localhost:8080/nowflix/selectProfileImg.do', ${selectProfile.profile_id}, editname.value, '${selectProfile.profile_img }', '${selectProfile.kids}')">
                  <img class="img-responsive img-rounded profileImg"
                  src="${selectProfile.profile_img }"> <c:if
                     test="${selectProfile.kids  == 'Y'}">
                     <img class="img-responsive kids2"
                        src="http://yonom.duckdns.org/images/profile/kids.png">
                  </c:if>
               </a>

            </div>
            <div class="" style="width: 70%;">
               <div
                  style="width: auto; height: 30%; border-bottom: 1px solid grey;">
                  <input type="text" class="editname"
                     value="${selectProfile.profile_name }" id="editname"
                     style="font-size: 1.5vw;">
                  <input type="hidden" value="${ selectProfile.genre_name}" name="genre-hidden" id="genre-hidden">
               </div>
               <div align="left"
                  style="height: 40%; border-bottom: 1px solid grey;">
                  <c:if test="${selectProfile.kids  == 'Y'}">
                     <input type="checkbox" id="kidBox" class="kidbox" checked>
                     <input type="hidden" value="Y" name="kidhidden" id="kidhidden">
                  </c:if>
                  <c:if test="${selectProfile.kids  == 'N'}">
                     <input type="checkbox" id="kidBox" class="kidbox">
                     <input type="hidden" value="N" name="kidhidden" id="kidhidden">
                  </c:if>
                  <label for="kidBox"></label> <span class="kidBox" role="checkbox"
                     aria-checked="false" tabindex="0"
                     style="font-size: 1vw; color: white;">어린이인가요?</span>
                  <script>
                     $(document).ready(function(){
                         $("#kidBox").change(function(){
                             if($("#kidBox").is(":checked")){
                                $('input[name=kidhidden]').attr('value','Y');
                                $(".profileEdit").append("<img class='kids2' src='http://yonom.duckdns.org/images/profile/kids.png'>");
                             }else{
                                $('input[name=kidhidden]').attr('value','N');
                                $(".kids2").remove();
                             }
                         });
                     });
                  </script>
               </div>
               <div style="height: 25%;" align="left">
                  <div>
                     <div style="color: grey; font-size: 1.5vw;">자동 재생 설정</div>
                     <div style="color: grey; font-size: 1.1vw;">
                        <input type="checkbox" id="kidBox"> <label for="kidBox"></label>
                        <span class="kidBox" role="checkbox" aria-checked="false"
                           tabindex="1">모든 디바이스에서 시리즈의 다음 화 자동 재생</span>
                     </div>
                     <div style="color: grey; font-size: 1.1vw;">
                        <input type="checkbox" id="kidBox"> <label for="kidBox"></label>
                        <span class="kidBox" role="checkbox" aria-checked="false"
                           tabindex="1">모든 디바이스에서 탐생 중 미리보기 자동 재생</span>
                     </div>
                  </div>
               </div>
            </div>
            <div class="mt-5" align="left">
               <a href="#" class="next"
                  onclick="acyncMovePage3('http://localhost:8080/nowflix/updateProfileEdit.do', ${selectProfile.profile_id}, editname.value, '${selectProfile.profile_img }', kidhidden.value)">저장</a>
               <a href="#" class="cancel"
                  onclick="acyncMovePage2('http://localhost:8080/nowflix/profile.do')">취소</a>
               <a href="#" class="delete"
                  onclick="acyncMovePage4('http://localhost:8080/nowflix/deleteProfile.do', ${selectProfile.profile_id})">삭제</a>
            </div>
         </div>
      </div>
   </div>
</div>