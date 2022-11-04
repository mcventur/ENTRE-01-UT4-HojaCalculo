
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Adrian Vera
 * @version - 0.0.1
 *  
 *  CLASE SIN CONSTRUCTOR EN EL CÓDIGO (SE USARÁ EL QUE JAVA CREA POR DEFECTO)
 */
public class TestHojaCalculo
{

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1()
    {
        Fila fila1 = new Fila("Fila1", new Fecha(4, 10, 2020), 25.50, 132.00);
        Fila fila2 = new Fila("Fila2", new Fecha(5,10, 2020), 300.00, 350.00);
        Fila fila3 = new Fila("Fila3");
        Fila fila4 = new Fila("Fila4");
        
        HojaCalculo hoja1 = new HojaCalculo("HOJA1", fila1, fila2, fila3);
        hoja1.addFila(fila4);
        
        HojaCalculo hojaDuplicada1 = hoja1.duplicarHoja();
        
        System.out.println(hoja1.toString());
        System.out.println(hojaDuplicada1.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2()
    {
        Fila fila1 = new Fila("Fila1", new Fecha(7, 10, 2020), 260.00, 125.00);
        Fila fila2 = new Fila("Fila2", new Fecha(9, 10, 2020), 125.00, 245.00);
        
        HojaCalculo hoja2 = new HojaCalculo("HOJA2");
        
        hoja2.addFila(fila1);
        hoja2.addFila(fila2);
        
        HojaCalculo hojaDuplicada2 = hoja2.duplicarHoja();
        
        System.out.println(hoja2.toString());
        System.out.println(hojaDuplicada2.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3()
    {
        Fila fila1 = new Fila("Fila1", new Fecha(8, 10, 2020), 670.00, 234.00);
        
        HojaCalculo hoja3 = new HojaCalculo("HOJA3");
        
        hoja3.addFila(fila1);
        
        HojaCalculo hojaDuplicada3 = hoja3.duplicarHoja();
        
        System.out.println(hoja3.toString());
        System.out.println(hojaDuplicada3.toString());
    }

}
