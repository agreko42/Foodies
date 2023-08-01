import WheelContainer from "./Roulette/WheelContainer.jsx";

const ContentSection = (props) => {
  return (
    <div>
      <WheelContainer filterBtn={props.filterBtn} />
    </div>
  );
};

export default ContentSection;
