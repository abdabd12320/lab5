package com.example.trackersystem.Controller;

import com.example.trackersystem.Api.ApiResponse;
import com.example.trackersystem.Model.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {

    Date date = new Date();
    ArrayList<Tracker> trackers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Tracker> getTracker()
    {
        return trackers;
    }
    @PostMapping("/add")
    public ApiResponse postTracker(@RequestBody Tracker tracker)
    {
        trackers.add(tracker);
        return new ApiResponse("tracker added",date.toString());
    }
    @PutMapping("/update/{index}")
    public ApiResponse putTracker(@PathVariable int index,@RequestBody Tracker tracker)
    {
        trackers.set(index,tracker);
        return new ApiResponse("tracked updated",date.toString());
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTracker(@PathVariable int index)
    {
        trackers.remove(index);
        return new ApiResponse("tracker deleted",date.toString());
    }
    @PutMapping("/change/{index}")
    public ApiResponse changeStatus(@PathVariable int index)
    {
        if(trackers.get(index).getStatus().equalsIgnoreCase("Not done")) {
            trackers.get(index).setStatus("Done");
        }
        return new ApiResponse("status changed",date.toString());
    }
    @GetMapping("/search/{s}")
    public Tracker searchTracker(@PathVariable String s)
    {
        for (Tracker tracker : trackers) {
            if (tracker.getTitle().equals(s)) {
                return tracker;
            }
        }
        return null;
    }
    @GetMapping("/get-company/{s}")
    public ArrayList<Tracker> getCompany(@PathVariable String s)
    {
        ArrayList<Tracker> newTrackerArrayList = new ArrayList<>();
        for (Tracker tracker: trackers)
        {
            if(tracker.getCompanyname().equalsIgnoreCase(s))
            {
                newTrackerArrayList.add(tracker);
            }
        }
        return newTrackerArrayList;
    }
}