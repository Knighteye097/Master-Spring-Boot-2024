import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

function LoginComponent() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [notAuthenticated, setNotAuthenticated] = useState(false);
    const navigate = useNavigate();
    const authContext = useAuth();

    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleLoginSubmit() {
        if(authContext.login(username, password)){
            navigate(`/welcome/${username}`)
        } else {
            setNotAuthenticated(true);
        }
    }

    return (
        <div className="Login">
            {notAuthenticated && <div className="errorMessage" >Authenticate Failed.</div>}
            Login Component
            <div>
                <div>
                    <label>Username:</label>
                    <input type="text" 
                            name="username" 
                            value={username}
                            placeholder="username"
                            onChange={handleUsernameChange}
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" 
                            name="password" 
                            placeholder="password"
                            value={password}
                            onChange={handlePasswordChange}
                    />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleLoginSubmit}>Login</button>
                </div>
            </div>
        </div>
    );
}

export default LoginComponent;