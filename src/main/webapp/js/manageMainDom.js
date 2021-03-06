function renderPendingTable(reimbursements) {
  for (const r of reimbursements) {
    const tr = document.createElement("tr");
    const usernameTd = document.createElement("td");
    const dateSubmitTd = document.createElement("td");
    const descriptionTd = document.createElement("td");
    const statusTd = document.createElement("td");
    const typeTd = document.createElement("td");
    const amountTd = document.createElement("td");
    const approveBox = document.createElement("td");
    const approveButton = document.createElement("button");
    approveBox.appendChild(approveButton);

    usernameTd.innerText = r.username;
    dateSubmitTd.innerText = r.submitted;
    descriptionTd.innerText = r.description;
    statusTd.innerText = r.status;
    typeTd.innerText = r.type;
    amountTd.innerText = r.amount;

    approveButton.innerText = "approve";
    tr.append(
      usernameTd,
      dateSubmitTd,
      descriptionTd,
      statusTd,
      typeTd,
      amountTd,
      approveBox
    );

    document.getElementById("completeReimBody").append(tr);
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

// asyncFetch("http://localhost:8080/Project1/complete.json", renderPendingTable);
asyncFetch(
  "http://3.17.110.130:8081/Project1-0.0.1-SNAPSHOT/complete.json",
  renderPendingTable
);
