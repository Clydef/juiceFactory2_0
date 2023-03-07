var productArray = [];

loadProductList();

function addAllToCart() {
    sessionStorage.setItem('sessionProductObject', JSON.stringify(productArray));
}

function loadProductList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let productDataList = JSON.parse(this.responseText);
            productDataList.reverse(); //why tho?

            let productList = '';
            for (let index = 0; index < productDataList.length; index++) {
                productList +=
                    '<div class="col-sm-6 col-lg-3 mb-2-6"> ' +
                    '<div class="card-wrapper mb-4"> ' +
                    '<div class="card-img"><img src="'+productDataList[index].imageUrl+'" ' +
                    'width="240" height="240" alt="..."></div> ' +
                    '<div class="card-body"> ' +
                    '<div> ' +
                    '<a type="button"><i id="' + index + '" class="bg-white p-3 rounded-circle font-weight-600">add to cart</i></a> ' +
                    '</div> ' +
                    '</div> ' +
                    '</div> ' +
                    '<div class="text-center"> ' +
                    '<h4 class="h5 mb-2"><a class="text-capitalize"> ' + productDataList[index].name + ' </a></h4> ' +
                    '<a class="prod-description" style="color:#000000; text-decoration:none" > ' + productDataList[index].description + ' </a> ' +
                    '<h5 class="mb-0 text-primary">SRD '+ productDataList[index].price +',-</h5> ' +
                    '</div> ' +
                    '</div> ';

            }
            document.getElementById("productData").innerHTML = productList;

            var addCartButtons = document.getElementsByClassName('bg-white p-3 rounded-circle font-weight-600');
            for (let i = 0; i < addCartButtons.length; i++) {
                var button = addCartButtons[i]
                button.addEventListener('click', addToCartClicked)
            }
            hideSpinner();
        }
    };
    xhttp.open("GET", "http://localhost:9090/juiceFactory2_0/api/product/list", true);
    xhttp.send();
}

function hideSpinner() {
    document.getElementById('spinner')
        .style.display = 'none';
}

/*function addItemToCart(productName, productDescription) {
    var cartRow = document.createElement('div');
    console.log('productName: '+ productName);
    var cartItems = document.getElementsByClassName('cart-items')[0];
    console.log('cartItems: ' + cartItems)
    // cartItems.append(cartRow)
}*/

function addToCartClicked(event) {
    var button = event.target;
    if (button.innerText === 'Added to cart!') {return;}
    button.innerText = 'Added to cart!';
    var shopItem = button.parentElement.parentElement.parentElement.parentElement.parentElement;

    var productName = shopItem.getElementsByClassName('text-capitalize')[0].innerText;
    var productDescription = shopItem.getElementsByClassName('prod-description')[0].innerText;
    var productPrice = shopItem.getElementsByClassName('mb-0 text-primary')[0].innerText;
    const imageElement = shopItem.querySelector('img');
    const productImage = imageElement.getAttribute('src');
    var productObject = {
        'productName': productName,
        'productDescription': productDescription,
        'productPrice': productPrice,
        'productImage': productImage
    };

    productArray.push(productObject);
    console.log(productArray);
}


