package com.seriajack.loader.ref.textereglementaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seriajack.textereglementaire.TexteReglementaire;
import com.seriajack.textereglementaire.TexteReglementaireRepository;
import com.seriajack.textereglementaire.TexteType;

@Component
public class TexteReglementaireLoader {

	private List<TexteReglementaire> lTexte = new ArrayList<>();

	@Autowired
	TexteReglementaireRepository texteReglementaireRepository;

	public TexteReglementaire createTexteReglementaire(TexteType type, String numero, String intitule,
			LocalDate dateCreation, byte[] fichier, String precision, LocalDate dateCertification,
			LocalDate dateParution, String numeroJONC, LocalDate dateAbrogation, String reference, String lienJuridoc) {

		TexteReglementaire texte = new TexteReglementaire();
		texte.setType(type);
		texte.setNumero(numero);
		texte.setIntitule(intitule);
		texte.setDateCreation(dateCreation);
		texte.setFichier(fichier);
		texte.setPrecision(precision);
		texte.setDateCertification(dateCertification);
		texte.setDateParution(dateParution);
		texte.setNumeroJONC(numeroJONC);
		texte.setDateAbrogation(dateAbrogation);
		texte.setReference(reference);
		texte.setLienJuridoc(lienJuridoc);

		texteReglementaireRepository.save(texte);
		lTexte.add(texte);

		return texte;
	}

	public void deleteAll() {
		texteReglementaireRepository.delete(lTexte);
	}

}
