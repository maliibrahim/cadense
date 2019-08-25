/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addrow() {
    $('.editable td .delete,.options .actions .cancel').on('click', function () {
        $(this).closest('tr').remove();
    });
    $('.options .actions .confirm').on('click', function () {
        $(this).closest('tr').find('input').addClass('disabled');
    });    
}




$(document).ready(function () {


  	$('#dd1 li').click(function(){
    $('#selectedregion').text($(this).text());
  }); 
  
  $('#dd2 li').click(function(){
    $('#selectedsales').text($(this).text());
  }); 
  
  $('#dd3 li').click(function(){
    $('#selectedsector').text($(this).text());
  });
  
                    

  
  
  
  
  
    $('.datepicker').each(function () {
        $(this).datetimepicker({
            format: 'yyyy-mm-dd'
        });
    });
    $('.editable').each(function () {
        $(this).find('td').each(function () {
            $(this).dblclick(function () {
                var value = $(this).find('input').val();
                $(this).children('input').removeClass('disabled');
                $(this).find('.actions li').click(function () {
                    console.log(value)
                    if ($(this).closest('.actions').prev('input').val().length > 0) {
                        if ($(this).hasClass('cancel')) {
                            $(this).closest('.actions').prev('input').val(value);
                        }
                        $(this).closest('.actions').prev('input').addClass('disabled');
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
    })
});