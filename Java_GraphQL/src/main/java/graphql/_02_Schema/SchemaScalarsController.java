package graphql._02_Schema;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SchemaScalarsController {

    @QueryMapping
    public SchemaScalars schemaScalars(@Argument String id) {
        return new SchemaScalars(id, true, 100, 10.5f, "Example String");
    }

}
