package src.Eredua;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PartidaErregistro extends Observable{
	private static PartidaErregistro nPartidaErregistro;
	private String[] izenak = new String[5];
	private String[] scoreak = new String[5];
	
	private PartidaErregistro() {}
	
	public static PartidaErregistro getPartidaErregistro() {
		if(nPartidaErregistro == null) {
			nPartidaErregistro = new PartidaErregistro();
		}
		return nPartidaErregistro;
	}
	
	public String getLeh() {
		return izenak[0];
	}
	
	public String getLehSc() {
		return scoreak[0];
	}
	
	public String getBig() {
		return izenak[1];
	}
	
	public String getBigSc() {
		return scoreak[1];
	}
	
	public String getHir() {
		return izenak[2];
	}
	
	public String getHirSc() {
		return scoreak[2];
	}
	
	public String getLau() {
		return izenak[3];
	}
	
	public String getLauSc() {
		return scoreak[3];
	}
	
	public String getBos() {
		return izenak[4];
	}
	
	public String getBosSc() {
		return scoreak[4];
	}
	
	public void getLehenengoBostak() {
		Path bidea = Paths.get("TamagotchiDB/TamagotchiDB.txt");
		try{
			List<String> lerroak = Files.readAllLines(bidea, Charset.forName("ISO-8859-1"));
			IntStream.range(0,5).forEach(i -> {
				String[] zatiak = lerroak.get(i).split(" ### ");
				izenak[i] = zatiak[0];
				scoreak[i] = zatiak[1];
			});
			setChanged();
			notifyObservers();
		}catch(IOException e) {
			e.printStackTrace();
		}        
    }

	public void eguneratu(int pScore, String pJokalaria){
		File file= new File("TamagotchiDB/TamagotchiDB.txt");
		String[] izenakAux = new String[5];
		String[] scoreakAux = new String[5];
		int i = 0;
		int j = 0;
		boolean amaitu = false;
		while (j < 5) {
			if ((pScore > Integer.parseInt(scoreak[i])) && !amaitu) {
				izenakAux[j] = pJokalaria;
				scoreakAux[j] = Integer.toString(pScore);
				j++;
				amaitu = true;
			}
			else{
				izenakAux[j] = izenak[i];
				scoreakAux[j] = scoreak[i];
				i++;
				j++;
			}
		}
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			i = 0;
			while (i < 5) {
				writer.write(izenakAux[i] + " ### " + scoreakAux[i]);
				writer.newLine();
				i++;
			}
			writer.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}

	public void reset(){
		File file= new File("TamagotchiDB/TamagotchiDB.txt");
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();
			izenak[0]="Ongi Etorri";
			izenak[1]="Bienvenido";
			izenak[2]="Welcome";	
			izenak[3]="Bienvenue";	
			izenak[4]="Benvenuto";	
			scoreak[0]="0";
			scoreak[1]="0";
			scoreak[2]="0";
			scoreak[3]="0";
			scoreak[4]="0";
			String[] izenakAux = new String[5];
			String[] scoreakAux = new String[5];
			int i = 0;
			int j = 0;
			while (j < 5) {
				izenakAux[j] = izenak[i];
				scoreakAux[j] = scoreak[i];
				i++;
				j++;
			}
			FileWriter fw1 = new FileWriter(file);
			BufferedWriter writer2 = new BufferedWriter(fw1);
			i = 0;
			while (i < 5) {
				writer2.write(izenakAux[i] + " ### " + scoreakAux[i]);
				writer2.newLine();
				i++;
			}
			writer2.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
}
