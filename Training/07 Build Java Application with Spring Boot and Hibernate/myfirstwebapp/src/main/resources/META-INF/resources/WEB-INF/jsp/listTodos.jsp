<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container m-5 px-5">

		<h1>Your Todos</h1>

		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>TargetDate</th>
					<th>IsDone?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-outline-danger">DELETE</a></td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-outline-success">EDIT</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="add-todo" class="btn btn-outline-primary">Add Todo</a>

	</div>

<%@ include file="common/footer.jspf"%>