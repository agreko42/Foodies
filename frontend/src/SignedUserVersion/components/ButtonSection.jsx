const ButtonSection = ({ handleActiveComponentChange }) => {
  return (
    <div className="flex flex-col items-center">
      <div className="flex space-x-4">
        <button className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-lg">
          Ranking
        </button>
        <button className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-lg">
          Wheel
        </button>
        <button
          onClick={() => handleActiveComponentChange("Collection")}
          className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-lg"
        >
          Collections
        </button>
        <button className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-lg">
          Friends
        </button>
        <button
            onClick={() => handleActiveComponentChange("Post")}
            className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-lg">
          Post
        </button>
      </div>
    </div>
  );
};

export default ButtonSection;
