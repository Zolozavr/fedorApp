<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">


		<div class="com-md-offset-2 col-md-8">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Book Management</h4>
				</div>

				<div class="panel-body">
					<!-- Forms -->
					<sf:form class="form-horizontal" modelAttribute="book">
						<div class="form-group">
							<label class="controll-label col-md-4" for="bookName">Enter
								Book Title:</label>
							<div class="col-md-8">
								<sf:input type="text" path="bookName" id="bookName"
									placeholder="Book Title" class="form-control" />
								<em class="help-block">Please enter book title!</em>
							</div>
						</div>




						<div class="form-group">
							<label class="controll-label col-md-4" for="author">Enter
								Author Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="author" id="author"
									placeholder="Author's Name" class="form-control" />
								<em class="help-block">Please enter author's first name and
									second name.</em>
							</div>
						</div>






						<div class="form-group">
							<label class="controll-label col-md-4" for="yearOfPrint">Enter
								Year of edition:</label>
							<div class="col-md-8">
								<sf:input type="text" path="yearOfPrint" id="yearOfPrint"
									placeholder="Year Of Edition" class="form-control" />
								<em class="help-block">Please enter edition year of the
									book.</em>
							</div>
						</div>





						<div class="form-group">
							<label class="controll-label col-md-4" for="unitPrice">Enter
								price of the book</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Book price" class="form-control" /> <em
									class="help-block">Book price in &#8372;</em>
							</div>
						</div>

						<div class="form-group">
							<label class="controll-label col-md-4" for="categoryId">Select category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId" 
								items="${categories}" itemLabel="name"
								itemValue="id"
								/>
							</div>
						</div>
						<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
						<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
						<!--  Hide fields -->
						<sf:hidden path="id"/>
						<sf:hidden path="imgUrl"/>
						<sf:hidden path="usersId"/>
						<sf:hidden path="views"/>
						<sf:hidden path="active"/>
						</div>
						</div>
					</sf:form>
				</div>


			</div>

		</div>
	</div>

</div>