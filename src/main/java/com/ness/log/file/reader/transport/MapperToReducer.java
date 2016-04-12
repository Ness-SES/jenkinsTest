package com.ness.log.file.reader.transport;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by P3700601 on 03/08/2016.
 */
public class MapperToReducer implements WritableComparable<MapperToReducer> {

    private String data;
    private long position;

    public int compareTo(MapperToReducer other) {
        if (null == other) {
            return 1;
        }
        if (this.position > other.position) {
            return 1;
        } else if (this.position < other.position) {
            return -1;
        }
        return 0;
    }

    public void write(DataOutput out) throws IOException {

    }

    public void readFields(DataInput in) throws IOException {

    }
}
