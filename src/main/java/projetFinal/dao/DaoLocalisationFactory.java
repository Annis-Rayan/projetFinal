package projetFinal.dao;


public class DaoLocalisationFactory {
	private static DaoLocalisation singleton = null;

	public static DaoLocalisation getInstance() {
		if (singleton == null) {
			singleton = new DaoLocalisationJpaImpl();
		}
		return singleton;
	}

	private DaoLocalisationFactory() {

	}
}
