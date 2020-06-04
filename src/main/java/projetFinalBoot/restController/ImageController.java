package projetFinalBoot.restController;

import java.io.IOException;

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

import projetFinalBoot.entity.Utilisateur;
import projetFinalBoot.models.ImageModel;
import projetFinalBoot.repository.ImageRepository;
import projetFinalBoot.service.UtilisateurService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rest/")
public class ImageController {
	

    @Autowired
    ImageRepository imageRepository;
    
    @Autowired
    UtilisateurService utilisateurService;

    @PostMapping("users/edit/upload/{id}")
    public ResponseEntity<ImageModel> uplaodImageUser(@RequestParam("myFile") MultipartFile file,@PathVariable("id") Integer id) throws IOException {
    	
    	
    	System.out.println("------------------------------------------------");
    	Utilisateur user = utilisateurService.findById(id).get();
    	
        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        
        if (user.getImageProfil()!=null) {
        	System.out.println("image existante");
			imageRepository.deleteById(user.getImageProfil().getId());
		}
        
        user.setImageProfil(img);
       
        final ImageModel savedImage = imageRepository.save(img);
        
        
        
        System.out.println("id image : "+user.getImageProfil().getId());
        System.out.println("pseudo : "+user.getPseudo());
        
        
        utilisateurService.save(user);
        
        System.out.println("------------------------------------------------");
        return new ResponseEntity<ImageModel>(savedImage, HttpStatus.OK);
    }

    
    @PostMapping("animal/{id}/upload")
    public ResponseEntity<ImageModel> uplaodImageAnimal(@RequestParam("myFile") MultipartFile file,@PathVariable("id") Integer id) throws IOException {

    	Utilisateur user = utilisateurService.findById(id).get();
    	
        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        
        if (user.getImageProfil()!=null) {
			imageRepository.deleteById(user.getImageProfil().getId());
		}
        
        user.setImageProfil(img);
        
        final ImageModel savedImage = imageRepository.save(img);
        utilisateurService.save(user);

        return new ResponseEntity<ImageModel>(savedImage, HttpStatus.OK);
    }
    
    @GetMapping("users/{id}/download")
    public ResponseEntity<ImageModel> downloadImage(@PathVariable("id") Integer id) throws IOException {
		return null;

    	
        //ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        //final ImageModel savedImage = imageRepository.save(img);

        //return new ResponseEntity<ImageModel>(savedImage, HttpStatus.OK);


    }
	
}
