import api from "../config/api";
import jwt_decode from "jwt-decode";

const RegisterAuth = (username, userEmail, userPassword, navigate, user) => {
  if (username.trim().length <= 0) {
    return;
  } else if (userEmail.trim().length <= 0) {
    return;
  } else if (userPassword.trim().length <= 0) {
    return;
  }

  let userInput = {
    username: username,
    email: userEmail,
    password: userPassword,
  };

  fetch(api.REGISTER.getUrl, {
    method: api.REGISTER.method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(userInput),
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Authentication failed");
      }
    })
    .then((data) => {
      localStorage.setItem("token", data.token); //oder sessionStorage.setItem.....
      console.log("Token saved in localStorage");
      const jwt = data.token;
      const decodedToken = jwt_decode(jwt);
      console.log("DecodedToken: ", decodedToken);
      user(decodedToken);
      navigate("/logged-in");
    })
    .catch((err) => console.log(`Hey, there is an ${err}`));
};

export default RegisterAuth;
