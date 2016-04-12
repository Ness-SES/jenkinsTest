package com.ness.log.file.reader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by P3700601 on 03/01/2016.
 */
public class TheReaderEngine {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (null == args || 2 != args.length) {
            return;
        }
        String inputPath = args[0];
        String outputPath = args[1];

        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "read log file");
        job.setJarByClass(TheReaderEngine.class);
        job.setMapperClass(TheReaderMapper.class);
        job.setReducerClass(TheReaderReducer.class);
        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(1);
        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
