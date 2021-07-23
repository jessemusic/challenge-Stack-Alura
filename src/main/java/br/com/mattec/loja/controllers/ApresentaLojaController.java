package br.com.mattec.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApresentaLojaController {
	
	@RequestMapping(name = "/")
	@ResponseBody
	public String VideosOla() {
		return "Bem vindo à loja da Mattec Vídeos";
	}

}
