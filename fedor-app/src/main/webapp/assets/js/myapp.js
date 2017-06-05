$(function() {
	//active menu
	switch(menu){
	case'About Us':
		$('#about').addClass('active');
		breack;
	case'Contact Us':
		$('#contact').addClass('active');
		breack;
	case 'All Books':
		$('#listBooks').addClass('active');
	default:	
		$('#listBooks').addClass('active');
	$('#a_'+menu).addClass('active');
		breack;
		
		
	
	}
	
})