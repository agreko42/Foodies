import {Box} from "@mui/material";
import WheelContainer from "./Roulette/WheelContainer.jsx";

const ContentSection = (props) => {
    return (
            <Box>
                <WheelContainer filterBtn={props.filterBtn}/>
            </Box>  
    );
};

export default ContentSection;
