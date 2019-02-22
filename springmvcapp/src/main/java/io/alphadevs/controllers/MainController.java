package io.alphadevs.controllers;
import io.alphadevs.data.entities.Student;
import io.alphadevs.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @PostConstruct
    void init(){
        System.out.println("initialised");
    }

    @Autowired
    MainService mainService;


    @RequestMapping(value = "/students", method = RequestMethod.POST, consumes="application/json;charset=UTF-8")
    @ResponseBody
    public Student createStudent(@RequestBody StudentRequestData studentRequestData) throws Exception{
        Student student = mainService.createStudent(studentRequestData.getName(), studentRequestData.getAge());
        return student;
    }


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> fetchStudents(){
        return mainService.fetchStudents();
    }


    @RequestMapping(value = "/session/save", method = RequestMethod.POST)
    @ResponseBody
    public String saveSessionValue(@RequestBody  Map<String, String> map, HttpSession session){
        session.setAttribute("value", map.get("value"));
        return (String) session.getAttribute("value");
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    @ResponseBody
    public String sessionValue(HttpSession session){
        return (String) session.getAttribute("value");
    }


    @RequestMapping(value = "/cache/{key}", method = RequestMethod.GET)
    @ResponseBody
    public String cachedValues(@PathVariable(value = "key") String key){
        return mainService.cachedValue(key);
    }






}
