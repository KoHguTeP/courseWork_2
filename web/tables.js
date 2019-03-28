function del(numb) {
    var xhr = new XMLHttpRequest();
    var table = document.getElementById('table');
    var nametable = '/' + table.getAttribute("name");
    var body = 'action=' + 'delete' + '&id=' + numb;
    xhr.open("POST", nametable, false);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
    xhr.send(body);
    window.location = nametable;
}

var id;

function upd(numb) {
    var xhr = new XMLHttpRequest();
    var table = document.getElementById('table');
    id = numb;
    var nametable = '/upd' + table.getAttribute("name");
    if (nametable.localeCompare("/flight") == 0) {
        var body = 'action=' + 'update' + '&id1=' + encodeURIComponent(table.rows[numb].cells[1].innerHTML) + '&id2=' + encodeURIComponent(table.rows[numb].cells[2].innerHTML);
    }
    else {
        var body = 'action=' + 'update' + '&id=' + numb;
    }
    xhr.open("POST", nametable, false);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
    xhr.send(body);
    window.location = nametable;
}

function getId() {
    document.getElementById("id2upd").innerHTML = id;
    //return id;
}