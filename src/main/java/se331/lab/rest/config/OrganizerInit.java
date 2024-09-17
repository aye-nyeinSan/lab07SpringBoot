package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class OrganizerInit implements ApplicationListener<ApplicationReadyEvent>{
    final OrganizerRepository organizerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        organizerRepository.save(Organizer.builder()
                .id(123L)
                .name("Gigi Hather")
                .organizationName("Children Association of Dream World")
                .address("48 Street, London").build());
        organizerRepository.save(Organizer.builder()
                .id(456L)
                .name("Robin Green ")
                .organizationName("Orphan ")
                .address("40 Street, London").build());
        organizerRepository.save(Organizer.builder()
                .id(789L)
                .name("Brown Salin")
                .organizationName("Environmental Association of Dream World")
                .address("40 Street, London").build());
        organizerRepository.save(Organizer.builder()
                .id(1001L)
                .name("Violet Kerry")
                .organizationName("Environmental Association of Dream World")
                .address("40 Street, London").build());
        organizerRepository.save(Organizer.builder()
                .id(1002L)
                .name("Leo Cane")
                .organizationName("Puppy Association of Dream World")
                .address("36 Wall Street, United State").build());
        organizerRepository.save(Organizer.builder()
                .id(789L)
                .name("Brown Salin")
                .organizationName("Environmental Association of Dream World")
                .address("40 Street, London").build());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
