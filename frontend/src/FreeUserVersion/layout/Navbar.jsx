const Navbar = () => {
  return (
    <nav className="border-gray-200 bg-white dark:bg-gray-800 dark:border-gray-700">
      <div className="min-w-full flex flex-wrap items-center justify-center mx-auto p-4">
        <a href="/" className="flex items-center">
          <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">
            Foodies
          </span>
        </a>
      </div>
    </nav>
  );
};

export default Navbar;
