package projetFinalBoot.restController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(path = "/rest")
public class ImageController {
	

    @Autowired
    ImageRepository imageRepository;
    
    @Autowired
    UtilisateurService utilisateurService;

    @PostMapping("users/{id}/upload")
    public ResponseEntity<ImageModel> uplaodImageUser(@RequestParam("myFile") MultipartFile file,@PathVariable("id") Integer id) throws IOException {

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
    //{"","observation/{id}/upload",
    
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
    
    @PostMapping({"animal/{id}/download","observation/{id}/download","users/{id}/download"})
    public ResponseEntity<ImageModel> downloadImage(@RequestParam("myFile") MultipartFile file) throws IOException {

        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        final ImageModel savedImage = imageRepository.save(img);

        return new ResponseEntity<ImageModel>(savedImage, HttpStatus.OK);


    }
	
}
