//package fr.eni.clinique.ihm;
//
//import java.util.List;
//
//import fr.eni.clinique.bo.Personnel;
//
//
//
//
//public class LoginController {
//	
//	private EcranLogin ecranLogin ;
//	//Attributs
//	
//	private List<Personnel> listePersonnel;
//	
//	private static LoginController instanceLogin;
//	
//
//	//Méthodes
//	public static synchronized LoginController get(){
//		if(instanceLogin == null){
//			instanceLogin = new LoginController();
//		}
//		return instanceLogin;
//	}
//	
//	public void startApp(){
//		ecranLogin = new EcranLogin();
//		
//		afficherPremierArticle();
//		ecranArticle.setVisible(true);
//	}
//
//	public void login() {
//		Article articleAffiche = ecranArticle.getArticle();
//		
//		try {
//			if(articleAffiche.getIdArticle()==null){
//				catalogueManager.addArticle(articleAffiche);
//				System.out.println("article: " + articleAffiche);
//				catalogue.add(articleAffiche);
//				ecranArticle.afficherArticle(articleAffiche);
//			}else{
//				catalogueManager.updateArticle( articleAffiche);
//				catalogue.set(indexCatalogue, articleAffiche);
//			}
//		} catch (BLLException e1) {
//			ecranArticle.infoErreur("Erreur enregistrement.");
//			
//			e1.printStackTrace();
//		}
//		
//	}
//
//}