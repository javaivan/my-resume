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
    //alert($("form[detiteEntityName]").attr('action'));
    //alert($("form[detiteEntityName]").attr('detiteEntityName'));
    //alert(id);

    /*.panel-body*/

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
$(document).ready(function() {
    $('body').on('click', '.box_detite_entity .btn_yes', function (){

        var  url = $("form[detiteEntityName]").attr('action')+'_delete/'+this.id;

        var  detiteEntityName = $("form[detiteEntityName]").attr('detiteEntityName');
        alert(url);
        $.ajax({
            url: url,
            type: 'GET',
            //data: {id: this.id, name: detiteEntityName},
            success: function(result) {
                alert(result);
                console.log('result: ', result);
            },
            error : function(error) {
                console.log('error: ', error);
                alert(error);
            }
        });

        //alert(url + " btn_yes " + this.id);
    });


/*
    $('body').on('click', '.box_detite_entity .box_detite_entity .close', function (){
        $('.panel-body .box_detite_entity').remove();
        $('.panel-body .box_detite_bg').remove();
    });
    $('body').on('click', '.box_detite_entity .box_detite_entity .btn_not', function (){
        $('.panel-body .box_detite_entity').remove();
        $('.panel-body .box_detite_bg').remove();
    });
    $('body').on('click', '.box_detite_entity .box_detite_bg', function (){
*/
    $('body').on('click', '.box_detite_entity .close,.box_detite_entity .btn_not,.box_detite_bg', function (){
        $('.panel-body .box_detite_entity').remove();
        $('.panel-body .box_detite_bg').remove();
    });

/*
*     $('body').on('click', '.box_detite_entity .box_detite_entity .close,.box_detite_entity .box_detite_entity .btn_not,.box_detite_entity .box_detite_bg', function (){
* */

});