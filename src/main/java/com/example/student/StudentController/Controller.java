package com.example.student.StudentController;

import com.example.student.StudentApiResponse.ApiResponse;
import com.example.student.StudentModel.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/v/student")
public class Controller {

    ArrayList<Model> students =  new ArrayList<>();
    Date date = new Date();

    @GetMapping("/get")
    public ArrayList<Model> getStudents()
    {
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addName(@RequestBody Model s)
    {
        students.add(s);
        return new ApiResponse("student added",date.toString());
    }

    @PutMapping("/update/{i}")
    public ApiResponse updateName(@PathVariable int i,@RequestBody Model s)
    {
        students.set(i,s);
        return new ApiResponse("student updated",date.toString());
    }

    @DeleteMapping("/delete/{i}")
    public ApiResponse deleteName(@PathVariable int i)
    {
        students.remove(i);
        return new ApiResponse("student deleted",date.toString());
    }

    @GetMapping("/get-name/{i}")
    public String getName(@PathVariable int i)
    {
        return students.get(i).getName();
    }
    @GetMapping("/get-age/{i}")
    public int getAge(@PathVariable int i)
    {
        return students.get(i).getAge();
    }
    @GetMapping("/get-degree/{i}")
    public String getDegree(@PathVariable int i)
    {
        return students.get(i).getDegree();
    }
    @GetMapping("/get-status/{i}")
    public boolean getStatus(@PathVariable int i)
    {
        return students.get(i).getStatus().equalsIgnoreCase("graduated");
    }
}
//graduated
//diploma
//bachelor
//master