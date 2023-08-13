

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

    return (
        <div>

        </div>
    )

}

export default TimeLine;