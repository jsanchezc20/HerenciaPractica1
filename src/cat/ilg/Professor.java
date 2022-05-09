package cat.ilg;

import static cat.ilg.Utils.comprovaDada;

public class Professor extends Persona {
	private Double sou;

	public void canviarSou(Double sou) throws Exception {

		String strMessage = "";

		if (sou > 3000)
			strMessage = "superior a 3000€.";

		if (sou < 0)
			strMessage = "inferior a 0€.";

		if (!"".equals(strMessage))
			throw new Exception("El sou ("+ sou +"€) no pot ser " + strMessage);

		this.sou = sou;
	}

	@Override
	public String obtenirDades() throws Exception {
		return	super.obtenirDades() +
				"\nSou:\t\t\t" + (this.sou != null ? comprovaDada(this.sou) : "No informat") +
				"\n-----------------------------------------";
	}

}
