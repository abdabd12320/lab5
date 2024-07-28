package com.example.eventsystem.EventController;

import com.example.eventsystem.EventApiResponse.ApiResponse;
import com.example.eventsystem.EventModel.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/v/event")
public class Controller {

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime localDateTime = LocalDateTime.now();
    ArrayList<Model> events = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Model> getEvent()
    {
        return events;
    }
    @PostMapping("/add")
    public ApiResponse postEvent(@RequestBody Model e)
    {
        events.add(e);
        return new ApiResponse("event added",localDateTime.toLocalDate().toString());
    }
    @PutMapping("/update/{index}")
    public ApiResponse putEvent(@PathVariable int index, @RequestBody Model e)
    {
        events.set(index,e);
        return new ApiResponse("event updated",localDateTime.toLocalDate().toString());
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index)
    {
        events.remove(index);
        return new ApiResponse("event deleted",localDateTime.toLocalDate().toString());
    }
    @PutMapping("/change/{index}/{n}")
    public ApiResponse changeEvent(@PathVariable int n,@PathVariable int index)
    {
        events.get(index).setCapacity(n);
        return new ApiResponse("capacity changed",localDateTime.toLocalDate().toString());
    }

    @GetMapping("/search/{i}")
    public Model searchEvent(@PathVariable int i)
    {
        return events.get(i);
    }

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date dd = new Date();
}
