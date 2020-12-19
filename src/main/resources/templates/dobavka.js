


let user = {
    name: 'John',
    address :'543',
    year :'345',
    username :'345',
    // roles:'null'
};

let response = await fetch('http://localhost:8080/adminn', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(user)
});
let result = await response.json();
alert(result.message);


