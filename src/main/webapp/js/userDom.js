function getCookie(name) {
  const value = `; ${document.cookie}`;
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(";").shift();
}

function renderObjTable(r) {
  const tr = document.createElement("tr");
  const dateSubmitTd = document.createElement("td");
  const descriptionTd = document.createElement("td");
  const statusTd = document.createElement("td");
  const typeTd = document.createElement("td");
  const amountTd = document.createElement("td");

  const deleteForm = document.createElement("form");
  const deleteButtonBox = document.createElement("td");
  const deleteButton = document.createElement("button");
  deleteButtonBox.appendChild(deleteButton);

  deleteButtonBox.appendChild(deleteForm);
  deleteForm.appendChild(deleteButton);

  dateSubmitTd.innerText = r.submitted;
  descriptionTd.innerText = r.description;
  statusTd.innerText = r.status;
  typeTd.innerText = r.type;
  amountTd.innerText = r.amount;

  deleteForm.type = "submit";
  deleteForm.action = "deleteReimbursement.page";
  deleteForm.method = "POST";
  deleteButton.value = r.id;
  deleteButton.name = "id";
  deleteButton.innerText = "delete";
  // setCookie("username", r.username);

  // deleteForm.action = "deleteReimbursement.page";
  // deleteForm.appendChild(deleteButtonBox);

  tr.append(
    dateSubmitTd,
    descriptionTd,
    statusTd,
    typeTd,
    amountTd,
    deleteButtonBox
  );

  document.getElementById("userReimBody").append(tr);
}

const username = getCookie("username");
// setCookie("username", r.username);

// const password = getCookie("password");

document.getElementById("welcome-top").innerText = "Welcome " + username;

async function fetchUserData(name, url) {
  const response = await fetch(url);
  const json = await response.json();
  for (var obj of json) {
    if (obj["username"] == name) {
      renderObjTable(obj);
    }
  }
}

fetchUserData(username, "http://localhost:8080/Project1/complete.json");
