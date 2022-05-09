package cat.ilg;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ProfessorSubstitut extends Professor {
	private Date dataInici;
	private Date dataFi;

	public void assignarSubstitucio (Date dataInici, Date dataFi) {
		this.dataInici = dataInici;
		this.dataFi = dataFi;
	}

	@Override
	public String obtenirDades() throws Exception {
		if (this.dataInici == null || this.dataFi == null) {
			return	super.obtenirDades() + "\n-----------------------------------------";
		} else {
			return	super.obtenirDades() +
					"Data d'inici:\t" + new SimpleDateFormat("dd-MM-yyyy").format(this.dataInici) +
					"Data fi:\t\t" + new SimpleDateFormat("dd-MM-yyyy").format(this.dataFi);
		}
	}
}
