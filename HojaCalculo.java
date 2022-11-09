
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
    
    {
    /** La version super elegante que arregla todos los problemas con null de un plumazo:
     * 
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estan a null)
     * 
     * Ademas añade una fila de nombre "Null" que nos ayudara a evitar errores en los calculos en los que se llame a filas nulas.
     
     
    public int getNumeroFilas() {
        int numFilas = 0;
        
        if(fila1 != null && fila1.getId() != "Null") numFilas++; else fila1 = new Fila("Null");
        if(fila2 != null && fila2.getId() != "Null") numFilas++; else fila2 = new Fila("Null");
        if(fila3 != null && fila3.getId() != "Null") numFilas++; else fila3 = new Fila("Null");
        return numFilas;

    }  No se vale, no profe?
    */
    }
    
    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estan a null)
     */

    public int getNumeroFilas() {
        int numFilas = 0;
        
        if(fila1 != null) numFilas++;
        if(fila2 != null) numFilas++;
        if(fila3 != null) numFilas++;

        return numFilas;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        return getNumeroFilas() == 3;

    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    
    public void addFila(Fila fila) {
    switch(getNumeroFilas()){
        case 0: fila1 = fila; break; 
        case 1: fila2 = fila; break;
        case 2: fila3 = fila; break;
        case 3: System.out.println("Fila" + (getNumeroFilas() +1) + " no se puede añadir en " + getNombre() + "\n"); 
        
        }   
    }
    
    /**
     * Dada la informacion a guardar en una fila el metodo
     * crea la fila y la añade a la hoja
     * (evita repetir codigo)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        addFila(fila);

    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
    */
    
    public double getTotalIngresos() {
        
        double numFilas = 0; //El almacenador se ira llenando solo con las filas que no sean null evaluandolas una a una.
        
        switch(getNumeroFilas()) //Como sabemos que la Hoja no contiene huecos, con un switch descendente una vez que se meta en la Fila de numero mas alto, 
                                // sabemos que las de numero mas bajo no seran null asi que podemos ponerlo sin break;
        {
        case 3: numFilas = numFilas + fila3.getIngresos(); // No lo entiende si pones =+ 
        case 2: numFilas = numFilas + fila2.getIngresos();
        case 1: numFilas = numFilas + fila1.getIngresos();
        }
        
        return numFilas;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
    */
    public double getTotalGastos() {
        double numFilas = 0;
        
        switch(getNumeroFilas())
        {
        case 3: numFilas = numFilas + fila3.getGastos(); 
        case 2: numFilas = numFilas + fila2.getGastos();
        case 1: numFilas = numFilas + fila1.getGastos();
        }
        
        return numFilas;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
    */ 
    public double getBeneficio() {
        double numFilas = 0;
        
        switch(getNumeroFilas())
        {
        case 3: numFilas = numFilas + fila3.getBeneficio(); 
        case 2: numFilas = numFilas + fila2.getBeneficio();
        case 1: numFilas = numFilas + fila1.getBeneficio();
        }
        
        return numFilas;
    }
        
    /** Las versiones elegantes de Totales para el recuerdo
     * 
     */ 
    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     
    public double getTotalIngresos() {
        
        return fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
    
    public double getTotalGastos() {
        
        return fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     
    public double getBeneficio() {
        
        return fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio();

    }   
    */
   
    /** El toString
     * 
     * Representacion textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String guiones = "";
        String stringFilas = "";
        
        String strTitulos = String.format("%s\n%23s%16s%16s%16s\n",getNombre(),"FECHA","INGRESOS","GASTOS","BENEFICIO"); //Guarda el string de la fila de titulos de columna
                                                //Aqui guardo los strings de las filas no null
        
        
        if(fila1 != null) stringFilas = stringFilas.concat(fila1.toString()); // Aqui no se puede usar switch, por que el orden de entrada importa, 
        if(fila2 != null) stringFilas = stringFilas.concat(fila2.toString()); // no como a la hora de sumar Ingresos, Gastos etc
        if(fila3 != null) stringFilas = stringFilas.concat(fila3.toString());
        
                                                //Aqui guardo los guiones
        for(int i = 0; i < 80; i++) {
            guiones =  guiones.concat("-");
        }
        guiones = guiones + "\n";
                                                //Aqui guardo los strings de los totales
        String strTotales = String.format("% 38.2f€% 15.2f€% 15.2f€\n",getTotalIngresos(), getTotalGastos(), getBeneficio());
        
        return strTitulos + stringFilas + guiones + strTotales;
    }
    
    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán tambiÃ©n las filas que contenga
     */
    
    public HojaCalculo duplicarHoja() {
       HojaCalculo hojaDuplicada = new HojaCalculo("Duplicada " + getNombre()); //Creamos una hoja nueva, de nombre duplicada
       if(fila1 != null) hojaDuplicada.addFila(fila1.duplicar()); //Si fila 1 no es nula, añadimos a la hoja duplicada una fila nueva creada con duplicar(), copia de fila1
       if(fila2 != null) hojaDuplicada.addFila(fila2.duplicar());
       if(fila3 != null) hojaDuplicada.addFila(fila3.duplicar()); 
        
       return hojaDuplicada;
    }

   
}
