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
                        '<div class="card-img"><img src="https://m.traxxas.com/sites/default/files/55077-3-Jato-ORNG-Front-3-4-LtoR-5799@1x.jpg" ' +
                            'width="240" height="240" alt="..."></div> ' +
                        '<div class="card-body"> ' +
                            '<div> ' +
                                '<a href="#"><i class="bg-white p-3 rounded-circle font-weight-600">add to card</i></a> ' +
                            '</div> ' +
                        '</div> ' +
                    '</div> ' +
                    '<div class="text-center"> ' +
                        '<h4 class="h5 mb-2"><a href="#" class="text-secondary"> ' + productDataList[index].productName + ' </a></h4> ' +
                        '<a> ' + productDataList[index].productDescription + ' </a> ' +
                        '<h5 class="mb-0 text-primary">SRD-</h5> ' +
                    '</div> ' +
                '</div> ';

            }
            productList += "</ul>";
            document.getElementById("productData").innerHTML = productList;
        }
    };
    xhttp.open("GET", "http://localhost:9090/juiceFactory2_0/api/product/list", true);
    xhttp.send();
}