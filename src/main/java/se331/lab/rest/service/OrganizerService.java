package se331.lab.rest.service;

import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Organizer getOrganizer(Long organizerId);
    List<Organizer> getAllOrganizers(Integer ItemNo, Integer pageNo);
    Integer getOrganizerSize();
}
