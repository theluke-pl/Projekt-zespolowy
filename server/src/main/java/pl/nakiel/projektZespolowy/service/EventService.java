package pl.nakiel.projektZespolowy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.nakiel.projektZespolowy.domain.events.Comment;
import pl.nakiel.projektZespolowy.domain.events.Event;
import pl.nakiel.projektZespolowy.domain.geo.Localization;
import pl.nakiel.projektZespolowy.repository.CommentRepository;
import pl.nakiel.projektZespolowy.repository.EventRepository;
import pl.nakiel.projektZespolowy.repository.LocalizationRepository;
import pl.nakiel.projektZespolowy.resources.dto.common.CommentDTO;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;
import pl.nakiel.projektZespolowy.security.SecurityService;
import pl.nakiel.projektZespolowy.service.admin.UserService;
import pl.nakiel.projektZespolowy.utils.converter.EventEventDTOConverter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventService implements IEventService{

    @Autowired
    private FileService fileService;

    @Autowired
    private LocalizationRepository localizationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CommentRepository commentRepository;

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
        event.setDate(new Date());
        Localization localization = new Localization();
        localization.setLatitude(eventDTO.getLocalization().getLatitude());
        localization.setLongitude(eventDTO.getLocalization().getLongitude());
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
        comment.setDate(new Date());
        comment.setCommentsAuthor(securityService.getCurrentUser());
        comment.setCommentsEvent(eventRepository.getOne(eventId));
        comment = commentRepository.save(comment);
        eventRepository.save(event);
    }

    @Override
    public EventDTO getEvent(Long eventId){
        Event event = eventRepository.getOne(eventId);
        event.setViews(event.getViews()+1);
        event = eventRepository.save(event);
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