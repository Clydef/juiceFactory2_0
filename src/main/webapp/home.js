function loadProductList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let productDataList = JSON.parse(this.responseText);
            let productList = ' <ul class="w3-ul w3-card-4"> ';

            productDataList.reverse();

            for (let index = 0; index < productDataList.length; index++) {
                productList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + productDataList[index].id + ' onclick="editMedicine(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + productDataList[index].id + ' onclick="removeMedicine(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> Name: ' +  productDataList[index].name  + ' </span><br> ' +
                    ' <span> Brand: ' +  productDataList[index].brand  + ' </span> <br>' +
                    ' <span> Description: ' +  productDataList[index].description  + ' </span> <br>' +
                    ' <span> Stock: ' +  productDataList[index].stock  + ' </span> <br> ' +
                    ' </div> ';
            }
            productList += "</ul>";
            document.getElementById("productData").innerHTML = productList;
        }
    };
    xhttp.open("GET", "/juiceFactory2_0/api/product/list", true);
    xhttp.send();
}