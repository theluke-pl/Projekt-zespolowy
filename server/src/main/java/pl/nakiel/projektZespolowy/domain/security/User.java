package pl.nakiel.projektZespolowy.domain.security;


import lombok.Data;
import pl.nakiel.projektZespolowy.domain.geo.Localization;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="USERS")
public class User implements Serializable {

    public static final int TO_ACTIVATION_STD = 1;
    public static final int TO_ACTIVATION_FB = 2;
    public static final int ACTIVE_STD = 3;
    public static final int ACTIVE_FB = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMAIL")
    private String email;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="SECOND_NAME")
    private String secondName;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    /**
     * 1 - do aktywacji standardowo
     * 2 - do aktywacji facebook
     * 3 - aktywne - standardowo
     * 4 - aktywne - facebook
     */
    @Column(name="STATUS")
    private Integer status;

    @Column(name="FACEBOOK_ID")
    private String facebookId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="LOCALIZATION_ID")
    private Localization localization;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") }
    )
    private List<Role> roles = new ArrayList<>();
}
