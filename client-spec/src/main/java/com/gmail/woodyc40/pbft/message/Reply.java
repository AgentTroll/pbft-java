package com.gmail.woodyc40.pbft.message;

import com.gmail.woodyc40.pbft.Client;

/**
 * Represents a {@code REPLY} message in the PBFT protocol
 * that transmits the computational result from the replicas
 * to the client dispatching the corresponding
 * {@link Request}.
 *
 * @param <R> the reply type
 */
public interface Reply<R> {
    /**
     * The view number, {@code v}, which represents the
     * current state of all state machines.
     *
     * @return the view number
     */
    int viewNumber();

    /**
     * The timestamp, {@code t}, which was assigned to the
     * original {@link Request} that initiated the
     * computation.
     *
     * @return the timestamp
     */
    long timestamp();

    /**
     * The {@link Client}, {@code c}, which dispatched the
     * corresponding {@link Request}.
     *
     * @param <O> the client operation type
     * @return the dispatching client
     */
    <O> Client<O, R> client();

    /**
     * The replica ID number, {@code i}, which tells the
     * {@link Client} from what replica this message came
     * from.
     *
     * @return the replica's ID number
     */
    int replicaId();

    /**
     * The ultimate result of running the computation on the
     * replica.
     *
     * @return the result value of the computation
     */
    R result();
}
