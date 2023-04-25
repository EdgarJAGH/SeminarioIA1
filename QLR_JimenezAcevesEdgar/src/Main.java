
public class Main {
	public static void main(String[] noseusa) {
		DataSet dataSet = new DataSet();
        DiscreteMaths discreteMaths = new DiscreteMaths();
        QLR qlr = new QLR();
		
        System.out.println("Program for quadratic linear regression");
        System.out.println("Jimenez Aceves Edgar \n");
        
        System.out.println("sumX =" + discreteMaths.sumX(dataSet.getX()));
        System.out.println("sumY =" + discreteMaths.sumY(dataSet.getY()));
        System.out.println("sumX^2 =" + discreteMaths.sumX2(dataSet.getX()));
        System.out.println("sumX^3 =" + discreteMaths.sumX3(dataSet.getX()));
        System.out.println("sumX^4 =" + discreteMaths.sumX4(dataSet.getX()));
        System.out.println("sumXY =" + discreteMaths.sumXY(dataSet.getX(), dataSet.getY()));
        System.out.println("sumX^2Y =" + discreteMaths.sumX2Y(dataSet.getX(), dataSet.getY()));
        System.out.println("");
        
        System.out.println("Beta 0 =" + qlr.toComputeBeta0());
        System.out.println("Beta 1 =" + qlr.toComputeBeta1());
        System.out.println("Beta 2 =" + qlr.toComputeBeta2());

        qlr.printRegEquation();
        System.out.println("Prediction of  -2.5 = " + qlr.toPredict(-2.5f));
        System.out.println("Prediction of  0.5 = " + qlr.toPredict(0.5f));
        System.out.println("Prediction of  2.6 = " + qlr.toPredict(2.6f));
        System.out.println("R^2 = " + qlr.RSquared());

    }
}
