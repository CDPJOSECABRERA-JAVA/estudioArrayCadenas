package excepciones;

public class CodigoBarrasException extends Exception{
public CodigoBarrasException(){
    super("El código de barras es incorrecto");
}
}
