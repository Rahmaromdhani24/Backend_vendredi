package com.projet.BackendPfe.Controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projet.BackendPfe.Entity.DossierMedical;
import com.projet.BackendPfe.repository.AdminMedicalManagerRepository;
import com.projet.BackendPfe.repository.DossierMedicalRepository;
import com.projet.BackendPfe.repository.MedecinRepository;
import com.projet.BackendPfe.repository.PatientRepository;
import com.projet.BackendPfe.services.DossierMedicalService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/DossierMedical")
public class DossierMedicalController {

	@Autowired DossierMedicalRepository  repository ; 
	@Autowired MedecinRepository  repositoryM ; 
	@Autowired PatientRepository  repositoryP ; 
	@Autowired AdminMedicalManagerRepository  repositoryA ;
	@Autowired DossierMedicalService  service ; 
	
	 @PostMapping("/add/{idMedecin}/{idPatient}/{adminM}")
	    public DossierMedical create(@PathVariable("idMedecin") long idMedecin ,
	    	                       	@PathVariable("idPatient") long idPatient ,
	    	                    	@PathVariable("adminM") long adminM ,
	    		                    @RequestBody DossierMedical dosssierMedicale){
	    
		 DossierMedical dossier = new DossierMedical( repositoryP.findById(idPatient).get(),new Date(),
				                                      dosssierMedicale.getDiagnostic(),
				                                      repositoryA.findById(adminM),
				                                      repositoryM.findById(idMedecin).get());
	        return repository.save(dossier);
	    }
	    @GetMapping("/all")
	    public List<DossierMedical> get(){
	        return service.getAll();
	    }
	    @PutMapping("update/{id}")
	    public DossierMedical update(@PathVariable int id ,@RequestBody DossierMedical dosssierMedicale){
	        return service.modifierDossier(id,dosssierMedicale);
	    }
	    @DeleteMapping("{id}")
	    public String delet(@PathVariable int id){
	        return service.SupprimerDossier(id);
	    }

	    @GetMapping("/get/{id}")
	    public DossierMedical getById(@PathVariable int id){
	        return service.getDossier(id);
	    }
}
