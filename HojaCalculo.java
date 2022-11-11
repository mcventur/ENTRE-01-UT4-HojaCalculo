
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de c√°lculo. La hoja tiene hasta un m√°ximo de 3 filas (no m√°s)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @¡lvaro Mateos
 * 
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
     * Crea la hoja de calculo con el nombre indicado 
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
     * Devuelve el n∫ de filas de la hoja
     * (dependera de cuantas filas estan a null)
     */
    public int getNumeroFilas() {
        //atributos locales
        int numeroFilas;
        numeroFilas = 0;
        
        if(getFila1()!= null){
            numeroFilas++;
        }
        if(getFila2()!= null){
            numeroFilas++;
        }
        if(getFila3()!=null){
            numeroFilas++;
        }
        return numeroFilas ;
    }

    /**
     * Devuelve true si la hoja esta completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(getFila1()!= null && getFila2()!=null && getFila3()!=null){
            return true;    
        }
        return false;
    }

    /**
     * Se anyade una nueva fila a la hoja
     * Si la hoja esta completa se muestra el mensaje "FilaX no se puede anyadir en HOJAX"
     * Si no esta completa se anyade la fila a la hoja teniendo en cuenta
     * si se anyade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(getNumeroFilas()==1){
            this.fila2 = fila;
        }else if(getNumeroFilas()==2){
            this.fila3 = fila;
        }else if(getNumeroFilas()==3){
            System.out.println("Fila 3  no se puede aÒadir en"+ nombre);
        }else {
            this.fila1 = fila;
        }
    }

    /**
     * Dada la informacion a guardar en una fila el metodo
     * crea la fila y la anyade a la hoja
     * (evita repetir codigo)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila (id,fecha,ingresos,gastos);
        addFila(fila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        //atributos locales
        double total = 0 ;
        
        if(getFila1()!=null){
            total = fila1.getIngresos();
        }
        if(getFila2()!=null){
            total += fila2.getIngresos();
        }
        if(getFila3()!=null){
            total += fila3.getIngresos();
        }
        
        return total;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        //atributos locales
        double total = 0 ;
        
        if(getFila1()!=null){
            total = fila1.getGastos();
        }
        if(getFila2()!=null){
            total += fila2.getGastos();
        }
        if(getFila3()!=null){
            total += fila3.getGastos();
        }
        
        return total; 
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double gastos = getTotalGastos();
        double beneficios = getTotalIngresos(); 
        return  beneficios - gastos;
    }
    
    /**
     * Representacion textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String str ="";
        str = "\n"+ nombre  +"\n";
        str += String.format("%23s%16s%16s%16s", "FECHA","INGRESOS","GASTOS","BENEFICIO");
        if(getFila1()!=null){
            str+="\n"+fila1.toString();
        }
        if(getFila2()!=null){
            str+="\n"+fila2.toString();
        }
        if(getFila3()!=null){
            str+="\n"+fila3.toString();
        }
        str+="\n--------------------------------------------------------------------------";
        str+=String.format("\n %37.2fÄ%15.2fÄ%15.2fÄ",getTotalIngresos(),getTotalGastos(),getBeneficio());
        System.out.print(str);
        return str;
    }
    
    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada ser√° "Duplicada HojaX"
     * Al duplicar la hoja se duplicar√°n tambi√©n las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo hojaCalculo1 = new HojaCalculo("Duplicada " + nombre);
        if(getFila1()!=null){
            hojaCalculo1.addFila(fila1);
        }
        if(getFila2()!=null){
            hojaCalculo1.addFila(fila2);    
        }
        if(getFila3()!=null){
            hojaCalculo1.addFila(fila3);    
        }
        return hojaCalculo1;
    }
}
