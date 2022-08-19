    var removeCartItemButtons = document.getElementsByClassName('btn-outline-danger btn-sm btn-block mb-2')
    console.log(removeCartItemButtons);
    for (var i = 0; i < removeCartItemButtons.length; i++) {
        var button = removeCartItemButtons[i]
        button.addEventListener('click', function() {
            console.log("clicked")
        })
    }

    // btn btn-outline-danger btn-sm btn-block mb-2