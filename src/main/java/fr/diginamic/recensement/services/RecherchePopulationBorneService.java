package fr.diginamic.recensement.services;

import java.util.List;

import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.Exception.MessageException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws NumberFormatException, MessageException{

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		if (!NumberUtils.isDigits(saisieMin)) {
			throw new MessageException("La valeur minimal doit être un nombre entier");
			
		} 
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		if (!NumberUtils.isDigits(saisieMax)) {
			throw new NumberFormatException("Le nombre doit être un entier positif " + saisieMax) ;
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		
		int max = Integer.parseInt(saisieMax) * 1000;
		
		 if (min > max) {
			throw new MessageException("Le maximun ne peut pas être inférieur au minimum");
		}
		
		List<Ville> villes = rec.getVilles();
		boolean verif =false;
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				verif = true;
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
		if (!verif) {
			throw new MessageException("Le code département n'est pas reconnu");
		}
	}

}
