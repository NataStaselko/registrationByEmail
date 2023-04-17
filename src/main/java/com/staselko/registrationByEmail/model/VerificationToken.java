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

    @Column(name = "DATE")
    private LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(1440l).withNano(0);

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

}
