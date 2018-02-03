"use strict";
$('#upload-button').click(function() {
    const client = filestack.init('AwjEmOSsTKuJMBQBVgE7fz');

    const addLink = function(file) {
        $('.user-image-display').src = file.url;
        $('#temp-display').src = file.url;
    };

    client.pick({
        accept: 'image/*',
        fromSources:  ['local_file_system','facebook','googledrive','instagram','dropbox','imagesearch','webcam',],
        maxSize: 1024*2024,
        maxFiles: 6,
    }).then(
        //TODO This function needs to display the image that the user has chosen immediately, instead of just setting the input's val to the url.
        function(result) {
            const fileUrl = result.filesUploaded[0].url;
            $('#imageUrl').val(fileUrl);
            result.filesUploaded.forEach(function(file) {
                addLink(file)
            });
        });

});