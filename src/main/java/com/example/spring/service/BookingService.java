package com.example.spring.service;

import com.example.spring.dao.EventDAO;
import com.example.spring.dao.UserDAO;
import com.example.spring.facade.BookingFacade;
import com.example.spring.model.DTO.Event;
import com.example.spring.model.DTO.User;
import com.example.spring.model.EventI;
import com.example.spring.model.TicketI;
import com.example.spring.model.UserI;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BookingService implements BookingFacade {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public Event getEventById(long eventId) {
        EventDAO eventDAO = eventService.getEventById(eventId);
        return mapper.map(eventDAO, Event.class);
    }

    @Override
    public List<EventI> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<EventI> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public Event createEvent(Event event) {
        EventDAO eventToCreate = eventService.createEvent(event);
        log.info("Creating Event:" + eventToCreate);
        return mapper.map(eventToCreate, Event.class);
    }

    @Override
    public Event updateEvent(Event event) {
        EventDAO eventUpdated = eventService.updateEvent(event);
        log.info("Updating Event:" + eventUpdated.getId());
        return mapper.map(eventUpdated, Event.class);
    }

    @Override
    public void deleteEvent(long eventId) {
        log.info("Deleting Event:" + eventId);
        eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        UserDAO userDAO = userService.getUserById(userId);
        return mapper.map(userDAO, User.class);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public User createUser(User user) {
        UserDAO userToSaved = userService.createUser(user);
        log.info("Creating User:" + user.getId());
        return mapper.map(userToSaved, User.class);
    }

    @Override
    public User updateUser(User user) {
        UserDAO userUpdated = userService.updateUser(user);
        log.info("Updating User:" + userUpdated.getId());
        return mapper.map(userUpdated, User.class);
    }

    @Override
    public void deleteUser(long userId) {
        log.info("Deleting User:" + userId);
        userService.deleteUser(userId);
    }

    @Override
    public TicketI bookTicket(long userId, long eventId, int place, TicketI.Category category) {
        return null;
    }

    @Override
    public List<TicketI> getBookedTickets(UserI user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<TicketI> getBookedTickets(EventI event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return false;
    }
}