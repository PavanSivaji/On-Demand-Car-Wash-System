import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Register from "./pages/Register";
import ContactUs from "./pages/ContactUs";
import AboutUs from "./pages/AboutUs";
import Login from "./pages/Login";
import CustomerDashboard from "./pages/CustomerDashboard";
import WasherDashboard from "./pages/WasherDashboard";
import AdminDashboard from "./pages/AdminDashboard";
import BookingDashboard from "./pages/BookingDashboard";

function App() {
  return (
    <Router>
      <Navbar />
      <div className="main-content">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/contact" element={<ContactUs />} />
          <Route path="/about" element={<AboutUs />} />
          <Route path="/login" element={<Login />} />
          <Route path="/customer" element={<CustomerDashboard />} />
          <Route path="/washer" element={<WasherDashboard />} />
          <Route path="/admin" element={<AdminDashboard />} />
          <Route path="/customer/book" element={<BookingDashboard />} />
          <Route path="/washer/dashboard" element={<WasherDashboard />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;