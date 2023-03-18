clearInputFields();
loadCustomerList();
let customerDataList;
function loadCustomerList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
             customerDataList = JSON.parse(this.responseText);
            console.log(JSON.parse(this.responseText));
            let customerList = ' <ul class="w3-ul w3-card-4"> ';

            customerDataList.reverse();
            let customerName = '';
            let customer = null;
            for (let index = 0; index < customerDataList.length; index++) {
                customer = customerDataList[index];
                if (customerDataList[index].category === 'BEDRIJF') {
                    customerName = customerDataList[index].firstName;
                } else {
                    customerName = customerDataList[index].firstName + ' ' + customerDataList[index].lastName;
                }


                    customerList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + customer.customerNumber + ' onclick="editCustomer(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + customer.customerNumber + ' onclick="removeCustomer(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <img src="factory%20images/no_customer_pic.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> Name: ' +  customerName  + ' (' + firstLetterToUpperCase(customer.category) + ') </span><br> ' +
                        ' <span> Customer number: ' +  customer.customerNumber  + ' </span> <br>' +
                        ' <span> Email: ' +  customer.email  + ' </span> <br>' +
                    ' <span> Address: ' +  customer.address  + ' </span> <br>' +

                    ' <span> District: ' +  customer.district  + ' </span> <br>' +
                    ' <span> Phone Number: ' +  customer.phoneNumber  + ' </span> ' +
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
    let customer = {
        "customerNumber" : document.getElementById("customerNumber").value,
        "firstName" : document.getElementById("firstName").value,
        "lastName" : document.getElementById("lastName").value,
        "email" : document.getElementById("email").value,
        "address" : document.getElementById("address").value,
        "district" : document.getElementById("district").value,
        "phoneNumber" : document.getElementById("phoneNumber").value,
        "category" : document.getElementById("category").value
    }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "/juiceFactory2_0/api/customer/update", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status===200) { loadCustomerList(); clearInputFields();}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(customer));
    // loadCustomerList();
}

function addCustomer()
{
    let customer = {
        "firstName" : document.getElementById("firstName").value,
        "lastName" : document.getElementById("lastName").value,
        "email" : document.getElementById("email").value,
        "address" : document.getElementById("address").value,
        "district" : document.getElementById("district").value,
        "phoneNumber" : document.getElementById("phoneNumber").value,
        "category" : document.getElementById("category").value
    }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/juiceFactory2_0/api/customer/add", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status===200) { loadCustomerList(); clearInputFields();}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(customer));
}

function clearInputFields()
{
    document.getElementById("customerId").value = "";
    document.getElementById("customerNumber").value = "";
    document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
    document.getElementById("address").value = "";
    document.getElementById("district").value = "";
    document.getElementById("phoneNumber").value = "";
    document.getElementById("email").value = "";
    document.getElementById("category").value = "";

    document.getElementById("btnSaveCustomer").innerText = "Create Customer";
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
        if (xhttp.readyState>3 && xhttp.status===200) { loadCustomerList(); }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(customerNumber);
}

function editCustomer(customerNumber)
{
    for (let customerNumberElement of customerDataList) {
        // console.log("Element: "+ customerNumberElement.customerNumber + " Customer: "+ customerNumber);
        // console.log(customerNumberElement.customerNumber == customerNumber);
        if (customerNumberElement.customerNumber === customerNumber) {
            // document.getElementById("btnSaveCustomer").disabled = false;
            document.getElementById("customerNumber").value = customerNumberElement.customerNumber;
            document.getElementById("firstName").value = customerNumberElement.firstName;
            document.getElementById("lastName").value = customerNumberElement.lastName;
            document.getElementById("email").value = customerNumberElement.email;
            document.getElementById("address").value = customerNumberElement.address;
            document.getElementById("district").value = customerNumberElement.district;
            document.getElementById("phoneNumber").value = customerNumberElement.phoneNumber;
            document.getElementById("category").value = customerNumberElement.category;
        }
    }
    document.getElementById("btnSaveCustomer").innerText = "Update Customer";
}

function saveCustomer()
{
    if(validateForm())
    {
        if (document.getElementById("customerNumber").value) {
            updateCustomer();
        }
        else {
            addCustomer();
        }

    }
}

function validateForm()
{
    let pass = true;
    let firstName = document.getElementById("firstName").value;
    let address = document.getElementById("address").value;
    let district = document.getElementById("district").value;
    let phoneNumber = document.getElementById("phoneNumber").value;

    if (firstName == null || firstName === "", address == null || address === "", district == null || district === "",
        phoneNumber === "" || phoneNumber == null)
    {
        alert("Please fill in all the fields.");
        pass = false;
    }

    return pass;
}

function firstLetterToUpperCase(category) {
    return newStr = category.charAt(0).toUpperCase() + category.slice(1).toLowerCase();
}