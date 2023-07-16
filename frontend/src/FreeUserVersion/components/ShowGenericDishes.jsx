import { useEffect, useState } from "react";

const fetchAllGenericFood = async () => {
  const foodData = await fetch("http://localhost:8080/foodlist");
  const foodResult = await foodData.json();
  return foodResult;
};
const ShowGenericDishes = () => {
  const [food, setFood] = useState([]);

  useEffect(() => {
    fetchAllGenericFood().then((food) => {
      return setFood(food);
    });
  }, []);

  console.log(food);

  let counter = 0;
  let counter2 = 0;

  return (
    <>
      <div>
        {food.map((foodList) => (
          <div key={counter++}>
            {foodList.map((food) => (
              <div key={counter2++}>{food.name}</div>
            ))}
          </div>
        ))}
      </div>
    </>
  );
};

export default ShowGenericDishes;
