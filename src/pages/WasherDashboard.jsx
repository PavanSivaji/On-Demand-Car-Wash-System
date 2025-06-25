import React, { useEffect, useState } from "react";
import axios from "axios";
import "./WasherDashboard.css";

const WasherDashboard = () => {
  // Get username from localStorage (adjust key as per your app)
  const user = JSON.parse(localStorage.getItem("user"));
  const username = user?.username || "Washer";

  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchOrders = async () => {
      setLoading(true);
      try {
        const res = await axios.get(
          "http://localhost:8088/booking/order/washer/pending"
        );
        setOrders(res.data);
      } catch (err) {
        setOrders([]);
      }
      setLoading(false);
    };
    fetchOrders();
  }, []);

  const handleDetails = (order) => {
    alert(
      `Order Details:\nOrder ID: ${order.id}\nCustomer: ${order.customerName}\nCar: ${order.carModel || "N/A"}`
    );
  };

  const handleAccept = async (orderId) => {
    // Replace with your actual accept order API endpoint
    try {
      await axios.post(
        `http://localhost:8088/booking/order/washer/accept/${orderId}`
      );
      setOrders((prev) => prev.filter((order) => order.id !== orderId));
      alert("Order accepted!");
    } catch (err) {
      alert("Failed to accept order.");
    }
  };

  return (
    <div className="washer-dashboard-bg">
      <div className="washer-dashboard-card">
        <h2 className="washer-dashboard-title">
          Welcome <span className="username">{username}</span>!
        </h2>
        <div className="orders-list-section">
          <h3>Pending Orders</h3>
          {loading ? (
            <div className="loader">Loading...</div>
          ) : orders.length === 0 ? (
            <p className="empty-msg">No pending orders.</p>
          ) : (
            <ul className="orders-list">
              {orders.map((order) => (
                <li key={order.id} className="order-row">
                  <span className="order-info">
                    <b>Order #{order.id}</b> &mdash; {order.customerName}
                  </span>
                  <div className="order-actions">
                    <button
                      className="details-btn"
                      onClick={() => handleDetails(order)}
                    >
                      Details
                    </button>
                    <button
                      className="accept-btn"
                      onClick={() => handleAccept(order.id)}
                    >
                      Accept
                    </button>
                  </div>
                </li>
              ))}
            </ul>
          )}
        </div>
      </div>
    </div>
  );
};

export default WasherDashboard;