import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;

/**
 * Created by Volker on 25.02.17.
 */
public class NeuralNetwork {

//    private static Logger log = LoggerFactory.getLogger(NeuralNetwork.class);

    public static MultiLayerConfiguration configNeuralNetwork() {


//        log.info("**** CREATING NEURAL NETWORK");
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(Configuration.rngseed)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .iterations(Configuration.iterations)
                .learningRate(Configuration.learningRate)
                .updater(Updater.NESTEROVS).momentum(Configuration.momentum)
                .regularization(true).l2(1e-4)
                .list()
                .layer(0, new DenseLayer.Builder()
                        .nIn(Configuration.height * Configuration.width)
                        .nOut(100)
//                        .activation("relu")
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .layer(1, new OutputLayer.Builder()
                        .nIn(100)
                        .nOut(Configuration.outputNum)
//                        .activation("softmax")
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .pretrain(false).backprop(true)
                .setInputType(InputType.convolutional(Configuration.height, Configuration.width, Configuration.channels))
                .build();

        return conf;

    }
}

