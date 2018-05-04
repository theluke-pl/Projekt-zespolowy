package pl.nakiel.projektZespolowy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.events.Comment;
import pl.nakiel.projektZespolowy.domain.events.Event;
import pl.nakiel.projektZespolowy.domain.geo.Localization;
import pl.nakiel.projektZespolowy.repository.EventRepository;
import pl.nakiel.projektZespolowy.repository.LocalizationRepository;
import pl.nakiel.projektZespolowy.resources.dto.common.CommentDTO;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;
import pl.nakiel.projektZespolowy.security.SecurityService;
import pl.nakiel.projektZespolowy.service.admin.UserService;
import pl.nakiel.projektZespolowy.utils.converter.EventEventDTOConverter;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService implements IEventService{

    @Autowired
    private LocalizationRepository localizationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private EventEventDTOConverter eventEventDTOConverter;

    @Override
    public EventDTO addEvent(EventDTO eventDTO){
        Event event = new Event();
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        try {
            event.setDate(eventDTO.getSubmissionDateConverted());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Localization localization = new Localization();
        localization.setLatitude(eventDTO.getLocalization().getLatitude());
        localization.setLongitude(event.getLocalization().getLongitude());
        localization = localizationRepository.save(localization);
        event.setLocalization(localization);
        event.setType(eventDTO.getType());
        event.setViews(new Long(0));
        event.setActive(true);
        event.setEventsAuthor(securityService.getCurrentUser());
        event.getFollowingUsers().add(securityService.getCurrentUser());
        event = eventRepository.save(event);
        return eventEventDTOConverter.toEventDTO(event);
    }

    @Override
    public void followEvent(Long eventId){
        Event event = eventRepository.getOne(eventId);
        if(!event.getFollowingUsers().contains(securityService.getCurrentUser()))
            event.getFollowingUsers().add(securityService.getCurrentUser());
        eventRepository.save(event);
    }

    @Override
    public void addComment(Long eventId, CommentDTO commentDTO){
        Event event = eventRepository.getOne(eventId);
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        comment.setCommentsAuthor(userService.getUserById(commentDTO.getUser().getId()));
        comment.setCommentsEvent(eventRepository.getOne(eventId));
        eventRepository.save(event);
    }

    @Override
    public EventDTO getEvent(Long eventId){
        Event event = eventRepository.getOne(eventId);
        return eventEventDTOConverter.toEventDTO(event);
    }
    @Override
    public List<EventDTO> getAllEvents(){
        return eventRepository
                .findOneByActive(true)
                .stream()
                .map(e->eventEventDTOConverter.toEventDTO(e))
                .collect(Collectors.toList());
    }
}