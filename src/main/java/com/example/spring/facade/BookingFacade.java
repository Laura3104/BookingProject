package com.example.spring.facade;

import java.sql.Date;
import java.util.List;

import com.example.spring.model.dto.Category;
import com.example.spring.model.dto.Event;
import com.example.spring.model.dto.Ticket;
import com.example.spring.model.dto.User;
import com.example.spring.model.dto.UserAccount;

/** Groups together all operations related to tickets booking. Created by maksym_govorischev. */
public interface BookingFacade {

  /**
   * Gets event by its id.
   *
   * @return Event.
   */
  Event getEventById(long eventId);

  /**
   * Get list of events by matching title. Title is matched using 'contains' approach. In case
   * nothing was found, empty list is returned.
   *
   * @param title Event title or it's part.
   * @return List of events.
   */
  List<Event> getEventsByTitle(String title);

  /**
   * Get list of events for specified day. In case nothing was found, empty list is returned.
   *
   * @param day Date object from which day information is extracted.
   * @return List of events.
   */
  List<Event> getEventsForDay(Date day);

  /**
   * Get list of events for specified day. In case nothing was found, empty list is returned.
   *
   * @return List of events.
   */
  List<Event> getEvents();
  /**
   * Creates new event. Event id should be auto-generated.
   *
   * @param event Event data.
   * @return Created Event object.
   */
  Event createEvent(Event event);

  /**
   * Updates event using given data.
   *
   * @param event Event data for update. Should have id set.
   * @return Updated Event object.
   */
  Event updateEvent(Event event);

  /**
   * Deletes event by its id.
   *
   * @param eventId Event id.
   * @return Flag that shows whether event has been deleted.
   */
  void deleteEvent(long eventId);

  /**
   * Gets user by its id.
   *
   * @return User.
   */
  User getUserById(long userId);

  /**
   * Gets user by its email. Email is strictly matched.
   *
   * @return User.
   */
  User getUserByEmail(String email);

  /**
   * Get list of users by matching name. Name is matched using 'contains' approach. In case nothing
   * was found, empty list is returned.
   *
   * @param name Users name or it's part.
   * @return List of users.
   */
  List<User> getUsersByName(String name);

  /**
   * Get list of users. In case nothing was found, empty list is returned.
   *
   * @return List of users.
   */
  List<User> getUsers();

  /**
   * Creates new user. User id should be auto-generated.
   *
   * @param user User data.
   * @return Created User object.
   */
  User createUser(User user);

  /**
   * Updates user using given data.
   *
   * @param user User data for update. Should have id set.
   * @return Updated User object.
   */
  User updateUser(User user);

  /**
   * Deletes user by its id.
   *
   * @param userId User id.
   * @return Flag that shows whether user has been deleted.
   */
  void deleteUser(long userId);

  /**
   * Book ticket for a specified event on behalf of specified user.
   *
   * @param userId User Id.
   * @param eventId Event Id.
   * @param place Place number.
   * @param category Service category.
   * @return Booked ticket object.
   * @throws IllegalStateException if this place has already been booked.
   */
  Ticket bookTicket(long userId, long eventId, int place, Category category);

  /**
   * Get all booked tickets for specified user. Tickets should be sorted by event date in descending
   * order.
   *
   * @param user User
   * @return List of Ticket objects.
   */
  List<Ticket> getBookedTickets(User user);

  /**
   * Get all booked tickets for specified event. Tickets should be sorted in by user email in
   * ascending order.
   *
   * @param event Event
   * @return List of Ticket objects.
   */
  List<Ticket> getBookedTickets(Event event);

  /**
   * Get all booked tickets for specified user. Tickets should be sorted by event date in descending
   * order.
   *
   * @param userId String
   * @return List of Ticket objects.
   */
  List<Ticket> getBookedTicketsByUserId(String userId);

  /**
   * Cancel ticket with a specified id.
   *
   * @param ticketId Ticket id.
   * @return Flag whether anything has been canceled.
   */
  void cancelTicket(long ticketId);

  /**
   * Fill user Account with a specified amount.
   *
   * @param userId User id.
   * @param amount Integer.
   * @return user account object.
   */
  UserAccount fillUserAccount(long userId, Integer amount);

  /**
   * Withdraw money from user Account with a specified amount.
   *
   * @param userId User id.
   * @param amount Integer.
   * @return user account object.
   */
  UserAccount withdrawMoneyUserAccount(long userId, Integer amount);
}
