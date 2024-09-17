package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

import java.util.List;

@Repository
@Profile("db")
@RequiredArgsConstructor
public class OrganizerDaoDbImpl implements OrganizerDao{
    final OrganizerRepository organizerRepository;


    @Override
    public Organizer getOrganizer(Long organizerId) {
        return organizerRepository.findById(organizerId).orElse(null);
    }

    @Override
    public Page<Organizer> getAllOrganizers(Integer ItemNo, Integer page) {
        return organizerRepository.findAll(PageRequest.of(page - 1,  ItemNo));
    }

    @Override
    public Integer getOrganizerSize() {
        return Math.toIntExact(organizerRepository.count());
    }

    @Override
    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
}
