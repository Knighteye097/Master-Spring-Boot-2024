import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import { createNewTodoApi, retrieveTodoByIdApi, updateTodoByIdApi } from "./api/TodoApiService";
import { useEffect, useState } from "react";
import { Formik, Form, Field, ErrorMessage} from "formik";

function TodoComponent() {

    const { todoId } = useParams();
    const { username } =useAuth();
    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');
    const navigate = useNavigate();
    
    const retrieveTodoById = async () => {
        if(todoId !== -1){
            try{
                const response = await retrieveTodoByIdApi(username ,todoId);
                setDescription(response.data.description);
                setTargetDate(response.data.targetDate);
            } catch (err) {
                console.log(err);
            }
        }
    }

    useEffect( () => {retrieveTodoById()},[todoId] );

    const handleFormikSubmit = async (values) => {
        const todo = {
            id: todoId,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        };

        try {
            if(todoId !== -1){
                await updateTodoByIdApi(username, todoId, todo);
            } else {
                await createNewTodoApi(username, todo);
            }
            navigate("/list-todos");
        } catch(err) {
            console.log(err);
        }
        
    }

    function handleFormikValidate(values){
        let errors = {};

        if(values.description.length<5){
            errors.description = "Enter atleast 5 characters";
        }

        if(!values.targetDate){
            errors.targetDate = "Enter a targetDate";
        }

        return errors;
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div className="coantiner">
                <Formik initialValues={ {description, targetDate} } 
                    enableReinitialize={true}
                    onSubmit={handleFormikSubmit}
                    validate={handleFormikValidate}
                    validateOnChange={false}
                    validateOnBlur={false}>
                    {
                        (props) => (
                            <Form action="">
                                <ErrorMessage 
                                    name="description"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <ErrorMessage 
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <fieldset className="form-group">
                                    <label htmlFor="description">Description:</label>
                                    <Field 
                                        type="text" 
                                        name="description" />
                                    <br />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label htmlFor="targetDate">TargetDate:</label>
                                    <Field 
                                        type="date" 
                                        name="targetDate"/>
                                    <br />
                                    <br />
                                </fieldset>
                                <input className="btn btn-primary mb-5" type="submit" value="Submit" />
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    );
}

export default TodoComponent;