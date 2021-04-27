<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CDN 방식의 링크 연결  -->
<!-- 보고 따라한 곳(밑에 링크)   -->
<!-- https://blog.edit.kr/entry/Bootstrap-4-%EB%8B%AC%EB%A0%A5-datetimepicker-Bootstrap-3%EB%B2%84%EC%A0%84-%EC%97%85%EA%B7%B8%EB%A0%88%EC%9D%B4%EB%93%9C-%EB%B2%84%EC%A0%84-%EC%9D%B8%EA%B8%B0-%EB%8B%AC%EB%A0%A5 -->
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
<link rel="stylesheet"
   href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />
<!-- CDN 방식의 링크 연결  -->


<!-- 캘린더 부분 스크립트 -->
<script type="text/javascript">
   $(function() {
      $('#datetimepicker1').datetimepicker({
         format : 'L' //포멧에 L들어오면 날짜만 표시되도록 함.
      });
      $('#datetimepicker2').datetimepicker({
         format : 'L', //포멧에 L들어오면 날짜만 표시되도록 함.
         useCurrent : false
      //여기 true로 하면 날짜 지정 안됨.

      });
      $("#datetimepicker1").on("change.datetimepicker", function(e) {
         $('#datetimepicker2').datetimepicker('minDate', e.date);
      });
      $("#datetimepicker2").on("change.datetimepicker", function(e) {
         $('#datetimepicker1').datetimepicker('maxDate', e.date);
      });
   });
</script>
<!-- 캘린더 부분 자바스크립트 -->


</head>
<body>

   <section>
      <div class="container-fluid">
         <div class="row mb-5">
            <div class="col-xl-10 col-lg-9 col-md-8 ml-auto">
               <div class="col-12">
                  <h3 class="text-muted text-center mb-3">판매 관리</h3>
               </div>






               <div class="row">

                  <!-- time -->
                  <div class='col-md-3 col-xs-4'>
                     <div class="form-group">
                        <div class="input-group date" id="datetimepicker1"
                           data-target-input="nearest">
                           <input type="text" class="form-control datetimepicker-input"
                              data-target="#datetimepicker1" value="">
                           <div class="input-group-append" data-target="#datetimepicker1"
                              data-toggle="datetimepicker">
                              <div class="input-group-text">
                                 <i class="fa fa-calendar"></i>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class='col-md-3 col-xs-4'>
                     <div class="form-group">
                        <div class="input-group date" id="datetimepicker2"
                           data-target-input="nearest">
                           <input type="text" class="form-control datetimepicker-input"
                              data-target="#datetimepicker2" value="">
                           <div class="input-group-append" data-target="#datetimepicker2"
                              data-toggle="datetimepicker">
                              <div class="input-group-text">
                                 <i class="fa fa-calendar"></i>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  
                  
                  <div class="col-7">
                     <button type="button" class="btn btn-info btn-sm">COPY</button>
                     <button type="button" class="btn btn-info btn-sm">EXCEL</button>
                     <button type="button" class="btn btn-info btn-sm">PDF</button>
                     <button type="button" class="btn btn-info btn-sm">Print</button>
                  </div>

                  <div class="col-5">
                     <form action="">

                        <div class="input-group">
                           <input type="text" class="form-control search-input"
                              placeholder="검색어 입력">
                           <button type="button" class="btn btn-light search-button">
                              <i class="fas fa-search text-danger"></i>
                           </button>
                        </div>

                     </form>

                  </div>
               </div>
               <table
                  class="table bg-light text-center table-bordered table-striped">
                  <thead>
                     <tr class="text-muted">
                        <th>#</th>
                        <th>상태</th>
                        <th>이메일</th>
                        <th>이용권</th>
                        <th>결제금액</th>
                        <th>결제일</th>
                        <th>만료일</th>
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <th>1</th>
                        <th>이용중</th>
                        <th>test@naver.com</th>
                        <th>정기권_1</th>
                        <th>&#8361;7,900</th>
                        <th>2021-04-08</th>
                        <th>2021-10-08</th>
                     </tr>
                     <tr>
                        <th>1</th>
                        <th>이용중</th>
                        <th>test@naver.com</th>
                        <th>정기권_2</th>
                        <th>&#8361;7,900</th>
                        <th>2021-04-08</th>
                        <th>2021-10-08</th>
                     </tr>
                     <tr>
                        <th>1</th>
                        <th>이용중</th>
                        <th>test@naver.com</th>
                        <th>정기권_3</th>
                        <th>&#8361;7,900</th>
                        <th>2021-04-08</th>
                        <th>2021-10-08</th>
                     </tr>
                  </tbody>
               </table>

               <!-- page 1번 2 번 3번 이동하는 거임.-->
               <nav>
                  <ul class="pagination justify-content-center">
                     <li class="page-item"><a href="#"
                        class="page-link py-2 px-3"> <span>&laquo;</span>
                     </a></li>

                     <!-- 페이지 정보 추가 -->
                     <li class="page-item active"><a href="#"
                        class="page-link py-2 px-3">1</a></li>
                     <li class="page-item"><a href="#"
                        class="page-link py-2 px-3">2</a></li>
                     <li class="page-item"><a href="#"
                        class="page-link py-2 px-3">3</a></li>

                     <li class="page-item"><a href="#"
                        class="page-link py-2 px-3"> <span>&raquo;</span>
                     </a></li>
                  </ul>
               </nav>
            </div>
         </div>
      </div>
      </div>
   </section>
</body>
</html>

