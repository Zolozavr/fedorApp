<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">
		<c:if test="${not empty msg}">
			<div class="col-xs-8">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${msg}
				</div>
			</div>
		</c:if>
		<div class="com-md-offset-2 col-md-8">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Book Management</h4>
				</div>

				<div class="panel-body">
					<!-- Forms -->
					<sf:form class="form-horizontal" modelAttribute="book"
						action="${contextRoot}/manage/books" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="bookName">Enter
								Book Title:</label>
							<div class="col-md-8">
								<sf:input type="text" path="bookName" id="bookName"
									placeholder="Book Title" class="form-control" />
								<sf:errors path="bookName" cssClass="help-block" element="em" />
							</div>
						</div>




						<div class="form-group">
							<label class="control-label col-md-4" for="author">Enter
								Author Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="author" id="author"
									placeholder="Author's Name" class="form-control" />

							</div>
						</div>





						<!-- YEAR -->
						<div class="form-group">
							<label class="control-label col-md-4" for="yearOfPrint">Enter
								Year of edition:</label>
							<div class="col-md-8">
								<sf:input type="text" path="yearOfPrint" id="yearOfPrint"
									placeholder="Year Of Edition" class="form-control" />
								<sf:errors path="yearOfPrint" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- File IMG uploader -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Upload
								IMG:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
							</div>
						</div>



						<!-- PRICE -->
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								price of the book</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Book price in &#8372;" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>


						<!-- CATEGORY -->
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
								<c:if test="${book.id == 0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add
											New Category</button>
									</div>
								</c:if>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
								<!--  Hide fields -->
								<sf:hidden path="id" />
								<sf:hidden path="imgUrl" />
								<sf:hidden path="usersId" />
								<sf:hidden path="views" />
								<sf:hidden path="active" />
							</div>
						</div>
					</sf:form>
				</div>


			</div>

		</div>
	</div>


	<div class="col-xs-12">
		<h2>BOOKS IN CATALOG</h2>
		<hr />
	</div>

	<div class="col-xs-12">
		<div style="owerflow: auto">

			<!-- ADMIN TABLE -->
			<table id="adminBookTable" class="table table-striped table-borderd">
				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Title</th>
						<th>Author</th>
						<th>Year of print</th>
						<th>Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</thead>
				<!-- Table Body -->


				<tfoot>

					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Title</th>
						<th>Author</th>
						<th>Year of print</th>
						<th>Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</tfoot>

			</table>


		</div>

	</div>
	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<!-- M header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<!--  Form for new category based on Spring-->
					<sf:form modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label for="categoryName" class="control-label col-md-4">Category
								name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="categoryName"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="categoryDescription" class="control-label col-md-4">Category
								description</label>
							<div class="col-md-8">
								<sf:textarea type="text" cols="" rows="2" path="description"
									id="categoryDescription" class="form-control" />
							</div>


						</div>
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary">
							</div>


						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>