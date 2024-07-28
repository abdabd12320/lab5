package com.example.eventsystem.EventModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Model {

    private String id;
    private String description;
    private int capacity;
    private String startDate;
    private String endDate;
}