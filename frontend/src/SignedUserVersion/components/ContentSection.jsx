import PostForm from "./PostForm.jsx";
import RezeptCollection from "./RezeptCollection.jsx";

const ContentSection = (props) => {
  return (
    <div>
      {props.activeComponent === "Landing" ? <PostForm user={props.user}/> : ""}
      {props.activeComponent === "Collection" ? <RezeptCollection user={props.user}/> : ""}
    </div>
  );
};

export default ContentSection;
