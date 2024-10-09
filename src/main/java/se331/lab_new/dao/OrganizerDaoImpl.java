package se331.lab_new.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab_new.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();

        // Add Organizer 1
        organizerList.add(Organizer.builder()
                .id(123L)
                .name("Organization 1")
                .build());

// Add Organizer 2
        organizerList.add(Organizer.builder()
                .id(124L)
                .name("Organization 2")
                .build());

// Add Organizer 3
        organizerList.add(Organizer.builder()
                .id(125L)
                .name("Organization 3")
                .build());

// Add Organizer 4
        organizerList.add(Organizer.builder()
                .id(126L)
                .name("Organization 4")
                .build());

// Add Organizer 5
        organizerList.add(Organizer.builder()
                .id(127L)
                .name("Organization 5")
                .build());

// Add Organizer 6
        organizerList.add(Organizer.builder()
                .id(128L)
                .name("Organization 6")
                .build());

        // Add Organizer 7
        organizerList.add(Organizer.builder()
                .id(129L)
                .name("Organization 7")
                .build());


    }
    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize=pageSize==null?getOrganizerSize():pageSize;
        page=page==null?1:page;
        int firstIndex=(page-1)*pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+pageSize),
                PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer ->
                organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }


}
