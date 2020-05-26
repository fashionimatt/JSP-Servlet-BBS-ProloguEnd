<%@page import="com.pe.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
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

        .menu li:nth-child(3) a{
            margin-right: 280px;
        }

        .menu li:nth-child(4) a{
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
        
        .container{
            margin-top: 20px;
        }

        #searchRow{
       		margin-bottom: 10px;
        }
        
        #searchRow .form-group:first-child{
        	margin-right: 5px;
        }

        #searchRow .form-group:nth-child(2){
        	margin-right: 5px;
        }
        
        /* Footer */
        .footer {
          font-size: 13px;
          padding: 20px;
          text-align: center;
          background-color: white;
          margin-top: 10px;
        }
        
        #title a{
        	color: black;
        }
        
        #title a:hover{
        	color: darkgray;
        	text-decoration: none;
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
            <li><a href="${root }" id="logo">PrologueEnd</a></li>
            <li><a href="${root }about/about">About</a></li>
            <li><a href="${root }notice/list">Notice</a></li>
            <li><a href="#">Log in</a></li>
            <li><a href="${root }membership/joinView" id="join">Join</a></li>        
        </ul>
    </div>
    
    <div class="container">
	
	    <form class="form-inline float-right" id="searchRow">
				<div class="form-group">
					<select class="form-control" name="f">
						<option ${(param.f == "title")?"selected":""} value="title">제목</option>
						<option ${(param.f == "author")?"selected":""} value="author">작성자</option>
					</select>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="q" value="${param.q}">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-secondary">검색</button>
				</div>
	    </form>
    
    
        <table class="table table-hover">
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody>
            
          <%--   <%
            List<Notice> list = (List<Notice>)request.getAttribute("list");
            for( Notice n : list) { 
            	pageContext.setAttribute("n", n);
            %> --%>
            
            <c:forEach var="n" items="${list}">
	            <tr>
	                <td>${n.id}</td>                   
	                <td id="title"><a href="detail?id=${n.id}">${n.title}</a></td>                   
	                <td>${n.author}</td>                   
	                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regdate}"/></td>                   
	                <td><fmt:formatNumber value="${n.cnt}"/></td>                   
	            </tr>
            </c:forEach>
			
			<%-- <% } %> --%>	           
	        
	        
            </tbody>
        </table>
	    
	    <div class="text-right">
			<a href="write" type="button" class="btn btn-secondary">글쓰기</a>	    
        </div>
        
        <div class="d-flex justify-content-center">
        
        <c:set var="page" value="${(empty param.p == null)?1:param.p }"/>
        <c:set var="startNum" value="${page-(page-1)%5}"/>
        <c:set var="lastNum" value="2"/>
        
            <ul class="pagination">
	            
	            <c:if test="${startNum<=1}">
            	<li class="page-item">
	            	<a class="page-link" data-toggle="modal" href="#prevModal" aria-label="Next" style="color:black;">
	            		<span aria-hidden="true">&laquo;</span>
	            	</a>
	            </li>
	            </c:if>

				<c:if test="${startNum>1}">
            	<li class="page-item">
	            	<a class="page-link" href="?p=${startNum-1}&f=&q=" aria-label="Next" style="color:black;">
	            		<span aria-hidden="true">&laquo;</span>
	            	</a>
	            </li>
				</c:if>	            
            	
            	<c:if test="${lastNum>=5}">
	            	<c:forEach var="i" begin="0" end="4">
    	        	<li class="page-item"><a class="page-link" href="?p=${startNum+i}&f=${param.f}&q=${param.q}" style="color:black;">${startNum+i}</a></li>            
        	    	</c:forEach>
            	</c:if>
            	
            	<c:if test="${lastNum<5}">
	            	<c:forEach var="i" begin="0" end="${lastNum-1}">
    	        	<li class="page-item"><a class="page-link" href="?p=${startNum+i}&f=${param.f}&q=${param.q}" style="color:black;">${startNum+i}</a></li>            
        	    	</c:forEach>
            	</c:if>
            	
            	<c:if test="${startNum+5<lastNum}">
	            <li class="page-item">
	            	<a class="page-link" href="?p=${startNum+5}&t=&q=" aria-label="Next" style="color:black;">
	            		<span aria-hidden="true">&raquo;</span>
	            	</a>
	            </li>
            	</c:if>	


				<c:if test="${startNum+5>=lastNum}">
	            <li class="page-item">
	            	<a class="page-link" data-toggle="modal" href="#nextModal" style="color:black;">
	            		<span aria-hidden="true">&raquo;</span>
	            	</a>
	            </li>
				</c:if>	            
				
            </ul>
        </div>
        
		<div id="nextModal" tabindex="-1" class="modal fade" role="dialog">
		 	<div class="modal-dialog modal-dialog-centered" role="document">
		 		<div class="modal-content">
		 			<div class="modal-header">
		 				<h4 class="modal-title" style="text-align:center">Example</h4>
		 				<button type="button" class="close" data-dismiss="modal">&times;</button>
		       		</div>
		       		<div class="modal-body">
		       			<p>다음 페이지가 없습니다</p>
		       		</div>
		       		<div class="modal-footer">
		       			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		       		</div>
		       	</div>
		   </div>
		</div>
		
		<div id="prevModal" tabindex="-1" class="modal fade" role="dialog">
		 	<div class="modal-dialog modal-dialog-centered" role="document">
		 		<div class="modal-content">
		 			<div class="modal-header">
		 				<h4 class="modal-title" style="text-align:center">Example</h4>
		 				<button type="button" class="close" data-dismiss="modal">&times;</button>
		       		</div>
		       		<div class="modal-body">
		       			<p>이전 페이지가 없습니다</p>
		       		</div>
		       		<div class="modal-footer">
		       			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

