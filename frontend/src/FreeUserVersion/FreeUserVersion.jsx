//import './App.css'
import Navbar from "./layout/Navbar.jsx";
import Footer from "./layout/Footer.jsx";
import LoginPage from "./components/LoginPage.jsx";
import LandingPageSection from "./components/LandingPageSection.jsx";

function FreeUserVersion({ setUser }) {
  return (
    <div className="flex flex-col min-h-screen">
      <Navbar />
      <LandingPageSection setUser={setUser} />
      <Footer />
    </div>
  );
}

export default FreeUserVersion;

/*; 
const [filterBtnForFood, setFilterBtnForFood] = useState("sweet");
 <>
      <Navbar />
      <div className="flex flex-row justify-around items-center">
        <div>
          <MenuOptions setFilterBtnChange={setFilterBtnForFood} />
        </div>
        <div>
          <ContentSection filterBtn={filterBtnForFood} />
        </div>
        <div>for test purposes</div>
      </div>
      <Footer />
    </>
      > */

/* */
