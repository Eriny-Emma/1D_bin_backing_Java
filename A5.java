import java.util.*;
import java.io.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class A5{
    static long endTime;
    static long startTime;
    static long elapsedTime;
   
    public static void main(String[] args)

    { 
        int runagain = 0;
            do{
       runagain = driver();
            }
            while (runagain==0);
    }//End of main


/* driver - method to call the necessary methods involved, returns prompt 
if user wants to run the program again*/
    public static int driver()
    {
    ArrayList<ArrayList<Double>> binVal = getUserInput();
    int binlength = binVal.size()-1;
    String srep = Arrays.toString(binVal.toArray());
    //System.out.println(" Driver"+Arrays.toString(binVal.toArray()));

    report( srep, binlength);
    return display(binlength);
    }

/*getUserInput () - Prompts user for input and checks input logic to make
sure that all values are logical and valid, before calling binPack()
 returns the BinPack() calculation as 2D ArrayList */
    public static ArrayList<ArrayList<Double>> getUserInput() // Gets input from the user
    {
        int interlude = 1;
        int binCap;
        int numObj;
        int randVal= -1;
        ArrayList < ArrayList < Double >> solved = new ArrayList < ArrayList < Double >>();
        double[] allValues ;
        do {
            int demo=presetdemo();
            if(demo==0) // small demo
            {
                interlude=0;
                binCap=500 ;
                numObj=1000 ;
                allValues= new double[]{
                        353,154,86,231,369,480,118,219,461,319,199,84,158,432,419,105,345,443,415,331,213,165,470,362,141,414,361,101,364,412,290,460,203,282,453,483,297,392,291,122,418,461,216,231,96,462,153,350,419,305,188,163,259,375,468,112,497,131,100,185,409,243,154,431,377,389,204,240,338,406,479,184,458,424,378,445,298,431,308,470,361,332,491,452,88,163,413,212,110,187,249,87,139,307,328,278,314,89,224,355,358,235,214,438,337,468,427,243,177,408,122,272,430,318,275,383,457,422,225,433,443,257,178,406,269,110,250,229,216,182,115,105,379,258,215,256,244,382,285,429,389,434,105,387,175,413,239,353,230,407,427,155,315,247,413,94,422,116,308,254,109,484,451,119,272,457,163,100,113,264,361,274,384,183,132,367,189,260,196,208,289,265,292,95,118,125,334,160,482,82,328,171,185,92,349,374,181,153,377,457,176,194,405,225,184,199,86,209,420,91,182,170,459,469,160,427,280,170,111,200,162,123,235,468,212,178,209,350,217,155,420,414,81,99,218,344,274,455,250,401,486,428,491,470,260,232,394,471,252,272,379,252,126,181,225,372,102,449,466,420,124,442,188,132,308,223,173,164,401,441,199,411,256,402,176,296,175,152,393,248,148,322,414,138,197,87,232,276,237,194,406,491,493,415,161,314,233,383,317,160,400,448,250,220,498,298,158,91,84,339,285,492,132,436,302,422,382,235,110,223,422,385,140,442,451,343,80,404,287,210,461,330,266,317,147,346,386,169,335,451,385,281,227,123,443,160,190,178,355,324,428,241,424,391,323,219,280,293,354,226,454,91,491,209,204,458,164,195,498,116,318,234,380,333,198,155,177,109,400,219,457,362,499,424,148,429,140,120,350,328,314,335,436,83,200,329,235,81,413,278,340,299,220,88,317,372,455,199,258,330,315,141,350,97,201,261,480,486,420,343,117,82,413,133,245,216,394,466,148,260,433,277,246,203,230,233,435,396,430,232,233,206,88,257,263,172,151,476,443,389,280,200,409,467,367,276,151,121,80,212,468,216,298,222,253,281,222,479,308,248,257,433,255,477,230,338,271,93,130,331,184,202,468,291,134,234,157,331,311,336,212,276,469,176,299,95,347,120,282,217,427,100,479,457,341,366,209,344,206,443,443,357,435,278,110,254,274,168,181,165,356,440,445,378,358,379,472,313,268,253,344,392,482,162,203,392,177,120,96,269,315,185,330,265,231,402,126,261,332,456,113,320,366,359,228,91,327,345,351,420,368,487,85,87,364,227,384,310,491,285,121,416,455,168,93,471,315,319,181,362,282,354,94,118,357,128,370,389,448,313,221,209,81,270,308,193,306,288,144,91,312,490,148,83,191,323,307,97,328,197,361,408,423,482,391,353,393,269,407,251,265,410,243,205,171,407,499,121,358,392,222,240,176,154,404,279,134,353,442,130,378,199,241,82,81,361,257,193,366,353,185,118,476,372,98,252,165,342,431,265,149,84,255,213,454,274,259,341,249,382,392,332,118,183,448,154,413,93,325,97,463,153,275,202,343,132,369,403,339,117,352,248,331,250,433,487,97,356,453,334,158,118,319,121,443,81,153,443,106,395,103,207,87,455,391,362,301,458,395,242,403,177,339,419,307,473,241,338,388,434,258,262,153,390,243,424,285,141,80,165,130,148,85,459,122,402,120,345,259,221,467,180,269,439,331,263,224,416,108,123,452,149,209,320,370,398,251,326,426,296,230,465,416,213,353,252,343,276,300,310,218,182,484,178,310,267,261,243,334,356,301,127,364,390,86,335,407,135,387,306,377,350,383,326,206,342,353,436,449,354,156,333,153,480,130,423,141,328,338,232,373,475,97,401,138,178,339,295,85,222,404,91,326,185,408,411,361,416,253,487,159,291,148,317,496,90,261,257,411,497,412,347,333,499,417,259,333,381,312,218,423,448,135,379,128,342,395,101,266,184,116,251,482,455,407,253,98,125,409,259,328,221,205,383,239,399,105,377,110,261,419,420,368,97,436,414,378,346,459,238,345,349,367,104,480,177,206,206,205,89,207,257,277,290,147,284,398,147,91,263,410,245,148,124,338,419,387,141,162,313,181,348,442,452,406,386,217,371,247,103,481,473,96,155,426,264,342,395,425,244,412,134,228,482,381,417,346,286,292,119,431,170,348,287,443,327,292,407,324,94,290,475,176,445,187,210,123,217,345,228,443,141,240,214,355,290,138,338,241,101,266,456,374,86,234,84,110,406,297,366
                         };

            }
            else if(demo==1)
            {
                interlude=0;
                binCap=1000  ;
                numObj=100000  ;
                allValues=new double[numObj];

                ArrayList<Float> result = new ArrayList<>();
                try (Scanner s = new Scanner(new FileReader("input.txt"))) {
                    while (s.hasNext()) {
                     result.add(s.nextFloat());
                     }
                } catch (FileNotFoundException e) {
                   e.printStackTrace();
                }

                for (int k=0;k<result.size();k++)
                {
                    allValues[k]= result.get(k);
                }
            }
            else
            {
                binCap = getBinCap();
                JOptionPane.showMessageDialog(null, "BIN CAPACITY set to: " + binCap);
                numObj = getNumObj();
                JOptionPane.showMessageDialog(null, "Working with: " + numObj + " OBJECTS ");
                randVal = askRand();
                if (randVal== 0){
                    allValues = allObjValRand(binCap, numObj);
                }
                else{
                    allValues = getAllObjVal(binCap, numObj);
                }

                interlude = interlude(binCap, numObj, allValues);
            }

        }
        while (interlude == 1); 
        solved = binPack(allValues, numObj, binCap); 
         return solved;
    }

public static double[] allObjValRand(int binCap, int numObj){

      double value = 0;
        double[] allObjVal = new double[numObj];//organizes and assigns all of our values into a DS

        for (int i = 1; i <= numObj; i++) {
            value =  (Math.random() * (binCap - 0.2)) + 0.2;
            allObjVal[i - 1] = value;
        }
        return allObjVal;
 }
    public static int askRand(){
    int askR = JOptionPane.showConfirmDialog(null, "Use randomized object values?\n" +
                                                        "[CHOOSE ONE]\n", null, JOptionPane.YES_NO_OPTION);
        return askR;
    }

/*binPack () - takes in input parameters which would have been validated by
                getUserInput and calculates the number of Bins used using first fit heuristic.
                Returns the calculated values as an 2D ArrayList */
    public static ArrayList < ArrayList < Double >> binPack(double weight[], int n, double bin_cap) {
        int binCount = 0;
        int k = 0;
        double[] bin_space = new double[n];
        ArrayList < Integer > bin = new ArrayList < Integer > ();
        ArrayList < Double > val = new ArrayList < Double > ();
        ArrayList < ArrayList < Double >> binVal = new ArrayList < ArrayList < Double >> ();
        binVal.add(k, new ArrayList < Double > ());
        System.out.println(".......Commencing Calculation...........\n");
        startTime = System.nanoTime();

        ////////////////// sort the weights.//////////////////////////////////
        //.sort(weight);
        ParallelMergeSort.parallelMergeSort(weight);
        /////////////////////////////////////////////////////////////////////


        ////// the first bin that has cappacity to hold
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < binCount; j++) {
                
                if (bin_space[j] >= weight[i]) {
                    bin_space[j] = bin_space[j] - weight[i];
                    //val.add(weight[i]);
                    (binVal.get(j)).add((weight[i]));
                    k=j+1;
                    System.out.println("---Bin " + j + " took in weight " + weight[i]);
                    break;
                }
                 
            }
                System.out.println("*Bad fit for next weight size "+ weight[i]+ 
                "\n\n ***NEW BIN CREATED***\n");
            /////// no open bins can hold the weight--> open a new bin
            if (j == binCount) {
              
                bin_space[binCount] = bin_cap - weight[i];
                //val.add(weight[i]);
                binCount++;
                //k++;
                bin.add(j);
                binVal.add(j, new ArrayList < Double > ());
                (binVal.get(j)).add((weight[i]));
                k=j+1;
                System.out.println("---Bin " + k + " took in weight **" + weight[i]);
            }
        } 
       endTime = System.nanoTime();
       elapsedTime = (endTime- startTime);
       System.out.println("\nBIN PACKING ALGORITHM COMPLETE\n");

       return binVal;
    }


    public static int presetdemo() //Obtains Bin Capacity
    {
        int summary = JOptionPane.showConfirmDialog(null,"----------------[preset demo?]----------------\n" +
                "[Small demo]         - 500 bin capacity and 1000 objects\n" +
                "[Large Demo]          - 1000  bin capacity and 100000 objects\n" +
                "[Enter custom values]     \n" , "CONFIRMATION", JOptionPane.YES_NO_CANCEL_OPTION);
        return summary;
    }



    /* getNumObj() - Works with getUserInput() to prompt user for the number of
                 objects they intend to fit in the bin, also checks for format
                 errors to ensure only integers are input. Returns the number of 
                 objects to be used as an int */
    public static int getNumObj() //Gets the number of objects 
    {
        int numObj = -1;
        try {
            if (numObj <= 0) {
                numObj = Integer.parseInt((JOptionPane.showInputDialog("Please enter (POSITIVE) INTEGER for NUMBER-OF-OJECTS:  ")));
                if (numObj <= 0) {
                    throw new NumberFormatException();
                }
            }
        } catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(null, "ERROR!!!\n - NUMBER OF OBJECTS MUST BE A (POSITIVE) INTEGER - \n Please try again! \n ", null, JOptionPane.ERROR_MESSAGE);
            numObj = getNumObj(); //recursion
        }

        return numObj;
    }

/* getBinCap() - Works with getUserInput() to prompt user for the capacity of the 
                 Bins they intend to use, also checks for format
                 errors to ensure only integers are input. Returns the number of 
                 objects to be used as an int */
    public static int getBinCap() //Obtains Bin Capacity
    {
        int binCap = -1;

        try {
            binCap = Integer.parseInt((JOptionPane.showInputDialog("Please enter (POSITIVE) INTEGER for BIN CAPACITY:  ")));
            if (binCap <= 0) {
                throw new NumberFormatException();
            }
        } catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(null, "ERROR!!!\n" + "-BIN CAPACITY MUST BE A (POSITIVE) INTEGER-\n" + "Please try again!", null, JOptionPane.ERROR_MESSAGE);
            binCap = getBinCap();
            //recursion
        }
        return binCap;
    }

/* getObjVal-    Works with getUserInput() to prompt user for the value/ size of the 
                 objects within the set they intend to use, also checks for format
                 errors to ensure only values within the BIN capacity size are accepted.
                 Accepts both Integers and doubles
                  Returns only valid input numbers of objects to be used as a double*/
    public static double getObjVal(int binCap, int numObj, int i) //obtains individual values of our objects
    {
        double objVal = -1;

        try {
            objVal = Double.parseDouble((JOptionPane.showInputDialog("OBJECT #:" + i + " out of " + numObj + "\n Enter INT/DOUBLE (POSITIVE) for next size:")));
            if (objVal <= 0 || objVal > binCap) {
                throw new NumberFormatException();
            }
        } catch (Exception NumberFormatException) {
            JOptionPane.showMessageDialog(null, "ERROR!!!\n - OBJECT SIZE MUST BE POSITIVE - \n - OBJECT SIZE MUST BE INT/DOUBLE - \n -OBJECT SIZE MUST NOT EXCEED BIN CAPACITY:" + binCap +
                " -\n - Please try again! -  \n ", null, JOptionPane.ERROR_MESSAGE);
            objVal = getObjVal(binCap, numObj, i); //recursion, see what i did here...lol
        }
        return objVal;
    }

/*getAllObjVal-  Formats value for the objects we are trying to fit in the bins. Places them
                into an array for better collectivity and manipulation. Returns the array
                of the values as an Array of doubles*/
    public static double[] getAllObjVal(int binCap, int numObj) 
    {
        double value = 0;
        double[] allObjVal = new double[numObj];//organizes and assigns all of our values into a DS
        for (int i = 1; i <= numObj; i++) {
            value = getObjVal(binCap, numObj, i);
            allObjVal[i - 1] = value;
        }
        return allObjVal;
    }

/* interlude() - Takes in the user's values and displays them to the user through the pane. 
                Acts as a failsafe and feedback so that the user can confirm the values they
                have entered and confirm them. Also allows for recourse so that the user can change
                the values they have entered if they are not happy with them. Also allows user to
                Exit the program*/
    public static int interlude(int binCap, int numObj, double allValues[]) // confirms the values 
    {

        JTextArea msg = new JTextArea("CONFIRMATION OF CHOSEN VALUES:\n\n" +
            "\nBIN-CAPCITY: " + binCap +
            "\nNUMBER-OF-OBJECTS: " + numObj +
            "\nOBJECT SIZES: \n" + Arrays.toString(allValues));
            msg.setLineWrap(true);
            msg.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(msg);
            JOptionPane.showMessageDialog(null, scrollPane);
             int summary = JOptionPane.showConfirmDialog(null,"----------------[PLEASE CHOOSE ONE]----------------\n" +
            "[YES]         - to CONTINUE\n" +
            "[NO]          - to change your values\n" +
            "[CANCEL]    - to EXIT PROGRAM \n" , "CONFIRMATION", JOptionPane.YES_NO_CANCEL_OPTION);
        if (summary == 2) {
            quit();
        }
        return summary;
    }

/*report() - prints out stastics to the user so that they can see how the bin-packing
           Algorithm went. Prints out to the console for more detail*/
    public static void report (String rep,int numBins ){
        System.out.println("\n\n ..................COMPILING REPORT......................");
        System.out.println("Total Bins used =" + numBins);
        System.out.println("Total time spent =" + elapsedTime +"[M/S]");
        String [] binVal = rep.split("],");
        float [] binvaluesarray=new float[numBins];
        for( int i =0;i<numBins; i++)
        {
            int j= i+1;
           String binValues =  binVal[i];
            binValues = binValues.replaceAll("[\\[\\](){}]","");
            String splitedvalues[] = binValues.split(",", 0);
            float totalinbin=0;
            for (String e : splitedvalues)
            {
                totalinbin+=Float.parseFloat(e);
            }
            binvaluesarray[i]=totalinbin;
            // System.out.println(" Bin "+ j +" Contains values: \n"+ binValues + "\n");
        }
        System.out.println("-------waste calculate--------\n");
        float sum = 0;
        for (float e : binvaluesarray) sum += e;
        System.out.println("total waste = " + sum +"\n");
        float avrage = sum / numBins;
        System.out.println("avrage waste = " + avrage +"\n");



        System.out.println("End of Report..........\n\n");
    }

/*display() - prints out a summary of the stastics to the user so that they can see how the bin-packing
           Algorithm went. Also prompts the user for another run or to exit the 
           program. Allows for recourse*/
    public static int display( int binlength){
    JOptionPane.showMessageDialog(null, "\n FOR DETAILED REPORT\nPLEASE CHECK CONSOLE");

    int summary = JOptionPane.showConfirmDialog(null, 
            "\n-------------RESULTS----------------\n"+
            "TOTAL BINS USED : " + binlength + " \n"+
            "TIME TAKEN: " + elapsedTime + " (M/S) \n" +
            "\n\n" +"Run NEW test? \n"+
            "   [CHOOSE ONE]\n" + 
            "[YES]      - to RUN \n" +
            "[NO]       - to EXIT PROGRAM \n" , "CONFIRMATION" , JOptionPane.YES_NO_OPTION);
        if (summary != 0) {
            quit();
        }
        return summary;
    }

/*quit() - Allows the user to confirm that they really want to quit the program.
            Shows up as a dialog box and avoids accidentally terminating the program
            when the user wanted to do more tests*/
    public static int quit() {
        int quit = JOptionPane.showConfirmDialog(null, "Exit Program? ", null, JOptionPane.YES_NO_OPTION);
        if (quit != 0) {//Confirms Program Termination
            //do nothing 
        } else
            System.exit(quit);
        return quit;
    }

}//End of A5.Java