/**
 * Describe a un estudiante
 * Todo estudiante tiene un nombre
 * y guarda las 3 notas que ha sacado en cada una de las tres unidades de
 * trabajo que hay en la evaluaci�n
 */
public class Estudiante {
    private String nombre;
    private NotaEstudianteUnidad notaA;
    private NotaEstudianteUnidad notaB;
    private NotaEstudianteUnidad notaC;

    /**
     * Constructor
     * Inicializa el nombre del estudiante y el resto lo deja a null
     * Cuando se crea un estudiante inicialmente no tiene registrada ninguna
     * nota
     */
    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notaA = null;
        this.notaB = null;
        this.notaC = null;
    }

    /**
     * Accesor para el nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Mutador para el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la cantidad de notas registradas hasta el momento
     * (0, 1, 2 o 3)
     */
    public int totalNotas() {
        int notas = 0;
        
        if(notaA != null){
            notas++;
        }
        else if(notaB != null){
            notas++;
        }
        else if(notaC != null){
            notas++;
        }
        
        return notas;
    }

    /**
     * registra un nuevo objeto nota, la nota asociada a una unidad
     * Los objetos se sit�an uno detr�s de otro pero siempre han de quedar
     * las notas en orden de fecha de finalizaci�n de la UT asociada (de
     * menor a mayor)
     * 
     * Pista!! En este m�todo se utilizar� el m�todo totalNotas()
     */
    public void registrarNotaUnidad(NotaEstudianteUnidad nota) {
        if(totalNotas() == 0){
            notaA = nota;
        }   
        else if(totalNotas() == 1){
            if(notaA.getUnidad().getFechaFin().antesQue(nota.getUnidad().getFechaFin())) {
                notaB = nota;
            }
            else{
                NotaEstudianteUnidad temp = notaA;
                notaA = nota;
                notaB = temp;
            }
        }
        else if(totalNotas() == 2){
            if(nota.getUnidad().getFechaFin().antesQue(notaA.getUnidad().getFechaFin()) && nota.getUnidad().getFechaFin().antesQue(notaB.getUnidad().getFechaFin())){
                NotaEstudianteUnidad temp1 = notaA;
                NotaEstudianteUnidad temp2 = notaB;
                
                notaA = nota;
                notaB = temp1;
                notaC = temp2;
            }
            else if(nota.getUnidad().getFechaFin().antesQue(notaB.getUnidad().getFechaFin())){
                NotaEstudianteUnidad temp1 = notaB;
                
                notaB = nota;
                notaC = temp1;
            }
        }
    }

   
    /**
     * Calcula y devuelve la nota final obtenida por el estudiante en la
     * evaluaci�n que depender� de la ponderaci�n de cada UT
     * El m�todo devuelve -1 si al invocarlo no se han registrado los tres
     * objetos NotaEstudianteUnidad que se necesitan para calcular la nota final
     */
    public double calcularNotaFinalEstudiante() {
       //TODO
       
       
       return 0;

    }

    /**
     * Representaci�n textual del estudiante (ver enunciado)
     */
    public String toString() {
       //TODO
       
       
       return null;
    }

    /**
     * Este m�todo se ha incluido solo para testear la clase m�s f�cilmente
     */
    public void print() {
        System.out.println(this.toString());

    }

    

}
