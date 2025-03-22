public class credito 
{
    private String nombre;
    private int   cedula;
    private String tipocredito;
    private double vrcredito;
    public credito() {
    }
    public credito(String nombre, int  cedula, String tipocredito, double vrcredito) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipocredito = tipocredito;
        this.vrcredito = vrcredito;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int  getCedula() {
        return cedula;
    }
    public void setCedula(int  cedula) {
        this.cedula = cedula;
    }
    public String getTipocredito() {
        return tipocredito;
    }
    public void setTipocredito(String tipocredito) {
        this.tipocredito = tipocredito;
    }
    public double getVrcredito() {
        return vrcredito;
    }
    public void setVrcredito(double vrcredito) {
        this.vrcredito = vrcredito;
    }
    

    

    
}
