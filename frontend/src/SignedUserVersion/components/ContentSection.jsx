import PostForm from "./PostForm.jsx";


const ContentSection = (props) => {

    return(
        <>
            {props.activeComponent === "Landing" ? <PostForm/> : ""}

        </>
    )
}

export default ContentSection;