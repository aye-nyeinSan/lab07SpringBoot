package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.service.ParticipantService;
import se331.lab.rest.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;
    
    @GetMapping("/participants")
    ResponseEntity<?> getParticipants()
    {


        return
                ResponseEntity.ok(
                       LabMapper.INSTANCE.getParticipantDTO(participantService.getAllParticipants()) );

    }

}
