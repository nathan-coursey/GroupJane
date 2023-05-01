package org.rally.backend.userprofilearm.model;

import java.util.List;

public class AllMainUserDMs {

    List<DirectMessage> sent;
    List<DirectMessage> received;

    public AllMainUserDMs(List<DirectMessage> sent, List<DirectMessage> received) {
        this.sent = sent;
        this.received = received;
    }

    public AllMainUserDMs() {
    }

    public List<DirectMessage> getSent() {
        return sent;
    }

    public void setSent(List<DirectMessage> sent) {
        this.sent = sent;
    }

    public List<DirectMessage> getReceived() {
        return received;
    }

    public void setReceived(List<DirectMessage> received) {
        this.received = received;
    }
}
