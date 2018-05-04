package pl.nakiel.projektZespolowy.service;

import pl.nakiel.projektZespolowy.resources.dto.common.CommentDTO;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;

import java.util.List;

public interface IEventService {
    EventDTO addEvent(EventDTO eventDTO);

    void followEvent(Long eventId);

    void addComment(Long eventId, CommentDTO commentDTO);

    EventDTO getEvent(Long eventId);

    List<EventDTO> getAllEvents();
}
