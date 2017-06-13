$(function() {
	// Active menu
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Books':
		$('#listBooks').addClass('active');
		break;
	case 'Manage Books':
		$('#manageBooks').addClass('active');
		break;
	default:
		if (menu == 'Home')
			break;
		$('#listBooks').addClass('active');
		$('#a_' + menu).addClass('active');

	}
	

	var $table = $('#booksListTable');
	
	
	if ($table.length) {

	var jsonURL ='';
	
	if(window.categoryId ==''){
		jsonURL = window.contextRoot + '/json/data/all/books';
	}
	
	else
		{
		jsonURL = window.contextRoot + '/json/data/category/'+ window.categoryId +'/books'; 
		}

	
	$table.DataTable({
			lengthMenu: [[3,5,10,-1], ['3 books', '5 books', '10 books', 'All']],
			pageLength: 5,
			ajax: {
			url: jsonURL,
			dataSrc: ''
			},
			columns: [
			{data: 'imgUrl',
				mRender: function(data, type, row){
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="bookTableImg"/>';
				}
			},
			{data: 'bookName' },
			{data: 'author' }, 
			{data: 'yearOfPrint'},
			{data: 'unitPrice', mRender: function(data, type, row){
			return '&#8372; ' + data
		    }},
		    {data: 'id',
			bSortable: false,
		    	mRender: function(data, type, row){
				var str = '';
				str += '<a href="'+window.contextRoot+'/show/'+data+'/book" class="btn bttn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>';
				return str;
			}}
		    ]	
		});
	
	}	

	//Allert fade time
	var $alert =$('.alert');
	if($alert.length){
		setTimeout(function(){
		$alert.fadeOut('slow');	
		}, 1500)
	}
	
	
});