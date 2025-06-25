import React, { useState } from "react";
import "./Register.css";
import axios from "axios";

const initialState = {
  username: "",
  password: "",
  email: "",
  phoneNumber: "",
  address: "",
  age: "",
  role: "CUSTOMER",
};

const Register = () => {
  const [form, setForm] = useState(initialState);
  const [errors, setErrors] = useState({});

  const validate = () => {
    const errs = {};
    if (!form.username) errs.username = "Username is required";
    if (!form.password) errs.password = "Password is required";
    if (!form.email) errs.email = "Email is required";
    else if (!/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/.test(form.email))
      errs.email = "Invalid email format";
    if (!form.phoneNumber) errs.phoneNumber = "Phone number is required";
    else if (!/^\d{10}$/.test(form.phoneNumber))
      errs.phoneNumber = "Phone number must be 10 digits";
    if (!form.address) errs.address = "Address is required";
    if (!form.age) errs.age = "Age is required";
    else if (isNaN(form.age) || Number(form.age) < 18)
      errs.age = "Age must be 18 or older";
    if (!form.role) errs.role = "Role is required";
    return errs;
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleRoleChange = (e) => {
    setForm({ ...form, role: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const errs = validate();
    setErrors(errs);
    if (Object.keys(errs).length === 0) {
      try {
        await axios.post(
          "http://localhost:8088/auth/signup",
          {
            username: form.username,
            password: form.password,
            email: form.email,
            phoneNumber: form.phoneNumber,
            address: form.address,
            age: Number(form.age),
            role: form.role,
          }
        );
        alert("Registration successful!");
        setForm(initialState);
      } catch (error) {
        if (error.response && error.response.data) {
          alert("Registration failed: " + JSON.stringify(error.response.data));
        } else {
          alert("Registration failed. Please try again.");
        }
      }
    }
  };

  return (
    <div className="register-bg">
      <form className="register-form" onSubmit={handleSubmit}>
        <h2 className="register-title">Sign Up</h2>
        <div className="register-field">
          <label>Username</label>
          <input name="username" value={form.username} onChange={handleChange} />
          {errors.username && <span className="register-error">{errors.username}</span>}
        </div>
        <div className="register-field">
          <label>Password</label>
          <input type="password" name="password" value={form.password} onChange={handleChange} />
          {errors.password && <span className="register-error">{errors.password}</span>}
        </div>
        <div className="register-field">
          <label>Email</label>
          <input name="email" value={form.email} onChange={handleChange} />
          {errors.email && <span className="register-error">{errors.email}</span>}
        </div>
        <div className="register-field">
          <label>Phone Number</label>
          <input name="phoneNumber" value={form.phoneNumber} onChange={handleChange} />
          {errors.phoneNumber && <span className="register-error">{errors.phoneNumber}</span>}
        </div>
        <div className="register-field">
          <label>Address</label>
          <input name="address" value={form.address} onChange={handleChange} />
          {errors.address && <span className="register-error">{errors.address}</span>}
        </div>
        <div className="register-field">
          <label>Age</label>
          <input name="age" type="number" value={form.age} onChange={handleChange} />
          {errors.age && <span className="register-error">{errors.age}</span>}
        </div>
        {/* Role selection without visible label */}
        <div className="register-field">
          <div className="register-radio-group">
            <label className={form.role === "CUSTOMER" ? "selected" : ""}>
              <input
                type="radio"
                name="role"
                value="CUSTOMER"
                checked={form.role === "CUSTOMER"}
                onChange={handleRoleChange}
              />
              <span>Customer</span>
            </label>
            <label className={form.role === "WASHER" ? "selected" : ""}>
              <input
                type="radio"
                name="role"
                value="WASHER"
                checked={form.role === "WASHER"}
                onChange={handleRoleChange}
              />
              <span>Washer</span>
            </label>
          </div>
          {errors.role && <span className="register-error">{errors.role}</span>}
        </div>
        <button className="register-btn" type="submit">Sign Up</button>
      </form>
    </div>
  );
};

export default Register;