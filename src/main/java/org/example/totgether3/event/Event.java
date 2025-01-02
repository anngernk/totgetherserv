package org.example.totgether3.event;

import jakarta.persistence.*;
import lombok.*;
import org.example.totgether3.user.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Event {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Integer room;

    @Column(nullable = false)
    private String reason;

    @ManyToOne
    private User user;

}
