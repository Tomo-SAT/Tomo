var fsClient = filestack.init('AwjEmOSsTKuJMBQBVgE7fz');

$(document).ready(function () {

    $('#upload-button').click(function () {
        openPicker();
        // console.log("click me")
    });

    // const addLink = function (file) {
    //     $('.user-image-display').src = file.url;
    //     $('#temp-display').src = file.url;
    // };
    function openPicker() {
        fsClient.pick({
            fromSources:["local_file_system","imagesearch","facebook","instagram","dropbox"]
        }).then(function(response) {
            console.log(response.filesUploaded[0].url);
            var conImage = {
                url: response.filesUploaded[0].url
            };
            $.post("/profile/image", conImage).done(function(response) {
                localStorage.clear();
                window.location.reload(true);
                window.location = "/profile/edit";
                // handleFilestack(response);
                console.log(response)
            });
        });
    }
});


