/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.4.2/samples
 * This project uses @Incubating APIs which are subject to change.
 */
plugins {
    java
    war // 웹 애플리케이션 패키징
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    // Servlet
    // https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    // GraphQL
    // https://mvnrepository.com/artifact/com.graphql-java/graphql-java
    implementation("com.graphql-java:graphql-java:230521-nf-execution")

    // https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
    implementation("org.apache.kafka:kafka-clients:3.6.0")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.0.9")
}

tasks.test {
    // 테스트 결과를 콘솔에 출력하도록 설정
    testLogging {
        events("passed", "skipped", "failed")
    }
}