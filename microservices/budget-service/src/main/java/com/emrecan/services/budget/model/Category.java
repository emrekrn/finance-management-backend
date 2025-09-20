package com.emrecan.services.budget.model;

import com.emrecan.services.budget.model.core.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "Category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(nullable = false)
  private Integer id;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private TransactionTypeEnum type;

  private String color;
  private Integer transactions;
}
