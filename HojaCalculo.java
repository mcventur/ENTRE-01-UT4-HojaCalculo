
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Pablo Sanz   
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
        this.fila2 = null;
        this.fila3 = null;

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
        return this.fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return this.fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return this.fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int filas = 0;
        
        if (this.fila1 != null){
           filas ++;
        }
        if (this.fila2 != null){
           filas ++;
        }
        if (this.fila3 != null){
           filas ++;
        }
        
        return filas;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if (getNumeroFilas() == 3){
           return true;
        }else{
           return false;
        }
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if (this.fila1 == null){
           this.fila1 = fila; 
        }else if (this.fila2 == null){
           this.fila2 = fila;
        }else if (this.fila3 == null){
           this.fila3 = fila;
        }else{
            System.out.println(fila.getId() + " no se puede añadir en " + this.nombre);
        }

    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos){
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        addFila(fila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double total = 0;

        if (this.fila1 != null){
           total += this.fila1.getIngresos(); 
        }
        if (this.fila2 != null){
           total += this.fila2.getIngresos(); 
        }
        if (this.fila3 != null){
           total += this.fila3.getIngresos(); 
        }
        return total;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double total = 0;

        if (this.fila1 != null){
           total += this.fila1.getGastos(); 
        }
        if (this.fila2 != null){
           total += this.fila2.getGastos(); 
        }
        if (this.fila3 != null){
           total += this.fila3.getGastos(); 
        }
        return total;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double total = 0;

        if (this.fila1 != null){
           total += this.fila1.getBeneficio(); 
        }
        if (this.fila2 != null){
           total += this.fila2.getBeneficio(); 
        }
        if (this.fila3 != null){
           total += this.fila3.getBeneficio(); 
        }
        return total;

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String titulo = "\n\n"+this.nombre+"\n";
        String cabecera = String.format("%23s","FECHA") + String.format("%16s","INGRESOS") + String.format("%16s","GASTOS") + String.format("%16s","BENEFICIOS") + "\n";
        String filas = "";
        if (this.fila1 != null){
           filas += this.fila1.toString() + "\n";
        }
        if (this.fila2 != null){
           filas += this.fila2.toString() + "\n";
        }
        if (this.fila3 != null){
           filas += this.fila3.toString() + "\n";
        }
        String guiones = "-";
        String separacion = guiones.repeat(80) + "\n";
        String totales = String.format("%38.2f€", getTotalIngresos()) + String.format("%15.2f€", getTotalGastos()) + String.format("%15.2f€", getBeneficio()) + "\n";
        
        return titulo + cabecera + filas + separacion + totales;
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo copia = new HojaCalculo("Duplicada " + getNombre());
        copia.addFila(this.fila1);
        copia.addFila(this.fila2);
        copia.addFila(this.fila3);
        return copia;
    }

   
}
