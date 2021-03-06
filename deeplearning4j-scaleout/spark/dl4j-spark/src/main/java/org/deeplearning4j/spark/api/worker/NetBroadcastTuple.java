package org.deeplearning4j.spark.api.worker;

import lombok.Data;
import org.deeplearning4j.nn.conf.ComputationGraphConfiguration;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.nd4j.linalg.api.ndarray.INDArray;

import java.io.Serializable;

/**
 * A simple class for storing configurations, parameters and updaters in one class (so they can be broadcast together)
 *
 * @author Alex Black
 */
@Data
public class NetBroadcastTuple implements Serializable {

    private final MultiLayerConfiguration configuration;
    private final ComputationGraphConfiguration graphConfiguration;
    private final INDArray parameters;
    private final INDArray updaterState;

    public NetBroadcastTuple(MultiLayerConfiguration configuration, INDArray parameters, INDArray updaterState) {
        this(configuration, null, parameters, updaterState);
    }

    public NetBroadcastTuple(ComputationGraphConfiguration graphConfiguration, INDArray parameters, INDArray updaterState) {
        this(null, graphConfiguration, parameters, updaterState);

    }

    public NetBroadcastTuple(MultiLayerConfiguration configuration, ComputationGraphConfiguration graphConfiguration, INDArray parameters, INDArray updaterState) {
        this.configuration = configuration;
        this.graphConfiguration = graphConfiguration;
        this.parameters = parameters;
        this.updaterState = updaterState;
    }
}
