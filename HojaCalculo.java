
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author Aimar Caballero   
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
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int numeroFilas = 0;
        if (fila1 !=null) {
            numeroFilas++;
        }
        if (fila2 !=null) {
            numeroFilas++;
        }
        if (fila3 !=null) {
            numeroFilas++;
        }
        return numeroFilas;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if (getNumeroFilas() == 3) {
        }
        return true;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        switch(getNumeroFilas()) {
            case 1:
                fila1 = fila;
                break;
                
            case 2:
                fila2 = fila;
                break;
                
            case 3:
                fila3 = fila;
                break;
                
            case 4:
                System.out.println("Fila " + (getNumeroFilas() + 1) + "no se peude añadir en " + getNombre());
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
         this.addFila(new Fila(id, fecha, ingresos, gastos));
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos = 0;
        switch (getNumeroFilas()) {
            case 3: totalIngresos = totalIngresos + fila3.getIngresos();
            case 2: totalIngresos = totalIngresos + fila2.getIngresos();
            case 1: totalIngresos = totalIngresos + fila1.getIngresos();
        }
        return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos = 0;
        switch (getNumeroFilas()) {
            case 3: totalGastos = totalGastos + fila3.getGastos();
            case 2: totalGastos = totalGastos + fila2.getGastos();
            case 1: totalGastos = totalGastos + fila1.getGastos();
        }
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double totalBeneficio = 0;
        switch (getNumeroFilas()) {
            case 3: totalBeneficio = totalBeneficio + fila3.getGastos();
            case 2: totalBeneficio = totalBeneficio + fila2.getGastos();
            case 1: totalBeneficio = totalBeneficio + fila1.getGastos();
        }
        return totalBeneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String Fecha = String.format("%23s", "FECHA");
        String Ingresos = String.format("%16s", "INGRESOS");
        String Gastos = String.format("%16s", "GASTOS");
        String Beneficio = String.format("%16s", "BENEFICIO");
        String Datos = this.nombre + "\n" + Fecha + Ingresos + Gastos + Beneficio + "\n";
        String Linea = "----------------------------------------------------------------------------\n";
        String sumaIngresos = String.format("%38.2f€", this.getTotalIngresos());
        String sumaGastos = String.format("%15.2f€", this.getTotalGastos());
        String sumaBeneficio = String.format("%15.2f€", this.getBeneficio());
        
        String asteriscos = "";
        if(this.getBeneficio() < 0){
            asteriscos += "  **";
        }
        return Datos + Linea + sumaIngresos + sumaGastos + sumaBeneficio + asteriscos;
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo duplicarHoja = new HojaCalculo ("Duplicada " + getNombre());
        if(fila1 != null) {
            duplicarHoja.addFila(fila1.duplicar());
        }
        if(fila2 != null) {
            duplicarHoja.addFila(fila2.duplicar());
        }
        if(fila3 != null) {
            duplicarHoja.addFila(fila3.duplicar());
        }
        return duplicarHoja;
    }
}
