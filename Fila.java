
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - 
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
    
    public Fila(double ingresos, double gastos)    {
        this.id = "Fila1";
        this.fecha = new Fecha(12,12,2020);;
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
       Fecha fechacopia = fecha.obtenerCopia(); 
       return new Fila(this.id, fechacopia, this.ingresos, this.gastos);

    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    
    public String toString() {
        String strFecha = this.fecha.getDia() + "/" + this.fecha.getMes() + "/" +  this.fecha.getAño();
        
        String strFila = String.format("%8s%15s% 15.2f€% 15.2f€% 15.2f€",this.id, strFecha, this.ingresos, this.gastos, getBeneficio());
        
        if(getBeneficio() < 0) strFila+= " **\n"; else strFila+= "\n";
        
        return strFila;

    }
    
    public void toString1() {
        
        String strFila = String.format("%8s%15s% 15.2f€% 15.2f€% 15.2f€",this.id, fecha.toString(), this.ingresos, this.gastos, getBeneficio());
        
        if(getBeneficio() < 0) strFila+= " **\n"; else strFila+= "\n";
        
        System.out.println(strFila);

    }
    
    public void toString2() {
        Fila filaPrueba = new Fila("Prueba");
        filaPrueba = null;
        String strFila = filaPrueba.getGastos() + "";
        
        System.out.println(strFila);

    }
     

}
