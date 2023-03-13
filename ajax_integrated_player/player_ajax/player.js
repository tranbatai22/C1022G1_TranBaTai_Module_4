
function showList() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/rest/players",
        success: function (data) {
            console.log(data);
            let table = '';
            for (let i = 0; i < data.length; i++) {
                table += `<tr>`
                table += `<th scope="row">${i + 1}</th>`
                table += `<td>${data[i].name}</td>`
                table += `<td>${data[i].age}</td>`
                table += `<td>${data[i].position}</td>`
                table += `<td>${data[i].experience}</td>`
                table += `<td>${data[i].status}</td>`
                table += `</tr>`;
            }
            $('#playerList').html(table);
        }
    });
}


function add() {
    let name = $('#name').val();
    let age = $('#age').val();
    let position = $('#position').val();
    let experience = $('#experience').val();
    let status = $('#status').val();
    let player = {
        name: name,
        age: age,
        position: position,
        experience: experience,
        status: status
    }
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        type: 'POST',
        url: 'http://localhost:8080/rest/players',
        data: JSON.stringify(player),
        success: function () {
            $('#modal').toggle();
            $('#modal').hide();
        },
        complete: function (data) {
            console.log(data);
            showList();
        }
    })
}






















// function loadPlayer(players, append) {
//     $.ajax({
//         type: "GET",
//         dataType: "json",
//         url: "http://localhost:8080/rest/players",
//         success: function (data) {      //callback xử lí khi request thành công
//             let element = "";
//             for (let player of players) {
//                 element += `
//         <div class="card" style="width: 18rem;">
//             <img src="${player.image}" class="card-img-top" alt="...">
//             <div class="card-body">
//                 <h5 class="card-title">@{player.name}</h5>
//                 <p class="card-text">${player.position}</p>
//                 <a href="#" class="btn btn-primary">Add</a>
//             </div>
//         </div>
//         `;
//                 if (append) {
//                     $('#listPlayers').append(element);
//                 } else {
//                     $('#listPlayers').html(element);
//                 }
//             }
//         },
//         error: function (error) {      //callback xử lí khi request thành công
//             console.log(error);
//         }
//     })
// }
// //
// // function renderPlayers(players, append) {
// //     let element = "";
// //     for (let player of players) {
// //         element += `
// //         <div class="card" style="width: 18rem;">
// //             <img src="${player.image}" class="card-img-top" alt="...">
// //             <div class="card-body">
// //                 <h5 class="card-title">@{player.name}</h5>
// //                 <p class="card-text">${player.position}</p>
// //                 <a href="#" class="btn btn-primary">Add</a>
// //             </div>
// //         </div>
// //         `;
// //         if (append) {
// //             $("#listPlayers").append(element);
// //         } else {
// //             $("#listPlayers").html(element);
// //         }
// //     }
// // }
//
// // function renderLoadMoreButton(playerPageData) {
// //     if (playerPageData.number < playerPageData.totalPages - 1) {
// //         $("#loadMoreContainer").html(
// //             `<button type="button" class="btn btn-secondary"
// //                   onclick="loadMore(${playerPageData.number + 1})">
// //                   Load More
// //              </button>
// //
// //             `
// //         )
// //     }
// // }