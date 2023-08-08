package com.example.service;

import java.util.List;

import com.example.entity.Trainer;


public interface TrainerService  {
	public Trainer addTrainer(Trainer trainer);
	List<Trainer>getAllTrainer();
	Trainer getTrainerById(long trainerid);
	
	Trainer updateTrainer(Trainer trainer,long trainerid);
	void deleteTrainer(Long trainerid);

}
