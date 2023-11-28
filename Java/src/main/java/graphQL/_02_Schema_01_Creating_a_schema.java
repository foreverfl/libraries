package graphQL;

import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLFieldDefinition;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLObjectType.newObject;

public class _02_Schema_01_Creating_a_schema {
    public static void main(String[] args) {
        // GraphQLObjectType 생성
        GraphQLObjectType fooType = newObject()
                .name("Foo")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("bar")
                        .type(GraphQLString)
                        .build())
                .build();

        System.out.println(fooType.toString());
    }
}
