package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    final OrganizerDao organizerDao;



    @Override
    public Organizer getOrganizer(Long organizerId) {
        return organizerDao.getOrganizer(organizerId);
    }

    @Override
    public List<Organizer> getAllOrganizers(Integer ItemNo, Integer pageNo) {
        return organizerDao.getAllOrganizers(ItemNo,pageNo);
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerDao.getOrganizerSize();
    }
}
