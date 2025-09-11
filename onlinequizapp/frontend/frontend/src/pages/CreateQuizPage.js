import React, { useState } from "react";
import "../css/CreateQuizPage.css";
import { useNavigate } from "react-router-dom";

export default function CreateQuiz() {
  const [formData, setFormData] = useState({
    quizName: "",
    quizURL: "",
    startDate: "",
    startTime: "",
    endDate: "",
    endTime: "",
    timeZone: "",
    quizMode: "",
    description: "",
    rules: "",
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

   const handleQuizQuestion=()=>{
    navigate("/quizquestions")
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    alert("Quiz Created!");
  };

  return (
    <div className="create-quiz-container">
      <nav className="top-nav">
        <div className="logo">LOGO</div>
        <div className="nav-links">
          <a href="/">Home</a>
          <a href="/">Quizzes</a>
          <a href="/">Contact</a>
          <a href="/">Learn & Support</a>
          {/* <img
            className="profile-img"
            src="https://via.placeholder.com/30"
            alt="profile"
          /> */}
        </div>
      </nav>

      <div className="breadcrumb">Home &gt; Create Quiz</div>

      <div className="form-card">
        <h2>Create Quiz</h2>
        {/* <div className="quiz-image">
          <img
            src="https://cdn-icons-png.flaticon.com/512/2718/2718226.png"
            alt="quiz"
          />
          <p>Quiz Image</p>
        </div> */}

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="quizName"
            placeholder="Quiz Name *"
            value={formData.quizName}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="quizURL"
            placeholder="Quiz URL *"
            value={formData.quizURL}
            onChange={handleChange}
            required
          />

          <div className="row">
            <input
              type="date"
              name="startDate"
              placeholder="Start Date *"
              value={formData.startDate}
              onChange={handleChange}
              required
            />
            <input
              type="time"
              name="startTime"
              placeholder="Start Time *"
              value={formData.startTime}
              onChange={handleChange}
              required
            />
          </div>

          <div className="row">
            <input
              type="date"
              name="endDate"
              placeholder="End Date *"
              value={formData.endDate}
              onChange={handleChange}
              required
            />
            <input
              type="time"
              name="endTime"
              placeholder="End Time *"
              value={formData.endTime}
              onChange={handleChange}
              required
            />
          </div>

          <select
  name="timeZone"
  value={formData.timeZone}
  onChange={handleChange}
  className="timezone-select"
>
  <option value="" disabled>
    Time Zone *
  </option>
  <option value="UTC">UTC</option>
  <option value="GMT">GMT</option>
  <option value="EST">EST (Eastern Standard Time)</option>
  <option value="CST">CST (Central Standard Time)</option>
  <option value="MST">MST (Mountain Standard Time)</option>
  <option value="PST">PST (Pacific Standard Time)</option>
  <option value="IST">IST (Indian Standard Time)</option>
  <option value="CET">CET (Central European Time)</option>
  <option value="EET">EET (Eastern European Time)</option>
  <option value="JST">JST (Japan Standard Time)</option>
  <option value="AEST">AEST (Australian Eastern Standard Time)</option>
</select>
          {/* <input
            type="text"
            name="quizMode"
            placeholder="Quiz Mode"
            value={formData.quizMode}
            onChange={handleChange}
          /> */}

          <select
  name="quizMode"
  value={formData.quizMode}
  onChange={handleChange}
  className="timezone-select"
>
  <option value="" disabled>
    Quiz Mode *
  </option>
  <option value="PUBLIC">Public</option>
  <option value="PRIVATE">Private</option>
  
</select>

          <label>Quiz Description</label>
          <textarea
            name="description"
            value={formData.description}
            onChange={handleChange}
            rows="4"
             defaultValue={`Hey there!
We’re thrilled to have you join the quiz!
Remember, the faster you answer and the more questions you get right, the better your chances of climbing to the top of the leaderboard. So stay sharp, think fast, and give it your best shot—good luck!`}
          />

           
        <div className="rules-section">
          <h4>Rules:</h4>
          <ul>
            <li>Participation is completely free and open to all individuals aged 18 years and above.</li>
            <li>Creating multiple accounts on QuizHub using duplicate or invalid names, phone numbers, or email IDs will result in disqualification or account suspension.</li>
            <li>The organizer’s decision is final and binding in case of any disputes.</li>
          </ul>

          <h4>Guidelines:</h4>
          <ul>
            <li>Each participant is allowed to attempt the quiz only once.</li>
            <li>By registering for a tournament, you are automatically enrolled in all quizzes within that tournament.</li>
          </ul>

          <h4>Tips:</h4>
          <ul>
            <li>Your leaderboard score is determined by the number of correct answers you give. Aim to answer as many questions correctly as possible to top the chart.</li>
            <li>There is no negative marking for incorrect answers. If you’re unsure, take a guess—it might work in your favor!</li>
            <li>In case of a tie in scores, participants will be ranked by the least time taken to answer. So try to answer both accurately and quickly.</li>
          </ul>
          </div>

          <div className="button-group">
            <button type="button" className="cancel-btn">
              Cancel
            </button>
            <button onClick={handleQuizQuestion} type="submit" className="create-btn">
              Create
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
