package com.teamlab.skillup.todo.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/** Todo Form */
@Data
// Formクラス　HTML側のFormタグで定義したInputタグと1:1の関係になる
public class TodoForm {
  private String title;

  // @DateTimeFormat LocalDate型に値をセットするために利用するアノテーション
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate deadline;
}
