
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @aitor - 
 *  
 */
public class Fila
{
    private String id; //identificador de la fila
    private Fecha fecha; //
    private double ingresos; // 
    private double gastos; //

    /**
     * Constructor 1  
     */
    public Fila(String id)    {
        this.id = id;
        fecha =  new Fecha(1,1,2020);
        ingresos = 0;
        gastos = 0;
        
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
     * obtiene una copia identica a la fila actual.
     * La fecha que incluye la fila duplicada tambien es una copia
     * 
     */
    public Fila duplicar() {
        Fila fila = new Fila(id);
        return fila;

    }

    /**
     * Representacion textual de una fila
     * (leer enunciado)
     */
    public String toString() {
      return ("        " + id + "               "+fecha + "               "+ingresos+"�"+ "               "+gastos+"�"+ "               " +(ingresos-gastos)+"�");
    }
    //"        " 8 espacios
    //"               "15 espacios
     

}
