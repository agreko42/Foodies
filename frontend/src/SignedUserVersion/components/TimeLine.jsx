import {useState, useEffect} from "react";
import TimelineCard from "./TimelineCard.jsx";
const fetchTimeline = async (token) => {
    const authString = `Bearer ${token}`;
    const response = await fetch(`http://localhost:8080/timeline`, {
        method: "GET",
        headers: {
            Authorization: authString,
        },
        credentials: "include",
    });

    return await response.json();
};


const TimeLine = (props) => {

    const [timelineData, setTimelineData] = useState([]);

    useEffect( () => {
        fetchTimeline(props.user)
            .then( data => setTimelineData(data))
    }, [])

    console.log(timelineData);


    return (
        <div>
            {timelineData.map((recipe) => {
                return(
                    <TimelineCard
                        recipeName={recipe.name}
                        key={recipe.id}
                    />
                )
            })}
        </div>
    )

}

export default TimeLine;