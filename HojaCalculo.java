
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
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int cont = 0;
        if (fila1 != null){
            cont++;
        }
        if(fila2 != null){
            cont++;
        }
        if(fila3 != null){
            cont++;
        }
        return cont;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        boolean completo;
        if(getNumeroFilas() == 3){
            completo = true;
        }else{
            completo = false;
        }
        return completo;

    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(getNumeroFilas() == 0){
            fila1 = fila;
            fila2 = fila;
            fila3 = fila;
        
        }else if(getNumeroFilas() == 1){
            fila2 = fila;
            fila3 = fila;
            
        }else if(getNumeroFilas() == 2){
            fila3 = fila;
            
        }else {
            System.out.println("Fila" + (getNumeroFilas() +1) + " no se puede añadir en " + getNombre() + "\n"); 
        }
        
         

    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila filas = new Fila(id, fecha, ingresos, gastos);
        addFila(filas);

    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        //voy viendo si son null para ir haciendo la suma
        double ingre = 0;
        if(fila1 != null){
            ingre = fila1.getIngresos();
        }
        if(fila2 != null){
            ingre = ingre + fila2.getIngresos();
        }
        if(fila3 != null){
            ingre = ingre + fila3.getIngresos();
        }

        return ingre;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double gast = 0;
        if(fila1 != null){
            gast = fila1.getGastos();
        }
        if(fila2 != null){
            gast = gast + fila2.getGastos();
        }
        if(fila3 != null){
            gast = gast + fila3.getGastos();
        }
        return gast;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double bene = 0;
        if(fila1 != null){
            bene = fila1.getGastos();
        }
        if(fila2 != null){
            bene = bene + fila2.getGastos();
        }
        if(fila3 != null){
            bene = bene + fila3.getGastos();
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
        HojaCalculo nuevaHoja = new HojaCalculo("Duplicada " + getNombre() );//se supone que en el nombre ya le ponen el nombre
        if(fila1 != null){
            nuevaHoja.addFila(fila1);
        }
        if(fila2 != null){
            nuevaHoja.addFila(fila2);
            
        }
        if(fila3 != null){
            nuevaHoja.addFila(fila3);
            
        }
        
        
       return nuevaHoja;
    }

   
}
