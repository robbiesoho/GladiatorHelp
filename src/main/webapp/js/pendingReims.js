function renderPendingTable(reimbursements) {
  for (const r of reimbursements) {
    const tr = document.createElement("tr");
    const usernameTd = document.createElement("td");
    const dateSubmitTd = document.createElement("td");
    const descriptionTd = document.createElement("td");
    const typeTd = document.createElement("td");
    const amountTd = document.createElement("td");
    const approveBox = document.createElement("td");
    const approveButton = document.createElement("button");
    approveBox.appendChild(approveButton);
    const denyBox = document.createElement("td");
    const denyButton = document.createElement("button");
    denyBox.appendChild(denyButton);

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

asyncFetch("http://localhost:8080/Project1/pending.json", renderPendingTable);
