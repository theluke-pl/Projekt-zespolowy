package pl.nakiel.projektZespolowy.service;

import pl.nakiel.projektZespolowy.resources.dto.common.CommentDTO;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;
import pl.nakiel.projektZespolowy.resources.dto.common.ImageDTO;

import java.util.List;

public interface IEventService {
    EventDTO addEvent(EventDTO eventDTO);

    void followEvent(Long eventId);

    void addComment(Long eventId, CommentDTO commentDTO);

    void removeComment(CommentDTO commentDTO) throws Exception;

    EventDTO getEvent(Long eventId);

    List<EventDTO> getAllEvents();

    void addImage(Long eventId, ImageDTO image);

    void removeImage(ImageDTO image);
}
