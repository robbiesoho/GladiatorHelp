function renderObjTable(r) {
  const tr = document.createElement("tr");
  const dateSubmitTd = document.createElement("td");
  const descriptionTd = document.createElement("td");
  const statusTd = document.createElement("td");
  const typeTd = document.createElement("td");
  const amountTd = document.createElement("td");
  // const approveBox = document.createElement("td");
  // const approveButton = document.createElement("button");
  // approveBox.appendChild(approveButton);

  dateSubmitTd.innerText = r.submitted;
  descriptionTd.innerText = r.description;
  statusTd.innerText = r.status;
  typeTd.innerText = r.type;
  amountTd.innerText = r.amount;

  // approveButton.innerText = "approve";
  tr.append(
    dateSubmitTd,
    descriptionTd,
    statusTd,
    typeTd,
    amountTd
    //   approveBox
  );

  document.getElementById("userReimBody").append(tr);
}

const username = `${document.cookie}`.slice(9);

async function fetchUserData(name, url) {
  const response = await fetch(url);
  const json = await response.json();
  console.log(username);
  for (var obj of json) {
    if (obj["username"] == name) {
      renderObjTable(obj);
    }
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

fetchUserData(username, "http://localhost:8080/Project1/complete.json");
