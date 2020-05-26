<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	    }
	    
	    #logo:hover{
	        color: lightgray;
	    }
	    
	    .container-fluid{
	        height: 325px;
	        background-image: url("imgs/navImg3.jpg");
	        padding: 0px;
	        margin: 0px;
	    }
	    
	    #tag{
	        color: white;
	        font-size: 25px;
	        text-shadow: 1px 1px 1px black;
	        position: relative;
	        top: 100px;
	    }
	    
	    #photoCredit{
	        color: lightgray;
	        font-size: 13px;
	        position: relative;
			top: 250px;        
	        right: 20px;
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
            <li><a href="${root }" id="logo">PrologueEnd</a></li>
            <li><a href="${root }about/about">About</a></li>
            <li><a href="${root }notice/list">Notice</a></li>
            <li><a href="#">Log in</a></li>
            <li><a href="${root }membership/joinView" id="join">Join</a></li>        
        </ul>
    </div>
    
    <div class="container-fluid">
        <p class="h3 text-center" id="tag">
            From the Prologue. To the End.
        </p>
        <p class="h1 text-right" id="photoCredit">
            Picture by pxhere.com           
        </p>
    </div>

    <div class="footer">
        <p>&copy;2020 PrologueEnd. All rights reserved.</p>
    </div>
</body>
</html>