package org.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;




@Entity
@Table(name="CLIENTS")
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLIENT")
	private Long codeClient;
	private String nomClient;
	private String adresseClient;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client(String nomClient,String adresseClient) 
	{
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}
	public Client()
	{
		super();
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	

}
