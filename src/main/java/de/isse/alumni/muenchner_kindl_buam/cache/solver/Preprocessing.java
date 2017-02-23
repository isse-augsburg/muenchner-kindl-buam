package de.isse.alumni.muenchner_kindl_buam.cache.solver;

import de.isse.alumni.muenchner_kindl_buam.cache.data.Input;

public class Preprocessing {
    boolean[] relevantEndpoints;
    boolean[] relevantVideos;

    public void process(Input input) {
        relevantEndpoints = new boolean[input.getE()];
        relevantVideos = new boolean[input.getV()];

        for (int e = 0; e < input.getE(); ++e) {
            for (int c = 0; c < input.getC(); ++c) {
                if (input.getLatency(e, c) > 0) {
                    relevantEndpoints[e] = true;
                }
            }

            for (int v = 0; v < input.getV(); ++v) {
                if (input.getRequest(e, v) > 0) {
                    relevantVideos[v] = true;
                }
            }
        }

    }

}