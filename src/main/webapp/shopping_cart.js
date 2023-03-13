var sessionProduct = JSON.parse(sessionStorage.getItem('sessionProductObject'));

if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready);
} else {
    ready()
}

function ready() {
    addItemToCart();
    var removeCartItemButtons = document.getElementsByClassName('btn-outline-danger btn-sm btn-block mb-2')
    for (var i = 0; i < removeCartItemButtons.length; i++) {
        var button = removeCartItemButtons[i]
        button.addEventListener('click', function (event) {
            removeCartItem(event, i);
        });
    }

    var quantityInputs = document.getElementsByClassName('form-control form-control-sm');
    for (let i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i]
        input.addEventListener('change', quantityChanged)
    }
}

function removeCartItem(event, i) {
    var buttonClicked = event.target;
    console.log(buttonClicked.parentElement.parentElement);
    console.log(i);
    buttonClicked.parentElement.parentElement.remove();
    updateCartTotal();
    //TODO: Item weghalen van sessionStorage

    // let myArray = JSON.parse(sessionStorage.getItem('sessionProductObject'));

    // let itemToRemove = 'item2';
    // let indexToRemove = myArray.indexOf(itemToRemove);
    // if (indexToRemove !== -1) {
    //     myArray.splice(indexToRemove, 1);
    // }

// Update the sessionStorage with the updated array
//     sessionStorage.setItem('sessionProductObject', JSON.stringify(myArray));
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
    // addItemToCart(); //test
    var cartItemContainer = document.getElementsByClassName('cart-items')[0];
    var cartRows = cartItemContainer.getElementsByClassName('d-sm-flex justify-content-between my-4'); // pb-4 border-bottom
    var total = 0;
    for (let i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i]
        var priceElement = cartRow.getElementsByClassName('font-size-lg text-primary pt-2')[0];
        var quantityElement = cartRow.getElementsByClassName('form-control form-control-sm')[0];
        var price = parseFloat(priceElement.innerText.replace('SRD ', ''));
        var quantity = quantityElement.value;
        // console.log('Price * Quantity: ' + price * quantity)
        total = total + (price * quantity)
    }
    total = Math.round(total * 100) / 100;
    document.getElementsByClassName('h3 font-weight-semibold text-center py-3')[0]
        .innerText = 'SRD ' + total;
}

function addItemToCart() {
    // var productNameSes = sessionProduct[0].productName;
    var cartRow = document.createElement('div');
    var cartItems = document.getElementsByClassName('cart-items')[0];
    // var cartItemNames = cartItems.getElementsByClassName('product-card-title');
    var cartRowContents = '';
    if (sessionProduct.length === 0) {
        cartRowContents += `<p>NO ITEMS IN CART!</p>`;
    } else {
        for (let i = 0; i < sessionProduct.length; i++) {
            cartRowContents +=
                `<div class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
                <div class="media d-block d-sm-flex text-center text-sm-left">
                    <a class="cart-item-thumb mx-auto mr-sm-4"><img
                            src="${sessionProduct[i].productImage}" alt="Product"></a>
                    <div class="media-body pt-3">
                        <h3 class="product-card-title font-weight-semibold border-0 pb-0"><a href="#">${sessionProduct[i].productName}</a></h3>
                        <div class="font-size-sm"><span class="text-muted mr-2"><i>${sessionProduct[i].productDescription}</i></span></div>
                        <div class="font-size-lg text-primary pt-2">${sessionProduct[i].productPrice} </div><i>p/unit</i>
                    </div>
                </div>
                <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 10rem;">
                    <div class="form-group mb-2">
                        <label for="quantity4">Quantity</label>
                        <input class="form-control form-control-sm" type="number" id="quantity4" value="1" min="1"
                               max="100">
                    </div>
                    <button class="btn btn-outline-secondary btn-sm btn-block mb-2" type="button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                             class="feather feather-refresh-cw mr-1">
                            <polyline points="23 4 23 10 17 10"></polyline>
                            <polyline points="1 20 1 14 7 14"></polyline>
                            <path d="M3.51 9a9 9 0 0 1 14.85-3.36L23 10M1 14l4.64 4.36A9 9 0 0 0 20.49 15"></path>
                        </svg>
                        Update cart
                    </button>
                    <button class="btn btn-outline-danger btn-sm btn-block mb-2" type="button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                             class="feather feather-trash-2 mr-1">
                            <polyline points="3 6 5 6 21 6"></polyline>
                            <path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>
                            <line x1="10" y1="11" x2="10" y2="17"></line>
                            <line x1="14" y1="11" x2="14" y2="17"></line>
                        </svg>
                        Remove
                    </button>
                </div>
            </div>`;
            updateCartTotal();
        }
    }
    cartRow.innerHTML = cartRowContents
    cartItems.append(cartRow)
}

function SRDConverter() {
    let amountWithCurrency = document.getElementById("totalAmount").innerHTML;
    let currency = amountWithCurrency.substring(0,3);
    if (currency === 'USD') {return;}
    let amount = amountWithCurrency.substring(4);
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/juiceFactory2_0/api/pattern/SRDConverter", true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState > 3 && xmlhttp.status === 200) {
            console.log(JSON.parse(this.responseText));
            document.getElementById("totalAmount").innerHTML = 'USD ' + JSON.parse(this.responseText);
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(amount)
    ;
}

function USDConverter() {
    let amountWithCurrency = document.getElementById("totalAmount").innerHTML;
    let currency = amountWithCurrency.substring(0,3);
    if (currency === 'SRD') {return;}
    let amount = amountWithCurrency.substring(4);
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/juiceFactory2_0/api/pattern/USDConverter", true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState > 3 && xmlhttp.status === 200) {
            console.log(JSON.parse(this.responseText));
            document.getElementById("totalAmount").innerHTML = 'SRD ' + JSON.parse(this.responseText);
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(amount)
    ;
}

