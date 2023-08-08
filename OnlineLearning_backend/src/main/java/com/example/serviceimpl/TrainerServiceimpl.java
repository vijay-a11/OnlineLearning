package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Trainer;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.TrainerRepository;

import com.example.service.TrainerService;

@Service
public class TrainerServiceimpl implements TrainerService{
	@Autowired
	private TrainerRepository trainerrepository;

	@Override
	public Trainer addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		if(trainer.getPassword().equals(trainer.getConfirmPassword())) {
			return trainerrepository.save(trainer);
		}else {
			return null;
			
		}
		
	}
	@Override
	public List<Trainer> getAllTrainer() {
		// TODO Auto-generated method stub
		return this.trainerrepository.findAll();
	}
	@Override
	public Trainer getTrainerById(long trainerid) {
			// TODO Auto-generated method stub
		Trainer existingtrainer=this.trainerrepository.findById(trainerid).orElseThrow(()->new ResourceNotFoundException("Trainer","Id",trainerid));
		return existingtrainer;
		}
	

	@Override
	public Trainer updateTrainer(Trainer trainer,long trainerid){
		// TODO Auto-generated method stub
		Trainer existingtrainer=getTrainerById(trainerid);

	
		existingtrainer.setUserName(trainer.getUserName());
		existingtrainer.setPassword(trainer.getPassword());
		existingtrainer.setConfirmPassword(trainer.getConfirmPassword());
		existingtrainer.setEmail(trainer.getEmail());
		existingtrainer.setMobileNo(trainer.getMobileNo());
		return trainerrepository.save(existingtrainer);
		
	}


	@Override
	public void deleteTrainer(Long trainerid){
		// TODO Auto-generated method stub
		Trainer existingtrainer=getTrainerById(trainerid);
		this.trainerrepository.delete(existingtrainer);
		
		
	}


	

}
