
/**
 *  Modela una fecha
 *  
 *  @author - Ivan Barguilla
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int anio;

    /**
     * constructor  
     */
    public Fecha(int dia, int mes, int anio)
    {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;

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
    public int getAnio()
    {
        return anio;
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
     * mutador para el año
     */
    public void setAnio(int anio)
    {
        this.anio = anio;
    }


    /**
     * Devuelve una copia exacta al objeto actual
     */
    public Fecha obtenerCopia() {
         Fecha fechaCopia = new Fecha(dia,mes,anio);
         return fechaCopia;
    }

    /**
     * 
     */
    public String toString() {
        return this.dia + "/"  + this.mes+ "/" + this.anio;

    }
    

}
