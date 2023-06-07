import { useState } from "react";

import RoulettePro from "react-roulette-pro";
import "react-roulette-pro/dist/index.css";
import { Box, Button } from "@mui/material";

const Spinner = (props) => {
  const [isRunning, setIsRunning] = useState(false);
  const [priceIndex, setPriceIndex] = useState(0);

  const prices = [
    {
      id: 1,
      image: props.food[0].url,
    },
    {
      id: 2,
      image: props.food[1].url,
    },
    {
      id: 3,
      image: props.food[2].url,
    },
    {
      id: 4,
      image: props.food[3].url,
    },
    {
      id: 5,
      image: props.food[0].url,
    },
    {
      id: 6,
      image: props.food[1].url,
    },
    {
      id: 7,
      image: props.food[2].url,
    },
    {
      id: 8,
      image: props.food[3].url,
    },
    {
      id: 9,
      image: props.food[0].url,
    },
    {
      id: 10,
      image: props.food[1].url,
    },
  ];
  const generateRandomPriceIndex = () => {
    return Math.floor(Math.random() * prices.length);
  };
  const handleStart = () => {
    console.log(isRunning);
    setIsRunning(true);
    console.log(isRunning);
    let newIndex = generateRandomPriceIndex();
    setPriceIndex(newIndex);
  };

  const handlePrizeDefined = () => {
    setTimeout(() => {
      setIsRunning(false);
    });
    console.log("WINNER");
  };

  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <RoulettePro
        prizes={prices}
        prizeIndex={priceIndex}
        start={isRunning}
        onPrizeDefined={handlePrizeDefined}
        spinningTime={5}
        options={{ withoutAnimation: true }}
        //soundWhileSpinning={audio}
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
};

export default Spinner;
