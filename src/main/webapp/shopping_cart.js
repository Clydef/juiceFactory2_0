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
    // addItemToCart('test1', 'test2');
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
    cartRow.innerText = productName;
    var cartItems = document.getElementsByClassName('cart-items')[0];
    console.log('cartItems: ' + cartItems)
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

