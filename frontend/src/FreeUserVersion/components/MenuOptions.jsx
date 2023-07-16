import { Box, Button, Typography } from "@mui/material";

const MenuOptions = (props) => {
  const handleBtnSweet = () => {
    props.setFilterBtnChange("sweet");
  };
  const handleBtnSevery = () => {
    props.setFilterBtnChange("severy");
  };

  return (
    <Box>
      <Typography variant="h5" gutterBottom>
        Choose One
      </Typography>
      <Box sx={{ display: "flex", flexDirection: "column" }}>
        <Button onClick={() => handleBtnSweet()} variant="outlined">
          Sweet
        </Button>
        <Button onClick={() => handleBtnSevery()} variant="outlined">
          Severy
        </Button>
      </Box>
    </Box>
  );
};

export default MenuOptions;
