import { Link, useParams } from "react-router-dom";
import { useState } from "react";
import { retrieveHelloWorldBean, retrieveHelloWorldPathParam, retrieveHelloWorldText } from "./api/HelloWorldApiService";


function WelcomeComponent() {

    const[message, setMessage] = useState("");

    const {username} = useParams();

    async function hanldeClickRedirectHelloWorld() {
        try{
            const response = await retrieveHelloWorldText();
            successfulResponse(response.data);
        } catch (error) {
            errorResponse(error);
        }     
    }

    async function hanldeClickRedirectHelloWorldBean() {
        try{
            const response = await retrieveHelloWorldBean();
            successfulResponse(response.data.message);
        } catch (error) {
            errorResponse(error);
        }     
    }

    async function hanldeClickRedirectHelloWorldPathParam() {
        try{
            const response = await retrieveHelloWorldPathParam("Shivam");
            successfulResponse(response.data.message);
        } catch (error) {
            errorResponse(error);
        }    
    }

    function successfulResponse(response) {
        setMessage(response);
    }

    function errorResponse(error) {
        console.log(`Error Response: ${error}`);
    }

    return (
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                <p>Manage your todos: <Link to="/list-todos">Click here</Link></p>
                <button 
                    className="btn btn-outline-success m-5"
                    onClick={hanldeClickRedirectHelloWorld}
                >Call Hello World
                </button>
                <button 
                    className="btn btn-outline-success m-5"
                    onClick={hanldeClickRedirectHelloWorldBean}
                >Call Hello World Bean
                </button><button 
                    className="btn btn-outline-success m-5"
                    onClick={hanldeClickRedirectHelloWorldPathParam}
                >Call Hello World Path Param
                </button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}

export default WelcomeComponent;