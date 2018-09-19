package com.beije.videoNoleggio.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beije.videoNoleggio.dao.FilmDao;
import com.beije.videoNoleggio.model.Film;

@RestController
@RequestMapping("/film")
public class FilmController {
	
	@RequestMapping(method = RequestMethod.POST, path="/aggiungiFilm")
	public void aggiungiFilm(@RequestBody Film film) {
		FilmDao.inserisciFilm(film);
		
	}
	
	@RequestMapping(method = RequestMethod.GET , path="/eliminaFilm")
	public void eliminaFilm(@RequestParam("id") int id) {
		FilmDao.deleteFilm(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST , path="/aggiornaFilm")
	public void aggiornaFilm(@RequestBody Film film, @RequestParam("id") int id) {
		FilmDao.aggiornafilm(film, id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/trova-film-by-id")
	public Film trovaFilmById(@RequestParam("id") int id) {
		Film film = FilmDao.trovaFilmById(id);
		return film;
	}
	
	
	@RequestMapping(method = RequestMethod.GET , path="/listaFilm")
	public List<Film> getListaFilm(){
		List<Film> elencoFilm = FilmDao.findAllFilm();
		
		return elencoFilm;
	}

}
