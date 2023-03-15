//  customers: danh sách sản phẩm cần được render lên browser
//  append: nếu là true thì dữ diệu khách hàng sẽ được append tiếp vào danh sách sản phẩm hiện tại, false thì ngược lại
function renderCustomer(customers, append) {
    let element = '';
    for (let customer of customers) {
        // sử dụng `` để thao tác với chuỗi multiple lines
        element += `<tr>`
        element += `<td>${customer.customerId}</td>`
        element += `<td>${customer.customerName}</td>`
        element += `<td>${customer.customerDateOfBirth}</td>`
        element += `<td>${customer.customerGender}</td>`
        element += `<td>${customer.customerEmail}</td>`
        element += `<td>${customer.customerAddress}</td>`
        element += `<td>${customer.customerPhoneNumber}</td>`
        // element += `<td>${customer.customerType.customerTypeName}</td>`
        element += `</tr>`;
    }
    //nếu append = true thì sử dụng .append
    if (append) {
        $("#customerList").append(element);
    } else {
        //nếu append = false thì sử dụng .html để ghi đè lại danh sách sản phẩm hiện tại được hiển thị trên browser
        $('#customerList').html(element);
    }
}

function loadCustomer(page, append) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/customer?page=${page ? page : "0"}`,
        headers: {
            "Content-Type": "application/json",
        },
        // callback xử lí khi request thành công
        success: function (data) {
            renderCustomer(data.content, append);
        },
        // callback xử lí khi request thất bại
        error: function (error) {
            console.log(error);
        }
    })
}

// chờ cho document sẵn sàng rồi mới thực hiện phần code bên trong callback (lấy dữ liệu khách hàng)
$(document).ready(function () {
    loadCustomer();
})