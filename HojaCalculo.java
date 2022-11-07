
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de c·lculo. La hoja tiene hasta un m·ximo de 3 filas (no m·s)
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
     * Crea la hoja de c·lculo con el nombre indicado 
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
     * Devuelve el n¬∫ de filas de la hoja
     * (depender· de cu·ntas filas est√©n a null)
     */
    public int getNumeroFilas() {
        int numFilas = 0;
        
        if(fila1 != null && fila1.getId() != "Null") numFilas++; else fila1 = new Fila("Null");
        if(fila2 != null && fila2.getId() != "Null") numFilas++; else fila2 = new Fila("Null");
        if(fila3 != null && fila3.getId() != "Null") numFilas++; else fila3 = new Fila("Null");
        return numFilas;

    }

    /**
     * Devuelve true si la hoja est· completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        return getNumeroFilas() == 3;

    }

    /**
     * Se a√±ade una nueva fila a la hoja
     * Si la hoja est· completa se muestra el mensaje "FilaX no se puede a√±adir en HOJAX"
     * Si no est· completa se a√±ade la fila a la hoja teniendo en cuenta
     * si se a√±ade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
    switch(getNumeroFilas()){
        case 0: fila1 = fila; break;
        case 1: fila2 = fila; break;
        case 2: fila3 = fila; break;
        case 3: System.out.println("Fila" + (getNumeroFilas() +1) + " no se puede aÒadir en " + getNombre() + "\n\n"); break;
        }   
    }

    /**
     * Dada la informaci√≥n a guardar en una fila el m√©todo
     * crea la fila y la a√±ade a la hoja
     * (evita repetir c√≥digo)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        addFila(fila);

    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja NNNNNNNNNNUUUUUUUUUUULLLLLLLLLLLLLL como funcion si una fila o mas es null
     */
    public double getTotalIngresos() {
        
        return fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        
        return fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        
        return fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio();

    }

    /**
     * Representaci√≥n textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String strTitulos = String.format("%s\n%23s%16s%16s%16s\n",getNombre(),"FECHA","INGRESOS","GASTOS","BENEFICIO");
        String guiones = "";
        String filas = "";
        /**
        for(int i = 1; i < 91; i++) {
            guiones =  guiones.concat(i%10+"");
        }
        */
        for(int i = 0; i < 80; i++) {
            guiones =  guiones.concat("-");
        }
        guiones = guiones + "\n";
        
        String strTotales = String.format("% 38.2fÄ% 15.2fÄ% 15.2fÄ\n",getTotalIngresos(), getTotalGastos(), getBeneficio());
        
        switch(getNumeroFilas()){ 
        case 1: filas = fila1.toString(); break;
        case 2: filas = fila1.toString() + fila2.toString(); break;
        case 3: filas = fila1.toString() + fila2.toString() + fila3.toString(); break;
        }
        
        return strTitulos + filas + guiones + strTotales;
    }
    
    public void toString3() {
        String strTitulos = String.format("%s\n%23s%15s%16s%16s\n",getNombre(),"FECHA","INGRESOS","GASTOS","BENEFICIO");
        String lineas = "";
        /**
        for(int i = 1; i < 91; i++) {
            lineas =  lineas.concat(i%10+"");
        }
        */
       for(int i = 0; i < 80; i++) {
            lineas =  lineas.concat("-");
        }
        lineas = lineas + "\n";
        
        String strTotales = String.format("% 38.2fÄ% 15.2fÄ% 15.2fÄ\n",getTotalIngresos(), getTotalGastos(), getBeneficio());
        
        System.out.println(strTitulos + fila1.toString() + fila2.toString() + fila3.toString() + lineas + strTotales); 

    }


    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada ser· "Duplicada HojaX"
     * Al duplicar la hoja se duplicar·n tambi√©n las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
       HojaCalculo hojaDuplicada = new HojaCalculo("Duplicada " + getNombre());
       hojaDuplicada.addFila(fila1.duplicar());
       hojaDuplicada.addFila(fila2.duplicar());
       hojaDuplicada.addFila(fila3.duplicar());
        
        
       return hojaDuplicada;
    }

   
}
