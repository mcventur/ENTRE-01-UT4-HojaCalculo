
/**
 *  Modela una fecha
 *  
 *  @author - Adrian Vera
 *  @version - 0.0.1
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int año;

    /**
     * constructor  
     */
    public Fecha(int dia, int mes, int año)
    {
        this.dia = dia;
        this.mes = mes;
        this.año = año;

    }   

    /**
     * Accesor para  el día   
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * Accesor para  el mes 
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * Accesor para  el año  
     */
    public int getAño()
    {
        return año;
    }

    /**
     * Mutador para el dia
     */
    public void setDia(int dia)
    {
        this.dia = dia;
    }

    /**
     * Mutador para el mes
     */
    public void setMes(int mes)
    {
        this.mes = mes;
    }

    /**
     * Mutador para el año
     */
    public void setAño(int año)
    {
        this.año = año;
    }


    /**
     * Devuelve una copia exacta al objeto actual
     */
    public Fecha obtenerCopia()
    {
         return new Fecha(this.dia, this.mes, this.año);
    }

    /**
     * Método toString
     */
    public String toString()
    {
        return this.dia + "/"  + this.mes+ "/" + this.año;
    }
}
