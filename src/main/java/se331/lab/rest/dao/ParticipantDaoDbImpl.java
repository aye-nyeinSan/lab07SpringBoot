package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

@Repository
@Profile("db")
@RequiredArgsConstructor
public class ParticipantDaoDbImpl implements ParticipantDao{
    final ParticipantRepository participantRepository;


    @Override
    public Page<Participant> getParticipants(Pageable pageable) {

        return participantRepository.findAll(pageable);
    }
}
