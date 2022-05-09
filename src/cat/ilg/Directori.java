package cat.ilg;

import java.util.List;
import java.util.ArrayList;

import static cat.ilg.Main.*;
import static cat.ilg.Utils.keybInputInt;
import static cat.ilg.Utils.keybInputString;

public class Directori {
	private final List<Institut> directori = new ArrayList();

	// Comrpova si existeix cap institut
	private boolean existeixInstitut() {
		boolean existeixInstitut = false;

		if ((long) this.directori.size() > 0)
			existeixInstitut = true;
		else
			System.out.println(ANSI_YELLOW + "Encara no hi ha cap Institut.\n" + ANSI_RESET);

		return existeixInstitut;
	}

	public int veureLlistaInstituts(boolean blnChoose) throws InterruptedException {
		int codiInstitut = 0;

		if (existeixInstitut()) {
			int comptador = 1;
			String result = "";

			result +=
					blnChoose ? ANSI_BLUE : ANSI_GREEN +
					"""
					--------------------
					LLISTAT D'INSTITUTS:
					--------------------
					""";
			for (Institut institut : this.directori)
				result += (comptador++) + ") " + institut.obtenirNom() + ".\n";

			result += ANSI_RESET;
			System.out.println(result);

			if (blnChoose) {
				do {
					codiInstitut = keybInputInt();

					if (codiInstitut < 1 || codiInstitut > (long) this.directori.size()) {
						System.out.println(ANSI_RED + "No existeix aquest codi d'institut.\n" + ANSI_RESET);
						Utils.clearConsole();
						codiInstitut = 0;
					}
				} while (codiInstitut == 0);
			}
		}

		return codiInstitut;
	}

	public int accioSobreInstitut(String tipus) throws Exception {
		int codiInstitut = 0;

		if (existeixInstitut()) {

			String text =
       			"""
   				--------------------------------
   				INTRODUEIX EL CODI DE L'INSTITUT
   				--------------------------------
   				""";

			switch (tipus) {
				case "info" -> text += "per imprimir la informació.";
				case "eliminar" -> text += "que vols eliminar";
				case "persona" -> text += "on vols afegir la persona…";
			}

			System.out.println(ANSI_BLUE + text + "\n" + ANSI_RESET);

			codiInstitut = veureLlistaInstituts(true);

			if ("info".equals(tipus))
				this.directori.get(codiInstitut - 1).imprimirInformacio(true);

			if ("eliminar".equals(tipus))
				this.directori.remove(codiInstitut - 1);
		}

		return codiInstitut;
	}

	public void afegirPersonaInstitut () throws Exception {

		if (existeixInstitut()) {

			int codiPersona;
			String nomPersona;
			Persona persona = new Persona();
			int codiInstitut = accioSobreInstitut("persona");

			System.out.println(
				ANSI_BLUE + """
    			----------------------------------
				QUIN TIPUS DE PERSONA VOLS AFEGIR…
				----------------------------------
				1) Professor.
				2) Professor Substitut.
				3) Alumne.
				""" + ANSI_BLUE
			);

			do {
				codiPersona = keybInputInt();

				if (codiPersona < 0 || codiPersona > 3) {
					System.out.println(ANSI_RED + "No existeix aquest codi de persona.\n" + ANSI_RESET);
					codiPersona = 0;
				}
			} while (codiPersona == 0);

			System.out.println(ANSI_GREEN + "Introdueix el nom de la persona…\n" + ANSI_RESET);
			nomPersona = keybInputString();

			switch (codiPersona) {
				case 1 -> {
					Persona professor = new Professor();
					professor.canviarNom(nomPersona);
					persona = professor;
				}
				case 2 -> {
					ProfessorSubstitut professorSubstitut = new ProfessorSubstitut();
					professorSubstitut.canviarNom(nomPersona);
					persona = professorSubstitut;
				}
				case 3 -> {
					Estudiant estudiant = new Estudiant();
					estudiant.canviarNom(nomPersona);
					persona = estudiant;
				}
			}

			this.directori.get(codiInstitut - 1).afegirPersona(persona);
		}
	}

	public void crearInstitut() {
		System.out.println(ANSI_GREEN + "Escriu el nom de l'Institut que vols crear:" + ANSI_RESET);

		String nomInstitut = keybInputString();

		Institut institut = new Institut();
		institut.canviarNom(nomInstitut);
		this.directori.add(institut);
	}
}
