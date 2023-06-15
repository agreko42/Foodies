//import './App.css'
import Navbar from "./FreeUserVersion/layout/Navbar.jsx";
import Footer from "./FreeUserVersion/layout/Footer.jsx";
import ContentSection from "./FreeUserVersion/components/ContentSection.jsx";
import { useState } from "react";
import MenuOptions from "./FreeUserVersion/components/MenuOptions.jsx";
import { Box } from "@mui/material";


function FreeUserVersion() {

    const [filterBtnForFood, setFilterBtnForFood] = useState("sweet");

  return (
    <>
        <Navbar />
        <Box sx={{ display: 'flex', flexDirection: 'row', justifyContent: "space-around", alignItems: "center" }}>
            <Box>
                <MenuOptions
                    setFilterBtnChange={setFilterBtnForFood}
                    />
            </Box>
            <Box>
                <ContentSection
                    filterBtn={filterBtnForFood}
                />
            </Box>            
            <Box>
                for test purposes
            </Box>
        </Box>
        <Footer />
    </>
  )
}

export default FreeUserVersion
