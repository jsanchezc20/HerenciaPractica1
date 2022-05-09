package cat.ilg;

import java.text.SimpleDateFormat;

import static cat.ilg.Utils.keybInputInt;

public class
Main {
	// Temps en segons per pausar abans d'esborrar la consola
	public static final int SECONDS_WAITING = 2;

	/* Colors per imprimir per consola */
	public static final String ANSI_BLUE 	= "\u001B[34m";
	public static final String ANSI_GREEN 	= "\u001B[32m";
	public static final String ANSI_RED 	= "\u001B[31m";
	public static final String ANSI_YELLOW 	= "\u001B[33m";
	public static final String ANSI_RESET 	= "\u001B[0m";

	public static void main(String[] args) {
		try {
            /* * * * * * * PRIMERA PART * * * * * * *
			Exercicis 1 i 2
			- Crear Institut.
			- Afegir estudiants i professors.
			- Canviar les seves dades.
			- Imprimir informació de tot l’institut.
			* * * * * * * * * * * * * * * * * * * * * */
//			exercicis1_2();

			/* * * * * * * * * * * * * * * * * * * * *
			Implementar excepcions.
			a. Persona no pot canviar DNI si ja en té.
			b. Professors no poden cobrar més de 3K ni sous negatius.
			c. Nota d'estudiant entre 0 i 10.
			d. No es poden obtenir dades sense DNI o nom.
			* * * * * * * * * * * * * * * * * * * * * *
            FET! Validar amb el joc de proves de la segona part.

            * * * * * * * SEGONA PART * * * * * * *
            Implementar i provar el funcionament de les excepcions. */

//			a_canviarDNI();
//			b_sou_superior3K_negatiu(true);
//			b_sou_superior3K_negatiu(false);
//			c_notaEstudiantEntre_0_i_10(true);
//          c_notaEstudiantEntre_0_i_10(false);
//			c_obtenirDadesSense_DNI_nom(true);
//          c_obtenirDadesSense_DNI_nom(false);

            // Nota màxima, mínima i mitjana
//            obtenirNotaMaximaMinimaMitjana();

			// * * * * * * * TERCERA PART * * * * * * *
			programmaticBehavior();

		} catch (Exception e) {
			System.out.println(
				ANSI_RED +
				"\n * * * Error * * *\n" +
				e.getMessage() +
				"\n * * * Error * * *\n" +
				ANSI_RESET
			);
		} finally {
			System.out.println(ANSI_GREEN + "\nFi de l'execució!!!" + ANSI_RESET);
		}
	}

    private static void exercicis1_2() throws Exception {
		// Crear institut
		Institut institut = new Institut();
		institut.canviarNom("La Guineueta");

		// Afegir estudiants i professors
		// Estudiants
		Estudiant estudiant1 = new Estudiant();
		estudiant1.canviarNom("Erik");
		estudiant1.assignarDni("11111111E");
		estudiant1.posarNota("Bioinformàtica", 8.5);

		Estudiant estudiant2 = new Estudiant();
		estudiant2.canviarNom("Jaime");
		estudiant2.assignarDni("22222222J");
		estudiant2.posarNota("Bases de dades", 8d);

		Estudiant estudiant3 = new Estudiant();
		estudiant3.canviarNom("Marcello");
		estudiant3.assignarDni("33333333M");
		estudiant3.posarNota("Programació", 7.5);

		// Professors
		Professor professor = new Professor();
		professor.canviarNom("Oriol");
		professor.assignarDni("44444444O");
		professor.canviarSou(2500d);

		ProfessorSubstitut professorSubstitut = new ProfessorSubstitut();
		professorSubstitut.canviarNom("Marc");
		professorSubstitut.assignarDni("55555555M");
		professorSubstitut.canviarSou(2000d);
		professorSubstitut.assignarSubstitucio(
			new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-01"),
			new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-20")
		);

		// Hem d'afegir els estudiants i professors a l'institut
		institut.afegirPersona(estudiant1);
		institut.afegirPersona(estudiant2);
		institut.afegirPersona(estudiant3);

		institut.afegirPersona(professor);
		institut.afegirPersona(professorSubstitut);

		// Imprimir informació de l'institut
		institut.imprimirInformacio(false);
	}

	// a. Persona no pot canviar DNI si ja en té.
	private static void a_canviarDNI() throws Exception {
		Persona persona = new Persona();

		persona.canviarNom("Marcello");
		persona.assignarDni("33333333M");
		persona.assignarDni("44444444M");
	}

	// b. Profes no poden cobrar més de 3K ni sous negatius.
	private static void b_sou_superior3K_negatiu(boolean blnSuperior3K) throws Exception {
		Professor professor = new Professor();

		professor.canviarNom("Oriol");
		professor.assignarDni("61234567O");

		if (blnSuperior3K) {
			professor.canviarSou(3100d);
		} else {
			professor.canviarSou(-20.5);
		}
	}

	// c. Nota d'estudiant entre 0 i 10.
	private static void c_notaEstudiantEntre_0_i_10(boolean blnSuperior10) throws Exception {
		Estudiant estudiant = new Estudiant();

		estudiant.canviarNom("Erik");
		estudiant.assignarDni("51234567E");
		estudiant.posarNota("Programació", 7.5);
		estudiant.posarNota("Bases de dades", 6.5);
		estudiant.posarNota("Bioinformàtica", 8.5);
		estudiant.obtenirNotaMaxima();

        if (blnSuperior10) {
            estudiant.posarNota("Bases de dades", 12d);
        } else {
            estudiant.posarNota("Bioinformàtica", -1.5);
        }
	}

	// d. No es poden obtenir dades sense DNI o nom.
	private static void c_obtenirDadesSense_DNI_nom(boolean senseDNI) throws Exception {
		Persona persona = new Persona();

        if (senseDNI) {
            persona.canviarNom("Xavi");
        } else {
            persona.assignarDni("77777777X");
        }

		persona.obtenirDades();
	}

    private static void obtenirNotaMaximaMinimaMitjana() throws Exception {
        Estudiant estudiant = new Estudiant();

        estudiant.canviarNom("Jaime");
        estudiant.assignarDni("88888888J");

        estudiant.posarNota("Bases de dades", 7.5);
        estudiant.posarNota("Disseny d'Interfícies Web", 10d);
        estudiant.posarNota("Bioinformàtica", 8d);
        estudiant.posarNota("Sistemes informàtics", 6.5);

        estudiant.obtenirNotaMaxima();
        estudiant.obtenirNotaMinima();
		estudiant.obtenirNotaMitjana();
    }

	private static void programmaticBehavior() throws Exception {
		int opcioMenuPrincipal;
		Directori directori = new Directori();

		do {
			System.out.println(
				ANSI_BLUE + """
				\n
				-----------------------------------------------
				INTRODUEIX EL CODI DE LA OPERACIÓ QUE VOLS FER:
				-----------------------------------------------
				1) Veure la llista d’Instituts.
				2) Veure la informació completa d’un Institut.
				3) Afegir persona a un Institut.
				4) Eliminar un Institut.
				5) Crear un Institut.
				-----------------------------------------------
				0) Sortir de l'aplicació.
				-----------------------------------------------
				""" + ANSI_RESET
			);

			opcioMenuPrincipal = keybInputInt();

			switch (opcioMenuPrincipal) {
				case 1 -> directori.veureLlistaInstituts(false);
				case 2 -> directori.accioSobreInstitut("info");
				case 3 -> directori.afegirPersonaInstitut();
				case 4 -> directori.accioSobreInstitut("eliminar");
				case 5 -> directori.crearInstitut();
			}
		} while (opcioMenuPrincipal != 0);
	}
}