<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>資産リスト</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css"
	type="text/css">
</head>
<body>
	<h1>資産リスト</h1>

	<div id="assetsForm">
		<t:messagesPanel />

		<form:form action="${pageContext.request.contextPath}/assets/create"
			method="post" modelAttribute="assetsForm">
			<form:input path="assetsName" />
			<form:errors path="assetsName" cssClass="text-error" />
			<form:button>資産を登録する</form:button>
		</form:form>
	</div>
	<hr />
	<div id="assetsList">
		<ul>
				<table>
					<tr>
						<td>資産名</td>
						<td></td>
					</tr>
					<c:forEach items="${assetses}" var="assets">
						<tr>
							<td>${f:h(assets.assetsName)}</td>
							<td><form:form
									action="${pageContext.request.contextPath}/assets/delete"
									method="post" modelAttribute="assetsForm" cssClass="inline">
									<form:hidden path="assetsId" value="${f:h(assets.assetsId)}" />
									<form:button>削除</form:button>
								</form:form></td>
						</tr>
					</c:forEach>
				</table>
		</ul>
	</div>
</body>
</html>