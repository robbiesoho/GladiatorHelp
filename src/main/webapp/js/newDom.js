let username = null;
fetch("http://localhost:8080/Project1/session.json")
  // fetch("http://3.17.110.130:8081/Project1-0.0.1-SNAPSHOT/session.json")
  .then((response) => response.json())
  .then((json) => {
    username = json;
  })
  .then((e) => {
    document.getElementById("userInput").value = username;
  });
