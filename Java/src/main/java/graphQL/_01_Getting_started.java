package graphQL;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

public class _01_Getting_started {

    public static void main(String[] args) {

        String schema = "type Query{hello: String}"; // GraphQL 스키마를 정의

        SchemaParser schemaParser = new SchemaParser(); // 주어진 스키마 문자열을 파싱
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema); // 파싱된 스키마의 모든 타입 정의를 보관

        // 스키마의 각 필드에 대한 데이터를 어떻게 가져올지 정의
        // Query 타입의 hello 필드에 대해 StaticDataFetcher를 사용하여 world라는 문자열을 반환
        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();

        // 실행 가능한 GraphQL 스키마(GraphQLSchema)를 생성
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        // 생성된 스키마를 기반으로 GraphQL 인스턴스를 빌드
        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{hello}"); // execute 메소드를 사용하여 GraphQL 쿼리({hello})를 실행

        System.out.println(executionResult.getData().toString());
    }
}