import LoginPage from "./LoginPage";

const LandingPageSection = ({ setUser }) => {
  return (
    <section className="flex-grow flex flex-col md:flex-row items-center justify-center bg-orange-200 dark:bg-gray-900 p-10">
      <div className="w-full md:w-1/2 flex flex-col mb-8 md:mb-0">
        {" "}
        {/* Note the `w-full` for mobile and `mb-8` for spacing on mobile */}
        <h1 className="max-w-2xl mb-4 text-4xl font-extrabold tracking-tight leading-none md:text-5xl xl:text-6xl dark:text-white">
          Eat Like a King, Cook Like a Pro – Every Day!
        </h1>
        <p className="max-w-2xl mb-6 font-light text-gray-500 lg:mb-8 md:text-lg lg:text-xl dark:text-gray-400">
          Discover, Cook, and Rule the Kitchen!
        </p>
        <a
          href="/signup/register"
          className="inline-flex items-center justify-center px-5 py-3 text-base font-medium text-center text-gray-900 border border-gray-400 rounded-lg hover:bg-gray-100  focus:ring-gray-100 dark:text-white dark:border-gray-700 dark:hover:bg-gray-700 dark:focus:ring-gray-800"
        >
          Get started
          <svg
            className="w-5 h-5 ml-2 -mr-1"
            fill="currentColor"
            viewBox="0 0 20 20"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fillRule="evenodd"
              d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z"
              clipRule="evenodd"
            ></path>
          </svg>
        </a>
      </div>
      <div className="w-full lg:w-1/2 md:p-10">
        {" "}
        {/* Note the `w-full` for mobile */}
        <LoginPage setUser={setUser} />
      </div>
    </section>
  );
};

export default LandingPageSection;
