package pl.nakiel.projektZespolowy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.events.Event;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.domain.users.Notification;
import pl.nakiel.projektZespolowy.repository.NotificationRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void addNotification(Event event, User user, String content){
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setEvent(event);
        notification.setRead(Boolean.FALSE);
        notification.setUser(user);
    }
}
