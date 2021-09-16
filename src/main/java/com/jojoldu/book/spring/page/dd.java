package com.jojoldu.book.spring.page;

public class dd {


    public  static  void main(String [] args){
        String [] ss =new String [20];
        int [] askii = new int [20];
        char [] chars = new char[20];
        int y =65;
        for(int x =0; x<20; x++){
              askii[x] = y+x;

        }
        for(int x =0; x<20; x++){
            chars[x] = (char)askii[x];

        }
        for( int x =0; x<20; x++){
            ss[x] = String.valueOf(chars[x]);

        }
        for( int x =0; x<20; x++){
            System.out.println("insert into posts ( CREATED_DATE ,MODIFIED_DATE ,AUTHOR ,CATEGORY ,CONTENT ,TITLE ) values (SYSDATE,SYSDATE," +
                    "'"+ss[x]+"','ss','dd','"+ss[x]+"');");
        }




    }

}
