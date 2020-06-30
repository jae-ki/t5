package kr.co.util;

import java.io.UnsupportedEncodingException;

public class utils {

		public static String toKor(String msg) {
			try {
				return new String(msg.getBytes("8859_1"),"UTP-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		
		/*
		public String toKor(String name) {
			try {
				return new String(name.getBytes("8859_1"),"UTP-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		*/
}
