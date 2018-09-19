package com.beije.videoNoleggio.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beije.videoNoleggio.dao.PersonaDao;
import com.beije.videoNoleggio.model.Persona;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@RequestMapping(method = RequestMethod.GET , path="/listaPersona")
	public List<Persona> getListaPersona() {
		List<Persona> elencoPersona = PersonaDao.findAllPersona();
		return elencoPersona;
	}
	
	@RequestMapping(method = RequestMethod.GET , path = "/trova-persona-by-id")
	public Persona trovaPersonaById(@RequestParam("id") int id) {
		Persona persona = PersonaDao.trovaPersonaById(id);
		return persona;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/salvaPersona")
	public void salvaPersona(@RequestBody Persona persona) {
		PersonaDao.inserisciPersona(persona);	
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/eliminaPersona")
	public void eliminaPersona(@RequestParam("id")int id) {
		PersonaDao.deletePersona(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/aggiornaPersona")
	public void aggiornaPersona(@RequestBody Persona persona, @RequestParam("id") int id) {
		PersonaDao.aggiornaPersona(persona, id);
		
	}
}
