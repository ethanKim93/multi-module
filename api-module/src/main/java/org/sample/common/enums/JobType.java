package org.sample.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@AllArgsConstructor
@Getter
public enum JobType {
    FILE("FILE"), DB("DB"), MQ("MQ"), IMAGE("IMAGE"), NONE("NONE");

    private String value;

    static public JobType getJobType(String jobName) {
        if (FILE.value.equalsIgnoreCase(jobName)) {
            return FILE;
        }
        if (DB.value.equalsIgnoreCase(jobName)) {
            return DB;
        }
        if (MQ.value.equalsIgnoreCase(jobName)) {
            return MQ;
        }
        if (IMAGE.value.equalsIgnoreCase(jobName)) {
            return IMAGE;
        }
        return NONE;
    }
}
