<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <c:import url="/WEB-INF/view/common/top_menu.jsp"/>
    
	<div class="container" id="content">
	<form action="WriteController" method="post">
		<div class="row">
			<div class="col-xl-2"></div>
			<table class="col-xl-8 table">
				<tbody>
					<tr>
						<th class="active" style="vertical-align:middle;">제목</th>
						<td colspan="3"><input class="form-control" type="text" name="title" placeholder="제목을 입력해주세요"/></td>
					</tr>
					<tr>
						<th class="active">작성자</th>
						<td><input class="form-control" type="text" name="author" placeholder="작성자를 입력해주세요"/></td>
					</tr>
					<tr>
						<th class="active" style="vertical-align:middle;">첨부파일</th>
						<td colspan="3">
							<div class="input-group">
							  <div class="custom-file">
							    <input type="file" name="files" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
							    <label class="custom-file-label" for="inputGroupFile01">Choose a file</label>
							  </div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="4"><textarea class="form-control" rows="7" name="content" placeholder="내용을 입력해주세요"></textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="col-xl-2"></div>	
		</div>
		
		<div class="text-center">
        	<button type="submit" class="btn btn-secondary">작성</button>
        	<a type="button" href="list" class="btn btn-secondary">목록</a>  
		</div>
	</form>
		
	</div>

    <c:import url="/WEB-INF/view/common/footer.jsp"/>
    
</body>
</html>

