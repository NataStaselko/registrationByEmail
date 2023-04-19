package com.staselko.registrationByEmail.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TOKENS")
public class VerificationToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOKEN")
    private String token = UUID.randomUUID().toString();

    @Column(name = "EXPIRY_DATE")
    private LocalDateTime expiryDate = createTime();

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private LocalDateTime createTime(){
        LocalDateTime date = LocalDateTime.now();
        return date.plusHours(24).withNano(0);
    }

}
