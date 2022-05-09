package cat.ilg;

public class Persona {
	private String dni;
	private String nom;
	private boolean isList = false;

	public void canviarNom(String nom) {
		this.nom = nom;
	}

	public void assignarDni(String dni) throws Exception {
		if (!"".equals(this.dni) && this.dni != null)
			throw new Exception(
				"Aquest/a " + this.getClass().getSimpleName() +
				" ja te dni assignat."
			);
		this.dni = dni;
	}

	public String obtenirDades() throws Exception {
		String strMessage= "";
		
		if (!isList && "".equals(this.nom) | this.nom == null)
			strMessage = "nom";
		
		if (!isList && ("".equals(this.dni) | this.dni == null))
			strMessage = "DNI";

		if (!"".equals(strMessage))
			throw new Exception(
					"Aquest/a "+ getClass().getSimpleName() +
					" no te " + strMessage +" assignat."
			);

		return 	"\n-----------------------------------------" +
				"\nDADES DE " + this.getClass().getSimpleName().toUpperCase() + "." +
				"\n-----------------------------------------" +
				"\nNom:\t\t\t" + Utils.comprovaDada(this.nom) +
				"\nDni:\t\t\t" + Utils.comprovaDada(this.dni);
	}

	public void setList(boolean isList) {
		this.isList = isList;
	}
}


