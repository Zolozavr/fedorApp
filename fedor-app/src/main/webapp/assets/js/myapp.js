$(function() {
	// Active menu
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		breack;
	case 'Contact Us':
		$('#contact').addClass('active');
		breack;
	case 'All Books':
		$('#listBooks').addClass('active');
		breack;
	default:
		if (menu == 'Home')
			break;
		$('#listBooks').addClass('active');
		$('#a_' + menu).addClass('active');

	}
	// test
	var books = [ [ '1', 'abc' ], [ '2', 'abc' ], [ '3', 'abdsadc' ],
			[ '4', 'abdfsfc' ], [ '5', 'absadsac' ], [ '6', 'abfdsfc' ],
			[ '7', 'abgfdc' ], [ '8', 'abdsac' ], [ '9', 'abfdsfdsc' ]

	];

	var $table = $('#booksListTable');
	if ($table.length) {

		$table.DataTable({
			data : books
		});

	}
});