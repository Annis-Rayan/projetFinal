package projetFinalBoot.restController;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import projetFinalBoot.entity.Animal;
import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.models.ImageModel;
import projetFinalBoot.repository.ImageRepository;
import projetFinalBoot.service.AnimalService;
import projetFinalBoot.service.UtilisateurService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rest")
public class ImageController {
	

    @Autowired
    ImageRepository imageRepository;
    
    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    AnimalService animalService;

    @PostMapping("users/edit/upload/{id}")
    public ResponseEntity<ImageModel> uplaodImageUser(@RequestParam("myFile") MultipartFile file,@PathVariable("id") Integer id) throws IOException {
    	
    	Utilisateur user = utilisateurService.findById(id).get();
    	
        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        
        if (user.getImageProfil()!=null) {
        	ImageModel img2=user.getImageProfil();
        	user.setImageProfil(null);
        	utilisateurService.save(user);
			imageRepository.deleteById(img2.getId());
		}
        
       
        final ImageModel savedImage = imageRepository.save(img);
        
        user.setImageProfil(savedImage); 
        
        utilisateurService.save(user);

        return new ResponseEntity<ImageModel>(savedImage, HttpStatus.OK);
    }

    
    @PostMapping("animal/edit/upload/{id}")
    public ResponseEntity<ImageModel> uplaodImageAnimal(@RequestParam("myFile") MultipartFile file,@PathVariable("id") Integer id) throws IOException {

    	Animal animal = animalService.findById(id).get();
    	
        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        
        if (animal.getEmplacementImage()!=null) {
        	ImageModel img2=animal.getEmplacementImage();
        	animal.setEmplacementImage(null);
        	animalService.save(animal);
			imageRepository.deleteById(img2.getId());
		}
        
       
        final ImageModel savedImage = imageRepository.save(img);
        
        animal.setEmplacementImage(savedImage); 
        
        animalService.save(animal);

        return new ResponseEntity<ImageModel>(savedImage, HttpStatus.OK);
    }
    
}
