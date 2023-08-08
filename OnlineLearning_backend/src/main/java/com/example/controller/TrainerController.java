package com.example.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Trainer;

import com.example.service.TrainerService;
@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="true")
@RestController
@RequestMapping("api/trainer/")
public class TrainerController {
@Autowired
private TrainerService trainerservice;

@PostMapping("add")
public ResponseEntity<?>addTrainer(@Valid @RequestBody Trainer trainer ){
	Trainer trainercheck=this.trainerservice.addTrainer(trainer);
	if(trainercheck!=null) {
		return new ResponseEntity<Trainer>(trainercheck,HttpStatus.CREATED);
	
	}
	else {
		return new ResponseEntity<String>("Email and Password doesnt match",HttpStatus.BAD_REQUEST);
	}
	
}
@GetMapping("allTrainers")
public ResponseEntity <List<Trainer>>getAllTrainer(){
	if(this.trainerservice.getAllTrainer().size()>0) {
		return new ResponseEntity<List<Trainer>>(this.trainerservice.getAllTrainer(),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
@GetMapping("{trainerid}")
public ResponseEntity<Trainer> getTrainerById(@PathVariable long trainerid) {
	 
    Trainer trainer= trainerservice.getTrainerById(trainerid);
    if (trainer != null) {
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }
    else {
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	
    }
    
}

@PutMapping("{trainerid}")
public ResponseEntity<?>updateTrainer(@PathVariable long trainerid,@Valid @RequestBody Trainer trainer)
{
	Trainer trainercheck=this.trainerservice.updateTrainer(trainer,trainerid);
	if(trainercheck!=null) {
		return new ResponseEntity<Trainer>(trainercheck,HttpStatus.OK);
	}
	else
	{
	return new ResponseEntity<String>("wrong id",HttpStatus.BAD_REQUEST);
	}
}
@DeleteMapping("{trainerid}")
public List<Trainer> deleteTrainerById(@PathVariable Long trainerid)
{
	trainerservice.deleteTrainer(trainerid);
	return trainerservice.getAllTrainer();
}

}

