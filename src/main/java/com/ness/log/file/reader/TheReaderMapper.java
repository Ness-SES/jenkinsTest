package com.ness.log.file.reader;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by P3700601 on 03/01/2016.
 */
public class TheReaderMapper extends Mapper<Object, Text, LongWritable, Text> {

//    private List<String> lines = new LinkedList<String>();
    //  private LongWritable myKey = new LongWritable(0);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        InputSplit split = context.getInputSplit();
        if (null == split || !(split instanceof FileSplit)) {
            return;
        }
        long length = ((FileSplit) split).getLength();

//        if (value.toString().startsWith("2") && !lines.isEmpty()) {
//            StringBuilder builder = new StringBuilder();
//            for (String val : lines) {
//                builder.append(val);
//                builder.append("\n");
//            }
//            context.write(myKey, new Text(builder.toString()));
//            myKey.set(myKey.get() + 1);
//
//            lines.clear();
//            lines.add(value.toString());
//        } else {
//            lines.add(value.toString());
//        }
        if (510 >= ((LongWritable) key).get()) {
            context.write((LongWritable) key, new Text(value.toString()));
        }
    }
}
