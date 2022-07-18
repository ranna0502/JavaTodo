package com.teamlab.skillup.todo.service;

import com.teamlab.skillup.todo.entity.Todo;
import com.teamlab.skillup.todo.form.TodoForm;
import com.teamlab.skillup.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** Todo Service */
// @Service このクラスがサービスであることを指定するアノテーション
@Service
// @Transavtional クラスに付与することでを、そのクラス内の全てのメソッドにトランザクション制御をかけてくれるアノテーション(エラー時にロールバックを掛けるなど）
@Transactional
// @RequiredArgsConstructor lombokによって提供されるアノテーションで、private final TodoRepository
// todoRepository;とフィールドを宣言しておくと、コンストラクタを自動実装してくれるアノテーション
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  /**
   * Todo情報を全件取得する
   *
   * @return Todo情報
   */
  public List<Todo> searchAllTodo() {
    return todoRepository.findAll();
  }

  /**
   * Todo情報を保存する
   *
   * @param todoForm
   */
  public void saveTodo(TodoForm todoForm) {
    todoRepository.save(Todo.of(todoForm));
  }
}
