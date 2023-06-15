import {useEffect, useState} from 'react';
import {Box, Button, Stack} from "@mui/material";
import WheelContainer from "./Roulette/WheelContainer.jsx";

const fetchAllGenericFood = async (chosenFilterBtn) => {
    const foodData = await fetch(`http://localhost:8080/foodlist/${chosenFilterBtn}`)
    const foodResult = await foodData.json();
    return foodResult;
}

const ContentSection = (props) => {

    const [food, setFood] = useState([]);
    
    let data = [
        {
          option: "Go Hungry",
          style: { backgroundColor: "green", textColor: "white" },
        },
      ];
      food.forEach((food) => {
        data.push({
          option: `${food.name}`,
          style: { backgroundColor: "", textColor: "black" },
          image: { uri: `${food.url}`, sizeMultiplier: "0.8" },
        });
      });

      const [winningNumber, setWinningNumber] = useState(
        getRandomNumber(data.length)
      );
      const [mustSpin, setMustSpin] = useState(false);
      const [currentResult, setCurrentResult] = useState("");
      

    function handleSpinIt() {
        let number = getRandomNumber(data.length);
        setWinningNumber(number);
        setCurrentResult("");
        setMustSpin(true);
      }

      function getRandomNumber(limit) {
        return Math.floor(Math.random() * limit);
      }

    useEffect(() => {
        fetchAllGenericFood(props.filterBtn)
            .then((food) => setFood(food));
    }, [props.filterBtn]);

    return (
        <Stack spacing={2} direction="column" alignItems='center'>
            <Box>
                <WheelContainer
                    food = {food}
                    mustSpin = {mustSpin}
                    winningNumber = {winningNumber}
                    data = {data}
                    setMustSpin = {setMustSpin}
                    setCurrentResult = {setCurrentResult}
                    currentResult = {currentResult}
                />
            </Box>   
            <Box>
                <Button onClick={() => handleSpinIt()}>
                    Spin It!
                </Button>
            </Box>               
        </Stack>
    );
};

export default ContentSection;
