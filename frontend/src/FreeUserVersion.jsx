//import './App.css'
import Navbar from "./FreeUserVersion/layout/Navbar.jsx";
import Footer from "./FreeUserVersion/layout/Footer.jsx";
import ButtonSection from "./FreeUserVersion/components/ButtonSection.jsx";
import ContentSection from "./FreeUserVersion/components/ContentSection.jsx";
import { useState } from "react";
import WelcomeSection from "./FreeUserVersion/components/WelcomeSection.jsx";
import MenuOptions from "./FreeUserVersion/components/MenuOptions.jsx";


function FreeUserVersion() {

    const [activeComponent, setActiveComponent] = useState('Roulette');
    const [filterBtnForFood, setFilterBtnForFood] = useState("breakfast");
    const [randomFood, setRandomFood] = useState(""); // später wird das ein Object

  return (
    <>
        <Navbar />
        <WelcomeSection />
        <ButtonSection
            setActiceComponent={setActiveComponent}
        />
        <MenuOptions
            setRandomFood={setRandomFood}
            setFilterBtnChange={setFilterBtnForFood}/>
        <ContentSection
            randomFood={randomFood}
            setRandomFood={setRandomFood}
            activeComponent={activeComponent}
            filterBtn={filterBtnForFood}
        />
        <Footer />
    </>
  )
}

export default FreeUserVersion
