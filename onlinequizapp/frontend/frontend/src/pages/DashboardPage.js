// import React from "react";
// import "./Dashboard.css";
// import { FaTachometerAlt, FaQuestionCircle, FaUser, FaCog, FaEnvelope, FaBook, FaChalkboardTeacher, FaLock, FaRedo } from "react-icons/fa";
// import { Doughnut } from "react-chartjs-2";

// const Dashboard = () => {
//   const donutData = {
//     labels: ["Completed", "In Progress", "Scores over 90%"],
//     datasets: [
//       {
//         data: [375, 375, 375],
//         backgroundColor: ["#3f51b5", "#ccc", "#f5c542"],
//       },
//     ],
//   };

//   const donutOptions = {
//     cutout: "70%",
//     plugins: {
//       legend: {
//         display: true,
//         position: "bottom",
//       },
//     },
//   };

//   return (
//     <div className="dashboard-container">
//       {/* Sidebar */}
//       <aside className="sidebar">
//         <h2 className="logo">EduBridge<br />Classroom</h2>
//         <nav>
//           <ul>
//             <li><FaTachometerAlt /> Dashboard</li>
//             <li><FaQuestionCircle /> Generate quiz</li>
//             <li><FaBook /> My quizzes</li>
//             <li>About Us</li>
//             <li><FaEnvelope /> Contact Us</li>
//             <li>FAQ's</li>
//             <li><FaChalkboardTeacher /> 1:1 tutoring</li>
//             <li><FaCog /> Settings</li>
//           </ul>
//         </nav>
//         <div className="user-profile">
//           <img src="https://via.placeholder.com/40" alt="User" />
//           <span>James Smith</span>
//         </div>
//       </aside>

//       {/* Main Content */}
//       <main>
//         {/* Top Stats */}
//         <div className="stats-cards">
//           <div className="stat-card">In progress quizzes <h3>28</h3><p>Last 7 days</p></div>
//           <div className="stat-card">Completed quizzes <h3>78</h3><p>Last 7 days</p></div>
//           <div className="stat-card">Completed quiz rate <h3>98%</h3><p>Last 7 days</p></div>
//           <div className="stat-card">Scores over 90% <h3>82%</h3><p>Last 7 days</p></div>
//         </div>

//         {/* Progress Section */}
//         <div className="progress-section">
//           <div className="milestone-card">
//             <h1>50</h1>
//             <p>Quizzes completed</p>
//             <p className="desc">Exceptional milestone! Congratulations on achieving this milestone</p>
//           </div>

//           {/* Donut Chart */}
//           <div className="donut-chart">
//             <h3>Overall quiz performance</h3>
//             <Doughnut data={donutData} options={donutOptions} />
//             <p>Total quizzes: 1500</p>
//           </div>
//         </div>

//         {/* Quiz History */}
//         <div className="quiz-history">
//           <h3>Quiz history</h3>
//           <table>
//             <thead>
//               <tr>
//                 <th>Subject</th>
//                 <th>Score</th>
//                 <th>Status</th>
//                 <th>Actions</th>
//               </tr>
//             </thead>
//             <tbody>
//               <tr>
//                 <td>English</td>
//                 <td>10/15</td>
//                 <td className="completed">Completed</td>
//                 <td><FaRedo /> <FaLock /></td>
//               </tr>
//               <tr>
//                 <td>English</td>
//                 <td>-</td>
//                 <td className="unattempted">Unattempted</td>
//                 <td><FaRedo /> <FaLock /></td>
//               </tr>
//             </tbody>
//           </table>
//         </div>

//         {/* Recommendation */}
//         <div className="recommend-card">
//           <h2>5/15</h2>
//           <p>Computer Science</p>
//           <p>Keep practising! Improve your confidence in Computer Science by practicing another quiz</p>
//           <button>New quiz</button>
//         </div>
//       </main>
//     </div>
//   );
// };

// export default Dashboard;
