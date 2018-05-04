package pl.nakiel.projektZespolowy.domain.users;

import lombok.Data;
import pl.nakiel.projektZespolowy.domain.events.Event;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="NOTIFICATIONS")
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="EVENT_ID")
    private Event event;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private Event user;

    @Column(name="CONTENT")
    private String content;
}
