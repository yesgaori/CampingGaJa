<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠퍼모집</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/mainHeader.jsp" />
		<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		<section>
			<div id="section4">
				<h2 class="pt-2 pl-2">인기 캠퍼모집</h2>
				<div class="d-flex">
					<div class="ml-4"></div>
					<c:forEach var="post" items="${bestList }">
					<a href="/post/recruitment/detail-view?id=${post.recruitmentPostId }" class="text-dark col-4">
						<c:choose>
							<c:when test="${post.thumbnailPath != ''}">
								<img src="${post.thumbnailPath }" width="300px" height="250px">
							</c:when>
							<c:otherwise>
								<div class="bi bi-flag" style="font-size:11rem;" class="border"></div>
							</c:otherwise>
						</c:choose>
						<h4 class="col-11 text-truncate">${post.title }</h4>
						<i class="bi bi-people-fill">${post.count }</i>
					</a>
					</c:forEach>
				</div>			
			</div>
			<div class="d-flex">
				<table class="table text-center">
					<thead>
						<tr>
							<th class="col-2">Location</th>
							<th class="col-4">Title</th>
							<th class="col-2">Name</th>
							<th class="col-2">Personnel</th>
							<th class="col-2">Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="post" items="${recruitmentList }">
						<tr>
							<td>${post.mapPath }</td>
							<td><a href="/post/recruitment/detail-view?id=${post.postId }">${post.title }</a></td>
							<td>${post.userName }</td>
							<td>${post.personnelCount }/${post.personnel }</td>
							<td>${post.startDate } ~ ${post.endDate }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="d-flex justify-content-end">
				<a class="btn btn-primary" href="/post/recruitment/create-view">글쓰기</a>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
	
	
	</script>
</body>
</html>