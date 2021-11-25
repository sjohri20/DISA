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
import Codes.iCorr;

public class iCorrChart{
	static Scanner userinput=new Scanner(System.in);
   
    	
   
    	public iCorrChart(double[] array1)
    	{
    		
        final XYSeries series = new XYSeries("Amplitude");
       
       
        for(int i=0;i<array1.length;i++)
        {
        	series.add(i+1,array1[i]);
        }
        final XYSeriesCollection data = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "iCorr Plot ",
            "Window Number", 
            "Amplitude", 
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        ChartFrame frame = new ChartFrame("iCorr Curve", chart);
	      frame.pack();
	      frame.setVisible(true);

    }

    
    public static void main(final String[] args) {

    	
   }

}




