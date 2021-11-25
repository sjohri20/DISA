package Codes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.io.*;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Scanner;
import Codes.gCorr;
public class gCorrChart{
	static Scanner userinput=new Scanner(System.in);
   
    	public gCorrChart(String name, int ws, int ss, int len)
    	{
    		
        final XYSeries series = new XYSeries("Amplitude");
        gCorr gcorr = new gCorr(name,ws,ss,len);   
		//System.out.println("below");
		double[] array1;
		array1=gcorr.gcorrfunction();
        for(int i=0;i<array1.length;i++)
        {
        	series.add(i+1,array1[i]);
        }
        final XYSeriesCollection data = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Gcorr Plot ",
            "Window Number", 
            "Amplitude", 
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        ChartFrame frame = new ChartFrame("Gcorr Curve", chart);
	      frame.pack();
	      frame.setVisible(true);

    }

    
    public static void main(final String[] args) {
    	
    }

}




