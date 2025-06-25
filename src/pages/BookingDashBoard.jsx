import React, { useState } from "react";
import "./BookingDashboard.css";

const BookingDashboard = () => {
  const [form, setForm] = useState({
    name: "",
    phonenumber: "",
    capacity: "",
    carmodel: "",
    location: "",
    time: "",
    uid: "",
  });
  const [thankYou, setThankYou] = useState(false);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const confirmed = window.confirm("Are you sure you want to confirm the order?");
    if (!confirmed) return;

    // Trim all fields to avoid accidental spaces
    const trimmedForm = Object.fromEntries(
      Object.entries(form).map(([k, v]) => [k, typeof v === "string" ? v.trim() : v])
    );

    // Format time to "YYYY-MM-DD HH:mm"
    let formattedTime = trimmedForm.time;
    if (formattedTime && formattedTime.includes("T")) {
      formattedTime = formattedTime.replace("T", " ");
    }

    const formattedForm = {
      ...trimmedForm,
      time: formattedTime,
    };

    const token = localStorage.getItem("jwtToken");

    try {
      const res = await fetch("http://localhost:8088/booking/order/customer/request", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${token}`,
        },
        body: JSON.stringify(formattedForm),
      });
      if (res.ok) {
        setThankYou(true);
      } else {
        alert("Booking failed. Please try again.");
      }
    } catch {
      alert("Booking failed. Please try again.");
    }
  };

  if (thankYou) {
    return (
      <div className="booking-dashboard-thankyou">
        Thank you for booking your car wash!
      </div>
    );
  }

  return (
    <div className="booking-dashboard-container">
      <h2 className="booking-dashboard-title">Order Booking Form</h2>
      <form className="booking-dashboard-form" onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={form.name} onChange={handleChange} required />
        <input name="phonenumber" placeholder="Phone Number" value={form.phonenumber} onChange={handleChange} required />
        <input name="capacity" type="number" min="1" placeholder="Seating Capacity" value={form.capacity} onChange={handleChange} required />
        <input name="carmodel" placeholder="Car Model" value={form.carmodel} onChange={handleChange} required />
        <input name="location" placeholder="Location" value={form.location} onChange={handleChange} required />
        <input name="time" type="datetime-local" placeholder="Time" value={form.time} onChange={handleChange} required />
        <input name="uid" placeholder="User ID" value={form.uid} onChange={handleChange} required />
        <button type="submit">Book</button>
      </form>
    </div>
  );
};

export default BookingDashboard;