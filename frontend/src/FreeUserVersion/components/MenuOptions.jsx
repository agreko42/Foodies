import React from 'react';
import { Box, Button, Typography } from '@mui/material';

const MenuOptions = (props) => {

    const handleBtnBreakfast = () => {
        props.setRandomFood("");
        console.log("HIIIII Breakfast!!!")
        props.setFilterBtnChange("breakfast")

    }
    const handleBtnLunch = () => {
        props.setRandomFood("");
        console.log("HIIIII Lunch!!!!")
        props.setFilterBtnChange("lunch")
    }
    const handleBtnDinner = () => {
        props.setRandomFood("");
        console.log("HIIIII Dinner")
        props.setFilterBtnChange("dinner")
    }

    return (
        <Box>
            <Typography variant="h5" gutterBottom>
                Choose your MealType
            </Typography>
            <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start' }}>
                <Button onClick={() => handleBtnBreakfast()} variant="outlined">
                    Breakfast
                </Button>
                <Button onClick={() => handleBtnLunch()} variant="outlined">
                    Lunch
                </Button>
                <Button onClick={() => handleBtnDinner()} variant="outlined">
                    Dinner
                </Button>
            </Box>
        </Box>
    );
};

export default MenuOptions;
