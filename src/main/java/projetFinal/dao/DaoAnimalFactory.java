package projetFinal.dao;

import projetFinal.dao.DaoAnimal;
import projetFinal.dao.DaoAnimalJpaImpl;

public class DaoAnimalFactory {

	private static DaoAnimal singleton = null;

	public static DaoAnimal getInstance() {
		if (singleton == null) {
			singleton = new DaoAnimalJpaImpl();
		}
		return singleton;
	}
}
