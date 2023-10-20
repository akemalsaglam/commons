package com.aks.commons.pagination;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PaginationResult {

  private boolean last;
  private int totalPages;
  private long totalElements;
  private int size;
}
