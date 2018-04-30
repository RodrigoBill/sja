package br.com.sja.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.sja.dao.ContatoDao;
import br.com.sja.model.Contato;

@Controller
public class ContatoController {

	ContatoDao dao = new ContatoDao();
	
//	@RequestMapping("save")
//	public String saveContact(Contato contato) {
//		ContatoDao dao = new ContatoDao();
//		dao.adiciona(contato);
//		
//		return "redirect:cliente";
//	}
	
	@RequestMapping(value="saveCliente")
	@ResponseBody
	public Contato saveContact(Contato contato) {
		dao.adiciona(contato);
		return contato;
	}
	
	@RequestMapping("tabelaCliente")
	public ModelAndView tabelaCliente() {
		ModelAndView mv = new ModelAndView("principal");
		List<Contato> contatos = dao.getLista(); 
		mv.addObject("contatos", contatos);
		
		return mv;
	}
	
	@RequestMapping("removeCliente")
	public void remove(Contato contato) {
		dao.remove(contato);
	}
	    
	    
}
