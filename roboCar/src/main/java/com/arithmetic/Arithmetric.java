package arithmetic;

import com.pojo.Edge;
import com.pojo.Point;

import java.util.ArrayList;
import java.util.List;


public class Arithmetric {
	private List<Point> pointList = null;//存储地图上的相关点的List链表。
	private List<Edge> edgeList = null;//存储地图上边的相关信息。
	private static PaintGraph graph = null;
	public Arithmetric(List<Point> pointList,List<Edge> edgeList){
		this.pointList = pointList;
		this.edgeList = edgeList;
		this.graph = new PaintGraph(pointList, edgeList);
	}
	@SuppressWarnings("null")
	private static List<Point> getPartPath(Point begin,Point end,PaintGraph graph){

		List<Point> queue = new ArrayList();//广度遍历的栈queue,pointList存放了所有的节点信息
		List<Point> pointList = graph.getPointList();
		int size = pointList.size();//size记录有多少个节点
//		System.out.println(size);
		queue.add(begin);
		List<List<Point>> list = new ArrayList();//list存各个路线
		for(int i = 0;i<size;i++){
			List<Point> pList = new ArrayList();
			pList.add(begin);//pList存储的是路线的所有的节点信息，第一个节点是源点（begin节点）
			list.add(pList);
		}
		double[] D = new double[size];//存储源点到个节点的最短路径的值
		boolean[] mark = new boolean[size];//标记节点是否被遍历
		for(int i = 0;i<size;i++){//将D数组的值至为最大值，把mark数组至为false；
			D[i] = Double.MAX_VALUE;
			mark[i] = false;
		}
//		System.out.println(pointList.indexOf(begin));
//		if(pointList.indexOf(begin)<79)
		D[pointList.indexOf(begin)] = 0;
		//
		int markI = 0;
		while(!queue.isEmpty()){//最短路劲算法开始
			Point pt = queue.get(0);//出栈
			queue.remove(0);//去掉出栈后的元素
			List<Edge> eList = graph.getEdgeList(pt);//得到弧起点节点是pt的相关弧
			markI = pointList.indexOf(pt);//得到pt的节点在pointList中的位置
			if(!mark[markI]){//
				mark[markI] = true;
				for(int i = 1;i<eList.size();i++){
					Point po = PaintGraph.getPointFromPointList(pointList, eList.get(i).getSecondPoint());
					queue.add(po);
				}
			}
			for(int i = 1;i<eList.size();i++){
				Edge edge = eList.get(i);
				Point fp = PaintGraph.getPointFromPointList(pointList,edge.getFirstPoint());
				Point sp = PaintGraph.getPointFromPointList(pointList,edge.getSecondPoint());
				//判断新路径的距离比老路径的距离要小，则更新源点到该点的最小值D 和路径oldList。
				if((D[pointList.indexOf(fp)]+edge.getValue())<D[pointList.indexOf(sp)]){
					D[pointList.indexOf(sp)] = D[pointList.indexOf(fp)]+edge.getValue();
					List<Point> newList = list.get(pointList.indexOf(fp));
					List<Point> oldList = list.get(pointList.indexOf(sp));
					for(int k = 1;k<oldList.size();){//第一个节点是起点，保留
						oldList.remove(k);
					}
					for(int k = 1;k<newList.size();k++){//把经过的点都复制到oldList链表里
						oldList.add(newList.get(k));
					}
					Point po = PaintGraph.getPointFromPointList(pointList,edge.getSecondPoint());
					oldList.add(po);//把终点加到list的最后
				}
			}
		}

//		graph.
		return list.get(pointList.indexOf(end));
	}

	public static List<Point> getPath(List<Point> list){
		Point begin = list.get(0);
		Point end = list.get(list.size()-1);
		list.remove(list.size()-1);
		list.remove(0);
		return getPartPath(begin, end, graph);
	}
	public static List<Point> getPath(Point begin,Point end,List<Point> pList){
		List<Point> list = new ArrayList();
		list.add(begin);
		System.out.println("graph"+graph.getPointList().get(6).getName());
		System.out.println("begin"+begin.getName());
		System.out.println("fgff"+graph.getPointList().get(6).equals(begin));
//		System.out.println(begin.getName());
		Point partBegin = begin,partEnd = null;
		for(int i = 0;i<pList.size();i++){
			partEnd = pList.get(i);
			List<Point> lt = getPartPath(partBegin,partEnd, graph);
			System.out.println((i+1) + "List:" + lt.size());
			for(int j = 1;j<lt.size();j++)
				list.add(lt.get(j));
			partBegin = pList.get(i);
		}
		partEnd = end;
		List<Point> ls = getPartPath(partBegin, partEnd, graph);
		System.out.println( "Last List:" + ls.size());
		for(int j = 1;j<ls.size();j++)
			list.add(ls.get(j));
		return list;
	}

}
