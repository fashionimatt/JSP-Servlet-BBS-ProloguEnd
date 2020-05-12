<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html>
<head>
    <title>From the Prologue to the End, PrologueEnd</title>
    <style>
        * {
          box-sizing: border-box;
        }

        body {
            font-family: Arial;
            margin: 0px;
            background: white;
        }

        /* Header/Blog Title */
        .menu {
            height: 50px;
            width: 100%;
            font-size: 14px;
            padding: 0px;
            margin: 0px;
            background: black;
        }

        .menu ul{
            padding: 0px;
            margin: 0px auto;
            width: 820px;
            height: 50px;
        }

        .menu li{
            display: inline;
            float: center;
        }

        .menu a{
            color: lightgray;
            display: inline-block;
            width: 70px;
            text-align: center;
            vertical-align: middle;
            text-decoration: none;
            line-height: 50px;
        }

        #logo{
            font-weight: bold;
            color: white;
            font-size: 18px;
            margin-right: 80px;
        }

        .menu li:nth-child(2) a{
            margin-right: 15px;
        }

        .menu li:nth-child(4) a{
            margin-right: 280px;
        }

        .menu li:nth-child(5) a{
            margin-right: 15px;
        }

        #join {
            background-color: white;
            border-radius: 3px;
            height: 30px;
            width: 50px;
            line-height: 30px;
            color: black;
        }

        .menu a:hover {
            color : white;
            text-decoration : none;
        }

        #logo:hover{
            color: lightgray;
        }
        
        #content{
            margin-top: 20px;
        }
		
		.active{
			text-align: center;
		}
		
		#button{
			display: inline-block;
			text-align: center;
		}

        /* Footer */
        .footer {
          font-size: 13px;
          padding: 20px;
          text-align: center;
          background-color: white;
          margin-top: 10px;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
    <div class="menu">
        <ul>
            <li><a href="../index.jsp" id="logo">PrologueEnd</a></li>
            <li><a href="#">Lookbook</a></li>
            <li><a href="list">Notice</a></li>
            <li><a href="../about/about">About</a></li>
            <li><a href="#">Log in</a></li>
            <li><a href="../membership/joinView" id="join">Join</a></li>        
        </ul>
    </div>
    
    <div class="container" id="content">
	      <table class="table">
							<tbody>
								<tr>
									<th class="active">제목</th>
									<td colspan="3">${n.title}</td>
								</tr>
								<tr>
									<th class="active">작성일</th>
									<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${n.regdate}"/></td>
								</tr>
								<tr>
									<th class="active">작성자</th>
									<td>${n.author}</td>
									<th class="active">조회수</th>
									<td><fmt:formatNumber value="${n.cnt}" /></td>
								</tr>
								<tr>
									<th class="active">첨부파일</th>
									<td colspan="3">
									
									<c:forTokens var="fileName" items="${n.files}" delims="," varStatus="st">
										<a href="${fileName}">${fn:toUpperCase(fileName)}</a>
										<c:if test="${!st.last}">
										/
										</c:if>
									</c:forTokens>
									</td>
								</tr>
								<tr>
									<td colspan="4">${n.content}</td>
								</tr>
							</tbody>
						</table>
						
		<div class="text-center">
			<a href="update?id=${n.id}" class="btn btn-secondary">수정</a>
			<a data-toggle="modal" href="#confirm" class="btn btn-secondary" >삭제</a>
        	<a href="list" class="btn btn-secondary">목록</a>
		</div>
		
		<div class="modal" id="confirm" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">삭제 확인</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p>게시물을 삭제하시겠습니까?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" onclick="location.href='delete?id=${n.id}'" class="btn btn-primary">삭제</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
		      </div>
		    </div>
		  </div>
		</div>
		
    </div>
    
  

    <div class="footer">
        <p>&copy;2020 PrologueEnd. All rights reserved.</p>
    </div>
</body>
</html>

