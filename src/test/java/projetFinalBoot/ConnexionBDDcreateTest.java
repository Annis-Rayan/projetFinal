package projetFinalBoot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;



import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.models.ImageModel;
import projetFinalBoot.repository.ImageRepository;

import projetFinalBoot.service.UtilisateurService;


@SpringBootTest
@Sql({"/suppr_shema.sql ", "/initbdd.sql"})//TODO inserer utilisateur,localisation id=1
public class ConnexionBDDcreateTest {
	
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@Test
	public void find() throws IOException {
		
		File file = new File("C:\\Users\\utilisateur\\Desktop\\Angular Projects\\projetFinalAngular\\src\\assets\\images\\2.jpg");
		
		
		Utilisateur user = utilisateurService.findById(1).get();
		ImageModel img = new ImageModel(file.getName(),"image/jpeg",Files.readAllBytes(file.toPath()));
		if (user.getImageProfil()!=null) {
			imageRepository.deleteById(user.getImageProfil().getId());
		}
		user.setImageProfil(img);
        
        final ImageModel savedImage = imageRepository.save(img);
        utilisateurService.save(user);
	}
	
	
}
