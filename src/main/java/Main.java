import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

import java.io.IOException;


/**
 * Created by Volker on 26.02.17.
 */
public class Main {

//    private static Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws IOException {

//        NeuralNetwork neuralNetwork = new NeuralNetwork();
        MultiLayerConfiguration conf = NeuralNetwork.configNeuralNetwork();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
//        ImagePipeline2 imagePipeline2 = new ImagePipeline2();
        DataSetIterator dataIter = ImagePipeline2.createDataIter();

        model.setListeners(new ScoreIterationListener(10));
//        log.info("******TRAIN MODEL*******");

        for (int i = 0; i < Configuration.numEpochs; i++) {
            model.fit(dataIter);


        }
    }
}
