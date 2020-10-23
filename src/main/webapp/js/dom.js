function renderTable(reimbursements) {
  for (const r of reimbursements) {
    const tr = document.createElement("tr");
    const amountTd = document.createElement("td");
    const dateSubmitTD = document.createElement("td");
    const descriptionTd = document.createElement("td");
    const statusTd = document.createElement("td");
    const typeTd = document.createElement("td");
    amountTd.innerText = r.amount;
    dateSubmitTD.innerText = r.submitted;
    descriptionTd.innerText = r.description;
    statusTd.innerText = r.status;
    typeTd.innerText = r.type;
    tr.append(amountTd, dateSubmitTD, descriptionTd, statusTd, typeTd);

    document.getElementById("completeReimBody").append(tr);
  }
}

// const reimbursements = [];

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

asyncFetch("http://localhost:8080/Project1/complete.json", renderTable);

// fetch("http://localhost:8080/Project1/compelete.json", {
//   body: JSON.stringify(reimbursements),
//   method: "post",
//   mode: "no-cors",
//   headers: {
//     origin: "localhost",
//   },
// })
//   .then((r) => r.json())
//   .then(reimbursements.push);

// fetch("http://localhost:8080/HallowsMonsters/all.json", {
//   body: JSON.stringify(mockedMonsters),
//   method: "post",
//   mode: "no-cors",
//   headers: {
//     origin:'localhost'
//   }
// })
//   .then((r) => r.json())
//   .then(mockedMonsters.push);

//   async function addMonster() {
//     const monster = {
//       name: document.getElementById("monName").value,
//       type: {
//         type: document.getElementById("monType").value,
//         furry: document.getElementById("monFur").value,
//         paws: document.getElementById("monPaws").value,
//       },
//     };
//     const fetched = await fetch("http://localhost:8080/Project1/compelete.json", {
//       method: "post",
//       body: JSON.stringify(monster),
//     });
//     const json = await fetched.text();
//     const rows = (document.getElementById("hallowsTableBody").innerHTML = "");
//     asyncFetch("http://localhost:8080/Project1/compelete.json", renderTable);
//   }

//   document.getElementById("monSubmit").addEventListener("click", addMonster);
