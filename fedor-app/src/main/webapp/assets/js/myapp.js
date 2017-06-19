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

	// Allert fade time
	var $alert =$('.alert');
	if($alert.length){
		setTimeout(function(){
		$alert.fadeOut('slow');	
		}, 1500)
	}
	// admin table

	
	// Checkbox
	
	$('.switch input[type="checkbox"]').on('change', function(){
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var msg = (checked)? 'Do you want to activate the product': 'Do you want to deactivate the product';
		
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size: 'medium',
			title: 'Product manage activation',
			message: msg,
			callback: function(confirmed){
				if(confirmed){
					console.log(value);
					boootbox.alert({
						size: 'medium',
						title: 'Info',
						message: 'You are going to update the book prop ' + value
					});
				}
				else {
					checkbox.prop('checked', !checked);
				}
			}
		})
	});
	
var $adminBookTable = $('#adminBookTable');
	
	
	if ($adminBookTable.length) {

	var jsonURL = window.contextRoot + '/json/data/admin/all/books';
	
	

	
	$adminBookTable.DataTable({
			lengthMenu: [[10,30,50,-1], ['10 books', '30 books', '50 books', 'All']],
			pageLength: 30,
			ajax: {
			url: jsonURL,
			dataSrc: ''
			},
			columns: [
			{data: 'id'},
			{data: 'imgUrl',
				
				bSortable: false,
				mRender: function(data, type, row){
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
				}
			},
			{data: 'bookName' },
			{data: 'author' }, 
			{data: 'yearOfPrint'},
			{data: 'unitPrice', mRender: function(data, type, row){
			return '&#8372; ' + data
		    }},
		    {data: 'active',
		    	bSortable: false,
		    	mRender: function(data,type,row){
		    		var str = '';
		    		str += '<label class="switch">';
		    		if(data){
		    			str += '<input type="checkbox" checked="checked" value="'+row.id+'">';
		    		}
		    		else {
		    			str += '<input type="checkbox"  value="'+row.id+'">';
		    		}
		    		str +='<div class = "slider"></div></label>';
		    		return str;
		    		}
		    },
		    {data: 'id',
		    	bSortable: false,
		    	mRender: function(data, type, row){
		    		var str = '';
		    		str += '<a href="'+window.contextRoot+'/manage/'+data+'/books" class=" btn btn-warning"/>';
		    			str += '<span class="glyphicon glyphicon-pencil"></span></a>';
		    			return str;
		    	}
		    }
		    ],
		    initComplete: function(){
		    	var api = this.api();
		    	api.$('.switch input[type="checkbox"]').on('change', function(){
		    		var checkbox = $(this);
		    		var checked = checkbox.prop('checked');
		    		var msg = (checked)? 'Do you want to activate the product': 'Do you want to deactivate the product';
		    		
		    		var value = checkbox.prop('value');
		    		
		    		bootbox.confirm({
		    			size: 'medium',
		    			title: 'Product manage activation',
		    			message: msg,
		    			callback: function(confirmed){
		    				if(confirmed){
		    					console.log(value);
		    					
		    					var activationUrl = window.contextRoot +'/manage/books/' + value + '/activation';
		    					
		    					$.post(activationUrl, function(data){
		    						
		    						bootbox.alert({
			    						size: 'medium',
			    						title: 'Info',
			    						message: data
		    					});
		    					
		    					
		    					});
		    				}
		    				else {
		    					checkbox.prop('checked', !checked);
		    				}
		    			}
		    		})
		    	});
		    }
		});
	
	}	
	
	
});