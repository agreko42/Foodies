import api from "../config/api";

const LoginAuth = (
  username,
  userPassword,
  setUser,
  navigate,
  setUsernameError,
  setUserPasswordError
) => {
  if (username.trim().length <= 0) {
    setUsernameError(true);
    return;
  } else if (userPassword.trim().length <= 0) {
    setUserPasswordError(true);
    return;
  }

  let userInput = {
    username: username,
    password: userPassword,
  };

  fetch(api.LOGIN.getUrl, {
    method: api.LOGIN.method,
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
      console.log("DATA: ", data);
      localStorage.setItem("token", data.token); //oder sessionStorage.setItem.....
      console.log("Token saved in localStorage");
      const jwt = data.token;
      setUser(jwt);
      navigate("/logged-in");
    })

    .catch((err) => console.log(`Hey, there is an ${err}`));
};

export default LoginAuth;
