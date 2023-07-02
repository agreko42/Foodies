const BASE_URL = "http://localhost:8080";

const Endpoint = {
  LOGIN: {
    getUrl: `${BASE_URL}/api/v1/auth/authenticate`,
    method: "POST",
  },
  REGISTER: {
    getUrl: `${BASE_URL}/api/v1/auth/register`,
    method: "POST",
  },
};

export default Endpoint;
