import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


import SignupPage from './pages/SignupPage';
import LandingPage from './pages/LandingPage';
import LoginPage from './pages/LoginPage';
import CreateQuizPage from './pages/CreateQuizPage';
import QuizQuestions from './pages/QuizQuestions';


import './App.css';
import Dashboard from './pages/DashboardPage';

function App() {
  return (


    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />

        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />
        <Route path="/createquizpage" element={<CreateQuizPage/>}/>
        <Route path="/quizquestions" element={<QuizQuestions/>}/>
        
      </Routes>
    </Router>
  
  );
}

export default App;