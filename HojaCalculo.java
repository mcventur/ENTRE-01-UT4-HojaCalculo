
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -  Nidae Asrih 
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
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        if (fila1 == null && fila2 == null && fila3 == null){
            return 0;
        } else if(fila1 != null && fila2 == null && fila3 == null) {
            return 1;
        }else if(fila1 != null && fila2 != null && fila3 == null) {
            return 2;
        }else if(fila1 != null && fila2 != null && fila3 != null) {
            return 3;
        }
        return -1;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        return (fila1 != null && fila2 != null && fila3 != null);
    }
    
    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(getNumeroFilas() == 0){
            this.fila1 = fila;
        }
        if(getNumeroFilas() == 1){
            this.fila2 = fila;
        }
        if(getNumeroFilas() == 2){
            this.fila3 = fila;
        } else {
            System.out.println("Fila " + getNumeroFilas() + "no se puede añadir en HOJA" + this.nombre);
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila nuevaFila = new Fila(id, fecha, ingresos, gastos);
        addFila(nuevaFila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double ingreso = 0; 
        if(getNumeroFilas() == 1){
            ingreso += fila1.getIngresos();
        }else if (getNumeroFilas() == 2){
            ingreso += fila1.getIngresos() + fila2.getIngresos();
        } else if(getNumeroFilas() == 3){
            ingreso += fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        }
        return ingreso;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double gasto = 0; 
        if(getNumeroFilas() == 1){
            gasto += fila1.getGastos();
        }else if (getNumeroFilas() == 2){
            gasto += fila1.getGastos() + fila2.getGastos();
        } else if(getNumeroFilas() == 3){
            gasto += fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        }
        return gasto;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double bene = 0; 
        if(getNumeroFilas() == 1){
            bene += fila1.getBeneficio();
        }else if (getNumeroFilas() == 2){
            bene += fila1.getBeneficio() + fila2.getBeneficio();
        } else if(getNumeroFilas() == 3){
            bene += fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio();
        }
        return bene;

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
        
       HojaCalculo duplicada =  new HojaCalculo("Duplicada Hoja" + nombre);
       duplicada.addFila(fila1);
       duplicada.addFila(fila2);
       duplicada.addFila(fila3);
       return duplicada;
    }

   
}
