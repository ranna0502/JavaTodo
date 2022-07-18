package com.teamlab.skillup.todo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/** Todo Entity */
// @Data lombokによって提供されるアノテーションで、Getter/Setterを自動実装してくれるアノテーション
@Data
// @Entity 該当のクラスがエンティティであることを指定するアノテーションになります。このアノテーションを付けることでこのクラスがEntityクラスであると宣言している
@Entity
public class Todo {

  // @Id プライマリキー(主キー)となるフィールドを指定します。このアノテーションを指定することで該当フィールドと連動するカラムが該当テーブルの主キーであると認識される
  @Id
  // @GeneratedValue 主キー列にユニークな値を自動で生成、付与する方法を指定するアノテーションです。@Idを持つ主キーのフィールド又はプロパティに適用する
  //  strategy ユニークな値をどのように生成するか指定する
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private LocalDate deadline;
  private boolean status;

  // それぞれのカラムに現在日付を自動設定してくれる
  @CreationTimestamp private LocalDateTime createTime;
  @UpdateTimestamp private LocalDateTime updateTime;
}
