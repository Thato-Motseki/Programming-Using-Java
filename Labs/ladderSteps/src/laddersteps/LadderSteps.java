
package laddersteps;

public class LadderSteps {

    public static void main(String[] args) {
        int wallHeight = 1000;
        int stepLength = 50;
        
        int topStep = wallHeight/stepLength;
        int wallTop = topStep + 1; 
        
        int position = 0;
        int forwardStep = 0;
        int backwardStep = 0;
        int totalSteps = 0;
          
        
        while (position < wallTop){
            position ++;
            forwardStep ++;
            totalSteps ++;
            
            
            
            if (forwardStep % 2 == 0 && position < wallTop){
                position --;
                backwardStep ++;
                totalSteps ++;
            }
            
        }
        
        System.out.println("Top of ladder: Step " + topStep); 
        System.out.println("Top of wall: Step " + wallTop);
        System.out.println("Forward Steps: " + forwardStep);
        System.out.println("Backward Steps: " + backwardStep);
        System.out.println("Total Steps: " + totalSteps);
        
    }
    
}
