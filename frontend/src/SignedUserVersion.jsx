import {Component, useState} from 'react';
import Navbar from './SignedUserVersion/layout/Navbar';
import ButtonSection from './SignedUserVersion/components/ButtonSection';
import Footer from './SignedUserVersion/layout/Footer';

function SignedUserVersion() {
    const [activeComponent, setActiveComponent] = useState("Landing");
    const handleActiveComponentChange = (componentName) => {
        setActiveComponent(componentName)
    };

    return(
        <>
            <Navbar />
            <ButtonSection />
            <Footer />
        </>
    )


}
export default SignedUserVersion;