
var CustomerList=null;
var sectorList=null;
var regionList=null;
$(document).ready(function () {
	getSectorList();
	getRegionList();
	
		$.ajax({
			type : "GET",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			url : "http://localhost:8080/api/v1/customer/",
			success : function(result) {
				var json = JSON.stringify(result);
				CustomerList = result;
				console.log(json);
					
				
				getCustomersTableHeader(result);
				getCustomersTableBody(result);
				restrucutre();
			}
		});
			
		function getSectorList(){
			$.ajax({
				type : "GET",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : "http://localhost:8080/api/v1/sector/",
				success : function(result) {
					sectorList = result;					
				},error: function(err){
					alert("Error in sectors service!!!");
				}
			});
		}
		
		function getRegionList(){
			$.ajax({
				type : "GET",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : "http://localhost:8080/api/v1/region/",
				success : function(result) {
					regionList = result;
				},error: function(err){
					alert("Error in regions service!!!");
				}
			});
		}
		
		function addCstomer(newObj){
			$.ajax({
				type : "POST",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : "http://localhost:8080/api/v1/customer/",
				data: JSON.stringify(newObj), // Note it is important
				success : function(result) {
				
				},error: function(err){
					alert("Couldnt Add!!!");
				}
			});
		}
		
		function updatecustomer(newObj){
			$.ajax({
				type : "PUT",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : "http://localhost:8080/api/v1/customer/",
				data: JSON.stringify(newObj), // Note it is important
				success : function(result) {
				
				},error: function(err){
					alert("Couldnt update!!!");
				}
			});
		}
		
		function deleteCustomer(id){
			$.ajax({
				type : "DELETE",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : "http://localhost:8080/api/v1/customer/" + id,
				success : function(result) {
				
				},error: function(err){
					alert("Couldnt delete!!!");
				}
			});
		}
			
		function getCustomersTableHeader(result) {
			var table = document.getElementById('customer-table');
			var header = table.getElementsByTagName("thead");
		
			// Create an empty <tr> element and add it to the first position of <thead>:
			var row = header[0].insertRow(0);
		
			var keys = Object.keys(result[0]);
			for (var i = 0; i < keys.length; i++) {
				var key = keys[i];
				
				if (key === "customerId")
					continue;
				
				if(key.includes('customer'))
					key = key.replace('customer', '');
		
				var x = document.createElement("TH");
				var t = document.createTextNode(key);
				x.appendChild(t);
				row.appendChild(x);
			}
			var addElement = document.createElement("TH");
			addElement.setAttribute("class","text-center");
			
			var span = document.createElement("span");
			span.setAttribute("class","add");
			
			var iElement = document.createElement("i");
			iElement.setAttribute("class","la la-plus");

			span.appendChild(iElement);
			addElement.appendChild(span);
			row.appendChild(addElement);
			
		}     
	
	
		function getCustomersTableBody(result) {
			
			var table = document.getElementById('customer-table');
			var body = table.getElementsByTagName("tbody");

			createAddRow(result[0]);
			
			for (var i = 0; i < result.length; i++) {

				var obj = result[i];
				var row = body[0].insertRow(i+1);
				var elementId = null;
				for ( var key in obj) {
					var x = document.createElement("td");
					var attrName = key;
					var value = obj[key];

					if (key.includes('Id')){
						elementId = value;
						continue;
					}
									
				var inputElement = null;

				if (key === 'email' || key === 'customerNumber' || key === 'customerName') {
					inputElement = document.createElement("input");
					inputElement.setAttribute("class","disabled");
					inputElement.setAttribute("type", "text");
					inputElement.setAttribute("id", elementId);
					inputElement.setAttribute("name", key);
					inputElement.setAttribute("value", value);
				} else if (key === 'sector') {
					inputElement = document.createElement("select");
					inputElement.setAttribute("name", "sector");
					inputElement.setAttribute("class", "disabled");
					inputElement.setAttribute("id", elementId);
				
					for (var j = 0; j < sectorList.length; j++) {
		 				var sector = sectorList[j];
		 				var selectOption = document.createElement("option");
		 				selectOption.setAttribute("id", sector.sectorId);
		 				selectOption.setAttribute("value", sector.sector);
						selectOption.innerHTML= sector.sector;
						
						if (value.sector === sector.sector)
							selectOption.setAttribute("selected", "");

						inputElement.appendChild(selectOption);						
					}
										
				} else if (key === 'region') {
					inputElement = document.createElement("select");
					inputElement.setAttribute("name", "region");
					inputElement.setAttribute("class", "disabled");
					inputElement.setAttribute("id", elementId);
				
					for (var j = 0; j < regionList.length; j++) {
		 				var region = regionList[j];
		 				var selectOption = document.createElement("option");
		 				selectOption.setAttribute("id", region.regionId);
		 				selectOption.setAttribute("value", region.region);
						selectOption.innerHTML= region.region;
						
						if (value.region === region.region)
							selectOption.setAttribute("selected", "");

						inputElement.appendChild(selectOption);						
					}
										
				} 
					var ul = document.createElement("ul");
					ul.setAttribute("class", "actions");

					var li = document.createElement("li");
					li.setAttribute("class", "confirm");
					var i1 = document.createElement("i");
					i1.setAttribute("class", "la la-check");
					$(i1).bind("click",{"object":obj},function(e){
						
			            var ie = $(this).closest('.actions').prev('input, select');
			            
			            var id = ie.attr('id');
			 			var name = ie.attr('name');
			 			var newValue = ie.val();
			 			console.log(id);
			 			console.log(name);
			 			console.log(newValue);
			 			
			 			for (var i = 0; i < CustomerList.length; i++) {
			 				var obj = CustomerList[i];
							if (JSON.stringify(obj.customerId) === id){				
								for ( var key in obj) {
									if (key === name){
										if(key === "sector"){
											var secorId = ie.find('option:selected').attr('id');
											obj[key].sectorId = secorId;
								 			console.log(secorId);

											obj[key].sector = newValue;
										}
										else if(key === "region"){
											var regionId = ie.find('option:selected').attr('id')
											obj[key].regionId = regionId;
											obj[key].region = newValue;
										} else 
											obj[key] = newValue;
										
										console.log( obj);
										updatecustomer(obj);
									}
								}
							}
			 			}
					
					});
				
					li.appendChild(i1);
					ul.appendChild(li)

					var li2 = document.createElement("li");
					li2.setAttribute("class", "cancel");
					var i2 = document.createElement("i");
					i2.setAttribute("class", "la la-close");
					li2.appendChild(i2)
					ul.appendChild(li2)

					x.appendChild(inputElement);
					x.appendChild(ul);
					row.appendChild(x);
				}
							
				var lastTd = document.createElement("td");
				lastTd.setAttribute("class", "options");

				var ul = document.createElement("ul");

				var li = document.createElement("li");
				var dev = document.createElement("dev");
				dev.setAttribute("class", "delete text-red");
				var i1 = document.createElement("i");
				i1.setAttribute("class", "la la-trash");
				
				dev.appendChild(i1)
				li.appendChild(dev)
				ul.appendChild(li)
				lastTd.appendChild(ul)
				row.appendChild(lastTd);
			}		
		}
		
		
		function createAddRow(result){
			
			var table = document.getElementById('customer-table');
			var body = table.getElementsByTagName("tbody");
		
			var row = body[0].insertRow(0);
			row.setAttribute("class", "hidden");
			
			var keys = Object.keys(result);

			for (var i = 0; i < keys.length; i++) {
				var x = document.createElement("td");
				//console.log(keys);
				var key = keys[i];
				
				if (key === "customerId"){
					continue;
				}
		
				if (key === 'email' || key === 'customerNumber' || key === 'customerName') {
					var input = document.createElement("input");
					input.setAttribute("type", "text");
					input.setAttribute("name", key);
					input.setAttribute("class", "input");
					x.appendChild(input);
				} else if (key === 'sector') {
					var select = document.createElement("select");
					select.setAttribute("name", "sector");
					select.setAttribute("class", "input");
					var selectedOption = document.createElement("option");
					selectedOption.setAttribute("selected", "");
					selectedOption.value="select";
					selectedOption.innerHTML= "select";
					select.appendChild(selectedOption);
										
					for (var j = 0; j < sectorList.length; j++) {
		 				var sector = sectorList[j];
		 				var selectOption = document.createElement("option");
		 				selectOption.setAttribute("id", sector.sectorId);
		 				selectOption.setAttribute("value", sector.sector);
						selectOption.innerHTML= sector.sector;
						select.appendChild(selectOption);						
					}
					
					x.appendChild(select);
					
				} else if (key === 'region') {
					var select = document.createElement("select");
					select.setAttribute("name", "region");
					select.setAttribute("class", "input");
					var selectedOption = document.createElement("option");
					selectedOption.setAttribute("selected", "");
					selectedOption.value="select";
					selectedOption.innerHTML= "select";
					select.appendChild(selectedOption);
										
					for (var k = 0; k < regionList.length; k++) {
		 				var region = regionList[k];
		 				var selectOption = document.createElement("option");
		 				selectOption.setAttribute("id", region.regionId);
		 				selectOption.setAttribute("value", region.region);
						selectOption.innerHTML= region.region;
						select.appendChild(selectOption);						
					}
					
					x.appendChild(select);
				}	
				
				row.appendChild(x);
			}


			var lastTd = document.createElement("td");
			lastTd.setAttribute("class", "options");
			
			var input = document.createElement("input");
			input.setAttribute("type","hidden");
			
			var ul = document.createElement("ul");
			ul.setAttribute("class", "actions");

			var li = document.createElement("li");
			li.setAttribute("class", "confirm");
			var i1 = document.createElement("i");
			i1.setAttribute("class", "la la-check commit");
		
			li.appendChild(i1);
			ul.appendChild(li);
			
			var li2 = document.createElement("li");
			li2.setAttribute("class", "cancel");
			var i2 = document.createElement("i");
			i2.setAttribute("class", "la la-close");
			li2.appendChild(i2)
			ul.appendChild(li2)

			lastTd.appendChild(input);
			lastTd.appendChild(ul);
			row.appendChild(lastTd);	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		function restrucutre(){
		    $('.editable').each(function () {
		        $(this).find('td').each(function () {
		            $(this).dblclick(function () {
		                var value = $(this).find('input, select').val();
		                $(this).children('input, select').removeClass('disabled');
		                $(this).find('.actions li').click(function () {
		                    //console.log(value);
		                    if ($(this).closest('.actions').prev('input, select').val().length > 0) {
		                        if ($(this).hasClass('cancel')) {
		                            $(this).closest('.actions').prev('input, select').val(value);
		                        }
		                        $(this).closest('.actions').prev('input, select').addClass('disabled');
		                    }
		                });
		                addrow();
		            });
		        });
		        $(this).find('.add').on('click', function () {
		            var markup = $(this).closest('.editable').find('tr.hidden').html();
		            $(this).closest('.editable').find('tr.hidden').after('<tr>' + markup + '</tr>');
		            addrow();
		        });
		    });
		}
		
		function addrow() {
			 $('.editable td .delete,.options .actions .cancel').on('click', function () {
		        $(this).closest('tr').remove();
		    });
			 $('.options .actions .confirm').on('click', function (e) {
		        $(this).closest('tr').find('input, select').addClass('disabled');
		    }); 
			 //delete row
			 $('.editable td .delete').on('click', function () {
				// deleteCustomer($(this).closest('tr').find('input').attr('id'));
			 });
			 //add new row
			 $('.commit').on('click', function (e) {
				 var newJson = new Object();
				 $(this).closest('tr').find('.input').each(function () {
					 
		 			var name = $(this).attr('name');
		 			var newValue = $(this).val();
		 			
		 			if (name==="customerName")
		 				newJson.customerName = newValue;
		 			if (name==="customerNumber")
		 				newJson.customerNumber = newValue;
		 			if (name==="email"){
		 				newJson.email = newValue;

		 			}
		 			if (name==="sector"){
						var id = $(this).find('option:selected').attr('id');
		 				sector = {}
		 				sector.sectorId = id;
		 				newJson.sector = sector;
		 				$(this).addClass('disabled');
		 			}
		 			if (name==="region"){
						var id = $(this).find('option:selected').attr('id');
		 				region = {}
		 				region.regionId = id;
		 				newJson.region = region;	
		 				$(this).addClass('disabled');
		 			}					 
				 });
				 console.log(newJson);
				 addCstomer(newJson);
				 location.reload();
			 });
		}
		
});




