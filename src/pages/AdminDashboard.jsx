import React, { useEffect, useState } from "react";

const AdminDashboard = () => {
  const [message, setMessage] = useState("");
  const token = localStorage.getItem("jwtToken");

  useEffect(() => {
    fetch("http://localhost:8088/protected/admin", {
      method: "GET",
      headers: {
        "Authorization": "Bearer " + token,
        "Content-Type": "application/json",
      },
    })
      .then((res) => {
        if (res.status === 401) {
          setMessage("Unauthorized. Please login again.");
          return null;
        }
        return res.json();
      })
      .then((data) => {
        if (data) setMessage("Welcome to the Admin Dashboard!");
      })
      .catch(() => setMessage("Could not fetch admin data."));
  }, [token]);

  return (
    <div>
      <h1>Admin Dashboard</h1>
      <p>{message}</p>
    </div>
  );
};

export default AdminDashboard;