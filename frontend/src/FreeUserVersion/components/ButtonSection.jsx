import React from 'react';
import {Box, Button} from '@mui/material';

const ButtonSection = (props) => {
    return (
        <Box sx={{ display: 'flex', justifyContent: 'center', marginTop: '20px' }}>
            <Button onClick={() => props.setActiceComponent('Roulette')}>Roulette</Button>
            <Button onClick={() => props.setActiceComponent('Spinner')}>Spinner</Button>
        </Box>
    );
};

export default ButtonSection;
