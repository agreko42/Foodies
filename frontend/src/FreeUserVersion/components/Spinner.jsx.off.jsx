import { useState } from 'react';

import RoulettePro from 'react-roulette-pro';
import 'react-roulette-pro/dist/index.css';
import {Box, Button} from "@mui/material";
import audio from '../../assets/Lied.mp3'

const Spinner = (props) => {
    let id = 0;
    let prizes = [];
    props.food.forEach( food => {
        prizes.push(
            { image: `${food.url}`, id: `${food.name}`, text: `${food.name}` }
        )
    });

    const winPrizeIndex = 0;

    const reproductionArray = (array = [], length = 0) => [
        ...Array(length)
            .fill('_')
            .map(() => array[Math.floor(Math.random() * array.length)]),
    ];

    const reproducedPrizeList = [
        ...prizes,
        ...reproductionArray(prizes, prizes.length * 3),
        ...prizes,
        ...reproductionArray(prizes, prizes.length),
    ];

    const generateId = () =>
        `${Date.now().toString(36)}-${Math.random().toString(36).substring(2)}`;

    const prizeList = reproducedPrizeList.map((prize) => ({
        ...prize,
        id: typeof crypto.randomUUID === 'function' ? crypto.randomUUID() : generateId(),
    }));

    const [start, setStart] = useState(false);
    const [priceIndex, setPriceIndex] = useState(0);

    const generateRandomPrizeIndex = () => {
        let prizeIndex = Math.floor(Math.random() * prizes.length * 4);

        console.log(prizeIndex);
        return prizeIndex;
    };

    const handleStart = () => {
        const newPriceIndex = generateRandomPrizeIndex();
        setPriceIndex(newPriceIndex);
        setStart((prevState) => !prevState);
    };

    const handlePrizeDefined = () => {
        console.log(prizeIndex)
        console.log(prizeList)
        console.log('🥳 Prize defined! 🥳');
    };

    return (
        <Box sx={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center'}}>
            <RoulettePro
                prizes={prizeList}
                prizeIndex={priceIndex}
                start={start}
                onPrizeDefined={handlePrizeDefined}
                spinningTime={7}
                soundWhileSpinning={audio}
            />
            <Button onClick={handleStart}>Start</Button>
        </Box>
    );

    /*
    return (
        <div>
            <div>SPINNER</div>
            <div>
                <ul>
                    {props.food.map((foodList) => (
                        <li key={foodList.name}> {foodList.name}</li>
                    ))}
                </ul>
            </div>
        </div>
    )

     */
}

export default Spinner;