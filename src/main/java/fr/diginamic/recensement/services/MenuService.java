package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.Exception.MessageException;
import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws MessageException 
	 * @throws NumberFormatException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws NumberFormatException, MessageException;
}
