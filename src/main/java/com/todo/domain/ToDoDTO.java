package com.todo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoDTO {
    private Long idx;
    private String item;
    private String status;
}
