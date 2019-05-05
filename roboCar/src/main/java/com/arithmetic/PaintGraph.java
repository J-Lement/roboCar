package arithmetic;

import com.pojo.Edge;
import com.pojo.Point;

import java.util.ArrayList;
import java.util.List;
//有向图存储类
public class PaintGraph {
	private List<Point> pointList = new ArrayList();//存储地图上的相关点的List链表。
	private List<List<Edge>> edgeList = new ArrayList();//存储地图上边的相关信息。

	//构造函数
	public PaintGraph(Point[] point,Edge[] edge){
		saveGraphOfEdge(point,edge);
	}
	public PaintGraph(List<Point> pList,List<Edge> eList){
		Point[] point = new Point[pList.size()];
		Edge[] edge = new Edge[eList.size()];
//		System.out.println(pList.size());
//		System.out.println(eList.size());
		for(int i = 0;i<pList.size();i++){
			point[i] = null;
			point[i] = pList.get(i);
		}

		for(int i = 0;i<eList.size();i++){
			edge[i] = null;
			edge[i] = eList.get(i);
		}
//		System.out.println(edge[230].getValue());
		saveGraphOfEdge(point,edge);
	}
	//将输入进来的数据存储到点和边的类中
	private void saveGraphOfEdge(Point[] point,Edge[] edge){
		for(int i = 0;i<point.length;i++){
			pointList.add(point[i]);
			Edge eList = new Edge(point[i].getpId(),point[i].getpId(),0);
			List<Edge> list = new ArrayList();
			list.add(eList);
			edgeList.add(list);
		}
		for(int i = 0;i<edge.length;i++){
			Point p = getPointFromPointList(pointList, edge[i].getpFirstid());
			int markFirst = pointList.indexOf(p);
			edgeList.get(markFirst).add(edge[i]);
		}
	}
	//在控制台打印有点的相关信息
	public void printlnPoint(){
		for(int i = 0;i<pointList.size();i++){
			System.out.println("ID:"+pointList.get(i).getpId());
			System.out.println("经度:"+pointList.get(i).getpLongitude());
			System.out.println("纬度:"+pointList.get(i).getpLatitude());
			System.out.println("NAME:"+pointList.get(i).getpName());
		}
	}
	//在控制台打印有边的相关信息
	public void printlnEdges(){
		for(int i = 0;i<edgeList.size();i++){
			int mark = 1;
			for(Edge edsa:edgeList.get(i)){
				if(mark==1){
					mark++;
					continue;
				}
				System.out.print("("+edsa.getpFirstid()+","+edsa.getpSecondid()+
						","+edsa.geteValue()+")  ");
				mark++;
			}
			if(mark!=2)
				System.out.println();
		}
	}
	//根据节点point找到节点相关的边的List。
	public List<Edge> getEdgeList(Point point){
		List<Edge> list = new ArrayList();
		for(int i = 0;i<edgeList.size();i++){
			if(edgeList.get(i).get(0).getpFirstid()==point.getpId()){
				list = edgeList.get(i);
				break;
			}
		}
		return list;
	}
	//得到节点的List
	public List<Point> getPointList(){
		return pointList;
	}
	//根据节点的id找到节点
	public static Point getPointFromPointList(List<Point> list,int id){
		Point point = null;
		for(int i = 0;i<list.size();i++){
			if(list.get(i).getpId()==id){
				point = list.get(i);
				break;
			}
		}
		return point;
	}
}
