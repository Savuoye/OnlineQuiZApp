import React from 'react';
import { Link } from 'react-router-dom';

function AuthForm({ type }) {
  const isLogin = type === 'login';

  return (
    <div className="auth-container">
      <div className="auth-left">
        <h2>{isLogin ? 'Log In' : 'Sign Up'}</h2>
        <form>
          <input type="email" placeholder="Your email" required />
          <input type="password" placeholder="Password" required />
          {!isLogin && <input type="password" placeholder="Repeat Password" required />}
          <button type="submit">{isLogin ? 'Log In' : 'Sign Up'}</button>
        </form>
        {isLogin ? (
          <>
            <p><a href="#">Forgot password?</a></p>
            <div className="auth-alt">
              <button className="google">Google</button>
              <button className="facebook">Facebook</button>
            </div>
            <p>Don't have an account? <Link to="/signup">Sign Up</Link></p>
          </>
        ) : (
          <>
            <div className="auth-alt">
              <button className="google">Google</button>
              <button className="facebook">Facebook</button>
            </div>
            <p>Already have an account? <Link to="/">Log In</Link></p>
          </>
        )}
      </div>

      <div className="auth-right">
        <div className="quote">
          {isLogin ? (
            <>
              <p>
                The future belongs to those who <strong>believe</strong> in the
                <strong> beauty of their dreams.</strong>
              </p>
              <span>– Eleanor Roosevelt</span>
            </>
          ) : (
            <>
              <p>
                The only way to <strong>do great work</strong> is to
                <strong> love what you do.</strong>
              </p>
              <span>– Steve Jobs</span>
            </>
          )}
        </div>
      </div>
    </div>
  );
}

export default AuthForm;
