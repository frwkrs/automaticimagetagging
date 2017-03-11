

/**
 * Created by Volker on 25.02.17.
 *
 * File for configuring the Model
 */
public class Configuration {

    // size of the images
    // they are going to be transformed to that size
    // also size of the matrix
    static final int height =1024;
    static final int width =768;
    // channels = red green blue
    static final int channels = 3;
    // seed for repeatable tests
    static final int rngseed = 123;
    static final int batchSize = 1;
    // number of possible labers
    static final int outputNum = 2;

    static final int numEpochs = 15;

    static final double learningRate = 0.006;
    static final int iterations = 1;
    static final double momentum = 0.9;


//    public static Configuration getConfiguration() {
//        Configuration cfg = new Configuration();
//        //image information
//        // size = XXX * XXX
//        return cfg;
//    }



}