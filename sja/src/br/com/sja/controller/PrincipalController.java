package br.com.sja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sja.dao.ContatoDao;
import br.com.sja.dao.SegmentoDao;

@Controller
public class PrincipalController {
	ContatoDao dao = new ContatoDao();
	SegmentoDao daos = new SegmentoDao();
	
	@RequestMapping("principal")
	public ModelAndView principal() {
		ModelAndView mv = new ModelAndView("principal");
		mv.addObject("contatos", dao.getLista());
		mv.addObject("segmentos", daos.getLista());
		
		return mv;		
	}
	
}
