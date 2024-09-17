package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .name("Gigi Hather")
                .organizationName("Children Association of Dream World")
                .address("48 Street, London").build());
        organizerList.add(Organizer.builder()
                .id(456L)
                .name("Robin Green ")
                .organizationName("Orphan ")
                .address("40 Street, London").build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .name("Brown Salin")
                .organizationName("Environmental Association of Dream World")
                .address("40 Street, London").build());
        organizerList.add(Organizer.builder()
                .id(1001L)
                .name("Violet Kerry")
                .organizationName("Environmental Association of Dream World")
                .address("40 Street, London").build());
        organizerList.add(Organizer.builder()
                .id(1002L)
                .name("Leo Cane")
                .organizationName("Puppy Association of Dream World")
                .address("36 Wall Street, United State").build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .name("Brown Salin")
                .organizationName("Environmental Association of Dream World")
                .address("40 Street, London").build());
    }
    @Override
    public Organizer getOrganizer(Long organizerId) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(organizerId)).findFirst().orElse(null);
    }

    @Override
    public Page<Organizer> getAllOrganizers(Integer ItemNo, Integer pageNo) {
        ItemNo = ItemNo==null? organizerList.size(): ItemNo;
        pageNo = pageNo == null? 1: pageNo;
        int firstIndex = (pageNo - 1) * ItemNo;
        return new
                PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+ItemNo), PageRequest.of(pageNo,ItemNo),organizerList.size());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Organizer createOrganizer(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
