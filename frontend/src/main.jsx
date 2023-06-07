import React from 'react';
import { createRoot } from 'react-dom/client';
import FreeUserVersion from './FreeUserVersion.jsx';
import SignedUserVersion from './SignedUserVersion.jsx';
import './index.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LoginPage from "./LoginPage.jsx";
import RegisterPage from "./FreeUserVersion/components/RegisterPage.jsx";

createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<FreeUserVersion />} />
                <Route path="/logged-in" element={<SignedUserVersion />} />
                <Route path="/signup/login" element={<LoginPage />} />
                <Route path="/signup/register" element={<RegisterPage />} />
            </Routes>
        </BrowserRouter>
    </React.StrictMode>
);
