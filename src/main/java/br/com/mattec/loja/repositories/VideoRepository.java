package br.com.mattec.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mattec.loja.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
