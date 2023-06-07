import React, {Component, useState} from 'react';

function SignedUserVersion() {
    const [activeComponent, setActiveComponent] = useState("Landing");
    const handleActiveComponentChange = (componentName) => {
        setActiveComponent(componentName)
    };

    return(
        <div>
            Insert Version for signed-up Users
        </div>
    )


}
export default SignedUserVersion;