
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -  Marce
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
        int numFilas = 3;
        if(fila1 == null) numFilas --;
        if(fila2 == null) numFilas --;
        if(fila3 == null) numFilas --;
        
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
        if(hojaCompleta()){
            System.out.println(fila.getId() + " no se puede añadir en " + nombre);
        }
        
        if(fila1 == null)
            fila1 = fila;
        else if(fila2 == null)
            fila2 = fila;
        else //Ya hemos comprobado previamente que no esté completa, así que podemos usar un else
            fila3 = fila;

    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        //Creamos el objeto Fila a añadir
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        //Lo añadimos usando la función anterior
        addFila(fila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos = 0; 
        
        if(fila1 != null){
            totalIngresos += fila1.getIngresos();    
            if(fila2 != null){
                totalIngresos += fila2.getIngresos();                
                if(fila3 !=  null){
                    totalIngresos += fila3.getIngresos();
                }
            }
        }

        return totalIngresos;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos = 0; 
        
        if(fila1 != null){
            totalGastos += fila1.getGastos();    
            if(fila2 != null){
                totalGastos += fila2.getGastos();                
                if(fila3 !=  null){
                    totalGastos += fila3.getGastos();
                }
            }
        }

        return totalGastos;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return getTotalIngresos() - getTotalGastos();

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String texto = nombre + "\n";
        //Cabecera. Usamos los datos de formato que se usan para cada fila, para que queden alineados
        texto += String.format("%8s%15s%16s%16s%16s","","FECHA","INGRESOS","GASTOS","BENEFICIO") + "\n";
        if (fila1 != null){
            texto += fila1 + "\n";
            if(fila2 != null){
                texto += fila2 + "\n";
                if(fila3 != null){
                    texto += fila3 + "\n";
                }
            }
        }
        //Pie con  los totales
        texto += "-------------------------------------------------------------------------------\n";
        texto += String.format("%8s%15s%15.2f€%15.2f€%15.2f€","","",getTotalIngresos(),
        getTotalGastos(),getBeneficio()) + "\n";
        
        return texto;

    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo copia = new HojaCalculo("Duplicada " + nombre);
        if(fila1 != null){
            copia.addFila(fila1.duplicar());
            if(fila2 != null){
                copia.addFila(fila2.duplicar());
                if(fila3 != null){
                    copia.addFila(fila3.duplicar());
                }
            }
        }
        return copia;
    }

    
        /**
     * Código para probar la clase HojaCalculo
     */
    public static void main(String[] args) {
        Fecha f1 = new Fecha(4, 10, 2020);
        Fila fila1 = new Fila("Fila1", f1, 25.5, 132);
        Fecha f2 = new Fecha(5, 10, 2020);
        Fila fila2 = new Fila("Fila2", f2, 300, 350);
        Fila fila3 = new Fila("Fila3");

        HojaCalculo hoja1 = new HojaCalculo("HOJA1");
        hoja1.addFila(fila1);
        hoja1.addFila(fila2);
        hoja1.addFila(fila3);
        hoja1.addFila(new Fila("Fila4"));
        System.out.println(hoja1.toString());     

        HojaCalculo duplicada = hoja1.duplicarHoja();
        System.out.println(duplicada.toString());

        System.out.println();
        System.out.println();

        HojaCalculo hoja2 = new HojaCalculo("HOJA2");
        hoja2.addFila(new Fila("Fila1", new Fecha(7, 10, 2020), 260, 125));
        hoja2.addFila(new Fila("Fila2", new Fecha(8, 10, 2020), 125, 245));     
        System.out.println(hoja2.toString());

        HojaCalculo duplicada2 = hoja2.duplicarHoja();
        System.out.println(duplicada2.toString());

        System.out.println();
        System.out.println();
        HojaCalculo hoja3 = new HojaCalculo("HOJA3");
        hoja3.addFila(new Fila("Fila1", new Fecha(8, 10, 2020), 670, 234));
        System.out.println(hoja3.toString());

        HojaCalculo duplicada3 = hoja3.duplicarHoja();
        System.out.println(duplicada3.toString());

    }
   
}
