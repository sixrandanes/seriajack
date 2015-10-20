package com.seriajack.textereglementaire;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "T_TEXTE_REGLEMENTAIRE", schema = "SERIAJACK")
public class TexteReglementaire {

	private long id;
	private TexteType type;
	private String numero;
	private String intitule;
	private LocalDate dateCreation;
	@Lob
	private byte[] fichier;
	private String precision;
	private LocalDate dateCertification;
	private LocalDate dateParution;
	private String numeroJONC;
	private LocalDate dateAbrogation;
	private String reference;
	private String lienJuridoc;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TTEXTEREG")
	@SequenceGenerator(name = "SEQ_TTEXTEREG", sequenceName = "SERIAJACK.SEQ_TTEXTEREG")
	@Column(name = "ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	public TexteType getType() {
		return type;
	}

	public void setType(TexteType type) {
		this.type = type;
	}

	@Column(name = "NUMERO", nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "INTITULE", nullable = false)
	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Column(name = "DATE_CREATION", nullable = false)
	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Column(name = "FICHIER", nullable = false)
	public byte[] getFichier() {
		return fichier;
	}

	public void setFichier(byte[] fichier) {
		this.fichier = fichier;
	}

	@Column(name = "PRECISION")
	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	@Column(name = "DATE_CERTIFICATION")
	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getDateCertification() {
		return dateCertification;
	}

	public void setDateCertification(LocalDate dateCertification) {
		this.dateCertification = dateCertification;
	}

	@Column(name = "DATE_PARUTION")
	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getDateParution() {
		return dateParution;
	}

	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}

	@Column(name = "NUMERO_JONC")
	public String getNumeroJONC() {
		return numeroJONC;
	}

	public void setNumeroJONC(String numeroJONC) {
		this.numeroJONC = numeroJONC;
	}

	@Column(name = "DATE_ABROGATION")
	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getDateAbrogation() {
		return dateAbrogation;
	}

	public void setDateAbrogation(LocalDate dateAbrogation) {
		this.dateAbrogation = dateAbrogation;
	}

	@Column(name = "REFERENCE")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "LIEN_JURIDOC")
	public String getLienJuridoc() {
		return lienJuridoc;
	}

	public void setLienJuridoc(String lienJuridoc) {
		this.lienJuridoc = lienJuridoc;
	}

}
