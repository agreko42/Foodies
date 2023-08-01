import { useEffect, useState } from "react";
import { Wheel } from "react-custom-roulette";
import ResultBox from "./ResultBox.jsx";

const WheelContainer = (props) => {
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

  const fetchAllGenericFood = async (chosenFilterBtn) => {
    const foodData = await fetch(
      `http://localhost:8080/foodlist/${chosenFilterBtn}`
    );
    const foodResult = await foodData.json();
    return foodResult;
  };

  function handleSpinIt() {
    let number = getRandomNumber(data.length);
    setWinningNumber(number);
    setCurrentResult("");
    setMustSpin(true);
  }

  useEffect(() => {
    fetchAllGenericFood(props.filterBtn).then((food) => setFood(food));
  }, [props.filterBtn]);

  return (
    <div>
      <Wheel
        mustStartSpinning={mustSpin}
        prizeNumber={winningNumber}
        data={data}
        onStopSpinning={() => {
          setMustSpin(false);
          setCurrentResult(food[winningNumber - 1]);
        }}
        backgroundColors={["#3e3e3e", "#df3428"]}
        innerRadius={40}
        perpendicularText={true}
        textDistance={75}
        textColors={["#ffffff"]}
      />
      <button
        onClick={() => handleSpinIt()}
        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
      >
        Spin It!
      </button>
      {currentResult === "" ? (
        ""
      ) : winningNumber === 0 ? (
        <ResultBox
          name={"absolutely NOTHING"}
          imageUrl={"https://i.imgur.com/V1j4hVb.jpeg"}
        />
      ) : (
        <ResultBox name={currentResult.name} imageUrl={currentResult.url} />
      )}
    </div>
  );
};

function getRandomNumber(limit) {
  return Math.floor(Math.random() * limit);
}

export default WheelContainer;
