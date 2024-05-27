package com.codegnan.app;

public class CmdArgs {

	public static void main(String[] args) {
		System.out.println("welcome");
		for(int c=0;c<args.length;c++) {
			System.out.println(args[c]);
		}
		System.out.println("thank you!!!");

	}

}
