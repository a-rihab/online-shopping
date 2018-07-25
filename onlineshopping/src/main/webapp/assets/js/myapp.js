$(function() {

	switch (menu) {
	case 'About us':
		$('#about').addClass('active');
		break;
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// code for jquery dataTable

	var $table = $('#productListTable');

	if ($table.length) {

		var jsonUrl = '';

		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'All' ] ],
			pageLength : 5,

			ajax : {

				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				
					{
						data : 'code',
						bSortable:false,
						mRender: function(data, type, row){
							
							return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
						}
					},
					{
						data : 'name'
					},
					{
						data : 'brand'
					},
					{
						data : 'unitPrice',
						mRender : function(data, type, row) {
							return data + ' &#8364;'
						}
					},
					{
						data : 'quantity',
						mRender:function(data, type, row){
							
							if(data < 1){
								return  '<span style="color: red"> Out of Stock</span>';
							}
							return data;
						}
					},
					{
						data : 'id',
						bSortable:false,
						mRender : function(data, type, row) {

							var str = '';

							if (row.quantity < 1){
								str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span><i class="fas fa-shopping-cart"></span></i> </a>';
							}
							else{
								str += '<a href="' + window.contextRoot	+ '/cart/add/' + data + '/product" class="btn btn-success"><span><i class="fas fa-shopping-cart"></span></i> </a>';
							}
							str += '<a href="' + window.contextRoot + '/show/'+ data + '/product" class="btn btn-primary"><span><i class="fas fa-eye"></i></span></a> &#160;';
							

							return str;
						}
					}
					
				]
		});
	}
});