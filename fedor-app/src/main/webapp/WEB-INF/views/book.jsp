<div class="container">

	<!-- Bread -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/books">Books</a></li>
				<li class="active">${book.bookName}</li>
			</ol>

		</div>



	</div>



</div>

<div class="row">
	<!--  IMG -->
	<div class="col-xs-12 col-sm-4">
		<div class="thumbnail">
			<img src="${images}/${book.imgUrl}.jpg" class="img img-responsive" />
		</div>
	</div>
	<!-- Description -->
	<div class="col-xs-12 col-sm-4">
		<h2>${book.bookName}</h2>
		<hr/>
		<h4><b>Price:</b> &#8372;${book.unitPrice}</h4>
		<hr/>
		<h5>Book description: ${book.description}</h5>
	</div>

</div>