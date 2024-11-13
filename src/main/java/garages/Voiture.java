package garages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.PrintStream;
import java.util.*;

@RequiredArgsConstructor
@ToString
/**
 * Représente une voiture qui peut être stationnée dans des garages.
 */
public class Voiture {

	@Getter
	@NonNull
	private final String immatriculation;
	@ToString.Exclude // On ne veut pas afficher les stationnements dans toString
	private final List<Stationnement> myStationnements = new LinkedList<>();

	/**
	 * Fait rentrer la voiture au garage
	 * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws IllegalStateException Si déjà dans un garage
	 */

	public void entreAuGarage(Garage g) throws Exception{
		// Et si la voiture est déjà dans un garage ?
		if (myStationnements.isEmpty() || !myStationnements.get(myStationnements.size() - 1).estEnCours()) {
			Stationnement s = new Stationnement(this, g);
			myStationnements.add(s);
		} else {
			throw new java.lang.Exception("La voiture est déjà dans un garage!!");
		}
	}

	/**
	 * Fait sortir la voiture du garage
	 * Précondition : la voiture doit être dans un garage
	 *
	 * @throws IllegalStateException si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
		if (!myStationnements.isEmpty() && myStationnements.get(myStationnements.size() - 1).estEnCours()) {
			myStationnements.get(myStationnements.size() - 1).terminer();
			// Trouver le dernier stationnement de la voiture
			// Terminer ce stationnement
		}
		else {
		throw new java.lang.Exception("La voiture n'est pas dans un garage");
	}
}

		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement



	/**
	 * Calcule l'ensemble des garages visités par cette voiture
	 *
	 * @return l'ensemble des garages visités par cette voiture
	 */

	public Set<Garage> garageVisites() {
		Set<Garage> Garagesvu = new HashSet<Garage>();
		for (Stationnement s : myStationnements) {
			Garagesvu.add(s.getGarageVisite());
		}
		return Garagesvu;
	}

	/**
	 * Détermine si la voiture est actuellement dans un garage
	 *
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */

	public boolean estDansUnGarage() {
		if (!myStationnements.isEmpty() && myStationnements.get(myStationnements.size() - 1).estEnCours()) {
			return true;
		} else {
			return false;
		}
	}



	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
	 * dates d'entrée / sortie dans ce garage
	 * <br>
	 * Exemple :
	 *
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out pour imprimer dans la
	 *            console)
	 */


	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
		HashSet<Garage> ListeGarage = (HashSet<Garage>) this.garageVisites();

		for (Garage g : ListeGarage){
			out.println(g.toString());
			for (Stationnement s : myStationnements){
				if (s.getGarageVisite().equals(g)){
					out.println(s.toString());
				}
			}
		}
		// Utiliser les méthodes toString() de Garage et Stationnement
	}

}