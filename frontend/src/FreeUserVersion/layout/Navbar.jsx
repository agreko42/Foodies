import { AppBar, Toolbar, Typography, Button, IconButton, Menu, MenuItem } from '@mui/material';
import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import MenuIcon from '@mui/icons-material/Menu';

const Navbar = () => {
    const [anchorEl, setAnchorEl] = useState(null);

    const navigate = useNavigate();

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleLoginClick = () => {
        navigate("/signup/login");
    }

    const handleRegisterClick = () => {
        navigate("/signup/register");
    }

    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <AppBar style={{ backgroundColor: 'green' }} position="static">
            <Toolbar>
                <IconButton
                    size="large"
                    edge="start"
                    color="inherit"
                    aria-label="menu"
                    sx={{ mr: 2 }}
                    onClick={handleClick}
                >
                    <MenuIcon />
                </IconButton>
                <Menu
                    anchorEl={anchorEl}
                    open={Boolean(anchorEl)}
                    onClose={handleClose}
                >
                    <MenuItem onClick={handleClose}>Breakfast</MenuItem>
                    <MenuItem onClick={handleClose}>Lunch</MenuItem>
                    <MenuItem onClick={handleClose}>Dinner</MenuItem>
                </Menu>
                <Typography variant="h6" component="div" sx={{ flexGrow: 1, textAlign: 'center' }}>
                    Foodies
                </Typography>
                <Button onClick={handleRegisterClick} color="inherit">Register</Button>
                <Button onClick={handleLoginClick} color="inherit">Login</Button>
            </Toolbar>
        </AppBar>
    );
};

export default Navbar;
