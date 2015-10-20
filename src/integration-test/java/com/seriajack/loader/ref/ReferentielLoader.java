package com.seriajack.loader.ref;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seriajack.loader.ref.textereglementaire.TexteReglementaireLoader;
import com.seriajack.textereglementaire.TexteType;

@Component
public class ReferentielLoader {

	@Autowired
	private TexteReglementaireLoader texteReglementaireLoader;

	public void loadData() {
		loadTexteReglementaire();
	}

	public void removeData() {
		texteReglementaireLoader.deleteAll();
	}

	private void loadTexteReglementaire() {
		texteReglementaireLoader.createTexteReglementaire(TexteType.ARRETE, "T1", "Texte 1", LocalDate.of(2015, 10, 19),
				new byte[10], null, null, null, null, null, null, null);
		texteReglementaireLoader.createTexteReglementaire(TexteType.ARRETE, "T2", "Texte 2", LocalDate.of(2015, 10, 19),
				new byte[10], null, null, null, null, null, null, null);
	}

}
