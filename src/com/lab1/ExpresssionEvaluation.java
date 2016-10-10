package com.lab1;

import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ExpresssionEvaluation {
	private static final char COM_MARK = '!';
	private static final String INPUT_PROMPT = ">";
	private static final String END_COM = "###";
	
	public static void main(String[] args)
	{
		Expression expression = Expression.instance();
		SimplifyCommand simplifyCommand = SimplifyCommand.instance();
		DerivationCommand derivationCommand = DerivationCommand.instance();
		
		System.out.print(INPUT_PROMPT);
		String line;
		Scanner reader = new Scanner(System.in);
		line = reader.nextLine();
		
		
		while(!line.equals(END_COM)){
			if (line.charAt(0) != COM_MARK) {//expression condition
				expression.input(line);
				expression.printOri();// print no-para simplified result.
			}else if (line.substring(1, 4).equals("d/d")) {//DerCom condition.
				derivationCommand.input(line);
				derivationCommand.execute();
				expression.printDer();
			}else if (line.substring(1,9).equals("simplify")) {//SimCom condition ,check contains " " at the end;
				simplifyCommand.input(line);
				simplifyCommand.execute();
				expression.printSim();
			
			}else {
				System.out.println("Error, invalid input.");
			}
			System.out.print(INPUT_PROMPT);
			line = reader.nextLine();
		}
		reader.close();//TODO:unc;
//		Map<String, Integer> m1 = new TreeMap<>();
//		String pString = new String("x");
//		m1.put(pString, 3);
//		String qString = new String("y");
//		m1.put(qString, 2);
//		
//		Item item1 = new Item(3.2, m1);
//		
//		Map<String, Integer> m2 = new TreeMap<>();
//		
//		String rString = new String("x");
//		String sString = new String("y");
//		m2.put(rString, 3);
//		m2.put(sString, 2);
//		
//		Item item2 = new Item(4.3,m2);
//		Expression expression = Expression.instance();
//		expression.addItemToOri(item1);
//		expression.addItemToOri(item2);
//		expression.printOri();
//		
//		Map<String, Integer> m3 = new TreeMap<>();
//		
//		m3.put(new String("x"), 2);
//		m3.put(new String("y"), 1);
//		
//		
//		Item item3 = new Item(5.2,m3);
//		expression.addItemToOri(item3);
//		expression.printOri();
//		expression.derivate("x");
//		expression.printDer();
//		expression.derivate("y");
//		expression.printDer();
//		
//		Map<String, Double> para = new HashMap<>();
//		para.put(new String("x"), 2.0);
//		para.put(new String("y"), 2.0);
//		
//		expression.simpify(para);
//		expression.printSim();
//		
		//para.put(new String("y"), 2.0);
		//expression.simpify(para);
		
		
		
		
	}
}




