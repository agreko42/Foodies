import { useEffect, useState } from "react";

const RezeptCollection = () => {
  const [data, setData] = useState([]);

  const fetchRezeptCollection = async () => {
    const recipeList = await fetch("http://localhost:8080/recipe/user/Enes");
    const recipeResult = await recipeList.json();
    return recipeResult;
  };

  useEffect(() => {
    fetchRezeptCollection().then((data) => {
      return setData(data);
    });
  }, []);

  console.log(data);

  return (
    <div>
      {data.map((recipe) => {
        return (
          <div key={recipe.id}>
            {recipe.name}
            {recipe.flavourType}
          </div>
        );
      })}
    </div>
  );
};

export default RezeptCollection;
