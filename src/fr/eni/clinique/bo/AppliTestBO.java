package fr.eni.clinique.bo;

import java.util.ArrayList;
import java.util.List;

public class AppliTestBO {

	public static void main(String[] args) {

		//Création d'une collection d'objets type Animal
		List<Animal> animalListe=null;
		animalListe = new ArrayList<Animal>();
		
		//Test de la création d'objet type Animal
		Animal a1 = new Animal(825, "Bill", 'H', "Tigré", "Burmese", "Chat", 15);
		Animal a2 = new Animal(451, "Penny", 'F', "Blanc et Noir", "Dalmatien", "Chien", 1);
		animalListe.add(a1);
		animalListe.add(a2);
		
		//Création d'une collection d'objets type Personnel
		List<Personnel> personnelListe=null;
		personnelListe = new ArrayList<Personnel>();
		
		//Test de la création d'objet type Animal
		Personnel p1 = new Personnel("De Jeu Odette", "3685", "vet");
		Personnel p2 = new Personnel("Bosapin Edmond", "4325", "adm");
		personnelListe.add(p1);
		personnelListe.add(p2);
		
		//Création d'une collection d'objets type Clients
		List<Client> clientListe=null;
		clientListe = new ArrayList<Client>();
				
		//Test de la création d'objet type Animal
		Client c1 = new Client(0, "Honnete", "Camille", "25, rue des Magnolias", "44200", "Nantes", "02.40.80.50.12", "xx", "honnete.camille@gmail.com");
		Client c2 = new Client(1, "Fissile", "Teddy", "4, boulevard des Anglais", "44000", "Nantes", "06.50.74.21.29", "xx", "fissile.teddy@gmail.com");
		clientListe.add(c1);
		clientListe.add(c2);
		
		
	
	}

}
