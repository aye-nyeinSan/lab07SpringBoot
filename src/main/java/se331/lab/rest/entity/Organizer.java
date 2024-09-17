package se331.lab.rest.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//one table for organizer
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String organizationName;
    String address;
}
