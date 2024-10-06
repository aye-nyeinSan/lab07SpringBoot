package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//one table for organizer
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String tellNo;

    @ManyToMany
    @Builder.Default
    List<Event> eventHistory = new ArrayList<>();
}
