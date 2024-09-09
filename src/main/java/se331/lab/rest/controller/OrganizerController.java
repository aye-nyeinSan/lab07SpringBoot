package se331.lab.rest.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

          List<Organizer> output = null;
          Integer organizerSize = organizerService.getOrganizerSize();
          HttpHeaders responseHeader = new HttpHeaders();
          responseHeader.set("x-total-count",String.valueOf(organizerSize));

          try{
               output = organizerService.getAllOrganizers(itemNo,pageNo);
               return new ResponseEntity<>(output,responseHeader, HttpStatus.OK) ;

          }catch(IndexOutOfBoundsException ex){
               return new ResponseEntity<>(output, responseHeader,HttpStatus.OK);
          }

     }

     @GetMapping("organizers/{id}")
     public ResponseEntity<?> getOrganizer(@PathVariable("id") long id) {
          Organizer output = organizerService.getOrganizer(id);
          if(output != null){
               return new ResponseEntity<>(output,HttpStatus.OK);
          }else
          { throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");}

     }

}
