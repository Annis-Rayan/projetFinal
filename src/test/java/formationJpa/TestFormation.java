package formationJpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.entity.Formation;

public class TestFormation {

	public static void main(String[] args) {
		Formation f = new Formation("java");
		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			f.setDateFormation(sdf.parse("10/02/2019"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		daoFormation.insert(f);
		
		Optional<Formation> opt = daoFormation.findByKey(f.getId());
		System.out.println(sdf.format(opt.get().getDateFormation()));

	}

}
