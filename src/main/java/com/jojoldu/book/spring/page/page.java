package com.jojoldu.book.spring.page;

import com.jojoldu.book.spring.domain.posts.Posts;
import lombok.Getter;

@Getter
public class page {
    private  final static  int pageCount =5;
    private  int blockStartNum =0;
    private  int blockLastNum =0;
    private  int lastPageNum = 0;


    public void setBlockStartNum(int blockStartNum){
        this.blockStartNum =blockStartNum;
    }
    public void setBlockLastNum(int blockLastNum){
        this.blockLastNum =blockLastNum;
    }
    public void setLastPageNum(int lastPageNum){
        this.lastPageNum=lastPageNum;
    }

    //block 생성
    //현재 페이지가 속한 block의 시작번호 , 끝 번호를 계산
    public void  makeBlock(int curPage){
        int blockNum =0;

        blockNum =(int)Math.floor((curPage-1)/ pageCount);
        blockStartNum =(pageCount * blockNum)+1;
        blockLastNum= blockStartNum +(pageCount-1);
    }

    // 총 페이지의 마지막 번호
    public void makeLastPageNum(){
        Posts posts =new Posts();

    }

}
