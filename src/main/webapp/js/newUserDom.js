let username = null;
fetch("http://localhost:8080/Project1/session.json")
  .then((response) => response.json())
  .then((json) => {
    username = json;
  })
  .then((e) => {
    document.getElementById("userInput").value = username;
  });
