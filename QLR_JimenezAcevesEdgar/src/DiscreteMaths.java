
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
            totalX2 = totalX2 + (x[i]*x[i]);

        return totalX2;
    } 
    
    public float sumX3(float x[]) {
        float totalX3 = 0;

        for(int i=0; i < x.length ; i++)
            totalX3 = totalX3 + (x[i]*x[i]*x[i]);

        return totalX3;
    }
    
    public float sumX4(float x[]) {
        float totalX4 = 0;

        for(int i=0; i < x.length ; i++)
            totalX4 = totalX4 + (x[i]*x[i]*x[i]*x[i]);

        return totalX4;
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
    public float sumX2Y(float x[], float y[]) {
        float totalXY = 0;
        
        for(int i=0; i < x.length ; i++)
            totalXY = totalXY + (x[i]* x[i] * y[i]);

        return totalXY;
        
    }

    public float sumXsumY(float sumX, float sumY) {
        return sumX * sumY;
    }
    public float EXX(float sumX2, float sumX, int n) {
        return sumX2 - ((sumX*sumX)/n);
    }
    public float EXY(float sumXY, float sumX, float sumY, int n) {
        return sumXY - ((sumX*sumY)/n);
    }
    public float EXX2(float sumX3, float sumX2, float sumX, int n) {
        return sumX3 - ((sumX2*sumX)/n);
    }
    public float EX2Y(float sumX2Y, float sumX2, float sumY, int n) {
        return sumX2Y - ((sumX2*sumY)/n);
    }
    public float EX2X2(float sumX4, float sumX2, int n) {
        return sumX4 - ((sumX2*sumX2)/n);
    }
}
