package cat.ilg;

import java.util.List;
import java.util.ArrayList;

import static cat.ilg.Main.*;

public class Institut {
	private String nom;
	private final List<Persona> personas = new ArrayList<>();

	public void canviarNom(String nom) {
		this.nom = nom;
	}

	public String obtenirNom() {
		return this.nom;
	}

	// Soluciona la redundància d'afegir estudiant i professor en dos mètodes diferents
	public void afegirPersona(Persona persona) {
		this.personas.add(persona);
	}

	public void imprimirInformacio(boolean isList) throws Exception {
		String result;

		if (personas.stream().count() == 0) {
			result = ANSI_YELLOW +  "Aquest institut encara no té alumnes o professors registrats." + ANSI_RESET;
		} else {
			result = ANSI_GREEN + "\nL'INSTITUT '" + this.nom + "' ESTÀ FORMAT PER:";

			for (Persona persona : this.personas) {
				if (isList)
					persona.setList(true);
				result += persona.obtenirDades();
			}
			result+= ANSI_RESET;
		}

		System.out.println(result);
	}
}