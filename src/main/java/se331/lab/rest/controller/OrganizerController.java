package se331.lab.rest.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
     final OrganizerService organizerService;

     @GetMapping("organizers")
     public ResponseEntity<?> getAllOrganizers(@RequestParam(value ="_limit",required = false) Integer itemNo,
                                             @RequestParam(value ="_page",required = false)Integer pageNo) {

          Page<Organizer> pageOutput = organizerService.getAllOrganizers(itemNo, pageNo);

          HttpHeaders responseHeader = new HttpHeaders();
          responseHeader.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));

         return new ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);

     }

     @GetMapping("organizers/{id}")
     public ResponseEntity<?> getOrganizer(@PathVariable("id") long id) {
          Organizer output = organizerService.getOrganizer(id);
          if(output != null){
               return new ResponseEntity<>(output,HttpStatus.OK);
          }else
          { throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");}

     }
     @PostMapping("/organizers")
     public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer){
          Organizer output = organizerService.createOrganizer(organizer);
          return ResponseEntity.ok(output);
     }

}
