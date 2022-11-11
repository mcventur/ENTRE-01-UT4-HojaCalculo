
/**
 *  Representa a una fila de la hoja de c√°lculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - Iva
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
        fecha = new Fecha(1,1,2020);
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
     * obtiene una copia id√©ntica a la fila actual.
     * La fecha que incluye la fila duplicada tambi√©n es una copia
     * 
     */
    public Fila duplicar() {
        Fila filaCopia = new Fila(id,fecha.obtenerCopia(),ingresos,gastos);
        return filaCopia;

    }

    /**
     * Representaci√≥n textual de una fila
     * (leer enunciado)
     */
    public String toString() {
        String strBeneficios = ""+getBeneficio();
        String str ="";
        if(getBeneficio()<0){
            strBeneficios = strBeneficios+"Ä **";
            str = String.format("%8s%15s%15.2fÄ%15.2fÄ%18s",id,fecha,ingresos,gastos,strBeneficios);
        }
        else{
            strBeneficios = strBeneficios+"Ä";
            str = String.format("%8s%15s%15.2fÄ%15.2fÄ%15s",id,fecha,ingresos,gastos,strBeneficios);
        }
        return str;
        

    }

}
