import PostForm from "./PostForm.jsx";
import RezeptCollection from "./RezeptCollection.jsx";
import TimeLine from "./TimeLine.jsx";

const ContentSection = (props) => {
  return (
    <div>
      {props.activeComponent === "Landing" ? <TimeLine user={props.user}/> : ""}
      {props.activeComponent === "Post" ? <PostForm user={props.user}/> : ""}
      {props.activeComponent === "Collection" ? <RezeptCollection user={props.user}/> : ""}
    </div>
  );
};

export default ContentSection;
