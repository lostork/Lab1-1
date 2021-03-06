package com.lab1;

import java.util.Map;
import java.util.TreeMap;

abstract public class Command {
	public abstract void execute();
	public abstract void input(String s);
}

class SimplifyCommand extends Command{
	
	private static SimplifyCommand  simplifyCommand  = new SimplifyCommand();
	
	
	private  SimplifyCommand() {
		;// TODO Auto-generated constructor stub
	}
	
	public static SimplifyCommand instance() {
		return simplifyCommand;
	}

	
	
	
	
	Map<String, Double> parameters;
	
	public void execute()
	{
		Expression expression = Expression.instance();
		expression.simpify(parameters);
	}
	
	public void input(String s)
	{
		s = s.substring("!simplify".length());
		if(s.charAt(0) == ' ') s = s.substring(1);
		String[] paras = s.split(" ");
		this.parameters = new TreeMap();
		for(int i=0;i<paras.length;i++){
			String[] var = paras[i].split("=");
			this.parameters.put(var[0], Double.parseDouble(var[1]));
		}		
	}
}

class DerivationCommand extends Command{
	
	private static DerivationCommand derivationCommand = new DerivationCommand();
	
	
	private DerivationCommand() {
		;// TODO Auto-generated constructor stub
	}
	
	public static DerivationCommand instance() {
		return derivationCommand;
	}

	
	
	
	private String derVar;
	
	public void execute()
	{
		Expression expression = Expression.instance();
		expression.derivate(derVar);
	}
	
	public void input(String s)
	{	s = s.replaceAll(" ", "");
		s = s.substring("!d/d".length());
		this.derVar = s;
	}
}
