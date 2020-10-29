function renderTable(reimbursements) {
  for (const r of reimbursements) {
    const tr = document.createElement("tr");
    const usernameTd = document.createElement("td");
    const dateSubmitTD = document.createElement("td");
    const descriptionTd = document.createElement("td");
    const statusTd = document.createElement("td");
    const typeTd = document.createElement("td");
    const amountTd = document.createElement("td");

    usernameTd.innerText = r.username;
    dateSubmitTD.innerText = r.submitted;
    descriptionTd.innerText = r.description;
    statusTd.innerText = r.status;
    typeTd.innerText = r.type;
    amountTd.innerText = r.amount;

    tr.append(
      usernameTd,
      dateSubmitTD,
      descriptionTd,
      statusTd,
      typeTd,
      amountTd
    );

    document.getElementById("completeReimBody").append(tr);
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

// asyncFetch("http://localhost:8080/Project1/complete.json", renderTable);
asyncFetch(
  "http://3.17.110.130:8081/Project1-0.0.1-SNAPSHOT/complete.json",
  renderTable
);
