package br.com.mattec.loja.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.mattec.loja.model.Video;
import br.com.mattec.loja.repositories.VideoRepository;
import br.com.mattec.loja.services.exceptions.ControllerNotFoundException;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepository;
	

	
	public List<Video> findAll(){
		return videoRepository.findAll();
	
	}
	
	
	public Video findById(Long id){	
		Optional<Video> obj= videoRepository.findById(id);
		return obj.orElseThrow(()-> new ControllerNotFoundException(id));
	
	}
	
	public void delete(Long id) {
		try {
		videoRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
		}
	}
	
	
	public Video insert(Video ACadastrar) {
		return videoRepository.save(ACadastrar);
	}
	
	public Video update(Long id, Video atualizar) {
		try {
		Video entity = videoRepository.getOne(id);
		updateData(entity, atualizar);
		return videoRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ControllerNotFoundException(id);
		}
		
	}


	private void updateData(Video entity, Video atualizar) {
		entity.setTitulo(atualizar.getTitulo());
		entity.setDescricao(atualizar.getDescricao());
		entity.setUrl(atualizar.getUrl());
		
	}
}
