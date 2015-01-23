package simens.MD5.test;

import java.security.MessageDigest;

public class MD5Test {
      private static MD5Test md5;
      private MD5Test(){}
      public static MD5Test getInstance(){
    	  if(md5==null){
    		  return new MD5Test();
    	  }
    	  return md5;
      }     
      
      public String parse(String s){
    	  String smd5="";
    	  char hex[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    	  try {
    		byte[] bytes = s.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(bytes);
			byte[] newByte = md5.digest();
		    //smd5 = new String(newByte);
			int l = newByte.length,k=0;
			char[] chars = new char[l*2];
			
			for(int i=0;i<l;i++){
				byte b=newByte[i];
				chars[k++]=hex[b>>4&0xf];
				chars[k++]=hex[b&0xf];
			}
			smd5 = String.valueOf(chars);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smd5;
      }
      
      public static void main(String args[]){
    	  MD5Test md5 = MD5Test.getInstance();
    	  System.out.println(md5.parse("hu123"));
    	
      }
}
