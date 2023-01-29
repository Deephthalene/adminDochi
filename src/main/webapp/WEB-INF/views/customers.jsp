<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="./layout/header.jsp"></jsp:include>
	<jsp:include page="./layout/sidebar.jsp"></jsp:include>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
		<div class="container-fluid px-4">
			<h1 class="mt-4">Tables</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="/index">Dashboard</a></li>
				<li class="breadcrumb-item active">Tables</li>
			</ol>
			<div class="card mb-4">
				<div class="card-body">고객 리스트</div>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<div
						class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
						<div class="datatable-top">
							<form action="/user/customers" method="get">
							<div class="datatable-dropdown">
									<select class="form-select" name="type">
										<option ${typed == null ? 'selected':'' }>Choose...</option>
										<option value="t" ${typed eq 't' ? 'selected':'' }>Name</option>
										<option value="c" ${typed eq 'c' ? 'selected':'' }>Status</option>
										<option value="w" ${typed eq 'w' ? 'selected':'' }>NickName</option>
									</select> <input class="form-control" type="text" name="keyword"
										placeholder="Search" value="${page.pageDto.keyword }"> <input
										type="hidden" name="pageNo" value="1"> <input
										type="hidden" name="qty" value="${page.pageDto.qty }">
									<button type="submit" class="btn btn-success position-relative">
										Search <span
											class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
											${page.totalCount } <span class="visually-hidden">unread
												messages</span>
										</span>
									</button>
							</div>
							</form>
						</div>
						<div class="datatable-container">
							<form action="/user/list" method="get">
								<table id="datatablesSimple" class="datatable-table">
									<thead>
										<tr>
											<th data-sortable="true" style="width: 15.076849183477425%;"><a
												href="#" class="datatable-sorter">회원번호</a></th>
											<th data-sortable="true" style="width: 15.70028818443804%;"><a
												href="#" class="datatable-sorter">Name</a></th>
											<th data-sortable="true" style="width: 30.465898174831894%;"><a
												href="#" class="datatable-sorter">Email</a></th>
											<th data-sortable="true" style="width: 15.532180595581172%;"><a
												href="#" class="datatable-sorter">Phone</a></th>
											<th data-sortable="true" style="width: 13.44860710854947%;"><a
												href="#" class="datatable-sorter">활동 여부</a></th>
											<th data-sortable="true" style="width: 12.776176753121998%;"><a
												href="#" class="datatable-sorter">닉네임</a></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${user }" var="user">
											<tr>
												<td data-sortable="true">${user.uid }</td>
												<td>${user.name }</td>
												<td>${user.email }</td>
												<td>${user.phone }</td>
												<td><c:choose>
														<c:when test="${user.status == 0 }">
											활동중
										</c:when>
														<c:when test="${user.status == 1 }">
											탈퇴
										</c:when>
														<c:otherwise>
											활동정지
										</c:otherwise>
													</c:choose></td>
												<td>${user.nickname }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>

						<!-- paging line -->
						<ul class="pagination justify-content-center">
							<c:if test="${page.prev }">
								<li class="page-item"><a
									href="/board/list?pageNo=${page.startPage - 1 }&qty=${page.pageDto.qty}&type=${page.pageDto.type}&keyword="
									${page.pageDto.keyword }" class="page-link">Prev</a></li>
							</c:if>
							<c:forEach begin="${page.startPage }" end="${page.endPage }"
								var="i">
								<li class="page-item ${page.pageDto.pageNo == i ? 'active':''}"
									aria-current="page"><a class="page-link"
									href="/board/list?pageNo=${i }&qty=${page.pageDto.qty}&type=${page.pageDto.type}&keyword="${page.pageDto.keyword }">${i }</a>
								</li>
							</c:forEach>
							<c:if test="${page.next }">
								<li class="page-item"><a class="page-link"
									href="/board/list?pageNo=${page.endPage + 1 }&qty=${page.pageDto.qty}&type=${page.pageDto.type}&keyword="${page.pageDto.keyword }">Next</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</main>
	<jsp:include page="./layout/footer.jsp"></jsp:include>
</body>
</html>