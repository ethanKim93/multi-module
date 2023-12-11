package org.sample.common.enums;

public enum JobStatus {
    REQ, JDG, DONE, HOLD;

    static public boolean contains(String msg) {

        for (JobStatus c : JobStatus.values()) {
            if (c.name().equals(msg)) {
                return true;
            }
        }
        return false;
    }
}
