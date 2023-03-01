// getMostFrequentBoughtProduct();
// getMostFrequentCustomer();

function getMostFrequentBoughtProduct() {
        let xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:9090/juiceFactory2_0/api/orderProduct/mostFrequentBoughtProduct", true);
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState > 3 && xhttp.status == 200) {
                let reportList = JSON.parse(this.responseText);
                // console.log(reportList);
                if (reportList.length !== 0) {
                    document.getElementById("mostFrequentBoughtProduct").innerHTML = '<h4 class="h5 mb-2"><a class="text-capitalize">Quantity:  ' + reportList.quantity + ' </a></h4> ' +
                        '<h5 class="mb-0 text-primary">OrderId: ' + reportList.id.orderId + '</h5> ';
                } else {
                    document.getElementById("mostFrequentBoughtProduct").innerHTML = "No reports available";
                }
            }
        };
        xhttp.setRequestHeader("Content-Type", "application/json");
        xhttp.send();
}

function getMostFrequentCustomer() {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:9090/juiceFactory2_0/api/order/mostFrequentCustomer", true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState > 3 && xhttp.status == 200) {
            let reportList = JSON.parse(this.responseText);
            console.log(reportList);
            if (reportList.length !== 0) {
                document.getElementById("mostFrequentCustomer").innerHTML = '<h4 class="h5 mb-2"><a class="text-capitalize">orderNumber:  ' + reportList.orderNumber + ' </a></h4> ' +
                    '<h5 class="mb-0 text-primary">orderDate year: ' + reportList.orderDate.year + '</h5> ';
            } else {
                document.getElementById("mostFrequentCustomer").innerHTML = "No reports available";
            }
        }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send();
}



function yearReport() {
    var e = document.getElementById("details");
    var value = e.value;
    console.log(value);
    var text = e.options[e.selectedIndex].text;
    console.log(text);
    findOrderDateByMonth(text);
}

function findOrderDateByMonth(year) {
    let reportRequest = {'stringyear': year}
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:9090/juiceFactory2_0/api/order/findOrderDateByMonth", true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState > 3 && xhttp.status == 200) {
            let reportList = JSON.parse(this.responseText);
            console.log(reportList);
            if (reportList.length !== 0) {
                document.getElementById("mostFrequentCustomer").innerHTML = '<h4 class="h5 mb-2"><a class="text-capitalize">orderNumber:  ' + reportList.orderNumber + ' </a></h4> ' +
                    '<h5 class="mb-0 text-primary">orderDate year: ' + reportList.orderDate.year + '</h5> ';
            } else {
                document.getElementById("mostFrequentCustomer").innerHTML = "No reports available";
            }
        }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(reportRequest));
}
