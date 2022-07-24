package com.teamlab.skillup.todo.controller;

import com.teamlab.skillup.todo.form.TodoForm;
import com.teamlab.skillup.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// このクラスがContorollerであることを示すアノテーション
/** test Controller */
@Controller
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  //  JavaDoc
  /**
   * トップ画面を表示
   *
   * @param model Model
   * @return 画面表示用HTMLパス
   */
  //  このメソッドがHTTPのGetメソッドで呼び出されることを示すアノテーション
  @GetMapping
  //  Modelクラス　addAttributeメソッドでキー文字列と合わせて値をセットすることで、HTML側に値を引き渡すことができる
  public String index(Model model) {
    model.addAttribute("todoList", todoService.searchAllTodo());
    return "index";
  }

  /**
   * TODO登録処理
   *
   * @param todoForm 入力値
   * @return 画面表示用URL
   */
  @PostMapping("/register")
  public String register(TodoForm todoForm) {
    todoService.saveTodo(todoForm);
    return "redirect:/";
  }
}
