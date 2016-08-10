package in.cakemporos.logistics.cakemporoslogistics.events;

/**
 * Created by roger on 10/8/16.
 */
public interface WebServiceCallDoneEvent {

    /**
     * Triggered when a web service call returns a response
     * @param message carries information about the response of the call
     * @param code carries error code if it exists
     */
    void onDone(int message_id, int code);

    void onContingencyError(int code);

    void onError(int message_id, int code, String... args);
}
