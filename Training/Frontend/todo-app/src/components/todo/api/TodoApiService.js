import axios from "axios";

const usernameForLocal = 'satyammi';
const passwordForLocal = 'password';

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080',
        withCredentials: true
    }
)

async function retrieveAllTodosForUserApi(username) {
    return await apiClient.get(`/users/${username}/todos`, {
        auth: {
        username: usernameForLocal,
        password: passwordForLocal
        }
    });
}

async function retrieveTodoByIdApi(username, todoId){
    return await apiClient.get(`/users/${username}/todos/${todoId}`, {
        auth: {
        username: usernameForLocal,
        password: passwordForLocal
        }
    })
}

async function createNewTodoApi(username, todo){
    return await apiClient.post(`/users/${username}/todos`, todo, {
        auth: {
        username: usernameForLocal,
        password: passwordForLocal
        }
    });
}

async function updateTodoByIdApi(username, todoId, todo){
    return await apiClient.put(`/users/${username}/todos/${todoId}`, todo, {
        auth: {
        username: usernameForLocal,
        password: passwordForLocal
        }
    });
}

async function deleteTodoByIdApi(username,id){
    return await apiClient.delete(`/users/${username}/todos/${id}`, {
        auth: {
        username: usernameForLocal,
        password: passwordForLocal
        }
    });
}


export {retrieveAllTodosForUserApi, retrieveTodoByIdApi, createNewTodoApi, updateTodoByIdApi, deleteTodoByIdApi}