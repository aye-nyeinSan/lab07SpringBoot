package se331.lab_new.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab_new.entity.Event;
import java.util.List;
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAll();

    Page<Event> findByTitle(String title, Pageable pageRequest);

    Page<Event> findByTitleContaining(String title, Pageable pageRequest);

    Page<Event> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageRequest);

    //new query to the text via title and description
    Page<Event> findByTitleContainingAndDescriptionContaining(String title, String description, Pageable pageRequest);

    //new query to get the result form organizer name
    Page<Event> findByTitleContainingOrDescriptionContainingOrOrganizer_NameContaining(String title, String description,String organizerName, Pageable pageRequest);

    Page<Event> findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(String title, String description, String organizerName, Pageable pageRequest);
}
