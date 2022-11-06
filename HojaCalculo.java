
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -   
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila1 = null;
        this.fila1 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el numero de filas de la hoja
     * (dependera de cuantas filas esten a null)
     */
    public int getNumeroFilas() {
        int contador = 0;
        if(getFila1()!=null){
            contador++;
        }
        if(getFila2()!=null){
            contador++;
        }
        if(getFila3()!=null){
            contador++;
        }
        return contador;
    }

    /**
     * Devuelve true si la hoja esta completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(getNumeroFilas() == 3){
            return true;
        }
        return false;
    }

    /**
     * Se anade una nueva fila a la hoja
     * Si la hoja esta completa se muestra el mensaje "FilaX no se puede a�adir en HOJAX"
     * Si no esta completa se a�ade la fila a la hoja teniendo en cuenta
     * si se anade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
         
        if(getNumeroFilas() == 1){
            this.fila2 = fila;
        }
        else if(getNumeroFilas() == 2){
            this.fila3 = fila;
        }
        else if(getNumeroFilas() == 3){
            System.out.println("FilaX no se puede a�adir en HOJAX");
        }
        else{
            this.fila1 = fila;
        }

    }

    /**
     * Dada la informacion a guardar en una fila el metodo
     * crea la fila y la anade a la hoja
     * (evita repetir codigo)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
         Fila nFila = new Fila(id,fecha,ingresos,gastos);
         addFila(nFila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double ingresos = fila1.getIngresos();
        ingresos += fila2.getIngresos();
        ingresos += fila3.getIngresos();
        return ingresos;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double gastos = fila1.getGastos();
        gastos += fila2.getGastos();
        gastos += fila3.getGastos();
        return gastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return 0;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
         
        return null;

    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        
        
        
       return null;
    }

   
}
