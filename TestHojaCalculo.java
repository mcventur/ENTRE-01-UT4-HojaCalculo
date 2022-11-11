
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author Khrystyna Polishchuk 
 *  
 */
public class TestHojaCalculo
{

    /**
     * Constructor  
     */
    public TestHojaCalculo()    {

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
        HojaCalculo hoja1 = new HojaCalculo("HOJA1"); 
           
        Fecha fecha1 = new Fecha(4, 10, 2020);
        Fila fila1 = new Fila("Fila1", fecha1, 25.50, 132.00);
        hoja1.addFila(fila1);
        
        Fecha fecha2 = new Fecha(5, 10, 2020);
        Fila fila2 = new Fila("Fila2", fecha2, 300.00, 350.00);
        hoja1.addFila(fila2);
           
        Fecha fecha3 = new Fecha(1, 1, 2020);
        Fila fila3 = new Fila("Fila3", fecha3, 0.00, 0.00);
        hoja1.addFila(fila3);
           
        hoja1.duplicarHoja();
        hoja1.toString();
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo hoja2 = new HojaCalculo("HOJA2"); 
           
        Fecha fecha1 = new Fecha(7, 10, 2020);
        Fila fila1 = new Fila("Fila1", fecha1, 260.00, 125.00);
        hoja2.addFila(fila1);
        
        Fecha fecha2 = new Fecha(8, 10, 2020);
        Fila fila2 = new Fila("Fila2", fecha2, 125.00, 245.00);
        hoja2.addFila(fila2);
        
        hoja2.toString();
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo hoja3 = new HojaCalculo("HOJA3"); 
           
        Fecha fecha1 = new Fecha(8, 10, 2020);
        Fila fila1 = new Fila("Fila1", fecha1, 670.00, 234.00);
        hoja3.addFila(fila1);

        hoja3.toString();
    }
}
