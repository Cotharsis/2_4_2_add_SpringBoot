fetch("http://localhost:8080/adminn/ad").then(
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
                        temp += "<td>" + u.roles + "<td>";
                        temp += "<td>" + "<button type='button' data-toggle='modal' class='btn btn-primary'"
                            + "data-target='#ModalEdit' data-user-id='" + u.id + "'>Edit</button>"+'</td>';
                        temp += "<td>" + "<button type='button' data-toggle='modal' class='btn btn-danger'"
                            + "data-target='#ModalDelete' data-user-id='" + u.id + "'>Delete</button>"+'</td><tr>';
                        // <button type="button" class="btn btn-danger" data-toggle="modal"
                        //         th:data-target="'#edit-modal2-' + ${userq.id}">Delete</button>
                    })
                    document.getElementById("data").innerHTML = temp;
                }
            }
        )
    }
)