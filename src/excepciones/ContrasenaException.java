package excepciones;

public class ContrasenaException extends Exception{
    
    public ContrasenaException(String error){
        super(error);
    }
    public ContrasenaException(){
        super("El DNI no es correcto.");
    }

}
