import { useEffect, useState } from "react";

const RezeptCollection = () => {
  const [data, setData] = useState([]);

  const fetchRezeptCollection = async () => {
    const recipeList = await fetch("http://localhost:8080/"); //Problem der token hat die User id nicht aber dafür den usernamen
  };

  useEffect(() => {
    fetchRezeptCollection();
  });

  return <div></div>;
};

export default RezeptCollection;
