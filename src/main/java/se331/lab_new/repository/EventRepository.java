package se331.lab_new.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab_new.entity.Event;
import java.util.List;
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAll();

}
