// fetch("http://localhost:8080/admin").then(
//     res=>{
//         res.json().then(
//             data=>{
//                 console.log(data);
//             }
//         )
//     }
// )
$(document).ready(data());
    fetch("http://localhost:8080/adminnn").then(
    res => {
    res.json().then(
        data => {
            console.log(data);
            if (data.length > 0) {
                var temp = "";

                data.forEach((u) => {
                    temp += "<tr>";
                    temp += "<td>" + u.id + "<td>";
                    temp += "<td>" + u.name + "<td>";
                    temp += "<td>" + u.address + "<td>";
                    temp += "<td>" + u.year + "<td>";
                    temp += "<td>" + u.username + "<td>";
                    temp += "<td>" + u.address + "<td>";
                    temp += "<td>" + u.address + "<td>";
                })
                document.getElementById("data").innerHTML = temp;
            }
        }
    )
})



