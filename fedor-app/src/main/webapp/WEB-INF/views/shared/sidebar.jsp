<p class="lead"></p>

<div class="list-group">
	<c:forEach items="${categories}" var="category">
	<a href="${contextRoot}/show/category/${category.id}/books" class="list-group-item" id="a_${category.name}">${category.description}</a>
	</c:forEach> 
</div>