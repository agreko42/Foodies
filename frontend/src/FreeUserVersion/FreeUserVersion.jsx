//import './App.css'
import Navbar from "./layout/Navbar.jsx";
import Footer from "./layout/Footer.jsx";
import ContentSection from "./components/ContentSection.jsx";
import { useState } from "react";
import MenuOptions from "./components/MenuOptions.jsx";

function FreeUserVersion() {
  const [filterBtnForFood, setFilterBtnForFood] = useState("sweet");

  return (
    <div>
      <Navbar />
      <div className="flex flex-row justify-around items-center">
        <div>
          <MenuOptions setFilterBtnChange={setFilterBtnForFood} />
        </div>
        <div>
          <ContentSection filterBtn={filterBtnForFood} />
        </div>
        <div>for test purposes</div>
      </div>
      <Footer />
    </div>
  );
}

export default FreeUserVersion;
