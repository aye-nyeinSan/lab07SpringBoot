package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Organizer;

import java.util.List;
import java.util.Optional;

public interface OrganizerDao {
   Page<Organizer> getOrganizer(Pageable pageable);
   Optional<Organizer> findById(Long id);
}
