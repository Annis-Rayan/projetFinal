package projetFinal.dao;

public class DaoSignalementFactory {
	private static DaoSignalement singleton = null;

	public static DaoSignalement getInstance() {
		if (singleton == null) {
			singleton = new DaoSignalementJpaImpl();
		}
		return singleton;
	}

	private DaoSignalementFactory() {

	}

}
