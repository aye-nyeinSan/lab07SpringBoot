package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;
import se331.lab.rest.security.user.Role;
import se331.lab.rest.security.user.User;
import se331.lab.rest.security.user.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor

public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    final UserRepository userRepository;


    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2, org3;
        Participant p1,p2,p3,p4,p5;

        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("Chiang Mai").build());

        p1 = participantRepository.save(Participant.builder().name("Rubi").tellNo("0614504875").build());
        p2 = participantRepository.save(Participant.builder().name("Ruth").tellNo("078654321").build());
        p3 = participantRepository.save(Participant.builder().name("GoGo").tellNo("54312256709").build());
        p4 = participantRepository.save(Participant.builder().name("HninEi").tellNo("654321890").build());
        p5 = participantRepository.save(Participant.builder().name("Nyein").tellNo("0615098086").build());

        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam ")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent.setParticipants(List.of(p1,p2,p3));
        p1.getEventHistory().add(tempEvent);
        p2.getEventHistory().add(tempEvent);
        p3.getEventHistory().add(tempEvent);

       tempEvent= eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.am-4.00 pm ")
                .petAllowed(false)
                .build());
       tempEvent.setOrganizer(org1);
       org1.getOwnEvents().add(tempEvent);
       tempEvent.setParticipants(List.of(p2,p3,p4));
       p2.getEventHistory().add(tempEvent);
       p3.getEventHistory().add(tempEvent);
       p4.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm ")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent.setParticipants(List.of(p1,p3,p4));
        p1.getEventHistory().add(tempEvent);
        p3.getEventHistory().add(tempEvent);
        p4.getEventHistory().add(tempEvent);

       tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Lets's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am-6.00 pm ")
                .petAllowed(true)
                .build());
       tempEvent.setOrganizer(org3);
       org3.getOwnEvents().add(tempEvent);
       tempEvent.setParticipants(List.of(p2,p5,p4));
       p2.getEventHistory().add(tempEvent);
       p5.getEventHistory().add(tempEvent);
       p4.getEventHistory().add(tempEvent);
       addUser();
    }
    User user1,user2,user3;

    private void addUser(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password((encoder.encode("admin")))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .build();
        user2 = User.builder()
                .username("user")
                .password((encoder.encode("user")))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .build();
        user3 = User.builder()
                .username("disableUser")
                .password((encoder.encode("disableUser")))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(false)
                .build();

        user1.getRoles().add(Role.ROLE_USER);
        user1.getRoles().add(Role.ROLE_ADMIN);
        user2.getRoles().add(Role.ROLE_USER);
        user3.getRoles().add(Role.ROLE_USER);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
