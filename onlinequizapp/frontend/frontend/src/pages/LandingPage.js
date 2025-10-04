import React from "react";
import "../css/LandingPage.css";
import { useNavigate } from "react-router-dom";

function LandingPage() {


  const navigate = useNavigate();

  const handleLogin=()=>{
    navigate("/login")
  }

  const handleSignUp=()=>{
    navigate("/signup")
  }

  const handleCreateQuizPage=()=>{
    navigate("/createquizpage")
  }

  return (
    <div className="landing-container">

      {/* Navbar */}
      <nav className="navbar">
        <div className="logo">LOGO</div>
        <ul className="nav-links">
          <li>Home</li>
          <li>Quizzes</li>
          <li>Contact</li>
          <li>Learn & Support</li>
        </ul>
        <div className="nav-buttons">
          <button className="btn login" onClick={handleLogin}>Log In</button>
          
          <button className="btn signup" onClick={handleSignUp}>Sign Up</button>
        </div>
      </nav>

      {/* Hero Section */}
      <section className="hero">
        <div className="hero-text">
          <h2>
            <span className="highlight">Assemble</span> Your Dream Tech Squad
          </h2>
          <p>From Backend Gurus to AI Whisperers engage your audience with live challenges, polls, and quizzes.</p>
        </div>
        <div className="hero-buttons">
          <button className="btn purple">Join Quiz
            <br/>
            Have a code? Jump in!
          </button>
          <button className="btn blue" onClick={handleCreateQuizPage}>Create Quiz
            <br/>
            Got questions? Start your quiz now!
          </button>
        </div>
      </section>

      {/* See How It Works */}
      <section className="see-how">
        <h3>See How It Works</h3>
        <p>A quick tour of our platform from creating your first quiz to celebrating your win.</p>
        <div className="video-placeholder">▶ Watch Now</div>
      </section>

      {/* How It Works */}
      <section className="how-it-works">
        <h3>How It Works</h3>
        <div className="steps">
          <div className="step">
            <img src="\images\How it works 1.jpg" width={100} height={100}/>
            <h4>1. Create & Join</h4>
            <p>Instantly via code, short link, or QR.</p>
          </div>
          <div className="step">
            <img src="\images\How it works 2.jpg" width={100} height={100}/>
            <h4>2. Engage in Real Time</h4>
            <p>Play with dynamic questions, including images, videos.</p>
          </div>
          <div className="step">
            <img src="\images\How it works 3.jpg" width={100} height={100}/>
            <h4>3. Celebrate Results</h4>
            <p>Leaderboard, badges, and notifications.</p>
          </div>
        </div>
      </section>

      {/* Why Choose Us */}
      <section className="why-choose">
        <h3>Why Choose Us?</h3>
        <div className="features">
           
          <div  className="feature">
           <img src="\images\Instant Access.jpg" width={100} height={100}/> 
            <h4>Instant Access</h4>
            </div>
          <div className="feature">
            <img src="\images\Rich Questions Format.jpg" width={100} height={100}/> 
            <h4>Rich Question Formats</h4>
            </div>
          <div className="feature">
            <img src="\images\Realtime Leaderboard.jpg" width={100} height={100}/>
            <h4>Real-Time Leaderboards</h4>
            </div>
          <div className="feature">
            <img src="\images\Reliable & Secure.jpg" width={100} height={100}/>
            <h4>Reliable & Secure</h4>
            </div>
        </div>
      </section>

      {/* Community & Events */}
      <section className="community">
        <h3>Community & Events</h3>
        <p>
            Join a vibrant community of learners and innovators.<br/>
             Take part in events, challenges, and discussions that not only sharpen your skills but also help you network with like-minded people.<br/>
            Stay updated with the latest happenings and never miss an opportunity to showcase your talent.
        </p>
        <div className="community-cards">
          <div className="card">Community <br/>
          <img src="\images\Community.jpg" width={100} height={100}/>
          <br/>
          <button>Explore more →</button>
          </div>
          
          
         <div className="card">Events <br/>
          <img src="\images\Events.jpg" width={100} height={100}/>
          <br/>
          <button>Explore more →</button>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="footer">
        <div className="footer-top">
          <div className="footer-logo">Logo</div>
          <div className="footer-newsletter">
            <h4>Join Our Newsletter</h4>
            <input type="email" placeholder="Enter your email" />
            <button className="btn subscribe">Subscribe</button>
          </div>
        </div>
        <div className="footer-links">
          <div>
            <h5>Product</h5>
            <p>Features</p>
            <p>About</p>
            <p>Case Studies</p>
          </div>
          <div>
            <h5>Company</h5>
            <p>About us</p>
            <p>Careers</p>
            <p>Blog</p>
          </div>
          <div>
            <h5>Support</h5>
            <p>Help center</p>
            <p>Terms</p>
            <p>Chat support</p>
          </div>
          <div>
            <h5>Contact us</h5>
            <p>contact@company.com</p>
            <p>+91 12345 67890</p>
          </div>
        </div>
        <div className="footer-bottom">
          <p>© 2025 Quiz App | All Rights Reserved | Terms and Conditions | Privacy Policy</p>
        </div>
      </footer>

    </div>
  );
}

export default LandingPage;
