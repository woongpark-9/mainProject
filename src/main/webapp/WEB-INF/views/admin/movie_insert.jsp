<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="header.jsp" %>
<script type="text/javascript">
   $(document).ready(
         function() {
            $("#fileInput").on(
                  'change',
                  function() {
                     if (window.FileReader) {
                        var fileName = $(this)[0].files[0].name;
                     } else {
                        var fileName = $(this).val().split('/').pop()
                              .split('\\').pop();
                     }
                     $("#posterFile").val(fileName);
                  });
         });
</script>
</head>
<body>
   <section>
      <div class="container-fluid">
         <div class="row mb-5">
            <div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
               <div>
                  <button type="button" class="btn btn-info btn-sm" onclick="acyncMovePage('manage_movie.mdo')">뒤로가기</button>

                  <section>
                     <div class="col-12 justify-content-center">
                        <h3 class="text-muted text-center mb-3">
                        	영화
                           <c:if test="${movieModifyInfo eq null }"> 등록</c:if>
                           <c:if test="${movieModifyInfo ne null }"> 수정</c:if>
                        </h3>
                     </div>
                     <div class="container-fluid">
                        <div class="row">
                           <div class="col-xl-10 col-lg-9 col-md-8 ml-auto">

                              <!-- card 전체 div -->
                              <form name="insertMovieForm" id="insertMovieForm">
                              <c:if test="${movieModifyInfo ne null }">
                              	<input type="hidden" id="seq" name="seq" value="${movieModifyInfo.seq }">
                              </c:if>
                                 <div class="row pt-md-5 mt-md-3 mb-5">

                                    <div class="col-xl-3 col-sm-6 p-2">
                                       <div class="card card-common">
                                          <div class="card-body">
                                             <div class="d-flex">
                                                <div class="text-left text-secondary">
                                                   <div>
                                                      <label for="title">제목</label> <input type="text"
                                                         class="form-control" id="title" name="title"
                                                         value="${movieModifyInfo.title }">
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="movie_rating">연령 제한</label> <select
                                                         class="form-control" id="movie_rating"
                                                         name="movie_rating"
                                                         value="${movieModifyInfo.movie_rating }">
                                                         <option selected value="전체">전체 관람가</option>
                                                         <option value="12">12세 이상 관람가</option>
                                                         <option value="15">15세 이상 관람가</option>
                                                         <option value="19">19세 이상 관람가</option>
                                                      </select>
                                                   </div>
                                                   <br>
                                                   <div class="form-group">
                                                      <label for="summary">줄거리</label>
                                                      <textarea class="form-control rounded-0" id="summary"
                                                         name="summary" rows="3">${movieModifyInfo.summary }</textarea>
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="director">감독</label> <select
                                                         class="form-control" id="director" name="director"
                                                         value="${movieModifyInfo.director }">
                                                         <option selected value="1">스티븐 스필버그</option>
                                                         <option value="2">봉준호</option>
                                                         <option value="3">정이삭</option>
                                                         <option value="4">이준익</option>
                                                      </select>
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="actor">배우</label> <select
                                                         class="form-control" id="actor" name="actor"
                                                         value="${movieModifyInfo.actor }">
                                                         <option selected value="1">송강호</option>
                                                         <option value="2">윤여정</option>
                                                         <option value="3">최우식</option>
                                                         <option value="4">설경구</option>
                                                      </select>
                                                   </div>
                                                   <br>
                                                </div>
                                             </div>

                                          </div>

                                       </div>
                                    </div>
                                    <div class="col-xl-3 col-sm-6 p-2">
                                       <div class="card card-common">
                                          <div class="card-body">
                                             <div class="d-flex">
                                                <div class="text-left text-secondary">
                                                   <div>
                                                      <label for="genre1">장르1</label> <input type="text"
                                                         class="form-control" id="genre1" name="genre1"
                                                         value="${movieModifyInfo.genre1 }">
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="genre2">장르2</label> <input type="text"
                                                         class="form-control" id="genre2" name="genre2"
                                                         value="${movieModifyInfo.genre2 }">
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="country">국가</label> <select
                                                         class="form-control" id="country" name="country"
                                                         value="${movieModifyInfo.country }">
                                                         <option selected value="1">한국</option>
                                                         <option value="2">미국</option>
                                                         <option value="3">영국</option>
                                                         <option value="4">일본</option>
                                                      </select>
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="movie_release_date">개봉연도</label> <select
                                                         class="form-control" id="movie_release_date"
                                                         name="movie_release_date">
                                                         <option selected
                                                            value="${movieModifyInfo.movie_release_date }">${movieModifyInfo.movie_release_date}년</option>
                                                         <option value="2">2018년</option>
                                                         <option value="3">2019년</option>
                                                         <option value="4">2020년</option>
                                                         <option value="5">2021년</option>
                                                      </select>
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="poster_path">포스터</label> <input
                                                         type="text" class="form-control" id="poster_path"
                                                         name="poster_path"
                                                         value="${movieModifyInfo.poster_path }">
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="teaser_path">티져 영상</label> <input
                                                         type="text" class="form-control" id="teaser_path"
                                                         name="teaser_path"
                                                         value="${movieModifyInfo.teaser_path }">
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="movie_path">본 영상</label> <input
                                                         type="text" class="form-control" id="movie_path"
                                                         name="movie_path"
                                                         value="${movieModifyInfo.movie_path }">
                                                   </div>
                                                   <br>
                                                   <!--                                                 <div class="form-group"> -->
                                                   <!--                                                    <label for="poster">포스터</label> -->
                                                   <!--                                                    <input id="fileInput" filestyle="" type="file" data-class-button="btn btn-default" data-class-input="form-control" data-button-text="" data-icon-name="fa fa-upload" class="form-control" tabindex="-1" style="position: absolute; clip: rect(0px 0px 0px 0px);"> -->
                                                   <!--                                                    <div class="bootstrap-filestyle input-group"> -->
                                                   <!--                                                       <input type="text" id="posterFile" class="form-control" name="posterFile" disabled="disabled"> -->
                                                   <!--                                                       <span class="group-span-filestyle input-group-btn" tabindex="0"> -->
                                                   <!--                                                          <label for="fileInput" class="btn btn-default"> -->
                                                   <!--                                                             <span class="glyphicon fa fa-upload"></span> -->
                                                   <!--                                                          </label> -->
                                                   <!--                                                       </span> -->
                                                   <!--                                                    </div> -->
                                                   <!--                                                 </div> -->
                                                   <!--                                                 <div class="form-group"> -->
                                                   <!--                                                    <label for="teaser">티져 영상</label> -->
                                                   <!--                                                    <input id="fileInput" filestyle="" type="file" data-class-button="btn btn-default" data-class-input="form-control" data-button-text="" data-icon-name="fa fa-upload" class="form-control" tabindex="-1" style="position: absolute; clip: rect(0px 0px 0px 0px);"> -->
                                                   <!--                                                    <div class="bootstrap-filestyle input-group"> -->
                                                   <!--                                                       <input type="text" id="teaserFile" class="form-control" name="teaserFile" disabled="disabled"> -->
                                                   <!--                                                       <span class="group-span-filestyle input-group-btn" tabindex="0"> -->
                                                   <!--                                                          <label for="fileInput" class="btn btn-default"> -->
                                                   <!--                                                             <span class="glyphicon fa fa-upload"></span> -->
                                                   <!--                                                          </label> -->
                                                   <!--                                                       </span> -->
                                                   <!--                                                    </div> -->
                                                   <!--                                                 </div> -->
                                                   <!--                                                 <div class="form-group"> -->
                                                   <!--                                                    <label for="video">본 영상</label> -->
                                                   <!--                                                    <input id="fileInput" filestyle="" type="file" data-class-button="btn btn-default" data-class-input="form-control" data-button-text="" data-icon-name="fa fa-upload" class="form-control" tabindex="-1" style="position: absolute; clip: rect(0px 0px 0px 0px);"> -->
                                                   <!--                                                    <div class="bootstrap-filestyle input-group"> -->
                                                   <!--                                                       <input type="text" id="videoFile" class="form-control" name="videoFile" disabled="disabled"> -->
                                                   <!--                                                       <span class="group-span-filestyle input-group-btn" tabindex="0"> -->
                                                   <!--                                                          <label for="fileInput" class="btn btn-default"> -->
                                                   <!--                                                             <span class="glyphicon fa fa-upload"></span> -->
                                                   <!--                                                          </label> -->
                                                   <!--                                                       </span> -->
                                                   <!--                                                    </div> -->
                                                   <!--                                                 </div> -->

                                                </div>
                                             </div>

                                          </div>

                                       </div>
                                    </div>
                                    <div class="col-xl-3 col-sm-6 p-2">
                                       <div class="card card-common">
                                          <div class="card-body">
                                             <div class="d-flex">
                                                <div class="text-left text-secondary">
                                                   <div>
                                                      <label for="movie_runningtime">상영 시간</label> <input
                                                         type="text" class="form-control"
                                                         id="movie_runningtime" name="movie_runningtime"
                                                         value="${movieModifyInfo.movie_runningtime }">
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="is_active">활성화 여부</label> <select
                                                         class="form-control" id="is_active" name="is_active"
                                                         value="${movieModifyInfo.is_active }">
                                                         <option selected value="1">비활성화</option>
                                                         <option value="2">활성화</option>
                                                      </select>
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="is_main">메인 지정 여부</label> <select
                                                         class="form-control" id="is_main" name="is_main"
                                                         value="${movieModifyInfo.is_main }">
                                                         <option selected value="1">NO</option>
                                                         <option value="2">YES</option>
                                                      </select>
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <label for="subtitle">소제목</label> <input type="text"
                                                         class="form-control" id="subtitle" name="subtitle"
                                                         value="${movieModifyInfo.subtitle }">
                                                   </div>
                                                   <br>
                                                   <div>
                                                      <c:if test="${movieModifyInfo == null}">
                                                         <button type="button" class="btn btn-success btn-sm" onclick="acyncInsertMovie('movieInsert.mdo')">등록하기</button>
                                                      </c:if>
                                                      <c:if test="${movieModifyInfo != null}">
                                                         <button type="button" class="btn btn-success btn-sm" onclick="acyncModifyMovie('movieModify.mdo')">수정하기</button>
                                                      </c:if>
                                                      <button type="button" class="btn btn-danger btn-sm" onclick="acyncMovePage('manage_movie.mdo')">취소</button>
                                                   </div>
                                                </div>
                                             </div>

                                          </div>

                                       </div>
                                    </div>

                                 </div>
                              </form>
                              <!-- card 전체 div 끝 -->
                           </div>
                        </div>
                     </div>
                  </section>
               </div>

            </div>
         </div>
      </div>
   </section>

</body>
</html>