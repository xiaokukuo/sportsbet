package com.sport.bet.common.structure.stack.utils;

import com.sport.bet.common.structure.stack.ArrayStack;

public class MapColorStack {
	
	private ArrayStack<Integer> mapStack = new ArrayStack<Integer>();
	
	int areanum; //地区数
	
	int[][] dist; //邻接矩阵，0表示不邻接，1表示相邻
	
	public MapColorStack(int areanum, int[][] dist){
		this.areanum = areanum;
		this.dist = dist;
	}
	
	public void mapcolor(){
		mapStack.push(1); //一号地区涂一号色
		int curarea = mapStack.size(); //当前应该涂的区域
	    int color = 1; //颜色
	    int i = 0;
	    while (curarea < areanum){//还没涂完
	    	 //当前应该涂的区域
	        while (color <= 4 && curarea < areanum){//每种颜色进行试探
	            i = 0;
	            //与当前区域相邻的已染色区域是否有与此种颜色相同的
	            while ((i < curarea) && (mapStack.get(i) * dist[curarea][i] != color)){
	                i++;
	            }
	            if (i<curarea){//k<curarea,提前退出循环，说明此种颜色不可用，比对下一种颜色
	                color++;
	            }else{//此种颜色可用
	            	mapStack.push(color);
	            	curarea = mapStack.size();
	                color = 1;//color从一开始
	            }
	        }
	        if (color>4){//color>4说明找不到合适的颜色对当前区域进行染色，回溯，更改上一个区域的颜色，
	            mapStack.pop();
	            curarea = mapStack.size();
	            color = mapStack.peek() + 1;//因为上一个区域已经染色，所以从已染色的下一个颜色开始即可
	        }
	    }
	    
	}
	
	public static void main(String[] args) {
		int areaNum = 6;//地区数量
	    int[][] dist = {//邻接矩阵，0表示不邻接
	        { 0, 1, 1, 0, 0, 1 },
	        { 1, 0, 1, 1, 1, 1 },
	        { 1, 1, 0, 1, 0, 0 },
	        { 0, 1, 1, 0, 1, 0 },
	        { 0, 1, 0, 1, 0, 1 },
	        { 1, 1, 0, 0, 1, 0 }
	    };
	    
	    MapColorStack map = new MapColorStack(areaNum, dist);
	    map.mapcolor();
	    
	    System.out.println(map.mapStack.toString());
	}
	
	
	
}
