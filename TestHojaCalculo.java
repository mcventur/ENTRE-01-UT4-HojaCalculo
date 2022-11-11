
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - David Andueza Ferro
 *  
 */
public class TestHojaCalculo
{
    
    /**
     * Constructor  
     */
    public TestHojaCalculo()    {
        test1();
        test2();
        test3();
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
        HojaCalculo Hoja1 = new HojaCalculo("HOJA1");
        
        Fecha fecha1 = new Fecha(4,10,2020);Fecha fecha2 = new Fecha(5,10,2020);Fecha fecha3 = new Fecha(1,1,2020);
        
        Fila fila1 = new Fila("Fila1", fecha1, 25.50, 132.00);Fila fila2 = new Fila("Fila2", fecha2, 300, 350);Fila fila3 = new Fila("Fila3", fecha3, 0, 0);Fila fila4 = new Fila("Fila4");
        
        Hoja1.addFila(fila1);Hoja1.addFila(fila2);Hoja1.addFila(fila3);Hoja1.addFila(fila4);
        
        System.out.println(Hoja1.toString());
        HojaCalculo copia = Hoja1.duplicarHoja();
        System.out.println();
        System.out.println(copia.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo Hoja2 = new HojaCalculo("HOJA2");
        
        Fecha fecha1 = new Fecha(7,10,2020);Fecha fecha2 = new Fecha(8,10,2020);
       
        Fila fila1 = new Fila("Fila1", fecha1, 260, 125);Fila fila2 = new Fila("Fila2", fecha2, 125, 245);
        
        Hoja2.addFila(fila1);Hoja2.addFila(fila2);
        
        System.out.println(Hoja2.toString());
        HojaCalculo copia = Hoja2.duplicarHoja();
        System.out.println();
        System.out.println(copia.toString());

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo Hoja3 = new HojaCalculo("HOJA3");
        Fecha fecha1 = new Fecha(8,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 670, 234);
        Hoja3.addFila(fila1);
        System.out.println(Hoja3.toString());
        HojaCalculo copia = Hoja3.duplicarHoja();
        System.out.println();
        System.out.println(copia.toString());

    }

}
