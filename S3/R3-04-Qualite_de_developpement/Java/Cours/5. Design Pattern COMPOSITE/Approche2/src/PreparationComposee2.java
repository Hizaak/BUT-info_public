/**
 * Classe : PreparationComposee2
 * Objectif : Tester l'approche 2 du Patron Composite qui d�finit...
 * ... les m�thodes de la composition uniquement au niveau du Compos�
 * @version 1.0
 * @author Lopist�guy Philippe
 * @date jj/mm/aa
 **/

import java.util.*;

public class PreparationComposee2 extends PreparationDeCuisine2 {
// CONSTANTES 				-non-
// ATTRIBUTS 				
	private Set<PreparationDeCuisine2> enfants = new HashSet<PreparationDeCuisine2>();

// CONSTRUCTEURS PreparationComposee2, PreparationComposee2(String, int)
	public PreparationComposee2() {
		super();
	}
	public PreparationComposee2(String libelle, int prix) {
		super (libelle, prix);
	}

// METHODES D'ENCAPSULATION getPrix
	public int getPrix() {
		int resultat = this.prix;
		for (PreparationDeCuisine2 preparation : enfants) {
			resultat += preparation.getPrix();
		}
		return resultat;
	}
// METHODES USUELLES 		toString
	public String toString (String message) {
		String resultat;
		resultat = message + this.getLibelle() + ": prix ("+this.getPrix() + ") dont ("+this.prix+")\n";
		for (PreparationDeCuisine2 preparation : enfants) {
			resultat += preparation.toString(message + "..");
		}
		return resultat;
	}
	
// METHODE SPECIFIQUE       ajouterPreparationDeCuisine, supprimerPreparationDeCuisine, existePreparationDeCuisine
	public boolean ajouterPreparationDeCuisine (PreparationDeCuisine2 preparation) {
		return enfants.add(preparation);
	}
	public boolean retirerPreparationDeCuisine (PreparationDeCuisine2 preparation) {
		return enfants.remove(preparation);
	}
	public boolean existePreparationDeCuisine (PreparationDeCuisine2 preparation) {
		return enfants.contains(preparation);
	}
}