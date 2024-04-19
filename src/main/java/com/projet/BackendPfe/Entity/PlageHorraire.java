package com.projet.BackendPfe.Entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "PlageHorraire")
public class PlageHorraire {

	/*** Association entre medecin et leur plage horraire ***/
		@ManyToOne
		@JoinColumn(name = "idMedecin")
		private Medecin medecin;
		
   /*** Association entre Plage horraire et Rendezvous 
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "rendezVous_id", referencedColumnName = "id")
		private RendezVous rendezVousPlageHorraire;***/
		@OneToOne
	    @JoinColumn(name = "rendez_vous_id")
	    private RendezVous rendezVous;

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int idPlage;
	    @Column(name ="date")
	    private Date date;
	    @Column(name ="nom")
	    private String nom;
	    @Column(name="HeureDebut")
	    private String HeureDebut;

	    @Column(name="HeureFin")
	    private String HeureFin;

	
	    
		public PlageHorraire(int idPlage, Date date, String heureDebut, String heureFin,String nom ,  Medecin medecin) {
			super();
			this.idPlage = idPlage;
			this.date = date;
			HeureDebut = heureDebut;
			HeureFin = heureFin;
			this.nom=nom ; 
			this.medecin = medecin;}

		public int getIdPlage() {
			return idPlage;
		}

		public void setIdPlage(int idPlage) {
			this.idPlage = idPlage;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getHeureDebut() {
			return HeureDebut;
		}

		public void setHeureDebut(String heureDebut) {
			HeureDebut = heureDebut;
		}

		public String getHeureFin() {
			return HeureFin;
		}

		public void setHeureFin(String heureFin) {
			HeureFin = heureFin;
		}

		public Medecin getMedecin() {
			return medecin;
		}

		public void setMedecin(Medecin medecin) {
			this.medecin = medecin;
		}
		
		public PlageHorraire() {
			super();
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public RendezVous getRendezVous() {
			return rendezVous;
		}
		
		public void setRendezVous(RendezVous rendezVous) {
			this.rendezVous = rendezVous;
		}
		
}
