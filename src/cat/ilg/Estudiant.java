package cat.ilg;

import java.util.Map;
import java.util.HashMap;

public class Estudiant extends Persona {
	private final HashMap<String, Double> nota = new HashMap<>();

	public void posarNota(String assignatura, Double nota) throws Exception {
		String strMessage = "";

		if ("".equals(assignatura))
			throw new Exception("S'ha d'indicar l'assignatura.");

		if (nota > 10)
			strMessage = "superior a 10.";

		if (nota < 0)
			strMessage = "inferior a 0.";

		if (!"".equals(strMessage))
			throw new Exception("La nota ("+ nota +") no pot ser " + strMessage);

		this.nota.put(assignatura, nota);
	}

	@Override
	public String obtenirDades() throws Exception {
		StringBuilder strAssignatures = new StringBuilder();

		for (Map.Entry<String, Double> entry : nota.entrySet())
			strAssignatures.append("\nAssignatura:\t")
							.append(entry.getKey())
							.append("\nNota:\t\t\t")
							.append(entry.getValue());

		return super.obtenirDades() + strAssignatures + "\n-----------------------------------------";
	}

	public void obtenirNotaMaxima() {
		Map.Entry<String, Double> max = null;

		for (Map.Entry<String, Double> entry : nota.entrySet())
			if (max == null || max.getValue() < entry.getValue())
				max = entry;

		assert max != null;
		System.out.println(	"\nLa tona màxima és " + max.getValue() +
							", correspon a la assignatura - "+ max.getKey());
	}

	public void obtenirNotaMinima() {
		Map.Entry<String, Double> min = null;

		for (Map.Entry<String, Double> entry : nota.entrySet())
			if (min == null || min.getValue() > entry.getValue())
				min = entry;

		assert min != null;
		System.out.println(
			"La tona mínima és: " + min.getValue() + ", " +
			"correspon a la assignatura - "+ min.getKey()
		);
	}

	public void obtenirNotaMitjana() {
		Double totalGrade = 0d;
		int totalSubjects;
		double avg;

		for (Map.Entry<String, Double> entry : nota.entrySet())
			totalGrade += entry.getValue();

		totalSubjects = nota.size();
		avg = totalGrade / totalSubjects;

		System.out.println("La mitjana de totes les assignatures és: " + avg);
	}
}
