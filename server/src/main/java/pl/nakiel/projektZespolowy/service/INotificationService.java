package pl.nakiel.projektZespolowy.service;

import pl.nakiel.projektZespolowy.domain.events.Event;
import pl.nakiel.projektZespolowy.domain.security.User;

public interface INotificationService {
    void addNotification(Event event, User user, String content);
}
