
/**
 * Write a description of FindingAGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class FindingAGene {
    public String findProtein(String dnaString){
        String dna = dnaString.toLowerCase();
        System.out.println("Find Gene In DNA String: " + dna);
        int start = dna.indexOf("atg");
        
        if(start == -1){
            return "";
        }
        int  stop = dna.indexOf("tag",start+3);
        int stop2 = dna.indexOf("tga",start+3);
        int stop3 = dna.indexOf("taa",start+3);
        if((stop-start)%3 == 0){
            //System.out.println("Stop Codon: " + dna.substring(stop,stop+3));
            return dna.substring(start,stop+3);
           
            
        }
        else if((stop2 - start)%3 == 0){
            //System.out.println("Stop Codon:" + dna.substring(stop2,stop2+3));
            return dna.substring(start,stop2+3);

        }
        else if ((stop3-start)%3 == 0){
            //System.out.println("Stop Codon:" + dna.substring(stop3,stop3+3));
            return dna.substring(start,stop3+3);
           
        }
        else{
            return "";
        }
    }
    
    public String stopCodon(String gene){
        int size = gene.length();
        if ( size > 6 ) {
        return gene.substring(size - 3, size);
    }
        else {
            return "";
        }
    }
    
    public void testTagFinder(){
        String result = findProtein("AAATGCCCTAACTAGATTGAAACC");
        System.out.println("Gene Found:" + result);
        System.out.println("Stop Codon:"+stopCodon(result));
    }
    
}

