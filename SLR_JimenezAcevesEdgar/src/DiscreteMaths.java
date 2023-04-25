
public class DiscreteMaths {
	 public DiscreteMaths(){}

    public float sumX(float x[]) {
        float totalX = 0;

        for(int i=0; i < x.length ; i++)
            totalX = totalX + x[i];

        return totalX;
    } 
    
    public float sumX2(float x[]) {
        float totalX2 = 0;

        for(int i=0; i < x.length ; i++)
            totalX2 = totalX2 + x[i]*x[i];

        return totalX2;
    } 

    public float sumY(float y[]) {
        float totalY = 0;

        for(int i=0; i < y.length ; i++)
            totalY = totalY + y[i];

        return totalY;
    }

    public float sumXY(float x[], float y[]) {
        float totalXY = 0;
        
        for(int i=0; i < x.length ; i++)
            totalXY = totalXY + (x[i] * y[i]);

        return totalXY;
        
    }

    public float sumXsumY(float sumX, float sumY) {
        return sumX * sumY;
    }
}
