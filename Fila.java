
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - Juan Pablo Marin
 *  
 */
public class Fila
{
    private String id;
    private Fecha fecha;
    private double ingresos;
    private double gastos;

    /**
     * Constructor  
     */
    public Fila(String id)    {
         this.id = id;
         ingresos = 0;
         gastos = 0;
         fecha = new Fecha(1,1,2020);
         

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
     * obtiene una copia idéntica a la fila actual.
     * La fecha que incluye la fila duplicada también es una copia
     * 
     */
    public Fila duplicar() {
       Fecha fecha2 = fecha.obtenerCopia();
       this.id = getId();
       this.ingresos = getIngresos();
       this.gastos = getGastos();
       Fila fila2 = new Fila(this.id,fecha2, this.ingresos, this.gastos);
        
       return fila2;

    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString() {
        String asteriscos = "";
        if(getBeneficio() < 0){
            asteriscos += " **";
        }
            
        String id = String.format("%8s", this.id);
        String fecha = String.format("%15s", this.fecha.toString());
        String ingreso = String.format("%15.2f€", this.ingresos);
        String gasto = String.format("%15.2f€", this.gastos);
        String beneficio = String.format("%15.2f€", this.getBeneficio());
        String FilaTotal = id + fecha + ingreso + gasto + beneficio + asteriscos;
        return FilaTotal;

    }

     

}
