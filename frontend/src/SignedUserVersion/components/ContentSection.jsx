import PostForm from "./PostForm.jsx";
import RezeptCollection from "./RezeptCollection.jsx";

const ContentSection = (props) => {
  return (
    <div>
      {props.activeComponent === "Landing" ? <PostForm /> : ""}
      {props.activeComponent === "Collection" ? <RezeptCollection /> : ""}
    </div>
  );
};

export default ContentSection;
