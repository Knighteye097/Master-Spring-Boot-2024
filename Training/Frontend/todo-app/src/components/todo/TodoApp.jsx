import {
    createBrowserRouter,
    Navigate,
    RouterProvider,
} from "react-router-dom";
import ErrorPage from "./error-page";  
import "./TodoApp.css";
import LoginComponent from "./LoginComponent";
import WelcomeComponent from "./WelcomeComponent";
import ListTodoComponent from "./ListTodoComponent";
import LogoutComponent from "./LogoutComponent";
import LayoutComponent from "./LayoutComponent";
import AuthProvider, { useAuth } from "./security/AuthContext";
import TodoComponent from "./TodoComponent";

function AuthenticateRoute({children}) {
    if(useAuth().isAuthenticated){
        return children;
    }

    return <Navigate to="/" />;
}

const router = createBrowserRouter([
    {
        element: <LayoutComponent />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: "/",
                element: <LoginComponent />,
            },
            {
                path: "/login",
                element: <LoginComponent />,
            },
            {
                path: "/welcome/:username",
                element: 
                    <AuthenticateRoute>
                        <WelcomeComponent />
                    </AuthenticateRoute>
                ,
            },
            {
                path: "/list-todos",
                element: 
                    <AuthenticateRoute>  
                        <ListTodoComponent />
                    </AuthenticateRoute>  ,
            },
            {
                path: "/todo/:todoId",
                element: 
                    <AuthenticateRoute>  
                        <TodoComponent />
                    </AuthenticateRoute>  ,
            },
            {
                path: "/logout",
                element: 
                    <AuthenticateRoute>
                        <LogoutComponent />
                    </AuthenticateRoute>,
            }
        ]
    }
]);

function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <RouterProvider router={router} />
            </AuthProvider>
        </div>
    );
}

export default TodoApp;
