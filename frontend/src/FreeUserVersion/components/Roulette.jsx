import {useEffect, useState} from "react";

const Roulette = (props) => {


    return (
        <div>
            <div>ROULETTE</div>
            <div>
                <ul>
            {props.food.map((foodList) => (
                <li key={foodList.name}> {foodList.name}</li>
            ))}
                </ul>
            </div>
        </div>
    )
}

export default Roulette;