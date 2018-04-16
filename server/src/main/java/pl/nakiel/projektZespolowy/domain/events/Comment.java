package pl.nakiel.projektZespolowy.domain.events;


import lombok.Data;
import pl.nakiel.projektZespolowy.domain.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name="COMMENTS")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="COMMENT")
    private String comment;

    @Column(name="DATE")
    private Date date;

    //relacja komentarz - user(autor) : usunięcie komentarza nie wpływa na uzytkownika
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="AUTHOR_USER_ID")
    private User commentsAuthor;

    //relacja komentarz - event : usunięcie komentarza nie wpływa na event
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="EVENT_ID")
    private Event commentsEvent;

}
