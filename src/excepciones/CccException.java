package excepciones;

public class CccException extends Exception {
    public CccException(){
        super("La cuenta bancaria introducida es incorrecta");
    }
}
