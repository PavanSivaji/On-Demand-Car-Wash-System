import { Link } from "react-router-dom";

const Navbar = () => (
  <nav className="navbar">
    <div className="navbar-logo">Crystal Car</div>
    <div className="navbar-links-container">
      <ul className="navbar-links">
        <li><Link to="/">Home</Link></li>
        <li><Link to="/register">Register</Link></li>
        <li><Link to="/contact">ContactUs</Link></li>
        <li><Link to="/about">AboutUs</Link></li>
        <li><Link to="/login">Login</Link></li>
      </ul>
    </div>
  </nav>
);

export default Navbar;