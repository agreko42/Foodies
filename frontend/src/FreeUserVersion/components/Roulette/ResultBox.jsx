import React from "react";
import {Box} from "@mui/material";


const ResultBox = ({name, imageUrl}) => {

    return <Box>
        {}
        <img
            src={imageUrl}
            height='200vh'
            alt={`Imagine there's a picture of ${name}`}
        ></img>
        <h2>
            You should eat {name}
        </h2>

    </Box>


}

export default ResultBox;

