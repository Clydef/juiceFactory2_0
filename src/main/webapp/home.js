function loadProductList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let medicineDataList = JSON.parse(this.responseText);
            let medicineList = ' <ul class="w3-ul w3-card-4"> ';

            medicineDataList.reverse();

            for (let index = 0; index < medicineDataList.length; index++) {
                medicineList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + medicineDataList[index].id + ' onclick="editMedicine(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + medicineDataList[index].id + ' onclick="removeMedicine(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <img src="https://png.pngtree.com/element_our/20200610/ourlarge/pngtree-medical-capsule-medicine-image_2242252.jpg" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> Name: ' +  medicineDataList[index].name  + ' </span><br> ' +
                    ' <span> Brand: ' +  medicineDataList[index].brand  + ' </span> <br>' +
                    ' <span> Description: ' +  medicineDataList[index].description  + ' </span> <br>' +
                    ' <span> Stock: ' +  medicineDataList[index].stock  + ' </span> <br> ' +
                    ' </div> ';
            }
            medicineList += "</ul>";
            document.getElementById("medicineData").innerHTML = medicineList;
        }
    };
    xhttp.open("GET", "/healthcentremanagement-front-end/api/product/list", true);
    xhttp.send();
}