package excepciones;

public class DniException extends Exception{
    public DniException(){
        super("El DNI no es correcto.");
    }
}
