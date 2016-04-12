package com.ness.log.file.reader;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by P3700601 on 03/01/2016.
 */
public class TheReaderReducer extends Reducer<LongWritable, Text, LongWritable, Text> {

    //private LongWritable result = new LongWritable();

    @Override
    protected void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        LongWritable result = new LongWritable();
        for (Text val : values) {
            context.write(key, val);
        }
    }
}
