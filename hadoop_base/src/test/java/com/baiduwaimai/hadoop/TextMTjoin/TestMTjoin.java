package com.baiduwaimai.hadoop.TextMTjoin;

import com.baiduwaimai.hadoop.MTjoin.MTjoin;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mrunit.ReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Super腾 on 2016/12/10.
 */
public class TestMTjoin {
    @Test
    public void testMap() throws IOException {
        Text line = new Text("beijing Red Star 1");
        Text line2 = new Text("1 beijing");
        new MapDriver<LongWritable,Text,Text,Text>()
                .withMapper(new MTjoin.Map())
                .withInput(new LongWritable(),line)
                .withOutput(new Text("1"),new Text("1beijing Red Star"))
                .runTest();
        new MapDriver<LongWritable,Text,Text,Text>()
                .withMapper(new MTjoin.Map())
                .withInput(new LongWritable(),line2)
                .withOutput(new Text("1"),new Text("2beijing"))
                .runTest();
    }
    public void testReducer() throws IOException {
        Text line = new Text("beijing Red Star 1");
        Text line2 = new Text("1 beijing");
        Text line3 = new Text("beijing Red Star beijing");
        List<Text> list = new ArrayList<Text>();
        list.add(new Text("1beijing Red Star"));
        list.add(new Text("2beijing"));
        new ReduceDriver<Text,Text,Text,Text>()
                .withReducer((Reducer<Text, Text, Text, Text>) new MTjoin.Reduce())
                .withInput(new Text("1"),list)
                .withOutput(new Text("beijing Red Star"),new Text("beijing"))
                .runTest();
    }
}
