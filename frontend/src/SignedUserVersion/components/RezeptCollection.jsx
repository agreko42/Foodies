import { useEffect, useState } from "react";
import { Card } from "flowbite-react";


const fetchRezeptCollection = async (token) => {
  const authString = `Bearer ${token}`;
  console.log(authString)
  const recipeList = await fetch("http://localhost:8080/recipe/user", {
    headers: {
      Authorization: authString,
    },
    credentials: "include",
  });
  return await recipeList.json();
};

const RezeptCollection = (props) => {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetchRezeptCollection(props.user)
        .then((data) => { setData(data);}
        );
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
