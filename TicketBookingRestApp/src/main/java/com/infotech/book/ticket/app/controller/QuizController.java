package com.infotech.book.ticket.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.book.ticket.app.entities.User;
import com.infotech.book.ticket.app.service.UserService;

@RestController
@RequestMapping(value = "/api/quiz")
public class QuizController {

	/*
	 * @Autowired private TicketBookingService ticketBookingService;
	 */

	@Autowired
	private UserService userService;

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

}
