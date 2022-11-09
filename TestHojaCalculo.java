
/**
 *  Clase con codigo para probar el resto de clases
 * 
 * @author - 
 *  
 */
public class TestHojaCalculo
{
    private HojaCalculo hojaCalculo1;
    private HojaCalculo hojaCalculo2;
    private HojaCalculo hojaCalculo3;
    
    /**
     * Constructor  
     */
    public TestHojaCalculo()    {
    this.hojaCalculo1 = new HojaCalculo("HOJA1");
    this.hojaCalculo2 = new HojaCalculo("HOJA2");
    this.hojaCalculo3 = new HojaCalculo("HOJA3");
}

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de calculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podra guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
    Fecha fecha1 = new Fecha(4,10,2020);
    Fecha fecha2 = new Fecha(5,10,2020);
    Fila fila3 = new Fila("Fila3");
    Fila fila4 = new Fila("Fila4");
    
    hojaCalculo1.addFila("Fila1",fecha1, 25.5, 132);
    hojaCalculo1.addFila("Fila2",fecha2, 300, 350);
    hojaCalculo1.addFila(fila3);
    hojaCalculo1.addFila(fila4);
    
    
    System.out.print(hojaCalculo1.toString());
    System.out.print(hojaCalculo1.duplicarHoja().toString());
}

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de calculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
    Fecha fecha1 = new Fecha(7,10,2020);
    Fecha fecha2 = new Fecha(8,10,2020);

    hojaCalculo2.addFila("Fila1",fecha1, 260, 125);
    hojaCalculo2.addFila("Fila2",fecha2, 125, 245);

    System.out.print(hojaCalculo2.toString());
    System.out.print(hojaCalculo2.duplicarHoja().toString());         
}

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de calculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {   
    Fila fila = new Fila("Fila1",new Fecha(8,10,2020),670, 234);
    
    hojaCalculo3.addFila(fila);
    
    System.out.print(hojaCalculo3.toString());
    System.out.print(hojaCalculo3.duplicarHoja().toString());   
}
}
