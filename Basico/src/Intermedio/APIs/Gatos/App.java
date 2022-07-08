package Intermedio.APIs.Gatos;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        int opcionMenu = -1;
        
        String[] botones = {
            "1. Ver gatos",
            "2. Ver favoritos",
            "3. Salir"
        };

        do {
            //Menu principal
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos", 
                            "Menu principal", JOptionPane.INFORMATION_MESSAGE, null, botones,botones[0]);

            //Validamos que opcion selecciona el usuario
            for(int i=0 ; i<botones.length ; i++){
                if(opcion.equals(botones[i])){
                    opcionMenu = i;
                }
            }

            switch(opcionMenu){
                case 0:
                    GatosService.verGatos();
                    break;
                case 1:
                    GatosService.verFavoritos(Gatos.apiKey);
                default: break;
            }

            
            
        } while (opcionMenu != 1);

    }
}
