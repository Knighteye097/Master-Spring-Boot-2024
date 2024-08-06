import "./Counter.css"
import { PropTypes } from "prop-types"

function Button(props) {

    return (
        <>
        <button className="counterButton" 
                    onClick={() => props.onClick(props.value)}   
                >{props.value}</button>
        </>
    );
}

Button.propTypes = {
    value : PropTypes.number
}

Button.defaultProps = {
    value: 1
}

export default Button;