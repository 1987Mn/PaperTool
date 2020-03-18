package com.lzw.view.statistics.pictureFrame;

import java.awt.Font;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import com.lzw.domain.Question;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart extends JFrame  {
	
//	大题折线图
	public LineChart(String title, String ytitle, Map<Integer,List<Map<Double,Double>>> pinList, Map<Integer, Question> questions, Integer qid) {
			//窗体设置
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 800, 650);
			
			add(new ChartPanel(createLineChart(title,ytitle,pinList,questions,qid)));
			// 设置窗体居中
			this.setLocationRelativeTo(null);
			setVisible(true);
	}

    public static JFreeChart createLineChart(String title,String ytitle,Map<Integer,List<Map<Double,Double>>> pinList, Map<Integer, Question> questions,Integer qid) {  
    	XYSeriesCollection seriesCollection = createDataSet(ytitle,pinList,questions,qid);
    	
        JFreeChart chart = ChartFactory.createXYLineChart(
        				title,           //图表标题
        				"分数段",                   //X轴标题
        				ytitle,                //Y轴标题
        				seriesCollection,     //绘图数据集
        				PlotOrientation.VERTICAL,    //绘制方向
        				true,                        //显示图例
        				true,                        //采用标准生成器
        				false);                      //是否生成超链接
        //ChartFrame frame=new ChartFrame("接口响应时间统计",chart);  
        //设置标题字体
    	chart.getTitle().setFont(new Font("宋体", Font.BOLD, 15));
    	chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); // 设置图例类别字体
    	//获取图表区域对象
    	XYPlot plot = (XYPlot) chart.getPlot();
    	
    	ValueAxis domainAxis=plot.getDomainAxis();
    	domainAxis.setTickLabelFont(new Font("黑体", Font.BOLD, 15));
    	/*------设置X轴坐标上的文字-----------*/ 
    	domainAxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 11));   
    	/*------设置X轴的标题文字------------*/ 
    	domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
    	
    	NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();   
    	/*------设置Y轴坐标上的文字-----------*/ 
    	numberaxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 12));    
    	/*------设置Y轴的标题文字------------*/ 
    	numberaxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
    	
        //终端显示
    	//frame.pack();  
    	//frame.setVisible(true);  
        return chart;
    }  
    
 public static XYSeriesCollection createDataSet(String ytitle,Map<Integer,List<Map<Double,Double>>> pinList, Map<Integer, Question> questions,Integer qid) {  
     XYSeriesCollection xySeriesCollection = new XYSeriesCollection(); 
     
     if(qid==null) {
		   Set<Integer> ids =pinList.keySet();
		   int p = 0;
		   if(ytitle.contains("累积频度")) {
			   p=2;
		   }else if(ytitle.contains("频度")) {
			   p=1;
		   }
		   
		   for(Integer id: ids) {
		      XYSeries xyseries1 = new XYSeries(questions.get(id).getContent1());   
		      List<Map<Double,Double>> ls =  pinList.get(id);
		      Map<Double,Double> pmap =  ls.get(p);
		       
		      Set<Double> das = pmap.keySet();
		      for (Double da : das) {
		    	  if(da!=0) {
		    		  xyseries1.add(da.intValue(),pmap.get(da),true);
		    	  }
		      }
		      xySeriesCollection.addSeries(xyseries1);
		   }
	 }else {
		 XYSeries xyseries1 = new XYSeries(questions.get(qid).getContent1());   
	      List<Map<Double,Double>> ls =  pinList.get(qid);
		   int p = 0;
		   if(ytitle.contains("累积频度")) {
			   p=2;
		   }else if(ytitle.contains("频度")) {
			   p=1;
		   }
	      Map<Double,Double> pmap =  ls.get(p);
	       
	      Set<Double> das = pmap.keySet();
	      for (Double da : das) {
	    	  if(da!=0) {
	    		  xyseries1.add(da.intValue(),pmap.get(da),true);
	    	  }
	      }
	      xySeriesCollection.addSeries(xyseries1);
	 }
     return xySeriesCollection;   
     
 }  
// 总分折线图
public LineChart(String title,String ytitle,List<Map<Double,Double>> pinList) {
		//窗体设置
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		
		add(new ChartPanel(createLineChart(title,ytitle,pinList)));
		// 设置窗体居中
		this.setLocationRelativeTo(null);
		setVisible(true);
}
public static JFreeChart createLineChart(String title,String ytitle,List<Map<Double,Double>> pinList) {  
	XYSeriesCollection seriesCollection = createDataSet(ytitle,pinList);
	
    JFreeChart chart = ChartFactory.createXYLineChart(
    				title,           //图表标题
    				"分数段",                   //X轴标题
    				ytitle,                //Y轴标题
    				seriesCollection,     //绘图数据集
    				PlotOrientation.VERTICAL,    //绘制方向
    				true,                        //显示图例
    				true,                        //采用标准生成器
    				false);                      //是否生成超链接
    //ChartFrame frame=new ChartFrame("接口响应时间统计",chart);  
    //设置标题字体
	chart.getTitle().setFont(new Font("宋体", Font.BOLD, 15));
	chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); // 设置图例类别字体
	//获取图表区域对象
	XYPlot plot = (XYPlot) chart.getPlot();
	
	ValueAxis domainAxis=plot.getDomainAxis();
	domainAxis.setTickLabelFont(new Font("黑体", Font.BOLD, 15));
	/*------设置X轴坐标上的文字-----------*/ 
	domainAxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 11));   
	/*------设置X轴的标题文字------------*/ 
	domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
	
	NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();   
	/*------设置Y轴坐标上的文字-----------*/ 
	numberaxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 12));    
	/*------设置Y轴的标题文字------------*/ 
	numberaxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
	
    //终端显示
	//frame.pack();  
	//frame.setVisible(true);  
    return chart;
}  
 public static XYSeriesCollection createDataSet(String ytitle,List<Map<Double,Double>> pinList) {  
	 XYSeriesCollection xySeriesCollection = new XYSeriesCollection(); 
	 
		 int p = 0;
		 if(ytitle.contains("累积频度")) {
			 p=2;
		 }else if(ytitle.contains("频度")) {
			 p=1;
		 }
		 
		 XYSeries xyseries1 = new XYSeries("总分");   
		 Map<Double,Double> pmap =  pinList.get(p);
		 
		 Set<Double> das = pmap.keySet();
		 for (Double da : das) {
			 if(da!=0) {
				 xyseries1.add(da.intValue(),pmap.get(da),true);
			 }
		 }
		 xySeriesCollection.addSeries(xyseries1);
	 return xySeriesCollection;   
	 
 }  

}
