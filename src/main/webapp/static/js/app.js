var resume = {

    alert : function(message){
        alert(message);
    },

    moreProfiles : function() {
        var page = parseInt($('#profileContainer').attr('data-profile-number')) + 1;
        var total= parseInt($('#profileContainer').attr('data-profile-total'));
        if (page >= total) {
            $('#loadMoreIndicator').remove();
            $('#loadMoreContainer').remove();
            return;
        }
        var url = '/fragment/more?page=' + page;

        $('#loadMoreContainer').css('display', 'none');
        $('#loadMoreIndicator').css('display', 'block');
        $.ajax({
            url : url,
            success : function(data) {
                $('#loadMoreIndicator').css('display', 'none');
                $('#profileContainer').append(data);
                $('#profileContainer').attr('data-profile-number', page);
                if (page >= total-1) {
                    $('#loadMoreIndicator').remove();
                    $('#loadMoreContainer').remove();
                } else {
                    $('#loadMoreContainer').css('display', 'block');
                }
            },
            error : function(data) {
                $('#loadMoreIndicator').css('display', 'none');
                resume.alert('Error! Try again later...');
            }
        });
    }
};
function detiteEntity(id) {
    var body = "";

    body += '<div class="box_detite_entity">';
    body += '<strong class="close">Close</strong>';
    body += '<strong class="btn_yes" id="'+id+'">yes</strong>';
    body += '<strong class="btn_not">not</strong>';
    body += '</div>';
    body += '<div class="box_detite_bg"></div>';
    $(".panel-body").append(body);
    return false;
}
function addNewEntity() {
    var length = $("#ui-block-container .ui-item").length;
    var url = '/fragment'+$("form[detiteEntityName]").attr('action')+'/'+length;
    $.ajax({
        url: url,
        type: 'GET',
        success: function(result) {
            $("form[detiteEntityName] #ui-block-container").append(result);
        },
        error : function(error) {
            alert(error);
            console.log('error: ', error);
        }
    });
    return false;
}

$(document).ready(function() {
    $('body').on('click', '.box_detite_entity .btn_yes', function (){
        var     id = this.id;
        var     url = $("form[detiteEntityName]").attr('action')+'/delete/'+id;

        var  detiteEntityName = $("form[detiteEntityName]").attr('detiteEntityName');
        $.ajax({
            url: url,
            type: 'GET',
            //data: {id: this.id, name: detiteEntityName},
            success: function(result) {
                $('.panel-body .box_detite_entity').remove();
                $('.panel-body .box_detite_bg').remove();
                $('#ui-item-'+id).remove();
                alert(result);
            },
            error : function(error) {
                $('.panel-body .box_detite_entity').remove();
                $('.panel-body .box_detite_bg').remove();
                alert(fails);
                console.log('error: ', error);
            }
        });
    });
    $('body').on('click', '.box_detite_entity .close,.box_detite_entity .btn_not,.box_detite_bg', function (){
        $('.panel-body .box_detite_entity').remove();
        $('.panel-body .box_detite_bg').remove();
    });


    if($('#ui-block-container.hobby_box').length){
        jQuery.each( checkboxChecked, function( i, val ) {
            $('#ui-block-container input:checkbox[value='+val+']').attr("checked", true);
        });
    }
});