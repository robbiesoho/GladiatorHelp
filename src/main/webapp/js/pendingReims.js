function renderPendingTable(reimbursements) {
  for (const r of reimbursements) {
    const tr = document.createElement("tr");
    const usernameTd = document.createElement("td");
    const dateSubmitTd = document.createElement("td");
    const descriptionTd = document.createElement("td");
    const typeTd = document.createElement("td");
    const amountTd = document.createElement("td");

    const approveForm = document.createElement("form");
    const approveBox = document.createElement("td");
    const approveButton = document.createElement("button");

    approveBox.appendChild(approveForm);
    approveForm.appendChild(approveButton);

    approveForm.type = "submit";
    approveForm.action = "approveReimbursement.page";
    approveForm.method = "POST";
    approveButton.name = "id";
    approveButton.value = r.id;

    const denyForm = document.createElement("form");
    const denyBox = document.createElement("td");
    const denyButton = document.createElement("button");

    denyBox.appendChild(denyForm);
    denyForm.appendChild(denyButton);

    denyForm.type = "submit";
    denyForm.action = "denyReimbursement.page";
    denyForm.method = "POST";
    denyButton.name = "id";
    denyButton.value = r.id;

    usernameTd.innerText = r.username;
    dateSubmitTd.innerText = r.submitted;
    descriptionTd.innerText = r.description;
    typeTd.innerText = r.type;
    amountTd.innerText = r.amount;

    approveButton.innerText = "approve";
    denyButton.innerText = "deny";
    tr.append(
      usernameTd,
      dateSubmitTd,
      descriptionTd,
      typeTd,
      amountTd,
      approveBox,
      denyBox
    );

    document.getElementById("completeReimBody").append(tr);
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

// asyncFetch("http://localhost:8080/Project1/pending.json", renderPendingTable);
asyncFetch(
  "http://3.17.110.130:8081/Project1-0.0.1-SNAPSHOT/pending.json",
  renderPendingTable
);
