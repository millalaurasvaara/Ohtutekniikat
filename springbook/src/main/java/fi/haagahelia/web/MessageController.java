package fi.haagahelia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import repository.StudentRepository;
import domain.Student;

	@Controller
	public class MessageController {

		@Autowired
		private StudentRepository repository;
		
	    @RequestMapping(value="/hello")
	    public String hello(@RequestParam(value="age") String age,@RequestParam(value="name") String name,  Model model) {
	    	model.addAttribute("age", age);
	    	model.addAttribute("name", name);
	        return "hello";
	    }
	    @RequestMapping(value="/hello2")
	    public String hello2(@RequestParam(value="firstName") String firstName,@RequestParam(value="lastName") String lastName, @RequestParam(value="email") String email,  Model model) {
	    	Student student = new Student("Milla","Laurasvaara","m.l@email.com");
	    	Student student2 = new Student("Niko","Pieviläinen","n.p@email.com");
	    	Student student3 = new Student("Mokhtar","Paukkio","m.p@email.com");
	    	repository.save(student);
	    	repository.save(student2);
	    	repository.save(student3);
	    	
	    	model.addAttribute("fistName", firstName);
	    	model.addAttribute("lastName", lastName);
	    	model.addAttribute("email", email);
	    	System.out.println(repository.findAll());
	        return "hello2";
	    }

	}

