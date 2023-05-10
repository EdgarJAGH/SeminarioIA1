public class Main {
	public static void main(String[] noseusa) {
		GA geneticAlgorithm = new GA();
		
        System.out.println("Program for genetic algorithm for MAXONES");
        System.out.println("Jimenez Aceves Edgar \n");
        
        System.out.println("Poblacion inicial");
        geneticAlgorithm.printCurrentPopulation();
        System.out.println("----------------------------------------");
        geneticAlgorithm.startGA();
        geneticAlgorithm.printCurrentPopulation();
        if (geneticAlgorithm.isCriterionSatisfied())
            System.out.println("Se encontro una solucion en la generacion " + geneticAlgorithm.generation);
        else
            System.out.println("No se encontro la solucion");
    }
}
