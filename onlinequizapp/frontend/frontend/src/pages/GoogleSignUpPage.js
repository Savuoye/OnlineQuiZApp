
import React, { useEffect } from 'react';
import jwt_decode from "jwt-decode";

const GoogleSignup = () => {
  useEffect(() => {
    /* global google */
    const initializeGoogleSignIn = () => {
      google.accounts.id.initialize({
        client_id: 'YOUR_GOOGLE_CLIENT_ID.apps.googleusercontent.com',
        callback: handleCredentialResponse,
        ux_mode: 'popup',
      });

      google.accounts.id.renderButton(
        document.getElementById("google-signin-button"),
        {
          theme: "outline",
          size: "large",
          text: "signup_with",
        }
      );
    };

    const script = document.createElement("script");
    script.src = "https://accounts.google.com/gsi/client";
    script.async = true;
    script.defer = true;
    script.onload = initializeGoogleSignIn;
    document.body.appendChild(script);
  }, []);

  const handleCredentialResponse = (response) => {
    const token = response.credential;

    // Optionally decode to get user info
    const user = jwt_decode(token);
    console.log("User Info from JWT:", user);

    // Send token to backend
    fetch('/api/google-signup', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ token })
    })
      .then(res => res.json())
      .then(data => {
        console.log("Signup success:", data);
        // Redirect or update state here
      })
      .catch(err => {
        console.error("Signup error:", err);
      });
  };

  return (
    <div>
      <h2>Signup with Google</h2>
      <div id="google-signin-button"></div>
    </div>
  );
};

export default GoogleSignup;
