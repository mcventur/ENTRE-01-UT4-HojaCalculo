
/**
 *  Representa a una fila de la hoja de c√°lculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - Kaiet Jimenez Aldasoro
 *  
 */
public class Fila
{
    private String id;
    private Fecha fecha;
    private double ingresos;
    private double gastos;

    /**
     * Constructor 1 
     */
    public Fila(String id)    {
        gastos = 0;
        ingresos = 0;
        fecha = new Fecha (1,1,2020);
        this.id = id;

    }

    /**
     * Constructor  
     */
    public Fila(String id, Fecha fecha, double ingresos, double gastos)    {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.gastos = gastos;
        

    }
    
    /**
     * accesor para el id de la fila
     */
    public String getId() {
        return this.id;

    }


    /**
     * accesor para la fecha
     */
    public Fecha getFecha() {
        return this.fecha;

    }

    /**
     * accesor para los ingresos
     */
    public double getIngresos() {
        return this.ingresos;

    }

    /**
     * accesor para los gastos
     */
    public double getGastos() {
        return this.gastos;

    }

    /**
     * calcula y devuelve el beneficio
     */
    public double getBeneficio() {
        return this.ingresos - this.gastos;

    }
    
    /**
     * obtiene una copia id√©ntica a la fila actual.
     * La fecha que incluye la fila duplicada tambi√©n es una copia
     */
    public Fila duplicar() {
     
       return new Fila(getId(),getFecha(),getIngresos(),getGastos());

    }

    /**
     * Representaci√≥n textual de una fila
     * (leer enunciado)
     */
    public String toString() {

        if(getBeneficio()< 0){
             return String.format("%8s %15s %15.2fÄ %15.2fÄ %15.2fÄ **" ,getId(),getFecha(),getIngresos(),getGastos(),getBeneficio());
        
        }
        else{
             return String.format("%8s %15s %15.2fÄ %15.2fÄ %15.2fÄ " ,getId(),getFecha(),getIngresos(),getGastos(),getBeneficio());
        }
          
       
        //si el benefico obtenido es negativa quiero que me devuelva el resultado con **, si no (positiva) sin asteriscos, este metodo sera llamado en la HojaCalculo
      
        }
}
