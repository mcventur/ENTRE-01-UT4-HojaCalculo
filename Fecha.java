
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
     * Constructor
     * 
     * @param int dia : Dia
     * @param int mes : Mes
     * @param int año : Año
     */
    public Fecha(int dia, int mes, int año)
    {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }   

    /**
     * Accesor para  el día
     * 
     * @return int
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * Accesor para  el mes
     * 
     * @return int
     * 
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * Accesor para  el año
     * 
     * @return int
     * 
     */
    public int getAño()
    {
        return año;
    }

    /**
     * Mutador para el dia
     * 
     * @param int
     * 
     */
    public void setDia(int dia)
    {
        this.dia = dia;
    }

    /**
     * Mutador para el mes
     * 
     * @param int
     * 
     */
    public void setMes(int mes)
    {
        this.mes = mes;
    }

    /**
     * Mutador para el año
     * 
     * @param int
     * 
     */
    public void setAño(int año)
    {
        this.año = año;
    }


    /**
     * Devuelve una copia exacta al objeto actual
     * 
     * @return Fecha
     */
    public Fecha obtenerCopia()
    {
         return new Fecha(this.dia, this.mes, this.año);
    }

    /**
     * Método toString
     * 
     * @return String
     * 
     */
    @Override
    public String toString()
    {
        return this.dia + "/"  + this.mes+ "/" + this.año;
    }
}
