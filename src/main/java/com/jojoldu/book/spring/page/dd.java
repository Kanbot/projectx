package com.jojoldu.book.spring.page;

public class dd {


    public  static  void main(String [] args){
        double s = 2.777;
        for(int x =1; x <37; x++){
            System.out.println(".col-lg-"+x+"{");
            System.out.println("flex: 0 0 auto;");
            System.out.println("width:"+s*x+"%;");
            System.out.println("}");

        }



    }

}
