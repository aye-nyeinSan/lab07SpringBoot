package se331.lab.rest.controller;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Event;
import org.springframework.stereotype.Controller;
import se331.lab.rest.service.EventService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController  {

    final EventService eventService;
    @GetMapping("/events")
    public ResponseEntity<?> getEventsLists(@RequestParam(value ="_limit",required = false) Integer perPage,
                                            @RequestParam(value ="_page",required = false)Integer page) {

        Page<Event> pageOutput = eventService.getEvents(perPage,page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        return
                new ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);



    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id){
       Event output = eventService.getEvent(id);
        if(output != null){
            return ResponseEntity.ok(output);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/events")
    public ResponseEntity<?> addEvent(@RequestBody Event event){
        Event output = eventService.save(event);
        return ResponseEntity.ok(output);
    }
}
