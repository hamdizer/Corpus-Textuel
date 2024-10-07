package com.company;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
public class Main {

    public static void main(String[] args) {
        String s1=new String("je");
        String s2=new String("suis");
        String s3=new String("je");
        String s4=new String("un");
        String s5=new String("informaticien");
        String s6=new String("je");
        String s7=new String("prj");
        String s8=new String("je");
        String s9=new String("un");
        String s10=new String("TextMining");
        Corpus c=new Corpus("Corpus");
        System.out.println(c.getId());
         Document d=new Document(c,"Document1");
         System.out.println(d.getId());
         Document f=new Document(c,"Document2");
         System.out.println(f.getId());
        // f.getMots().add(s1);
         f.getMots().add(s2);
        d.getMots().add(s1);
        d.getMots().add(s2);
        d.getMots().add(s3);
        d.getMots().add(s4);
        d.getMots().add(s5);
        d.getMots().add(s6);

        Document e=new Document(c,"Document3");
        System.out.println(e.getId());
        e.getMots().add(s7);
        e.getMots().add(s8);
        e.getMots().add(s9);
        e.getMots().add(s10);
        System.out.println("Nombre de mot du document "+e.getMots().size());
        c.Ajouterdocument(d);
        c.Ajouterdocument(e);
        c.Ajouterdocument(f);

        c.Afficherdocument(d);
       // c.Supprimerdocument(d);
        c.Afficherdocument(e);
        System.out.println("nb total de mots "+c.Nbdocuments());
        System.out.println("nb total de mots "+e.NbtotalMots());

        ArrayList<String > dist= d.ListemotsDist();
       for(int i=0;i<dist.size();i++){
            System.out.println("mot "+(i+1)+" "+dist.get(i));
        }
        System.out.println("nb total de mots "+d.NbtotalMots());
       int[] tab=d.freqMots();
       for(int i=0;i<tab.length;i++)
           System.out.println("fréquence du mot "+dist.get(i)+" est "+tab[i]);
       System.out.println("distance entre document d et document e "+d.distance(e));
       System.out.println("distance entre document e et document f "+e.distance(f));
       ArrayList<Document> docs=e.docsterme("je");
       System .out.println("les document qui contiennet le mot je sont: ");
       for(int i=0;i<docs.size();i++) {
    	   System.out.println("id: "+docs.get(i).getId()+",nom :"+docs.get(i).getNom());
       }

       System.out.println("Le document le plus proche est au document e est " +e.plusProche().getNom());






    }
	//lectures des mots à partie d' un fichier
	/*public static void main(String[] args) throws IOException {
	    FileReader fr=new FileReader("file.txt");
	  BufferedReader br=new BufferedReader(fr);
	    Corpus c=new Corpus("corpus 1");
	    Document d=new Document(c,"document 1");
	    String line=br.readLine();
	    String []mots=null;

	    while (line!=null){
	        mots=line.split(" ");
	        line=br.readLine();



	    }
	    for (int i=0;i<mots.length;i++){
	        d.getMots().add(mots[i]);
	    }



	    System.out.println("Le nombre de mot du document est :"+d.getMots().size());
	    ArrayList<String>ms=d.ListemotsDist();
	    for(int i=0;i<ms.size();i++){
	        System.out.println("mot "+(i+1)+" "+ms.get(i));
	    }
	    int[] freq= d.freqMots();
	    for(int i=0;i<ms.size();i++)
	        System.out.println("fréquence du mot "+ms.get(i)+" est "+freq[i]);




	}*/

}