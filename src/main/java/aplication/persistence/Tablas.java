package aplication.persistence;

import aplication.model.Batalla;
import aplication.model.Freestyler;
import aplication.model.Juez;

public class Tablas {
	
	public void crearTablas() {

		
				
		
        //Creamos los freestylers

        Freestyler mc1 = new Freestyler("Aczino", 38);
        Freestyler mc2 = new Freestyler("Gazir", 20);
        Freestyler mc3 = new Freestyler("CarpeDiem", 22);
        Freestyler mc4 = new Freestyler("Rapder", 26);
        
        
        //Creamos la batalla y añadimos los mcs
        Batalla octavos = new Batalla();
        Batalla cuartos = new Batalla();
        
        octavos.getFreestylers().add(mc1);
        octavos.getFreestylers().add(mc2);
        octavos.getFreestylers().add(mc3);
        octavos.getFreestylers().add(mc4);
        
        cuartos.getFreestylers().add(mc1);
        cuartos.getFreestylers().add(mc3);
        
        mc1.getBatallas().add(octavos);
        
        mc1.getBatallas().add(cuartos);
        
        mc2.getBatallas().add(octavos);
        
        mc3.getBatallas().add(octavos);
        
        mc3.getBatallas().add(cuartos);
        
        mc4.getBatallas().add(octavos);
        
        //Creamos el juez y lo asociamos a la batalla
        Juez juez1 = new Juez("Carlos");
        Juez juez2 = new Juez("Kapo");
        Juez juez3 = new Juez("Piezas");
        
        juez1.getbatallas().add(octavos);
        
        juez1.getbatallas().add(cuartos);
        
        juez2.getbatallas().add(octavos);
        
        juez2.getbatallas().add(cuartos);
        
        juez3.getbatallas().add(octavos);
        
        juez3.getbatallas().add(cuartos);
        
        octavos.setJuez(juez1);
        octavos.setJuez(juez2);
        octavos.setJuez(juez3);
        
        cuartos.setJuez(juez1);
        cuartos.setJuez(juez2);
        cuartos.setJuez(juez3);
        
        //Volcamos los objetos en la BBDD       
        JuezDAO crudJuez = new JuezDAO();
        FreestylerDAO  crudFreestyler = new FreestylerDAO( );
        BatallaDAO  crudBatalla = new BatallaDAO();
        
        crudJuez.insertarJuezJPA(juez1);
        crudJuez.insertarJuezJPA(juez2);
        crudJuez.insertarJuezJPA(juez3);
        
        crudBatalla.insertarBatallaJPA(octavos);
        crudBatalla.insertarBatallaJPA(cuartos);
        
        crudFreestyler.insertarFreestylerJPA(mc1);
        crudFreestyler.insertarFreestylerJPA(mc2);
        crudFreestyler.insertarFreestylerJPA(mc3);
        crudFreestyler.insertarFreestylerJPA(mc4);
        
	}

}
