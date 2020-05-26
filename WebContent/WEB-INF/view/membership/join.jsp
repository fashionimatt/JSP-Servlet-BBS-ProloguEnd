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
	        text-decoration : none;
	    }
        
        #background {
        	width: 100%;
        	height: 100vh;
        	background-image: url(../imgs/bgimg1.jpg);
        }
        
        .container{
            margin-top: 60px;
        }
        
        .container>form>h2{
        	color: white;
        	font-size: 28px;
        	text-align: center;
        	margin-bottom: 50px;
        }
        
        .field {
        	margin: 0 auto;
        	padding: 20px;
        	width: 320px;
            height: 360px;
            background-color: rgba(255,255,255,0.95);
        }
        
        .field>h3{
        	float: left;
        	font-size: 22px;
        	margin-top: 0px;
        	margin-bottom: 22px;
        }
        
        input[type="text"], input[type="password"] {
        	margin-bottom : 15px;
        	text-indent: 7px;
        	padding : 5px;
        	border: 1px solid #dfdfdf;
        }
        
        .gender-male{
        	display: inline-block;
        }

        .gender-female{
        	display: inline-block;
        }
        
        .btn-group{
        	margin: 0 auto;
        }
        
        .input-info>button[type="submit"]{
        	padding: 6px 120px;
        	margin-top: 45px;
        }
        
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
    
    <div id="background">
    
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
			<form action="JoinController" method="post">
				<h2>Join to communicate with fashion lovers!</h2>
				<div class="field text-center">
					<h3>Sign Up with Email</h3>
					<div class="input-info">
						<input type="text" size=33; name="name" placeholder="Name"/>
					</div>
					<div class="input-info">
						<input type="text" size=33; name="email" placeholder="Email"/>
					</div>
					<div class="input-info">
						<input type="password" size=33; name="password" placeholder="Password"/>
					</div>
					<div class="btn-group btn-group-toggle input-info" data-toggle="buttons"/>
							<label class="btn btn-secondary">
								<input type="radio" name="gender" id="gender-male" value="Male"/>Male
							</label>
							<label class="btn btn-secondary">
								<input type="radio" name="gender" id="gender-female" value="Female"/>Female
							</label>
					</div>
					<div class="input-info">
						<button type="submit" class="btn btn-dark">Join</button>
					</div>
				</div>
			</form>
	    </div>
    
    </div>

</body>
</html>

