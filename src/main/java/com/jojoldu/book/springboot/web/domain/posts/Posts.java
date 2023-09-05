package com.jojoldu.book.springboot.web.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Lombok의 어노테이션이다.
//클래스 안의 모든 필드의 Getter메소드를 자동생성해준다.
@Getter
//Lombok의 어노테이션이다.
//기본 생성자 자동 추가 기능이다.
//public posts(){}와 같은 효과를 가진다.
@NoArgsConstructor
//JPA의 어노테이션이다.
//테이블과 링크될 클래스임을 나타낸다.
//기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다.
//HelloWord=>hello_word
@Entity
public class Posts extends BaseTimeEntity{

    //해당 테이블의 PK필드를 나타낸다.
    @Id
    //PK의 생성 규칙을 나타낸다
    //스프링부트2.0에서는 generationType.IDENTITY를 옵션에 추가해야지 auto_increment가 된다.
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    //테이블의 칼럼을 나타내며 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이된다.
    //사용을 하는 이유는 기본값 이외 추가로 변경이 필요한 옵션이 있을 경우 사용한다.
    //문자열은 기본적으로 255가 기본값인데 사이즈를 늘리고 싶을때나 타입을 변경하기 위해 사용한다.
    @Column(length = 500, nullable =false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성한다
    //생성자 상단에 선언시 생성자에 '포함된 필드'만 빌더에 포함된다.
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
