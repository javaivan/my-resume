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
    },
    certificates : {
        showUploadDialog : function() {
            $('#certificateUploader').modal({
                show : true
            });
        },

        uploadCertificate : function () {
            /*var certificateName = $('#certificateName').val();
             var certificateFile = $('#certificateFile').val();

             alert(certificateName);
             alert(certificateFile);
             */
            var file_data = $('#certificateFile').prop('files')[0];
            var name = $('#certificateName').val();
            var form_data = new FormData();
            form_data.append('certificateFile', file_data);
            form_data.append('certificateName', name);

            $.ajax({
                url: '/edit/certificates/upload', // point to server-side PHP script
                dataType: 'json',  // what to expect back from the PHP script, if anything
                cache: false,
                contentType: false,
                processData: false,
                data: form_data,
                type: 'post',
                success: function(response){
                    location.reload();

                    /*
                    $('#certificateUploader').modal('hide');
                    alert(response);

                    /*
                    $('#ui-block-container .certificates-item:last #certificates-name').val(response.certificateName);
                    $('#ui-block-container .certificates-item:last #certificates-smallUrl').val(response.bigImage);
                    $('#ui-block-container .certificates-item:last #certificates-largeUrl').val(response.smallImage);

                    $('#ui-block-container .certificates-item:last .certificate-link img').attr('src',response.smallImage);
*/
                },
                error : function(error) {
                    alert(error);
                    console.log('error: ', error);
                }
            });


            /*
             alert(file_data);
             alert(form_data);
             console.log(file_data);
             console.log(form_data);
             */

            /*
             $('#upload').on('click', function() {
             var file_data = $('#sortpicture').prop('files')[0];
             var form_data = new FormData();
             form_data.append('file', file_data);
             alert(form_data);
             $.ajax({
             url: 'upload.php', // point to server-side PHP script
             dataType: 'text',  // what to expect back from the PHP script, if anything
             cache: false,
             contentType: false,
             processData: false,
             data: form_data,
             type: 'post',
             success: function(php_script_response){
             alert(php_script_response); // display response from the PHP script, if any
             }
             });
             });*/


        },

        add : function (){
            var certificateName = $('#certificateName').val();
            //https://www.tjvantoll.com/2012/08/05/html5-form-validation-showing-all-error-messages/
            if(certificateName.trim() == '') {
                alert('certificateName is null')
                return;
            }
            var template = resume.ui.getTemplate();
            var container = $('#ui-block-container');
            var blockIndex = container.find('.ui-item').length;
            var context = {
                blockIndex : blockIndex,
                name : $('#certificateName').val(),
                smallUrl : $('#certificateUploader').attr('data-small-url'),
                largeUrl : $('#certificateUploader').attr('data-large-url')
            };
            container.append(template(context));
            $('#certificateUploader').modal('hide');
            $('#certificateName').val('');
            $('#certificateFile').fileinput('clear');
        }
    },

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
            return false;
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