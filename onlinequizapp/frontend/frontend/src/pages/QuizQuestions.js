import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";
import "../css/QuizQuestions.css";

function QuizQuestions() {
  const fileInputRef = useRef(null);
  const navigate = useNavigate();

  // Handle bulk upload file selection
  const handleBulkUploadClick = () => {
    fileInputRef.current.click(); // trigger hidden input
  };

  const handleFileChange = (event) => {
    const file = event.target.files[0];
    if (file) {
      alert(`Uploaded file: ${file.name}`);
      // You can handle the file upload logic here
    }
  };

  // Handle download format
  const handleDownloadFormat = () => {
    const link = document.createElement("a");
    link.href = "/sample-format.csv"; // put your file path here (public folder)
    link.download = "quiz-format.csv";
    link.click();
  };

  // Navigate to Add Question form
  const handleAddQuestion = () => {
    navigate("/add-question"); // define this route in App.js
  };

  return (
    <div className="quiz-container">
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
      <div className="quiz-form-card">
      <h2>Quiz Questions</h2>

      <div className="button-group">
        <button className="btn btn-upload" onClick={handleBulkUploadClick}>
          📂 Bulk Upload Questions
        </button>

        <input
          type="file"
          ref={fileInputRef}
          style={{ display: "none" }}
          onChange={handleFileChange}
          accept=".csv,.xlsx,.xls"
        />

        <button className="btn btn-download" onClick={handleDownloadFormat}>
          ⬇️ Download Format
        </button>

        <button className="btn btn-add" onClick={handleAddQuestion}>
          ➕ Add Questions
        </button>
      </div>

      <p className="info-text">
        No questions available. Click 'Add Questions' to create your first one.
      </p>
      </div>
    </div>
  );
}

export default QuizQuestions;
