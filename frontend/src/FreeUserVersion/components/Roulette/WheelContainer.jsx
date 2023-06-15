import { useState } from "react";
import { Wheel } from "react-custom-roulette";
import { Box, Button } from "@mui/material";
import ResultBox from "./ResultBox.jsx";

const WheelContainer = (props) => {
  
  return (
    <Box>
      <Wheel
        mustStartSpinning={props.mustSpin}
        prizeNumber={props.winningNumber}
        data={props.data}
        onStopSpinning={() => {
          props.setMustSpin(false);
          props.setCurrentResult(props.food[props.winningNumber - 1]);
        }}
        backgroundColors={["#3e3e3e", "#df3428"]}
        innerRadius={40}
        perpendicularText={true}
        textDistance={75}
        textColors={["#ffffff"]}
      />
      {props.currentResult === "" ? (
        ""
      ) : props.winningNumber === 0 ? (
        <ResultBox
          name={"absolutely NOTHING"}
          imageUrl={"https://i.imgur.com/V1j4hVb.jpeg"}
        />
      ) : (
        <ResultBox name={props.currentResult.name} imageUrl={props.currentResult.url} />
      )}
    </Box>
  );
};



export default WheelContainer;
