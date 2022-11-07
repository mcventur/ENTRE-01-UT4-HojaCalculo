
/**
 *  Modela una fecha
 *  
 *  @author - Antonio Aguilera
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int anyo;

    /**
     * constructor  
     */
    public Fecha(int dia, int mes, int anyo)
    {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;

    }   

    /**
     * accesor para  el día   
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * accesor para  el mes 
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * accesor para  el año  
     */
    public int getAnyo(){
        return anyo;
    }
    
    /**
     * mutador para el dia
     */
    public void setDia(int dia)
    {
        this.dia = dia;
    }

    /**
     * mutador para el mes
     */
    public void setMes(int mes)
    {
        this.mes = mes;
    }

    /**
     * mutador para el anyo
     */
    public void setAnyo(int anyo)
    {
        this.anyo = anyo;
    }


    /**
     * Devuelve una copia exacta al objeto actual
     */
    public Fecha obtenerCopia() {
          Fecha nuevaFecha = new Fecha(dia,mes,anyo);
          return nuevaFecha;
    }

    /**
     * 
     */
    public String toString() {
        return this.dia + "/"  + this.mes+ "/" + this.anyo;

    }
}
