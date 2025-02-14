import { useState } from "react";
import { useNavigate } from "react-router-dom";
import LoginAuth from "../../auth/LoginAuth";
import Navbar from "../layout/Navbar";
import Footer from "../layout/Footer";

const LoginPage = (props) => {
  const [username, setUsername] = useState("");
  const [usernameError, setUsernameError] = useState(false);
  const [userPassword, setUserPassword] = useState("");
  const [userPasswordError, setUserPasswordError] = useState(false);
  const [showPassword, setShowPassword] = useState(false);

  const navigate = useNavigate();

  // const validateString = (string) => {
  //   return !(string == null || string.length <= 0);
  // };

  // const handleTogglePasswordVisibility = () => {
  //   setShowPassword(!showPassword);
  // };

  const handleSubmit = (e) => {
    e.preventDefault();
    LoginAuth(
      username,
      userPassword,
      props.setUser,
      navigate,
      setUsernameError,
      setUserPasswordError
    );
  };

  return (
    <>
      <div className="bg-white rounded-lg flex min-h-full flex-col px-6 py-12 lg:px-36">
        <div className="sm:mx-auto sm:w-full sm:max-w-sm text-center">
          <h1 className="my-4 text-2xl font-bold leading-9 tracking-tight text-gray-900">
            Foodies
          </h1>
          <h2 className="text-2xl font-bold leading-9 tracking-tight text-gray-900">
            Login to your account
          </h2>
        </div>

        <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
          <form className="space-y-6" action="#" method="POST">
            <div>
              <label
                htmlFor="username"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Your username
              </label>
              <input
                id="username"
                type="text"
                onChange={(e) => setUsername(e.target.value)}
                // onBlur={() => setUsernameError(!validateString(username))}
                className={`${
                  !usernameError
                    ? "border-gray-300 ring-blue-500"
                    : "border-red-500 ring-red-500"
                } bg-gray-50 border rounded-lg text-gray-900 sm:text-sm p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 focus:ring-primary-600 focus:border-primary-600 block w-full`}
                placeholder="Enter your username"
                required
              />
              {usernameError && (
                <p className="text-red-500">Username is required</p>
              )}
            </div>
            <div>
              <label
                htmlFor="password"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Password
              </label>
              <input
                id="password"
                type={showPassword ? "text" : "password"}
                value={userPassword}
                onChange={(e) => setUserPassword(e.target.value)}
                // onBlur={() =>
                //   setUserPasswordError(!validateString(userPassword))
                // }
                className={`${
                  !userPasswordError
                    ? "border-gray-300 ring-blue-500"
                    : "border-red-500 ring-red-500"
                } bg-gray-50 border rounded-lg text-gray-900 sm:text-sm p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 focus:ring-primary-600 focus:border-primary-600 block w-full`}
                placeholder="Enter password"
                required
              />
              {userPasswordError && (
                <p className="text-red-500">Password is required</p>
              )}
            </div>

            <div>
              <button
                onClick={handleSubmit}
                type="submit"
                className="flex w-full justify-center rounded-md border-2 border-gray-950 px-3 py-1.5 text-sm font-semibold leading-6 text-black shadow-sm hover:border-orange-200 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-orange-200"
              >
                Login
              </button>
            </div>
          </form>

          <p className="mt-10 text-center text-sm text-gray-500">
            You dont have an account?
            <a
              href="/signup/register"
              className="font-semibold leading-6 text-black hover:text-stone-300"
            >
              {" "}
              Sign In
            </a>
          </p>
        </div>
      </div>
    </>
  );
};

export default LoginPage;
