
public class Condition {

	Comparaison[] comparaisons;
	Fait fait;

	public Condition(Comparaison[] compa, Fait fact){
		this.comparaisons = compa;
		this.fait = fact;
	}
	
	/** M�thode pour �valuer une comparaison
	 * 
	 * @return la v�racit� de la comparaison
	 */
	public boolean evalComp(Comparaison c){
		boolean b;
		double a = this.fait.data[Integer.valueOf(c.comp[0])];
		double nb = Double.valueOf(c.comp[2]);
		switch(c.comp[1]){
		case "<": b = a < nb;
		break;
		case ">": b = a > nb;
		break;
		case "<=": b = a <= nb;
		break;
		case ">=": b = a >= nb;
		break;
		case "==": b = a == nb;
		default: b = true;
		break;
		}
		return b;
	}

	/** M�thode pour �valuer la condition
	 * 
	 * @return la v�racit� de la condition
	 */
	public boolean eval(){
		boolean b = true;
		boolean bc;
		for(int i = comparaisons.length - 1; i == 0; i--){
			bc = evalComp(comparaisons[i]);
			b = b && bc;
		}
		return b;
	}
}
