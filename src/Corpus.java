package com.company;

import java.util.*;

public class Corpus  {
	private String nom;
	private static int nbcorpus=0;
	private int id;
    private ArrayList<Document> documents;
	public Corpus(String nom) {
		documents=new ArrayList<Document>();
		this.nom=nom;
		nbcorpus++;
		id=nbcorpus;
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(ArrayList<Document> documents) {
		this.documents=documents;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}




	public void Ajouterdocument(Document document) {
            documents.add(document);
		document.setC(this);
		System.out.println("document ajouté");



	}


	public void Supprimerdocument(Document document) {
		// TODO - implement Corpus.Supprimerdocument
		documents.remove(document);
		System.out.println("document supprimé");
	}


	public void Afficherdocument(Document document) {
		ArrayList<String> mots=new ArrayList<String>();
		String mot;
		for(Document e:documents){
			if(e.equals(document)){
			 mots=e.getMots();
			System.out.println("touvé");
		}
	}
		for (int i =0;i<mots.size();i++){
			System.out.println("mot"+(i+1)+" "+mots.get(i));
		}
	}

	public int Nbdocuments() {

		return documents.size();
	}
    public  void finalize(){
		documents=null;
	}
}

