
/**
 *  Representa a una fila de la hoja de cÃ¡lculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - Daniel Villadangos
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
        this.id=id;
        gastos=0;
        ingresos=0;
        fecha = new Fecha(1,1,2020);
    }

    /**
     * Constructor  
     */
    public Fila(String id, Fecha fecha, double ingresos, double gastos)    {
        this.id=id;
        this.fecha=fecha;
        this.ingresos=ingresos;
        this.gastos=gastos;
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
     * La fecha que incluye la fila duplicada tambiénn es una copia
     * 
     */
    public Fila duplicar(){
        Fila filaD = new Fila(id,fecha,ingresos,gastos);
        return filaD;
    }
    

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString() {
        double beneficio = ingresos-gastos;
        String filaP = String.format("%8s%15s% 15.2f€% 15.2f€% 15.2f€",id,fecha.toString(),ingresos,gastos,beneficio);
        if (beneficio<0)
            return filaP + " **";
        else
            return filaP;            
    }
    
    public void printFila() {
        System.out.println(toString());
    }
}
