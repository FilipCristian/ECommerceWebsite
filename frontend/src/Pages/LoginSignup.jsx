import React, { useState } from "react";
import axios from 'axios'; // Import Axios
import "./CSS/LoginSignup.css"; // Ensure the CSS file is correctly imported

const LoginSignup = () => {
  // Updated formData state to include all required fields
  const [formData, setFormData] = useState({
    username: "",
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    agreeToTerms: false,
  });

  // State to manage whether it's in a "Login" or "Sign Up" state
  const [state, setState] = useState('Sign Up');

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Form Data:", formData);
    
    // Specify the URL of your Java Spring Boot backend endpoint
    const url = 'http://localhost:8080/api/v1/psProject'; // Adjust this URL as needed

    // Transform formData to match the RegistrationRequest Java class structure if needed
    const registrationData = {
      username: formData.username,
      firstName: formData.firstName,
      lastName: formData.lastName,
      email: formData.email,
      password: formData.password,
      agreeToTerms: formData.agreeToTerms,
      // Add any other fields expected by your RegistrationRequest class
    };

    // Sending the POST request with Axios
    axios.post(url, registrationData)
      .then(response => {
        console.log(response.data);
        alert('Registration successful!');
      })
      .catch(error => {
        console.error('There was an error!', error);
        alert('Registration failed. Check console for details.');
      });
  };

  return (
    <form className="loginsignup" onSubmit={handleSubmit}>
      <div className="loginsignup-container">
        <h1>{state}</h1>
        <div className="loginsignup-fields">
          {state === 'Sign Up' && (
            <>
              <input
                type="text"
                placeholder="Username"
                name="username"
                value={formData.username}
                onChange={handleChange}
              />
              <input
                type="text"
                placeholder="First Name"
                name="firstName"
                value={formData.firstName}
                onChange={handleChange}
              />
              <input
                type="text"
                placeholder="Last Name"
                name="lastName"
                value={formData.lastName}
                onChange={handleChange}
              />
            </>
          )}
          <input
            type="email"
            placeholder="Email Address"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
          <input
            type="password"
            placeholder="Password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Continue</button>
        <p className="loginsignup-login">
          {state === 'Sign Up' ? (
            <>
              Already have an account? <span onClick={() => setState('Login')} style={{ cursor: 'pointer' }}>Login Here</span>
            </>
          ) : (
            <>
              Create an account? <span onClick={() => setState('Sign Up')} style={{ cursor: 'pointer' }}>Click here</span>
            </>
          )}
        </p>
        <div className="loginsignup-agree">
          <input
            type="checkbox"
            name="agreeToTerms"
            id="agreeToTerms"
            checked={formData.agreeToTerms}
            onChange={handleChange}
          />
          <label htmlFor="agreeToTerms">By continuing, I agree to the terms of use & privacy policy.</label>
        </div>
      </div>
    </form>
  );
};

export default LoginSignup;
