import { useEffect, useState } from "react";
import { Card } from "flowbite-react";

const RezeptCollection = (props) => {
  const [data, setData] = useState([]);

  const fetchRezeptCollection = async (token) => {
    const jwToken = JSON.stringify(token);
    const recipeList = await fetch("http://localhost:8080/recipe/user",{
        headers: {
          "Authorize": `Bearer ${jwToken}`
        }}
    );
    const recipeResult = await recipeList.json();
    return recipeResult;
  };

  useEffect(() => {
    fetchRezeptCollection(props.user).then((data) => {
      return setData(data);
    });
  }, []);

  console.log(data);

  return (
    <div>
      {data.map((recipe) => {
        return (
          <Card key={recipe.id} className="max-w-sm">
            <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              <p>{recipe.name}</p>
            </h5>
            <p className="font-normal text-gray-700 dark:text-gray-400">
              {recipe.flavourType}
            </p>
          </Card>
        );
      })}
    </div>
  );
};

export default RezeptCollection;
