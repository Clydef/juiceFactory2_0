let customer;
let isRetrieved = false;
let customerCount = 700;

function validateForm() {
    let pass = true;
    let name = document.getElementById("name").value;
    let district = document.getElementById("district").value;
    let address = document.getElementById("address").value;
    let phoneNumber = document.getElementById("phoneNumber").value;
    // let customerNumber = document.getElementById("customerNumber").value;

    if (district == null || district == "",
    address == null || address == "",
    phoneNumber == null || phoneNumber == "",
    name == null || name == "") {
        alert("Please fill in all fields properly");
        pass = false;
    }
    return pass;
}

function addCustomer() {
    if (validateForm()) {
        customer = {
            "name": document.getElementById("name").value,
            "district": document.getElementById("district").value,
            "address": document.getElementById("address").value,
            "phoneNumber": document.getElementById("phoneNumber").value,
            "customerNumber": customerCount++
        }
        clearInputFields();
    }
}

function clearInputFields() {
    document.getElementById("name").value = "";
    document.getElementById("district").value = "";
    document.getElementById("address").value = "";
    document.getElementById("phoneNumber").value = "";
}

function saveCustomer() {
        let xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:9090/juiceFactory2_0/api/customer/add", true);
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState > 3 && xhttp.status == 200) {
                let isAdded = this.responseText;
                if (isAdded == "true") {
                    clearInputFields();
                    alert("Customer saved");
                } else {
                    alert("Customer not saved")
                }
            }
        };
        xhttp.setRequestHeader("Content-Type", "application/json");
        xhttp.send(JSON.stringify(customer));
        isRetrieved = false;
}

function addForReal() {
    addCustomer();
    saveCustomer();
}