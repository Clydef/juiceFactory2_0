clearInputFields();
loadCustomerList();
let customerDataList;
function loadCustomerList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
             customerDataList = JSON.parse(this.responseText);
            let customerList = ' <ul class="w3-ul w3-card-4"> ';

            customerDataList.reverse();
            let customerName = '';

            for (let index = 0; index < customerDataList.length; index++) {
                if (customerDataList[index].category === 'BEDRIJF') {
                    customerName = customerDataList[index].firstName;
                } else {
                    customerName = customerDataList[index].firstName + customerDataList[index].lastName;
                }


                    customerList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + customerDataList[index].customerNumber + ' onclick="editCustomer(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + customerDataList[index].customerNumber + ' onclick="removeCustomer(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <img src="factory%20images/no_customer_pic.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> Name: ' +  customerName  + ' </span><br> ' +
                    ' <span> Address: ' +  customerDataList[index].address  + ' </span> <br>' +

                    ' <span> District: ' +  customerDataList[index].district  + ' </span> <br>' +
                    ' <span> Phone Number: ' +  customerDataList[index].phoneNumber  + ' </span> ' +
                    ' </div> ';
            }
            customerList += "</ul>";
            document.getElementById("customerData").innerHTML = customerList;
        }
    };
    xhttp.open("GET", "/juiceFactory2_0/api/customer/list", true);
    xhttp.send();
}

function updateCustomer()
{
    let customer = {  "customerNumber" : document.getElementById("customerNumber").value, "name" : document.getElementById("name").value,
        "address" : document.getElementById("address").value, "district" : document.getElementById("district").value,
        "phoneNumber" : document.getElementById("phoneNumber").value }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "/juiceFactory2_0/api/customer/update", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) { loadCustomerList(); clearInputFields(); document.getElementById("btnSaveCustomer").innerHTML = "Add Customer";}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(customer));
    // loadCustomerList();
}

function clearInputFields()
{
    document.getElementById("customerNumber").value = "";
    document.getElementById("name").value = "";
    document.getElementById("address").value = "";
    document.getElementById("district").value = "";
    document.getElementById("phoneNumber").value = "";

    // document.getElementById("btnSaveCustomer").innerHTML = "Add Customer";
}

function removeCustomer(customerNumber)
{
    if ( confirm("Are you sure you want to delete this customer?") ) {
        deleteCustomer(customerNumber);
    }
}

function deleteCustomer(customerNumber)
{
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/juiceFactory2_0/api/customer/remove", true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState>3 && xhttp.status==200) { loadCustomerList(); }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(customerNumber));
}

function editCustomer(customerNumber)
{
    for (let customerNumberElement of customerDataList) {
        // console.log("Element: "+ customerNumberElement.customerNumber + " Customer: "+ customerNumber);
        // console.log(customerNumberElement.customerNumber == customerNumber);
        if (customerNumberElement.customerNumber == customerNumber) {
            document.getElementById("phoneNumber").disabled = false;
            document.getElementById("btnSaveCustomer").disabled = false;
            document.getElementById("customerNumber").value = customerNumberElement.customerNumber;
            document.getElementById("name").value = customerNumberElement.firstName;
            document.getElementById("address").value = customerNumberElement.address;
            document.getElementById("district").value = customerNumberElement.district;
            document.getElementById("phoneNumber").value = customerNumberElement.phoneNumber;
        }
    }
}

function saveCustomer()
{
    // document.getElementById("phoneNumber").disabled = false;

    if(validateForm())
    {
        updateCustomer();
    }
}

function validateForm()
{
    let pass = true;
    let name = document.getElementById("name").value;
    let address = document.getElementById("address").value;
    let district = document.getElementById("district").value;
    let phoneNumber = document.getElementById("phoneNumber").value;

    if (name == null || name == "", address == null || address == "", district == null || district == "",
        phoneNumber == "" || phoneNumber == null)
    {
        alert("Please fill in all the fields.");
        pass = false;
    }

    return pass;
}