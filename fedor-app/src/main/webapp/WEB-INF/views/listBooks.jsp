<div class="container">
	<div class="row">
		<!-- Sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- Actual products -->
		<div class="col-md-9">
			<!-- Breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllBooks == true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Books</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryBooks == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<table id="booksListTable"
						class="table table-striped table-borderd">
						<thead>
							<tr>
								<th></th>
								<th>Book Title</th>
								<th>Author</th>
								<th>Year of Edition</th>
								<th>Price</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Books</th>
								<th>Author</th>
								<th>Year of print</th>
								<th>Price</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>