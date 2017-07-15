/**
 *
 * Created by johnn on 7/15/2017.
 */

window.onload = ajaxGetAllRequests();

function ajaxGetAllRequests() {
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HttpRequest");

    xhr.onreadystatechange = function () {
        if (xhr.readyState !== 4) {
            // console.log("status != 4");
            return;
        }

        if (xhr.status === 200) {
            let res = xhr.responseText;
            let json = JSON.parse(res);
            // console.log(res);
            // console.log(json);

            let num = 1;
            let td = document.createElement("td");
            let t = document.getElementById("tableBody");

            for (let i = 0; i < json.length; i++) {
                let tr = document.createElement("tr");

                let link = json[i].id;
                let status = json[i].reimbursementStatus;
                let submitted = json[i].submitted;
                let updated = json[i].resolved;

                let td1 = document.createElement("td");
                let td2 = document.createElement("td");
                let td3 = document.createElement("td");
                let td4 = document.createElement("td");
                let td5 = document.createElement("td");

                switch (status) {
                    case 1:
                        status = "Pending";
                        break;
                    case 2:
                        status = "Approved";
                        break;
                    case 3:
                        status = "Denied";
                        break;
                    case 4:
                        status = "Other";
                        break;
                }

                td1.innerHTML = num;
                td2.innerHTML = link;
                td3.innerHTML = status;
                td4.innerHTML = submitted;
                td5.innerHTML = updated;
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                t.appendChild(tr);
                num++;
            }
        }
    };

    let url = "/getinfo";
    xhr.open("Get", url, true);
    xhr.send();
}