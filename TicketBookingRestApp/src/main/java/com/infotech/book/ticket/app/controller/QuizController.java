package com.infotech.book.ticket.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infotech.book.dao.UploadResult;
import com.infotech.book.ticket.app.dao.QuestionRepository;
import com.infotech.book.ticket.app.entities.Questions;
import com.infotech.book.ticket.app.entities.Quiz;
import com.infotech.book.ticket.app.entities.User;
import com.infotech.book.ticket.app.response.LoginResponse;
import com.infotech.book.ticket.app.service.QuestionService;
import com.infotech.book.ticket.app.service.QuizServiceImpl;
import com.infotech.book.ticket.app.service.UserService;
import com.infotech.book.ticket.request.LoginRequest;

@RestController
@RequestMapping(value = "/api/quiz")
@CrossOrigin("http://localhost:8080")
public class QuizController {

	/*
	 * @Autowired private TicketBookingService ticketBookingService;
	 */

	@Autowired
	private UserService userService;

	@Autowired
	private QuizServiceImpl quizServiceImpl;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionRepository questionRepository;

	/*
	 * @CrossOrigin
	 * 
	 * @PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,
	 * produces=MediaType.APPLICATION_JSON_VALUE) public Ticket
	 * createTicket(@RequestBody Ticket ticket){ return
	 * ticketBookingService.createTicket(ticket); }
	 */

	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping(value="/ticketId/{ticketId}",produces=MediaType.
	 * APPLICATION_JSON_VALUE) public Ticket
	 * getTicketById(@PathVariable("ticketId")Integer ticketId){ return
	 * ticketBookingService.getTicketById(ticketId); }
	 */

	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping(value="/alltickets",produces=MediaType.APPLICATION_JSON_VALUE)
	 * public Iterable<Ticket> getAllBookedTickets(){ return
	 * ticketBookingService.getAllBookedTickets(); }
	 */

	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping(value="/email/{email:.+}",produces=MediaType.
	 * APPLICATION_JSON_VALUE) public Ticket
	 * getTicketByEmail(@PathVariable("email")String email){ return
	 * ticketBookingService.getTicketByEmail(email); }
	 */

	/*
	 * @CrossOrigin
	 * 
	 * @DeleteMapping(value="/ticketId/{ticketId}") public void
	 * deleteTicket(@PathVariable("ticketId")Integer ticketId){
	 * ticketBookingService.deleteTicket(ticketId); }
	 */

	/*
	 * @CrossOrigin
	 * 
	 * @PutMapping(value="/ticketId/{ticketId}/email/{newEmail:.+}",produces=
	 * MediaType.APPLICATION_JSON_VALUE) public Ticket
	 * updateTicket(@PathVariable("ticketId")Integer
	 * ticketId,@PathVariable("newEmail")String newEmail){ return
	 * ticketBookingService.updateTicket(ticketId,newEmail); }
	 */

	@CrossOrigin
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	@CrossOrigin
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = userService.authenticateUser(loginRequest);
		if (loginResponse.isAuthenticated()) {
			return ResponseEntity.ok(loginResponse);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
		}

	}

	@CrossOrigin
	@PostMapping("/bulk-upload")
	public ResponseEntity<UploadResult> uploadQuiz(@RequestParam("file") MultipartFile file) {
		UploadResult result = quizServiceImpl.uploadQuizFromCSV(file);
		return ResponseEntity.ok(result);
	}

	@CrossOrigin
	@GetMapping(value = "/getAllQuiz", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Quiz>> getAllQuizzes() {
		List<Quiz> quizzes = quizServiceImpl.getAllQuizzes();
		return ResponseEntity.ok(quizzes);
	}

	@PutMapping(value = "/questions/{id}/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Questions> updateQuestion(@PathVariable Long id, @RequestBody Questions questionDetails) {
		Questions updatedQuestion = questionService.updateQuestion(id, questionDetails);
		return ResponseEntity.ok(updatedQuestion);
	}

	@DeleteMapping("/questions/{id}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
		if (!questionRepository.exists(id)) {
			return ResponseEntity.notFound().build(); // 404 if not found
		}

		questionRepository.delete(id);
		return ResponseEntity.noContent().build(); // 204 No Content
	}
}
