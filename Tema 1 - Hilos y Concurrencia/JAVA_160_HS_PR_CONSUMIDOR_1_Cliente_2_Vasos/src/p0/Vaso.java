package p0;

public class Vaso {
    private boolean lleno;
    private int veces;
    
    public Vaso() {
        lleno = false;
        veces = 0;
    }
    
    public boolean estaLleno() {
        return lleno;
    }
    
    public void llenarVaso() {
        lleno = true;
    }
    
    public void vaciarVaso() {
        lleno = false;
    }
    
    public void incrementarVeces() {
        veces++;
    }
    
    public int consultarVeces() {
        return veces;
    }
}