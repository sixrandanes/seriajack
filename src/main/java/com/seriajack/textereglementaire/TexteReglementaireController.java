package com.seriajack.textereglementaire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@RequestMapping(value = "/api/texte", produces = "application/json;charset=UTF-8")
public class TexteReglementaireController {

	@Autowired
	TexteReglementaireService texteReglementaireService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TexteReglementaire> findAllTexteReglementaire() {
		return texteReglementaireService.findAllTexteReglementaire();
	}
}
