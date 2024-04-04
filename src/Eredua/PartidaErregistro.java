package src.Eredua;
import java.util.*;
import java.io.*;

public class PartidaErregistro extends Observable{
	private static PartidaErregistro nPartidaErregistro;
	private String leh;
	private String big;
	private String hir;
	private String lau;
	private String bos;
	private String lehSc;
	private String bigSc;
	private String hirSc;
	private String lauSc;
	private String bosSc;
	
	
	public PartidaErregistro() {
	}
	
	public static PartidaErregistro getPartidaErregistro() {
		if(nPartidaErregistro == null) {
			nPartidaErregistro = new PartidaErregistro();
		}
		return nPartidaErregistro;
	}
	
	public String getLeh() {
		return leh;
	}
	
	public String getLehSc() {
		return lehSc;
	}
	
	public String getBig() {
		return big;
	}
	
	public String getBigSc() {
		return bigSc;
	}
	
	public String getHir() {
		return hir;
	}
	
	public String getHirSc() {
		return hirSc;
	}
	
	public String getLau() {
		return lau;
	}
	
	public String getLauSc() {
		return lauSc;
	}
	
	public String getBos() {
		return bos;
	}
	
	public String getBosSc() {
		return bosSc;
	}
	
	public void getLehenengoBostak() {
		File file= new File(this.getClass().getResource("/TamagotchiDB/TamagotchiDB.txt").toString().replace("file:/", ""));
        
        try{
        	
            Scanner entrada = new Scanner(new FileReader(file));
            String linea;
            int kont = 0;
            while (entrada.hasNext() && kont <5) {
                linea = entrada.nextLine();
                String[] parts = linea.split(" ### ");
                String izena = parts[0];
                String score = parts[1];
                
                if (kont == 0) {
                	leh= izena;        
                	lehSc = score;
                }
           
                if (kont == 1) {
                	big= izena;
                	bigSc = score;
                }
                
                if (kont == 2) {
                	hir=izena;
                	hirSc = score;
                }
                
                if (kont == 3) {
                	lau= izena;
                	lauSc = score;
                }
                
                if (kont == 4) {
                	bos=izena;
                	bosSc = score;
                }

                kont++;
            }
            entrada.close();
            setChanged();
            notifyObservers();
            
        }
        catch(IOException e) {e.printStackTrace();}

        
    }

	public void eguneratu(int pScore, String pJokalaria){
		File file= new File(this.getClass().getResource("/TamagotchiDB/TamagotchiDB.txt").toString().replace("file:/", ""));
		String[] izenak = {leh, big, hir, lau, bos};
		String[] scoreak = {lehSc, bigSc, hirSc, lauSc, bosSc};
		String[] izenakAux = new String[5];
		String[] scoreakAux = new String[5];
		int i = 0;
		int j = 0;
		while (i < 5) {
			if (pScore > Integer.parseInt(scoreak[i])) {
				izenakAux[j] = pJokalaria;
				scoreakAux[j] = Integer.toString(pScore);
				j++;
			}
			izenakAux[j] = izenak[i];
			scoreakAux[j] = scoreak[i];
			i++;
			j++;
		}
		try {
			PrintWriter writer = new PrintWriter(file);
			i = 0;
			while (i < 5) {
				writer.println(izenakAux[i] + " ### " + scoreakAux[i]);
				i++;
			}
			writer.close();
		}
		catch(IOException e) {e.printStackTrace();}
		getLehenengoBostak();
	}
	
 
}
