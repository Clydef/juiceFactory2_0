getMostFrequentBoughtProduct();

function getMostFrequentBoughtProduct() {
        let xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:9090/juiceFactory2_0/api/orderProduct/mostFrequentBoughtProduct", true);
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState > 3 && xhttp.status == 200) {
                let reportList = JSON.parse(this.responseText);
                console.log(reportList);
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

/*
function getMostFrequentBoughtProduct() {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:9090/juiceFactory2_0/api/orderProduct/mostFrequentBoughtProduct", true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState > 3 && xhttp.status == 200) {
            let reportList = JSON.parse(this.responseText);
            console.log(reportList);
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
}*/
