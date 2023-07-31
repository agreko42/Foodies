import {
  Button,
  ButtonGroup,
  Box,
  ThemeProvider,
  createTheme,
} from "@mui/material";

const buttonTheme = createTheme({
  palette: {
    primary: {
      main: "#b3e5fc", // Set the primary color to red
    },
  },
});

const ButtonSection = ({ handleActiveComponentChange }) => {
  return (
    <ThemeProvider theme={buttonTheme}>
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <ButtonGroup
          size="large"
          variant="contained"
          aria-label="outlined primary button group"
        >
          <Button>Ranking</Button>
          <Button>Wheel</Button>
          <Button onClick={() => handleActiveComponentChange("Collection")}>
            Collections
          </Button>
          <Button>Friends</Button>
          <Button>Post</Button>
        </ButtonGroup>
      </Box>
    </ThemeProvider>
  );
};

export default ButtonSection;
