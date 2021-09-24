package com.sist.temp;
import java.util.*;
import java.io.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="C:\\springDev2\\lotto.txt";
        try
        {
        	File file=new File(path);
        	FileReader fr=new FileReader(file);
        	int i=0;
        	int[] lotto=new int[45];
        	String data="";
        	while((i=fr.read())!=-1)
        	{
        		//System.out.print((char)i);
        		String s=String.valueOf((char)i);
        		data+=s;
        	}
        	//System.out.println(data);
        	fr.close();
        	String[] str=data.split("\n");
        	for(String ss:str)
        	{
        		System.out.println(ss);
        		StringTokenizer st=
        				new StringTokenizer(ss,",");
        		while(st.hasMoreTokens())
        		{
        			int kk=Integer.parseInt(st.nextToken().trim());
        			System.out.println(kk);
        			lotto[kk-1]++;
        		}
        	}
        	//Arrays.sort(lotto);
        	for(int k=0;k<lotto.length;k++)
        	{
        		System.out.println((k+1)+":"+lotto[k]);
        	}
        }catch(Exception ex){ex.printStackTrace();}
	}

}
