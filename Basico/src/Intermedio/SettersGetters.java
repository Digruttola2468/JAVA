package Intermedio;

public class SettersGetters {
    private String nombre;
    private String apellido;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    SettersGetters(){

    }

    SettersGetters(String nombre,String apellido,int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
    }

    public static void main(String[] args) {
        SettersGetters setGet = new SettersGetters();

        setGet.setNombre("Ivan");
        setGet.setApellido("Di Gruttola");
        setGet.setEdad(18);

        System.out.println("Nombre: " + setGet.getNombre() + "\nApellido: " + setGet.getApellido() + "\nEdad: " + setGet.getEdad());

        System.out.println();
        System.out.println();

        //O podemos usar constructores
        SettersGetters setGetConstructor = new SettersGetters("Mauro","Tauro",19);
        System.out.println("Nombre: " + setGetConstructor.getNombre() + "\nApellido: " +
                setGetConstructor.getApellido() + "\nEdad: " +
                setGetConstructor.getEdad());

        System.out.println();
        System.out.println();

        setGetConstructor.setNombre("Marco");
        setGetConstructor.setApellido("Canete");
        setGetConstructor.setEdad(14);

        System.out.println("Nombre: " + setGetConstructor.getNombre() + "\nApellido: " +
                setGetConstructor.getApellido() + "\nEdad: " +
                setGetConstructor.getEdad());


    }
}
