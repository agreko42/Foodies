import FreeUserVersion from "./FreeUserVersion/FreeUserVersion.jsx";
import SignedUserVersion from "./SignedUserVersion/SignedUserVersion.jsx";
import "./index.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./FreeUserVersion/components/LoginPage.jsx";
import RegisterPage from "./FreeUserVersion/components/RegisterPage.jsx";
import {useEffect, useState} from "react";
import ProtectedRoute from "./ProtectedRoute.jsx";

const App = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
      const token = localStorage.getItem("token");
      if(token){
          setUser(token);
      }
  }, [] )

  console.log(user);

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<FreeUserVersion />} />
        <Route
          path="/logged-in"
          element={
            <ProtectedRoute user={user}>
              <SignedUserVersion setUser={setUser} user={user} />
            </ProtectedRoute>
          }
        />
        <Route path="/signup/login" element={<LoginPage setUser={setUser} />} />
        <Route
          path="/signup/register"
          element={<RegisterPage setUser={setUser} />}
        />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
