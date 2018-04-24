package br.com.sja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.sja.dao.ContatoDao;
import br.com.sja.model.Contato;

@Controller
@RequestMapping("contato")
public class ContatoController {

	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody//Recebe documento do tipo Json
	public Contato saveContact(Contato contato) {
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		return contato;
	}

	@RequestMapping("/home")
	public ModelAndView lista(ModelMap model) {
		ContatoDao dao = new ContatoDao();
		model.put("contatos", dao.getLista());
		return new ModelAndView("contato", model);
	}

	@RequestMapping("alteraContato")
	public String altera(Contato contato) {
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		return "redirect:listaContato";
	}

	@RequestMapping("removeContato")
	public String remove(Contato contato) {
		ContatoDao dao = new ContatoDao();
		dao.remove(contato);
		return "redirect:listaContato";
	}
	    
	    
}
