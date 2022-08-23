loadProductList();

function loadProductList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let productDataList = JSON.parse(this.responseText);
            console.log("attempt loading...");
            let productList = ' <ul class="w3-ul w3-card-4"> ';

            productDataList.reverse();

            for (let index = 0; index < productDataList.length; index++) {
                productList +=
                    '<div class="col-sm-6 col-lg-3 mb-2-6"> ' +
                    '<div class="card-wrapper mb-4"> ' +
                    '<div class="card-img"><img src="https://scontent.forg2-1.fna.fbcdn.net/v/t39.30808-6/230586954_354541669543274_4846530692725520769_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=AqG5_q_uk8YAX_dkKmp&_nc_ht=scontent.forg2-1.fna&oh=00_AT_2Kujtra3rHZz4qWE2Mxi88yTJaFdYw5eFGDbCgEn4vg&oe=63049026" ' +
                    'width="240" height="240" alt="..."></div> ' +
                    '<div class="card-body"> ' +
                    '<div> ' +
                    '<a type="button"><i id="' + index + '" class="bg-white p-3 rounded-circle font-weight-600">add to cart</i></a> ' +
                    '</div> ' +
                    '</div> ' +
                    '</div> ' +
                    '<div class="text-center"> ' +
                    '<h4 class="h5 mb-2"><a class="text-capitalize"> ' + productDataList[index].productName + ' </a></h4> ' +
                    '<a class="prod-description" style="color:#000000; text-decoration:none" > ' + productDataList[index].productDescription + ' </a> ' +
                    '<h5 class="mb-0 text-primary">SRD 20,-</h5> ' +
                    '</div> ' +
                    '</div> ';

            }
            productList += "</ul>";
            document.getElementById("productData").innerHTML = productList;

            var addCartButtons = document.getElementsByClassName('bg-white p-3 rounded-circle font-weight-600');
            for (let i = 0; i < addCartButtons.length; i++) {
                var button = addCartButtons[i]
                button.addEventListener('click', addToCartClicked)
            }
        }
    };
    xhttp.open("GET", "http://localhost:9090/juiceFactory2_0/api/product/list", true);
    xhttp.send();
}

function addtoCartMgs(i) {
    // document.getElementById(i).innerHTML = "Added to Cart!";
    // document.getElementsByClassName('bg-white p-3 rounded-circle font-weight-600')[0].innerText = "Added to Cart!";
}

function addToCartClicked(event) {
    // console.log("clicked :)");
    var button = event.target;
    button.innerText = 'Added to cart!';
    var shopItem = button.parentElement.parentElement.parentElement.parentElement.parentElement;
    var productName = shopItem.getElementsByClassName('text-capitalize')[0].innerText;
    var productDescription = shopItem.getElementsByClassName('prod-description')[0].innerText;
    console.log(productName);
    console.log(productDescription);
}