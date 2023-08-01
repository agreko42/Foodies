import { Component, useEffect, useState } from "react";
import Navbar from "./layout/Navbar.jsx";
import ButtonSection from "./components/ButtonSection";
import ContentSection from "./components/ContentSection.jsx";
import Footer from "./layout/Footer";
import { useNavigate } from "react-router-dom";
import SignedUserNavbar from "./layout/Navbar.jsx";

function SignedUserVersion(props) {
  const [activeComponent, setActiveComponent] = useState("Landing");
  const handleActiveComponentChange = (componentName) => {
    setActiveComponent(componentName);
  };

  console.log(activeComponent);

  return (
    <>
      <SignedUserNavbar user={props.user} setUser={props.setUser} />
      <ButtonSection
        handleActiveComponentChange={handleActiveComponentChange}
        user={props.user}
      />
      <ContentSection activeComponent={activeComponent} />
      <Footer />
    </>
  );
}
export default SignedUserVersion;
