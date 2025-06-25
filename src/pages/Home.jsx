import React from "react";
import "./Home.css";

import interiorImg from "../assets/interiorwash.jpeg";
import exteriorImg from "../assets/exteriorwash.avif";
import serviceImg from "../assets/carservice.jpeg";

const galleryImages = [
  {
    src: interiorImg,
    alt: "Premium Interior Cleaning"
  },
  {
    src: exteriorImg,
    alt: "Premium Exterior Wash"
  },
  {
    src: serviceImg,
    alt: "Premium Car Service"
  }
];

const Home = () => (
  <div className="landing-bg">
    <div className="landing-navbar-space" />
    <div className="landing-main animated-fadein">
      <h1 className="landing-title">
        <span className="brand-gradient">Welcome to Crystal Car</span>
      </h1>
      <p className="landing-tagline">Your car, always shining. Fast. Friendly. Eco-friendly.</p>
      <p className="landing-subtitle">
        Experience the best car wash service in your city.<br />
        <span className="landing-subtext">Register or Login to get started!</span>
      </p>
      <a href="/register" className="cta-btn">Book Now</a>
      <div className="landing-gallery animated-slidein">
        {galleryImages.map((img, idx) => (
          <div className="gallery-card" key={idx}>
            <img src={img.src} alt={img.alt} />
            <div className="gallery-caption">{img.alt}</div>
          </div>
        ))}
      </div>
      <svg className="wave-bg" viewBox="0 0 1440 320">
        <path fill="#e3f2fd" fillOpacity="1" d="M0,224L48,197.3C96,171,192,117,288,117.3C384,117,480,171,576,197.3C672,224,768,224,864,197.3C960,171,1056,117,1152,117.3C1248,117,1344,171,1392,197.3L1440,224L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"></path>
      </svg>
    </div>
  </div>
);

export default Home;