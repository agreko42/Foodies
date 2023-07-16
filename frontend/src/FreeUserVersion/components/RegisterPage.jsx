import { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  Box,
  Button,
  Card,
  CardContent,
  Grid,
  IconButton,
  InputAdornment,
  TextField,
} from "@mui/material";
import { Visibility, VisibilityOff } from "@mui/icons-material";
import jwt_decode from "jwt-decode";
import RegisterAuth from "../../auth/RegisterAuth";

const RegisterPage = (props) => {
  const [username, setUsername] = useState("");
  const [usernameError, setUsernameError] = useState(false);
  const [userEmail, setUserEmail] = useState("");
  const [userEmailError, setUserEmailError] = useState(false);
  const [userPassword, setUserPassword] = useState("");
  const [userPasswordError, setUserPasswordError] = useState(false);
  const [showPassword, setShowPassword] = useState(false);

  const navigate = useNavigate();

  const validateString = (string) => {
    return !(string == null || string.length <= 0);
  };

  const handleTogglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    RegisterAuth(username, userEmail, userPassword, navigate, props.setUser);
  };

  return (
    <Grid
      container
      justifyContent="center"
      alignItems="center"
      style={{ height: "100vh" }}
    >
      <Card style={{ width: "400px" }}>
        <CardContent>
          <Box
            component="form"
            sx={{
              "& .MuiTextField-root": { m: 1, width: "100%" },
            }}
            noValidate
            autoComplete="off"
          >
            <Grid container spacing={2} direction="column" alignItems="center">
              <Grid container item spacing={1} justifyContent="center">
                <Grid item>
                  <TextField
                    required
                    id="outlined-required"
                    error={usernameError}
                    helperText={usernameError ? "Not right" : ""}
                    label="Username"
                    placeholder="Enter your username"
                    type="text"
                    onChange={(e) => setUsername(e.target.value)}
                    onBlur={() => setUsernameError(!validateString(username))}
                  />
                </Grid>
              </Grid>
              <Grid container item spacing={1} justifyContent="center">
                <Grid item>
                  <TextField
                    required
                    id="outlined-required"
                    error={userEmailError}
                    helperText={userEmailError ? "Not right" : ""}
                    label="User Email"
                    placeholder="Enter your email"
                    type="text"
                    onChange={(e) => setUserEmail(e.target.value)}
                    onBlur={() => setUserEmailError(!validateString(userEmail))}
                  />
                </Grid>
              </Grid>
              <Grid container item spacing={1} justifyContent="center">
                <Grid item>
                  <TextField
                    required
                    id="outlined-required"
                    error={userPasswordError}
                    helperText={userPasswordError ? "Not right" : ""}
                    label="User Password"
                    placeholder="Enter password"
                    type={showPassword ? "text" : "password"} // Switchen zwischen "text" und "password"
                    value={userPassword}
                    onChange={(e) => setUserPassword(e.target.value)}
                    onBlur={() =>
                      setUserPasswordError(!validateString(userPassword))
                    }
                    fullWidth
                    InputProps={{
                      // customizieren von input components. Hier InputAdornment damit man button icon hinzufügen kann
                      endAdornment: (
                        <InputAdornment position="end">
                          <IconButton
                            onClick={handleTogglePasswordVisibility}
                            edge="end"
                          >
                            {showPassword ? <VisibilityOff /> : <Visibility />}
                          </IconButton>
                        </InputAdornment>
                      ),
                    }}
                  />
                </Grid>
              </Grid>
            </Grid>
            <Grid container item spacing={1} justifyContent="center">
              <Grid item>
                <Button
                  variant="outlined"
                  disabled={
                    usernameError ||
                    userEmailError ||
                    userPasswordError ||
                    username === "" ||
                    userEmail === "" ||
                    userPassword === ""
                  }
                  onClick={handleSubmit}
                >
                  Sign up
                </Button>
              </Grid>
            </Grid>
          </Box>
        </CardContent>
      </Card>
    </Grid>
  );
};

export default RegisterPage;
