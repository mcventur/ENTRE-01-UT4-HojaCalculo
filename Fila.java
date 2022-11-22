
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - Marce
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
         //Las dos líneas siguientes se podrían omitir
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
        Fecha copiaFecha = fecha.obtenerCopia();
        return new Fila(id, copiaFecha, ingresos, gastos);
    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString() {
        double beneficio = getBeneficio();
        String texto = String.format("%8s%15s%15.2f€%15.2f€%15.2f€",id,fecha,ingresos,gastos,beneficio);
          
        if(beneficio < 0){
            texto += " **";
        }
        
        return texto;
    }
    
    /**
     * Código para probar la clase Fila
     */
    public static void main(String[] args) {
        Fecha f1 = new Fecha(4, 10, 2020);
        Fila fila1 = new Fila("Fila1", f1, 25.5, 132);
        Fecha f2 = new Fecha(5, 10, 2020);
        Fila fila2 = new Fila("Fila2", f2, 300, 350);
        Fila fila3 = new Fila("Fila3");
        System.out.println(fila1);
        System.out.println(fila2);
        System.out.println(fila3);
        
        System.out.println(fila1.duplicar());
    }    

}
