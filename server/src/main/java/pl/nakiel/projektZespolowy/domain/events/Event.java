package pl.nakiel.projektZespolowy.domain.events;


import lombok.Data;
import pl.nakiel.projektZespolowy.domain.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name="EVENTS")
public class Event implements Serializable {

    public static final int WANTED = 1;
    public static final int FOUND = 2;
    public static final int OTHER = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="TITLE", nullable = false, unique = false)
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="DATE")
    private Date date;    //jak przetrzymywać najlepiej datę i godzinę?

    //lokalizacja
    @Column(name="LONGITUDE")
    private Double longitude;

    @Column(name="LATITUDE")
    private Double latitude;

    /**
     * 1 - poszukiwanie
     * 2 - znalezienie
     * 3 - inne
     */
    @Column(name="TYPE")
    private Integer type;

    @Column(name="VIEWS")
    private Long views;

    //relacja event - user(autor) : usunięcie eventu usuwa relację nie usuwając użytkowników
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="AUTHOR_USER_ID")
    private User eventsAuthor;

    //relacja event - user(obserwujący) : usunięcie eventu usuwa relację nie usuwając użytkowników
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "FOLLOWING_USERS",
            joinColumns = { @JoinColumn(name = "EVENT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") }
    )
    private List<User> followingUsers = new ArrayList<>();

    //relacja event - komentarz : usunięcie eventu usuwa wszystkie komentarze
    @OneToMany(mappedBy = "commentsEvent",cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private List<Comment> eventsComments = new ArrayList<>();

    //relacja event - image : usunięcie eventu usuwa wszystkie zdjęcia
    @OneToMany(mappedBy = "imagesEvent",cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private List<Image> eventsImages = new ArrayList<>();
}
