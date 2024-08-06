import { useState } from "react";
import Button from "./Button";


function Counter() {

    const [count, setCount] = useState(0);

    function handleClick(value) {
        setCount(count+value);
    }

    function resetCounter() {
        setCount(0);
    }

    return (
        <div className="Counter">
            <div>
               <Button 
                    value={1}
                    onClick={handleClick}     
               />
               <Button 
                    value={-1}
                    onClick={handleClick}
               />
            </div>
            <div>
               <Button 
                    value={2}
                    onClick={handleClick}
               />
               <Button 
                    value={-2}
                    onClick={handleClick}
               />
            </div>
            <div>   
               <Button 
                    value={5}
                    onClick={handleClick}
               />
               <Button 
                    value={-5}
                    onClick={handleClick}
               />
            </div>   
            <span className="count">{count}</span>
            <div>
                <button className="resetButton" 
                    onClick={resetCounter}>
                Reset</button>
            </div>    
        </div>
    );
}

export default Counter;