import java.util.Random;

public class Matrix{
    
    // matrix[row][col]
    
    public static double[][] transpose(double[][] a){
        double[][] output = new double[a.length][a[0].length];
        
        for(int row=0; row<output.length; row++){
            for(int col=0; col<output[0].length; col++){
                output[row][col] = a[col][row];
            }  
        }
        
        return output;
    }
    
    public static double[][] multiply(double[][] a, double[][] b){
        
        double[][] output = new double[a.length][b[0].length];
        
        for(int row=0; row < output.length; row++){
            for(int col=0; col < output[0].length; col++){
                output[row][col] = dotProduct(getRow(a, row), getCol(b, col));
            }
        }
        
        return output;
        
    }
    
    public static double[][] multiply(double scalar, double[][] b){
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < output.length; row++){
            for(int col=0; col < output[0].length; col++){
                output[row][col] = b[row][col]*scalar;
            }
        }
        
        return output;
        
    }
    
    public static double[][] multiply(int scalar, double[][] b){
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < output.length; row++){
            for(int col=0; col < output[0].length; col++){
                output[row][col] = b[row][col]*scalar;
            }
        }
        
        return output;
        
    }
    
    public static double[][] multiply(double[][] b, double scalar){
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < output.length; row++){
            for(int col=0; col < output[0].length; col++){
                output[row][col] = b[row][col]*scalar;
            }
        }
        
        return output;
        
    }
    
    public static double[][] multiply(double[][] b, int scalar){
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < output.length; row++){
            for(int col=0; col < output[0].length; col++){
                output[row][col] = b[row][col]*scalar;
            }
        }
        
        return output;
        
    }
    
    /**
     * @param index of row to return
     * @return row of matrix as an array
     */
    public static double[] getRow(double[][] a, int row){
        if(row>=a.length || row<0){
            throw new IllegalArgumentException("invalid row: " + row);
        }
        
        return a[row];
    }
    
    /**
     * @param index of column to return
     * @return column of matrix as an array
     */
    public static double[] getCol(double[][] a, int col){
        if(col>=a[0].length || col<0){
            throw new IllegalArgumentException("invalid column: " + col);
        }
        
        double[] output = new double[a.length];
        
        for(int i=0; i<output.length; i++){
            output[i] = a[i][col];
        }
        
        return output;
        
    }
    
    /**
     * @param a -- first 1d vector
     * @param b -- second 1d vector
     * @return dot product of two vectors
     */ 
    public static double dotProduct(double[] a, double[] b){
        if(a.length != b.length){
            throw new IllegalArgumentException("lengths of arguments unequal:" + a.length + " != " + b.length);
        }
        
        double sum = 0;
        
        for(int i=0; i < a.length; i++){
            sum+=a[i]*b[i];
        }
        
        return sum;
    }
    
    public static double[][] add(double[][] a, double[][] b){
        if(a.length != b.length && a[0].length != b[0].length){
            throw new IllegalArgumentException("matricies have different dimensions: " + a.length + " x " + a[0].length + " and " + + b.length + " x " + b[0].length);
        }
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < b.length; row++){
            for(int col=0; col < b[0].length; col++){
                output[row][col] = a[row][col] + b[row][col];
            }
        }
        
        return output;
        
    }
    
    public static double[][] subtract(double[][] a, double[][] b){
        if(a.length != b.length && a[0].length != b[0].length){
            throw new IllegalArgumentException("matricies have different dimensions: " + a.length + " x " + a[0].length + " and " + + b.length + " x " + b[0].length);
        }
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < b.length; row++){
            for(int col=0; col < b[0].length; col++){
                output[row][col] = a[row][col] - b[row][col];
            }
        }
        return output;
    }
    
    public static double[][] multiplyElementwise(double[][] a, double[][] b){
        if(a.length != b.length && a[0].length != b[0].length){
            throw new IllegalArgumentException("matricies have different dimensions: " + a.length + " x " + a[0].length + " and " + + b.length + " x " + b[0].length);
        }
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < b.length; row++){
            for(int col=0; col < b[0].length; col++){
                output[row][col] = a[row][col] * b[row][col];
            }
        }
        return output;
    }
    
    public static double[][] divideElementwise(double[][] a, double[][] b){
        if(a.length != b.length && a[0].length != b[0].length){
            throw new IllegalArgumentException("matricies have different dimensions: " + a.length + " x " + a[0].length + " and " + + b.length + " x " + b[0].length);
        }
        
        double[][] output = new double[b.length][b[0].length];
        
        for(int row=0; row < b.length; row++){
            for(int col=0; col < b[0].length; col++){
                output[row][col] = a[row][col] / b[row][col];
            }
        }
        return output;
    }
    
    public static String toString(double[][] a){
        String output = "{";
        
        for(int row=0; row<a.length; row++){
            output += "[";
            for(int col=0; col<a[0].length; col++){
                output += (a[row][col]);
                if(col!=a[0].length-1){
                    output += ", ";
                }
            }
            output += "]";
            if(row!=a.length-1){
                    output += ",\n";
            }
        }
        output += "}";
        return output;
    }
    public static String toString(double[][][] a){
        String output="[\n";
        for(int index=0; index<a.length; index++){
            output += (Matrix.toString(a[index])+"\n\n");
        }
        return output+"]";
    }
    
    public static String toString(double[] a){
        String output = "{";
        for(int col=0; col<a.length; col++){
            output += (a[col]);
            if(col!=a.length-1){
                output += ", ";
            }
        }
        output += "}";
        return output;
    }
    
    public static String toStringOneLine(double[][] a){
        if(a.length==1&&a[0].length==1){
            return a[0][0]+"";
        }
        
        String output = "{";
        
        for(int row=0; row<a.length; row++){
            output += "[";
            for(int col=0; col<a[0].length; col++){
                output += (a[row][col]);
                if(col!=a[0].length-1){
                    output += ", ";
                }
            }
            output += "]";
            if(row!=a.length-1){
                    output += ",";
            }
        }
        output += "}";
        return output;
    }
    public static String toStringOneLine(double[][] a, int maxChars){
        if(a.length==1&&a[0].length==1){
            return a[0][0]+"";
        }
        
        String output = "{";
        
        for(int row=0; row<a.length; row++){
            output += "[";
            for(int col=0; col<a[0].length; col++){
                output += (a[row][col]);
                if(col!=a[0].length-1){
                    output += ", ";
                }
            }
            output += "]";
            if(output.length() >= maxChars){
                return (output.substring(0, maxChars-3)+"...");
            }
            if(row!=a.length-1){
                    output += ",";
            }
        }
        
        output += "}";
        return output;
    }
    
    public static double[][] normalize(double[][]a){
        double sum=0;
        
        for(int row=0; row<a.length; row++){
            for(int col=0; col<a[0].length; col++){
                sum+=Math.pow(a[row][col], 2);
            }
        }
        
        if(sum == 0){
            return a;
        }
        
        sum=Math.sqrt(sum);
        
        for(int row=0; row<a.length; row++){
            for(int col=0; col<a[0].length; col++){
                a[row][col]/=sum;
            }
        }
        
        return a;
    }
    
    
    /**
     * 
     * replaces all values of given array with random doubles
     */
    public static double[][] randomizeArray(double[][] a){
        Random rand = new Random();
        for(int row=0; row<a.length; row++){
            for(int col=0; col<a[0].length; col++){
                a[row][col] = rand.nextDouble();
            }
        }
        
        return a;
    }
    
    /**
     * 
     * replaces all values of given array with random doubles using specified Random object
     */
    public static double[][] randomizeArray(double[][] a, Random rand){
        for(int row=0; row<a.length; row++){
            for(int col=0; col<a[0].length; col++){
                a[row][col] = rand.nextDouble();
            }
        }
        
        return a;
    }
}