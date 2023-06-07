import React, {useEffect, useState} from 'react';
import Roulette from "./Roulette.jsx";
import Spinner from "./Spinner.jsx";
import {Box, Button} from "@mui/material";
import WheelContainer from "./Roulette/WheelContainer.jsx";

const fetchAllGenericFood = async (chosenFilterBtn) => {
    const foodData = await fetch(`http://localhost:8080/foodlist/${chosenFilterBtn}`)
    const foodResult = await foodData.json();
    return foodResult;
}

const ContentSection = (props) => {
    const [food, setFood] = useState([]);


    const fetchRandomFoodByUserChoice = async (chosenFilterBtn) => {
        const foodData = await fetch(`http://localhost:8080/foodlist/chooseFood/${chosenFilterBtn}`);
        const foodResult = await foodData.text();
        return props.setRandomFood(foodResult);
    }

    useEffect(() => {
        fetchAllGenericFood(props.filterBtn)
            .then((food) => setFood(food));
    }, [props.filterBtn]);

    return (
        <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
            {props.randomFood === "" ?
                <div>
                    {props.activeComponent === 'Roulette' &&
                        <WheelContainer
                            food = {food}
                        />
                    }
                    {props.activeComponent === 'Spinner' &&
                        <Spinner
                            food = {food}
                        />
                    }
                </div>
                :
                <div >{props.randomFood}</div>
            }
        </Box>

    );
};

export default ContentSection;
