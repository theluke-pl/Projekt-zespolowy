package pl.nakiel.projektZespolowy.domain.geo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="LOCALIZATIONS")
public class Localization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    //lokalizacja
    @Column(name="LONGITUDE")
    private Double longitude;

    @Column(name="LATITUDE")
    private Double latitude;

}
