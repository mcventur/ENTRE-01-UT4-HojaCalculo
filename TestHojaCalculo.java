
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Aimar Caballero
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
        Fila fila1 = new Fila("Fila1", new Fecha(4, 10, 2020), 25.50, 132.00);
        Fila fila2 = new Fila("Fila2", new Fecha(5,10, 2020), 300.00, 350.00);
        Fila fila3 = new Fila("Fila3");
        Fila fila4 = new Fila("Fila4");
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
    */
    public void test2() {
        Fila fila1 = new Fila("Fila1", new Fecha(7, 10, 2020), 260.00, 125.00);
        Fila fila2 = new Fila("Fila2", new Fecha(9, 10, 2020), 125.00, 245.00);
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        Fila fila1 = new Fila("Fila1", new Fecha(8, 10, 2020), 670.00, 234.00);
    }
}
