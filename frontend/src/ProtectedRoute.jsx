import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const ProtectedRoute = (props) => {

    const navigate = useNavigate();

    useEffect(() => {
        if(!props.user) {
            return navigate("/");
        }
    })
    
    return ( 
        props.children
     );
}
 
export default ProtectedRoute;