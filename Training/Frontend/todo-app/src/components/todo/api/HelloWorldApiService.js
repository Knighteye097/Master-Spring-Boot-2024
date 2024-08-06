import axios from "axios";

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080',
        withCredentials: true
    }
)

async function login(username, password) {
    try {
        const response = await apiClient.post('/login', {
            username,
            password
        });
        console.log('Login successful:', response.data);
        return response.data;
    } catch (error) {
        console.error('Login failed:', error);
        throw error;
    }
}

const retrieveHelloWorldText = async() => {
    await login('satyammi', 'password');
    return await apiClient.get("http://localhost:8080/hello-world");
}  

async function retrieveHelloWorldBean() {
    await login('satyammi', 'password');
    return await apiClient.get("/hello-world-bean");
}

async function retrieveHelloWorldPathParam(name) {
    await login('satyammi', 'password');
    return await apiClient.get(`/hello-world/path-variable/${name}`)
}

export {retrieveHelloWorldText, retrieveHelloWorldBean, retrieveHelloWorldPathParam}