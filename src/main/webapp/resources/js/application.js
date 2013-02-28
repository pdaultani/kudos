	$(function() {
		$("#menu").menu();
		$('#kudos_table').dataTable( {
			"sPaginationType": "scrolling"
		} );
	});

function send_kudos() {
	var boolReturn = true;
	boolReturn = validatePresenceOfValue('kudos_sent_from', boolReturn); 
	boolReturn = validatePresenceOfValue('kudos_sent_to', boolReturn); 
	boolReturn = validatePresenceOfValue('kudos_content', boolReturn); 
	
	$(function() {
		
		if(boolReturn){
		$.post("/lux/send_kudos",
					{ 	kudos_sent_to:  $("#kudos_sent_to").val(),
						kudos_sent_from:  $("#kudos_sent_from").val(),
						kudos_content: $('#kudos_content').val() },
						function(data){
							// data contains the result
							$(".ui-widget").show();							
					});
		}
		else {
			return boolReturn;
		}
	});
		
}

function validatePresenceOfValue(str_id, boolReturn)
{
	
	var el = $('#'+str_id);
	if ((el != null) && el.is(":visible")){
	removeAsterisk(str_id);
		if ($('#'+str_id).is(':disabled')==false){
			
			if (el.val()=='' || $.trim(el.val()) == ''){
				if (el.attr("class") != "not_required"){
					el.after("<span class='asterisk'>*</span>");
					el.css('padding','3px 0px 0px 3px');
					el.css('background','#FFEBE8');
					el.css('border','2px solid #DD3C10');
							
					boolReturn = false;
				}
			}
		}
	}
	return boolReturn;
}

function removeAsterisk(str_id)
{
	var el = $('#'+str_id);
	if (el != null){
			
				el.css('padding','3px 0px 0px 3px');
				el.css('background','#FFFFFF');
				el.css('border','1px solid black');

				if(el.val()){
				if(el.val().length == 0){
					el.css('background','#FFFFFF');
					el.css('border','1px solid grey');
				}
			}
		//var children = el.parent().children();
		el.parent().children().each(function(child){
			if ($(this).attr('class')=='asterisk') {
				$(this).remove();
				
			}
		});
	}
		
}