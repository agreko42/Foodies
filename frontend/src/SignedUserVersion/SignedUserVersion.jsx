import {Component, useEffect, useState} from 'react';
import Navbar from './layout/Navbar';
import ButtonSection from './components/ButtonSection';
import Footer from './layout/Footer';
import { useNavigate } from 'react-router-dom';

function SignedUserVersion(props) {
    const [activeComponent, setActiveComponent] = useState("Landing");
    const handleActiveComponentChange = (componentName) => {
        setActiveComponent(componentName)
    };

    return(
        <>
            <Navbar setUser={props.setUser} />
            <ButtonSection />
            <Footer />
        </>
    )


}
export default SignedUserVersion;