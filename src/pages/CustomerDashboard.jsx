import React from "react";
import { useNavigate } from "react-router-dom";
import "./CustomerDashboard.css";
import bgImg from "../assets/bg.jpg";
import carShakeHandsImg from "../assets/carshakehands.jpg";

function getUsernameFromToken() {
  const token = localStorage.getItem("jwtToken");
  if (!token) return "";
  try {
    const payload = token.split('.')[1];
    const decoded = JSON.parse(atob(payload));
    return decoded.sub || decoded.username || "";
  } catch {
    return "";
  }
}

const CustomerDashboard = () => {
  const navigate = useNavigate();
  const username = getUsernameFromToken();

  return (
    <div className="customer-dashboard-bg">
      <h1 className="customer-dashboard-title">
        Welcome{username ? ` ${username}` : ""}!
      </h1>
      <div className="customer-dashboard-boxes">
        <div
          className="dashboard-box book-box"
          onClick={() => navigate("/customer/book")}
        >
          <img
            src={bgImg}
            alt="Book Car Wash"
            className="dashboard-box-img"
          />
          <span className="dashboard-box-title">Book Your Car Wash</span>
          <span className="dashboard-box-desc">
            Schedule a wash for your car at your convenience.
          </span>
        </div>
        <div
          className="dashboard-box orders-box"
          onClick={() => navigate("/customer/orders")}
        >
          <img
            src={carShakeHandsImg}
            alt="Your Orders"
            className="dashboard-box-img"
          />
          <span className="dashboard-box-title">Your Orders</span>
          <span className="dashboard-box-desc">
            View and manage all your previous and upcoming bookings.
          </span>
        </div>
      </div>
    </div>
  );
};

export default CustomerDashboard;