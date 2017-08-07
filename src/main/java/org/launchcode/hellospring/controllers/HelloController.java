package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value="") //root route spec doesn't require leading slash
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");
        if (name == null) name = "World"; // handle blank parameters
        return "Hello " + name;
    }

    @RequestMapping(value="hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        if (name == "") name = "World"; // blank fields are different in POST requests
        return "Hello " + name;
    }

    @RequestMapping(value="hello/{name}") // {name} is a variable part of the path
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

//    @RequestMapping(value = "goodbye")
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye";
//    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/"; // this isn't text to be displayed, it's a command to the browser
    }
}




