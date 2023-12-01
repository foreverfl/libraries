package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.json.DefaultGsonObjectMapper;
import redis.clients.jedis.json.JsonObjectMapper;

public class _02_Data_type_02_JSON {

    static class Character {
        private String name;
        private int age;

        // getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Character {name='" + name + "', age=" + age + '}';
        }
    }

    public static void main(String[] args) {
        // Redis 서버에 연결
        Jedis jedis = JedisManager.getJedisInstance();

        Character character = new Character();
        character.setName("haruka");
        character.setAge(18);

        JsonObjectMapper objectMapper = new DefaultGsonObjectMapper();

        // 객체를 JSON으로 변환
        String json = objectMapper.toJson(character);
        System.out.println("JSON: " + json);

        // Redis에 JSON 저장
        jedis.set("jsonKey", json);

        // Redis에서 JSON 불러오기
        String retrievedJson = jedis.get("jsonKey");
        Character retrievedObject = objectMapper.fromJson(retrievedJson, Character.class);
        System.out.println("Retrieved Object: " + retrievedObject);

        jedis.close();

    }

}
