package se331.lab_new.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Organizer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    //the events that organizer organize

    //1 organizer can have many events
    @OneToMany(mappedBy = "organizer")
    List<Event> ownEvents;
}
