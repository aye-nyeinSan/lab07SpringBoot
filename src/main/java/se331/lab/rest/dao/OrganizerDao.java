package se331.lab.rest.dao;

import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerDao {
    Organizer getOrganizer(Long organizerId);
    List<Organizer> getAllOrganizers(Integer ItemNo, Integer pageNo);
    Integer getOrganizerSize();
}
