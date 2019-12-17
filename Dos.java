import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dos {
    public static void main (String[] args) throws Exception {
        
        try {
            // Constructor
            URL direccion = new URL("https://informatica.es.zone/course/dam-programacion-de-servicios-y-procesos/index.php");
            //Utilizamos la clase URLConnection para conectar la pagina.
            URLConnection connection= direccion.openConnection();
            //Usamos el metodo getInpuStream para generar un isr y leer con buffer
            BufferedReader br= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            ArrayList<String> hRefs=new ArrayList<>();
            //leemos el documento html
            while((line=br.readLine())!=null){
                //Creamos un pattern de la clase java regex, este buscara entre dos etiquetas pasadas por parametro
                // ("str(.*?)str") con esta expresion regular se puede capturar substrings que estén
                // contenidos en str (entendemos str por un string cualquiera). En nuestro ejemplo, etiquetas html
                //
                String truquete ="href=3(.*?)3";
                String replace=truquete.replace('3','"');
                Pattern pattern = Pattern.compile(replace);
                //aplicamos el pattern al matcher y ejecutamos el find,
                //si lo encuentra imprime por pantalla
                Matcher matcher = pattern.matcher(line);
                if (matcher.find())
                {
                    hRefs.add(matcher.group(1));
                }

            }
        } catch (MalformedURLException e) {
            System.out.println("Error en la construccion de la URL");
        }

    }
}
