package br.com.mattec.loja.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mattec.loja.model.Video;
import br.com.mattec.loja.services.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	
	@GetMapping
	public ResponseEntity <List<Video>> findAll(){
		List<Video> list = videoService.findAll();
		return ResponseEntity.ok().body(list);
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Video> findById(@PathVariable Long id){
		Video obj = videoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity <Video> insert(@RequestBody Video cadastro){
		cadastro= videoService.insert(cadastro);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(cadastro);
	
	}
	
	@DeleteMapping(value ="/{id}" )
	public ResponseEntity<Void> delete(@PathVariable Long id){
		videoService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video AAtualizar){
		AAtualizar = videoService.update(id, AAtualizar);
		return ResponseEntity.ok().body(AAtualizar);
	}
	
	
	

}
