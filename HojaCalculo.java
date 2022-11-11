
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Daniel Villadangos
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

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas están a null)
     */
    public int getNumeroFilas() {
        int numFilas = 0;
        if (fila1!=null)
            numFilas++;
        if (fila2!=null)
            numFilas++;
        if (fila3!=null)
            numFilas++;
        return numFilas;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if (getNumeroFilas()==3)
            return true;
        else
            return false;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if (getNumeroFilas()==3)
            System.out.println("Fila" + fila.getId() + " no se pudede añadir en hoja " + getNombre());
        else if (fila1==null) {
            fila1 = fila;
        }
        else if (fila2==null) {
            fila2 = fila;
        }
        else if (fila3==null) {
            fila3 = fila;
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila nuevaFila = new Fila(id,fecha,ingresos,gastos);
        if (getNumeroFilas()==3)
            System.out.println("Fila" + nuevaFila.getId() + " no se puede añadir en hoja " + getNombre());

        else if (fila1==null) {
            fila1 = nuevaFila;
        }
        else if (fila2==null) {
            fila2 = nuevaFila;
        }
        else if (fila3==null) {
            fila3 = nuevaFila;
        }
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double ingresos = 0;
        if (fila1!=null)
            ingresos+=fila1.getIngresos();
        if (fila2!=null)
            ingresos+=fila2.getIngresos();
        if (fila3!=null)
            ingresos+=fila3.getIngresos();
        return ingresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double gastos = 0;
        if (fila1!=null)
            gastos+=fila1.getGastos();
        if (fila2!=null)
            gastos+=fila2.getGastos();
        if (fila3!=null)
            gastos+=fila3.getGastos();
        return gastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return getTotalIngresos()-getTotalGastos();
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String hojaS = String.format("%s%n%23s%16s%16s%16s%n",getNombre(),"FECHA","INGRESOS","GASTOS","BENEFICIOS");
        String hoja2p = String.format("%s%n% 38.2f€% 15.2f€% 15.2f€","---------------------------------------------------------------------------",
        getTotalIngresos(),getTotalGastos(),getBeneficio());
        if (fila1!=null)
            hojaS = hojaS + fila1.toString() + "\n";
        if (fila2!=null)
            hojaS = hojaS + fila2.toString() + "\n";
        if (fila3!=null)
            hojaS = hojaS + fila3.toString() + "\n";
        hojaS = hojaS + hoja2p;
        return hojaS;
    }
    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo hojaD = new HojaCalculo("Duplicada " +getNombre());
        Fila filaUno = null;
        Fila filaDos = null;
        Fila filaTres = null;
        if (fila1!=null) {
            filaUno = fila1.duplicar();
        }
        if (fila2!=null){
            filaDos = fila2.duplicar();
        }
        if (fila3!=null){
            filaTres = fila3.duplicar();
        }
        hojaD.addFila(filaUno);
        hojaD.addFila(filaDos);
        hojaD.addFila(filaTres);
        return hojaD;
    }
}