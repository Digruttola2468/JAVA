public class StringJava{
    public static void main(String[] args) {

        String texto = "Texto";

        System.out.println(texto);

        System.out.println("Numero Caracteres: "      + texto.length() );
        System.out.println("Eliminar espacio: "      + " texto".trim());
        System.out.println("Convertir a Mayusculas: " + texto.toUpperCase());
        System.out.println("Convertir a Minusculas: " + texto.toLowerCase());
        System.out.println("Reemplazar f a g: " + texto.replace('x','_'));
        System.out.println("Eliminar cadenas: " + texto.substring(0,2));
        System.out.println("Agregar texto: " + texto.concat(" hola"));
        System.out.println("Repetir texto: " + texto.repeat(3));
        System.out.println("Verifica si esta vacio o si contiene solamente espacios: " + texto.isBlank());
        System.out.println("Verifica si esta vacio pero si contiene espacio no esta vacio: " + texto.isEmpty());
        System.out.println("Obtener un caracter del texto: " + texto.charAt(1));
        System.out.println("Obtener la posicion del caracter: " + texto.indexOf("x"));

        //Verificamos si contiene la letra
        String contieneTexto = "t";
        CharSequence xx = contieneTexto.subSequence(0,1);
        boolean isContains = texto.contains(xx);
        System.out.println("El texto contiene " + contieneTexto + " ? : " + isContains);

        //Pasamos el texto a un array de char
        char textoArray[] = texto.toCharArray();
        for (char x : textoArray){
            System.out.print(x + " ");
        }
    }
}