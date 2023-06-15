import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {Box, Button, Card, CardContent, Grid, IconButton, InputAdornment, TextField} from "@mui/material";
import {Visibility, VisibilityOff} from "@mui/icons-material";
import SignedUserVersion from "../../SignedUserVersion/SignedUserVersion.jsx";

const RegisterPage = ({setUser}) => {

    const [username, setUsername] = useState("");
    const [usernameError, setUsernameError] = useState(false);
    const [userEmail, setUserEmail] = useState("")
    const [userEmailError, setUserEmailError] = useState(false);
    const [userPassword, setUserPassword] = useState("");
    const [userPasswordError, setUserPasswordError] = useState(false);
    const [showPassword, setShowPassword] = useState(false);

    const validateString = (string) => {
        return !(string == null || string.length <= 0);
    };

    const navigate = useNavigate();

    const url = "http://localhost:8080/api/v1/auth/register";

    const handleTogglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (username.trim().length <= 0) {
            return;
        } else if (userEmail.trim().length <= 0) {
            return;
        } else if (userPassword.trim().length <= 0) {
            return;
        }

        let userInput = {
            username: username,
            email: userEmail,
            password: userPassword,
        };

        fetch(url, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(userInput),
        })
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Authentication failed");
                }
            })
            .then((data) => {
                localStorage.setItem('token', data.token); //oder sessionStorage.setItem.....
                console.log("Token saved in localStorage");
            })
            .catch((err) => console.log(`Hey, there is an ${err}`));
            setUser(true)
            navigate("/logged-in")
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
                                        onBlur={() => setUserPasswordError(!validateString(userPassword))}
                                        fullWidth
                                        InputProps={{ // customizieren von input components. Hier InputAdornment damit man button icon hinzufügen kann
                                            endAdornment: (
                                                <InputAdornment position="end">
                                                    <IconButton onClick={handleTogglePasswordVisibility} edge="end">
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