package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Organizer getOrganizer(Long organizerId);
    Page<Organizer> getAllOrganizers(Integer ItemNo, Integer pageNo);
    Integer getOrganizerSize();
    Organizer createOrganizer(Organizer organizer);
}
