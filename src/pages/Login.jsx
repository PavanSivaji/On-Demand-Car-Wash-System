import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";

function getRoleFromToken(token) {
  if (!token) return null;
  try {
    const payload = token.split('.')[1];
    const decoded = JSON.parse(atob(payload));
    // Adjust the key if your backend uses a different property name
    return (decoded.role || decoded.roles || "").toLowerCase();
  } catch {
    return null;
  }
}

const Login = ({ onLogin }) => {
  const [form, setForm] = useState({
    username: "",
    password: "",
  });
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({
      ...prev,
      [name]: value,
    }));
    setError("");
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      const response = await fetch("http://localhost:8088/auth/authenticate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          username: form.username.trim(),
          password: form.password.trim(),
        }),
      });
      const token = await response.text();
      if (response.ok) {
        localStorage.setItem("jwtToken", token);
        if (onLogin) onLogin(token);
        const role = getRoleFromToken(token);
        if (role === "customer") {
          navigate("/customer");
        } else if (role === "washer") {
          navigate("/washer");
        } else if (role === "admin") {
          navigate("/admin");
        } else {
          setError("Unknown role.");
        }
      } else {
        setError("Wrong credentials. Please try again.");
      }
    } catch {
      setError("Network error. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="login-container">
      <form className="login-form" onSubmit={handleSubmit}>
        <h2>Login</h2>
        <label>
          Username
          <input
            type="text"
            name="username"
            value={form.username}
            onChange={handleChange}
            required
            autoComplete="username"
          />
        </label>
        <label>
          Password
          <input
            type="password"
            name="password"
            value={form.password}
            onChange={handleChange}
            required
            autoComplete="current-password"
          />
        </label>
        {error && <div className="login-error">{error}</div>}
        <button type="submit" disabled={loading}>
          {loading ? "Logging in..." : "Login"}
        </button>
      </form>
    </div>
  );
};

export default Login;