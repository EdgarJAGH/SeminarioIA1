
public class Main {
	public static void main(String[] noseusa) {
        DataSet dataSet = new DataSet();
        DiscreteMaths discreteMaths = new DiscreteMaths();
        SLR slr = new SLR();
        
        System.out.println("Program for simple linear regression");
        System.out.println("Jimenez Aceves Edgar \n");

        System.out.println("sumX =" + discreteMaths.sumX(dataSet.getX()));
        System.out.println("sumY =" + discreteMaths.sumY(dataSet.getY()));
        System.out.println("sumX^2 =" + discreteMaths.sumX2(dataSet.getX()));
        System.out.println("sumXY =" + discreteMaths.sumXY(dataSet.getX(), dataSet.getY()));
        System.out.println("sumXsumY =" + discreteMaths.sumXsumY(discreteMaths.sumX(dataSet.getX()), 
                                                                 discreteMaths.sumY(dataSet.getY())));
        System.out.println("Beta 0 =" + slr.toComputeBeta0());
        System.out.println("Beta 1 =" + slr.toComputeBeta1());

        slr.printRegEquation();
        System.out.println("Prediction of  60 = " + slr.toPredict(60));
        System.out.println("Prediction of  22 = " + slr.toPredict(22));
        System.out.println("Prediction of  59 = " + slr.toPredict(59));
        System.out.println("R^2 = " + slr.RSquared());
    }
}
