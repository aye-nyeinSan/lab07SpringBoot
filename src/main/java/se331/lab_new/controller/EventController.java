package se331.lab_new.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab_new.entity.Event;
import jakarta.annotation.PostConstruct;
import se331.lab_new.service.EventService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class EventController {
    final EventService eventService;

    @GetMapping("events")
    //to add params just change inside the parameter, for invalid error use try catch
    public ResponseEntity<?> getEventLists(
            @RequestParam(value = "_limit",required = false) Integer perPage,
            @RequestParam(value = "_page",required = false) Integer page
    ){

        Page<Event> pageOutput=eventService.getEvents(perPage,page);
        HttpHeaders responseHeader=new HttpHeaders();
        responseHeader.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);
    }

    //find event by id using path variable
    //The usage of path is just put / and put the variable you want inside {}
    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id){
        //The result must be Event type and declare null at first.
        Event output=eventService.getEvent(id);

        //Returning ResponseEntity
        if(output!=null){
            return ResponseEntity.ok(output);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
}
