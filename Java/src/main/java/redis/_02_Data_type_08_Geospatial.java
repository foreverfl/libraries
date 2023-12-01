package redis;

import java.util.List;
import java.util.stream.Collectors;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.GeoUnit;
import redis.clients.jedis.resps.GeoRadiusResponse;

public class _02_Data_type_08_Geospatial {
    public static void main(String[] args) {

        Jedis jedis = JedisManager.getJedisInstance();

        jedis.del("bikes:rentable");

        // GEOADD: 공간 좌표를 추가함
        long res1 = jedis.geoadd("bikes:rentable", -122.27652, 37.805186, "station:1"); // Sorted Set(zset)으로 저장됨
        System.out.println(res1); // 1

        long res2 = jedis.geoadd("bikes:rentable", -122.2674626, 37.8062344, "station:2");
        System.out.println(res2);

        long res3 = jedis.geoadd("bikes:rentable", -122.2469854, 37.8104049, "station:3");
        System.out.println(res3);

        List<String> bikesRentables = jedis.zrange("bikes:rentable", 0, -1);
        for (String bikeStation : bikesRentables) {
            // 각 위치의 좌표 조회
            List<GeoCoordinate> coords = jedis.geopos("bikes:rentable", bikeStation);
            System.out.println("Station " + bikeStation + ": " + coords);
        }
        System.out.println("==================================================================");

        // GEOSEARCH: 공간 내에 속하는 공간 좌표를 찾음
        List<GeoRadiusResponse> res4 = jedis.geosearch(
                "bikes:rentable",
                new GeoCoordinate(-122.27652, 37.805186),
                5,
                GeoUnit.KM);
        List<String> members = res4.stream().map(GeoRadiusResponse::getMemberByString).collect(Collectors.toList());
        System.out.println(members);
        System.out.println("==================================================================");

        jedis.close();

    }
}
