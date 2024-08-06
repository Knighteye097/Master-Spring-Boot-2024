import { useEffect, useState } from "react";
import { deleteTodoByIdApi, retrieveAllTodosForUserApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

function ListTodoComponent() {
    
    const [todos, setTodos] = useState([]);

    const {username} = useAuth();

    const [messageForDelete, setMessageForDelete] = useState('');

    const navigate = useNavigate();

    const refreshTodos = async () => {
        try{
            const response = await retrieveAllTodosForUserApi(username);
            setTodos(response.data);
        } catch (err) {
            console.log(err.message);
        }
    };

    async function handleDeleteClickElt(todoId) {
        try{
            await deleteTodoByIdApi(username, todoId);
            setMessageForDelete(`Record with id: ${todoId} is deleted!`)
            refreshTodos();
        }
        catch (err){
            console.log(err.message);
        }
    }

    function handleEditClickElt(todoId) {
        navigate(`/todo/${todoId}`);
    }

    function handleNewTodoClick() {
        navigate(`/todo/${-1}`);
    }

    useEffect(() => {refreshTodos()},[]);

    return (
        <div className="container">
            <h1>Things you want to do!</h1>
            {messageForDelete && <div className="alert alert-danger">{messageForDelete}</div>}
            <table className="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Is Done?</th>
                        <th>TargetDate</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        todos.map(elt => (
                            <tr key={elt.id}>
                                <td>{elt.description}</td>
                                <td>{elt.done.toString()}</td>
                                <td>{elt.targetDate.toString()}</td>
                                <td><button 
                                            className="btn btn-outline-danger"
                                            onClick={() => handleDeleteClickElt(elt.id)}
                                            >Delete
                                            </button></td>
                                <td><button 
                                            className="btn btn-outline-success"
                                            onClick={() => handleEditClickElt(elt.id)}
                                            >Edit</button></td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
            <button 
                className="btn btn-outline-primary m-3" 
                onClick={handleNewTodoClick}
                >Add New Todo
            </button>
        </div>
    );
}

export default ListTodoComponent;