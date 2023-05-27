package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class ResponsePagination<T> {
    private List<T> data ;
    private Long total_count;
}
