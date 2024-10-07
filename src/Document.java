package com.company;

import java.util.ArrayList;
import java.math.*;

public class Document  {
	private ArrayList<String> mots;
	private static int nbdocs=0;
	private int id;
	private String nom;
	private Corpus c;
	public Corpus getC() {
		return c;
	}




	public Document(Corpus c ,String nom){
		mots=new ArrayList<String>();
		this.id=id;
        this.c=c;
        this.nom=nom;
        nbdocs++;
        id=nbdocs;
	}
    public ArrayList<String> getMots() {
        return mots;
    }

    public void setMots(ArrayList<String> mots) {
        this.mots = mots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Corpus getC(Corpus c) {
        return c;
    }

    public void setC(Corpus c) {
        this.c = c;
    }


    public ArrayList<String> ListemotsDist() {

        ArrayList<String> dist = new ArrayList<String>();
        dist.add(mots.get(0));
        for (int i=1;i<mots.size();i++){
            if(dist.contains(mots.get(i)))
			{

			}
            else
           dist.add(mots.get(i));


         }
        return dist;
    }

	public int[] freqMots() {
		int[] tab=new int[ListemotsDist().size()];
		for(int i=0;i<ListemotsDist().size();i++){
			String ch=ListemotsDist().get(i);
			for(int j=0;j<mots.size();j++) {
				if (mots.get(j).equals(ch)) {
					tab[i]++;
				}
			}
		}
return  tab;
	}

	public int NbtotalMots() {
		int c=0;
		for(String m:mots) {
			if (m!=" ")
			c++;
		}
	return  c;
	}
	public ArrayList<Document> docsterme(String ch){
		ArrayList<Document>docs=new ArrayList<Document>();
		Corpus c=this.c;
	 for(int i=0;i<this.c.getDocuments().size();i++) {
		 for(int j=0;j<c.getDocuments().get(i).ListemotsDist().size();j++) {
				 if(c.getDocuments().get(i).ListemotsDist().get(j).contains(ch))
					 docs.add(c.getDocuments().get(i));
			 }
	
	 }
	
		
		
		
		
		return docs;
	}




	public double distance(Document document) {
return Math.sqrt(Math.pow(id-document.id,2)+Math.pow(mots.size()-document.mots.size(),2));
	}
   public Document plusProche(){
		Corpus cor=this.c;
		Document less = c.getDocuments().get(0);
		double dismin;
	    for(int i=1;i<c.getDocuments().size();i++){
            if(c.getDocuments().get(i).distance(this)<less.distance(this))
                less=c.getDocuments().get(i);

	    }




       return less;
   }}

