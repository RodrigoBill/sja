package br.com.sja.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.sja.dao.SegmentoDao;
import br.com.sja.model.Segmento;

@Controller
public class SegmentoController {
	
	SegmentoDao dao = new SegmentoDao();
	
	@RequestMapping(value="saveSegmento")
	@ResponseBody
	public Segmento saveSegmento(Segmento segmento) {
		dao.adiciona(segmento);
		return segmento;
	}

	@RequestMapping("tabelaSegmento")
	public ModelAndView tabelaSegmento() {
		ModelAndView mv = new ModelAndView("principal");
		List<Segmento> segmentos = dao.getLista(); 
		mv.addObject("segmentos", segmentos);
		
		return mv;
	}
	
	@RequestMapping("removeSegmento")
	public String remove(Segmento segmento) {
		dao.remove(segmento);
		return "redirect:segmento";
	}
}
