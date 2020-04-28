package projetFinal.dao;

public class DaoObservationFactory {
	private static DaoObservation singleton = null;

	public static DaoObservation getInstance() {
		if (singleton == null) {
			singleton = new DaoObservationJpaImpl();
		}
		return singleton;
	}

	private DaoObservationFactory() {

	}

}
