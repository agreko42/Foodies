import { Box, Typography } from "@mui/material";
import "./Footer.css";

const Footer = () => {
  return (
    <Box style={{ backgroundColor: "green" }} className="footer">
      <Typography variant="body2" color="text.secondary" align="center">
        This is the footer.
      </Typography>
    </Box>
  );
};
export default Footer;
