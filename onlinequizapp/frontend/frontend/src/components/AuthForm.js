// import React from 'react';
// import { Link } from 'react-router-dom';

// function AuthForm({ type }) {
//   const isLogin = type === 'login';

//   return (
//     <div className="auth-container">
//       <div className="auth-left">
//         <h2>{isLogin ? 'Log In' : 'Sign Up'}</h2>
//         <form onSubmit={this.handleSubmit}>

//           <label htnlFor="username">Username</label>
//           <input type="text" value={this.state.username} id="username" name="username" onChannge={this.handleChange}/> <br/>
          
        
//         <label htmlFor="email">Email</label>
//           <input type="email" value={this.state.email} id="email" name="email" onChange={this.handleChange} placeholder="Your email" required /> <br/>

//         <label htmlFor="password">Password</label>
//           <input type="password" value={this.state.password} id="password" name="password" onChange={this.handleChange} placeholder="Password" required /> <br/>

//           {!isLogin && <input type="password" placeholder="Repeat Password" required />}
//           <button type="submit">{isLogin ? 'Log In' : 'Sign Up'}</button>
//         </form>
//         {isLogin ? (
//           <>
//             <p><a href="#">Forgot password?</a></p>
//             <div className="auth-alt">
//               <button className="google">Google</button>
//               <button className="facebook">Facebook</button>
//             </div>
//             <p>Don't have an account? <Link to="/signup">Sign Up</Link></p>
//           </>
//         ) : (
//           <>
//             <div className="auth-alt">
//               <button className="google">Google</button>
//               <button className="facebook">Facebook</button>
//             </div>
//             <p>Already have an account? <Link to="/">Log In</Link></p>
//           </>
//         )}
//       </div>

//       <div className="auth-right">
//         <div className="quote">
//           {isLogin ? (
//             <>
//               <p>
//                 The future belongs to those who <strong>believe</strong> in the
//                 <strong> beauty of their dreams.</strong>
//               </p>
//               <span>– Eleanor Roosevelt</span>
//             </>
//           ) : (
//             <>
//               <p>
//                 The only way to <strong>do great work</strong> is to
//                 <strong> love what you do.</strong>
//               </p>
//               <span>– Steve Jobs</span>
//             </>
//           )}
//         </div>
//       </div>
//     </div>
//   );
// }

// export default AuthForm;



import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class AuthForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      email: '',
      password: '',
      repeatPassword: '',
    };
  }

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    const { username, email, password, repeatPassword } = this.state;
    const { type } = this.props;

    if (type !== 'login' && password !== repeatPassword) {
      alert("Passwords do not match");
      return;
    }

    // Handle form submission logic
    console.log("Submitted:", { username, email, password });
  }

  render() {
    const { type } = this.props;
    const isLogin = type === 'login';
    const { username, email, password, repeatPassword } = this.state;

    return (
      <div className="auth-container">
        <div className="auth-left">
          <h2>{isLogin ? 'Log In' : 'Sign Up'}</h2>
          <form onSubmit={this.handleSubmit}>

            <label htmlFor="username">Username</label>
            <input
              type="username"
              value={username}
              id="username"
              name="username"
              onChange={this.handleChange}
              required
            /> <br />

            <label htmlFor="email">Email</label>
            <input
              type="email"
              value={email}
              id="email"
              name="email"
              onChange={this.handleChange}
              placeholder="Your email"
              required
            /> <br />

            <label htmlFor="password">Password</label>
            <input
              type="password"
              value={password}
              id="password"
              name="password"
              onChange={this.handleChange}
              placeholder="Password"
              required
            /> <br />

            {!isLogin && (
              <>
                <label htmlFor="repeatPassword">Repeat Password</label>
                <input
                  type="password"
                  value={repeatPassword}
                  id="repeatPassword"
                  name="repeatPassword"
                  onChange={this.handleChange}
                  placeholder="Repeat Password"
                  required
                /> <br />
              </>
            )}

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
}

export default AuthForm;
