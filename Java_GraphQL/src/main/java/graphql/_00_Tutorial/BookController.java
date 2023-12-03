package graphql._00_Tutorial;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @QueryMapping // GraphQL 쿼리에 바인딩
    public Book bookById(@Argument("id") String id) {
        return Book.getById(id);
    }

    @SchemaMapping // GraphQL 스키마 내의 특정 필드에 대한 데이터를 제공하는 메서드를 매핑
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }
}
