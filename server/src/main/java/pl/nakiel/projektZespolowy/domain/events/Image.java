package pl.nakiel.projektZespolowy.domain.events;

import lombok.Data;
import pl.nakiel.projektZespolowy.domain.security.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name="IMAGES")
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="URL", nullable = false, unique = false)
    private String url;

    //relacja image - event : usunięcie zdjęcia nie usuwa eventu
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="EVENT_ID")
    private Event imagesEvent;

}
