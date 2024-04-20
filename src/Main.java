
package src;

import src.Bista.HasieraMenua;
import src.Eredua.PartidaErregistro;

public class Main {
    public static void main(String[] args) {
        PartidaErregistro.getPartidaErregistro().reset();
        /*PartidaErregistro.getPartidaErregistro().getLehenengoBostak();
        PartidaErregistro.getPartidaErregistro().eguneratu(78, "Jon Ander");
        System.out.println(PartidaErregistro.getPartidaErregistro().getLauSc());*/
        HasieraMenua.main(args);
	}
}
