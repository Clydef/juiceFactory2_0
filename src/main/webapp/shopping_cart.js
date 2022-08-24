if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready);
} else {
    ready()
}

function ready() {
    var removeCartItemButtons = document.getElementsByClassName('btn-outline-danger btn-sm btn-block mb-2')
// console.log(removeCartItemButtons);
    for (var i = 0; i < removeCartItemButtons.length; i++) {
        var button = removeCartItemButtons[i]
        button.addEventListener('click', removeCartItem);
    }

    var quantityInputs = document.getElementsByClassName('form-control form-control-sm');
    for (let i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i]
        input.addEventListener('change', quantityChanged)
    }
}

function removeCartItem(event) {
    var buttonClicked = event.target;
    // console.log(buttonClicked.parentElement.parentElement);
    buttonClicked.parentElement.parentElement.remove();
    updateCartTotal();
}

function quantityChanged(event) {
    var input = event.target;
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1;
    }
    if (isNaN(input.value) || input.value > 100) {
        input.value = 100;
    }
    updateCartTotal();
}

function updateCartTotal() {
    addItemToCart('Orange', 'Fresh orange!'); //test
    // console.log('cartItemContainer ' + document.getElementsByClassName('cart-items')[0]);
    var cartItemContainer = document.getElementsByClassName('cart-items')[0];
    // console.log(cartItemContainer);
    // console.log('cartRows' + cartItemContainer.getElementsByClassName('d-sm-flex justify-content-between my-4 pb-4 border-bottom'));
    var cartRows = cartItemContainer.getElementsByClassName('d-sm-flex justify-content-between my-4'); // pb-4 border-bottom
    var total = 0;
    for (let i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i]
        // console.log('priceElement ' + cartRow.getElementsByClassName('font-size-lg text-primary pt-2')[0]);
        var priceElement = cartRow.getElementsByClassName('font-size-lg text-primary pt-2')[0];
        var quantityElement = cartRow.getElementsByClassName('form-control form-control-sm')[0];
        // console.log(priceElement, quantityElement);
        var price = parseFloat(priceElement.innerText.replace('SRD ', ''));
        // console.log('Price: ' + price);
        var quantity = quantityElement.value;
        // console.log('Price * Quantity: ' + price * quantity)
        total = total + (price * quantity)
    }
    total = Math.round(total * 100) / 100;
    document.getElementsByClassName('h3 font-weight-semibold text-center py-3')[0]
        .innerText = 'SRD ' + total;
}

export function addItemToCart(productName, productDescription) {
    var cartRow = document.createElement('div');
    // console.log('productName: '+ productName);
    cartRow.classList.add('justify-content-between');
    var cartItems = document.getElementsByClassName('cart-items')[0];
    console.log('cartItems: ' + cartItems)
    var cartRowContents = '<div class="media d-block d-sm-flex text-center text-sm-left">\n' +
        '                    <a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img\n' +
        '                            src="https://via.placeholder.com/240x240/eeeeee/000000" alt="Product"></a>\n' +
        '                    <div class="media-body pt-3">\n' +
        '                        <h3 class="product-card-title font-weight-semibold border-0 pb-0"><a href="#">Product</a></h3>\n' +
        '                        <div class="font-size-sm"><span class="text-muted mr-2">Type:</span>...</div>\n' +
        '                        <div class="font-size-lg text-primary pt-2">SRD 23</div>\n' +
        '                    </div>\n' +
        '                </div>\n' +
        '                <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 10rem;">\n' +
        '                    <div class="form-group mb-2">\n' +
        '                        <label for="quantity4">Quantity</label>\n' +
        '                        <input class="form-control form-control-sm" type="number" id="quantity4" value="4" min="1"\n' +
        '                               max="100">\n' +
        '                    </div>\n' +
        '                    <button class="btn btn-outline-secondary btn-sm btn-block mb-2" type="button">\n' +
        '                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"\n' +
        '                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"\n' +
        '                             class="feather feather-refresh-cw mr-1">\n' +
        '                            <polyline points="23 4 23 10 17 10"></polyline>\n' +
        '                            <polyline points="1 20 1 14 7 14"></polyline>\n' +
        '                            <path d="M3.51 9a9 9 0 0 1 14.85-3.36L23 10M1 14l4.64 4.36A9 9 0 0 0 20.49 15"></path>\n' +
        '                        </svg>\n' +
        '                        Update cart\n' +
        '                    </button>\n' +
        '                    <button class="btn btn-outline-danger btn-sm btn-block mb-2" type="button">\n' +
        '                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"\n' +
        '                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"\n' +
        '                             class="feather feather-trash-2 mr-1">\n' +
        '                            <polyline points="3 6 5 6 21 6"></polyline>\n' +
        '                            <path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>\n' +
        '                            <line x1="10" y1="11" x2="10" y2="17"></line>\n' +
        '                            <line x1="14" y1="11" x2="14" y2="17"></line>\n' +
        '                        </svg>\n' +
        '                        Remove\n' +
        '                    </button>\n' +
        '                </div>'
    cartRowContents.innerHTML = cartRowContents
    cartItems.append(cartRow)
}

export function addToCartClicked(event) {
    // console.log("clicked :)");
    var button = event.target;
    button.innerText = 'Added to cart!';
    var shopItem = button.parentElement.parentElement.parentElement.parentElement.parentElement;
    var productName = shopItem.getElementsByClassName('text-capitalize')[0].innerText;
    var productDescription = shopItem.getElementsByClassName('prod-description')[0].innerText;
    console.log(productName);
    console.log(productDescription);
    addItemToCart(productName, productDescription);
}

