import { Box, Button, Typography } from "@mui/material";

const MenuOptions = (props) => {
  const handleBtnSweet = () => {
    props.setFilterBtnChange("sweet");
  };
  const handleBtnSevery = () => {
    props.setFilterBtnChange("severy");
  };

  return (
    <div>
      <h5 className="text-xl font-bold mb-4">Choose One</h5>
      <div className="flex flex-col">
        <button
          onClick={() => handleBtnSweet()}
          className="border border-blue-500 text-blue-500 font-bold py-2 px-4 rounded mb-2"
        >
          Sweet
        </button>
        <button
          onClick={() => handleBtnSevery()}
          className="border border-blue-500 text-blue-500 font-bold py-2 px-4 rounded"
        >
          Severy
        </button>
      </div>
    </div>
  );
};

export default MenuOptions;
