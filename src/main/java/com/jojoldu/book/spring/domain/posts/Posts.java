package com.jojoldu.book.spring.domain.posts;


import com.jojoldu.book.spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 생성
@Entity //테이블과 링크될 클래스임을 나타냅니다.
        //기본값으로 클래스의 카멜케이스 이름을 _ 네이밍으로 테이블 이름을 매칭합니다
public class Posts extends BaseTimeEntity {
  @Id //해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙을 나타냅니다.
    private Long id;
  @Column (length = 500 ,nullable = false) // 테이블의 칼럼을 나태내며 굳이 선언하지않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
          //사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.사이즈를 늘리고 싶다던가 text로 변경하고 싶거나
    private String title;
    private String category;
  @Column(columnDefinition = "TEXT" ,nullable = false)
    private String content;
  private String author;
  @Builder //해당 클래스의 빌더 패턴 클래스를 생성 //생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title ,String content , String author ,String category){
      this.author =author;
      this.content = content;
      this.title =title;
      this.category=category;

  }
  public void update(String title ,String content){
    this.title=title;
    this.content=content;
  }


}
