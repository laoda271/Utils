import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by chenminghe on 2017/6/16.
 */
public class HttpClientTest {

    @Test
    public void testADJUST() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://10.13.16.153/signal");
        post.addHeader("Content-Type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sceneId","1");
        jsonObject.put("requestId","11");
        jsonObject.put("type","PROFILE_USERS");
        jsonObject.put("action","set");
        JSONObject dataJSON = new JSONObject();
        String image = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAd" +
                "Hx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5Ojf/2wBDAQoKCg0MDRoPDxo3JR8lNzc3Nzc3" +
                "Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzf/wAARCACKAGMDASIA" +
                "AhEBAxEB/8QAGwAAAgMBAQEAAAAAAAAAAAAAAAQBAwUGAgf/xABCEAACAQMBBAYHAwoFBQAAAAAB" +
                "AgMABBEFBhIhMRNBUWFxgRQiMkKRocEjUtEHFTNicoKSsbLCFqLS4fAlNDVTdP/EABQBAQAAAAAA" +
                "AAAAAAAAAAAAAAD/xAAUEQEAAAAAAAAAAAAAAAAAAAAA/9oADAMBAAIRAxEAPwD7hRUVNBBIAyTw" +
                "ql7uBAS0gAHXzrzqF3HaQb8nEkhVXGSxPIAVRbxyyMJZx9pzVM5Cf70FhupZf+2gbH35QUHw51Tc" +
                "R6nIv2V3bRn/AOdj/eKfVMcySa9bo7B8KDm5I9qIDvQXNjcge4yMuf5/zrS0fULq6jddSsWs50OC" +
                "N/eR+9Tw+BFadK3kEcxi6WFJVV84YZAPLl50DVFLSxPCnSWo4rzj6mHYOw17trhLiISIeB6uyguo" +
                "oooIooooJqCd0ZPKprH2jkZ7ZLKNiHu3ER3ee7zf/LkeLCgrsCdVvG1DOYFylrw4BeRk8W447FAP" +
                "XW0ihBha8W0K28CRIAqqAAByFW0BRRRQRUMoIwe3NeqW1C49FtWl4ZBAAPXxoGKQnRrK4NzGPsXP" +
                "2ydn647+3tHHq4tWdwl1bpMnJh8Oo1awDKQaAUhgCDkGppa0HRb0B4BOKD9X/b8KZoCiiiggnAJr" +
                "Ets3m0Ukh4x2kW6v7THif8vyFbUmdw45ngKy9nlUx3lwvKW6dVP6qfZj+knzoNaioqaAooqMgY76" +
                "BLULKe6dGh1G4tAoIYRBfWyDx4g8ckfCud13S5t5YRrWpMI4Zrl8unqgKQPd6y3Dwrpbu5SNTlwF" +
                "HM9n/OJ8qyp4JbzTdRnUYlvkFvDn3Yz6o+bMaBHZ+yugZrGTVrxDupcxFdzJSRRnmpzhlbs9qupt" +
                "ozFBHG0rzFVA6STG83ecACsrW19Aez1OIYS0PRTAf+hsAn90hW8A1aVnMJBImcmNyPI8R8iKDzfH" +
                "olS5HOI+t3qef40yDkZFVXib9rKo4kqcUvo0/T2EeeaeofLl8sUDtFFFBTezrbWstw/sxI0jeABP" +
                "0pDZRGTZzTw/tmEM57WPE/MmvO1bFdnr1BzlQRD98hfrTWiYOj2RHIwIfkKBwsAyjtqia5C3CwLx" +
                "fd3iO7kPjx+Bqq9n6GRXIJ3QcAcSTwAHzpLZ/pJI7jUrtvWuHLIx4KsY4LjuwM+B7c0GszCOMtIw" +
                "HaTWYb83N0VgzuL6iEe83vHwAwPEnsrOe8k1y8dYnMenQrvvIOBZeYOe1uY7FGfeFWCY2enNcxwg" +
                "zzKBBCOGAfYXu7T2CgVvJW1TXo9HtWzFbgS3jjkAfZXxP9PiK19SXUAFEF1DZwp7O5bmeQ8OzkPg" +
                "anZvRxpNiRI3SXc7ma5lI4vI3PyHAAdQFcL+V7S9o9Z02aXTGlFnZToDZxpvekLu5aRl94BiF3cH" +
                "2WPHhQdtpt1bXu/atqbXjlSHRhFxHWCFHAeNI2k0mj6vBp87MyOBFFIx9tMncz3j1lPb6p68Vw/5" +
                "ONlPzisuqa7HEJ5IwkUsFmtt0DhhuGPdVfWHrZIHWAc8RXW7YrOdU0yGBs3LgNE5HvxneHkTQdme" +
                "IwaxdEboL+9s26nLr39vyK1qWdwl3aQ3MXsSoHXPYRmkujWPXt48Olh3ge9eHzBPwoNOijFFBj7T" +
                "ENaxxdpaQjuVT9StM6D/AOHtB92ML8OH0pLaNt2Kdzyjt8A97MM/00/o43bIJ91iPr9aDI2oumjt" +
                "dQihfE4iG7jmu9jB+K1DRnXehgtiE0iJF3sH9Pw9VB+p2nrHLgc142q09ZjJeNI6rEUWUZ4GM4z4" +
                "cevsz3YX/JhqAudDnsXcNPp1y8Dke8Oat4EH5UG3f20Vtpno68I5ZB0zdbAnLnxIBHyFNQ2280c1" +
                "wg6UZbH3WPD5DhRJH6VeoG/RWx3iPvSEcPgDnxI7KcoIqi5s7e6ZWnjDOnsuCVZfAjiKYooK1gjB" +
                "U7u8V5FiWI8zXG7azrDtTs4GOFJmLnOMDC8SfjXbV8t2+H5z/KBYWIHSRWtkJJVABALu2Ac/sg4+" +
                "lB2uyV2l1ZXHRDEC3DmDviY7ynzzw7sUzqR6O8tJh7kgU+DHd/k1J6IBbX7W4JO/AjEk+8C2f6hT" +
                "mtIWiYKPW3GI8Rx+lBp0UKQyhhyPEUUGJtYP+lPu+0x+OBWhp5CpKOrpB81U/WkdpDvQFOeEyfN1" +
                "X6mrFl6Gwu5vuRiT+FB/poGL+Pehu1PsyQH4jP4iuEtLj8w7b2V3wSx1fToUuMDAWRSEV/IlV/fz" +
                "1V9CuAHjA573qjzBrgdeiD6Zs7dMqMolmtHDjgVdW592YxQfQ0UKDjrJJr1WNp18ltBDHNKzwMej" +
                "jlkOWVgPZc+R9b48eJ2M9lAVOaivEsqQoXkYKo+fd30FOp39rpen3F/fSrFbW6F5HY8gK+Y7IdNq" +
                "mr32u3ilbm+m3kRj+iQDCL3YUDJ/kSSiW3Wr3Ov65Lp1xMbTT7N23YSQCzKAekkPHlngMHHA8ScU" +
                "7sxMvo7rArdBECDvDJc893B7zkjrJCk+2zB2lkQdajZMlVg3QfF0OfMHPgR1k1r3RDXkCHrz81b8" +
                "Kz7GHcie5b2jIMnOc8QefX1caZuJM6laHtyD5HH1oNGFSkKKfdUD5UVIGBiigx9aG9bXr9jwR/B1" +
                "P91REOn069h7YWQ/w4/Grtfj3NHvXXmMSn90qf7aX0hsy6omf0cpTH8X0IoGNEuTd7PaVdMcma3g" +
                "kPmqn61kR6et/onorFlEGovulDxUb7YI8mB8687C3Jk2E08k5MDmA925MUHyArY0ldy7vVHsySmT" +
                "l+7j/L8+6gwtTSSPZu5eNVLwqk6gcAAjBmPhugjryFHOvelXF/DZme2k+zBA9HkRnXPUBjiCeeBk" +
                "Dsqdaa5/Nl3bRjennPo2FIOWcbvDtALDPnnHCuhhtDapGsIDRqeCjhjJOST1nt86DOg1DaC7bdj0" +
                "a3tUzxmubrPDtCKuT4ErWpbWjI/TXUxnn6mK7qp3KvV8z301U0Hx7anTIv8AGN+8zMCZ42QFeDFl" +
                "UgD73EnhyyBkjhjatjbQ6TMsSIqLCd0L75ZSRnxBLfsnPOQhew1XRLe+ufSJULl1ETqCRlc4zwPY" +
                "TzzWZf7NRxJJP0zMN1x0eAFyx4YHmM8eOO80DtpcGaLVowSRDPwJ5n1VP414dw05mHEQXAJ8Gcf6" +
                "s+VJ7NSia51ZieEzdJ/E0v0ApzQ06aTUonwQrpGQf2Bmg36KAMADOaKCu7gW6tZrd/ZlRkPgRisL" +
                "Z/JvdeQnLi4APj0a/XNdF1VjaTbG01W9V/anUTHzkk/kCooOc2GJi2U1OPPCHUZiO4Flf+6ulsgj" +
                "3U0YLZZpd4g4ON/l3f8AO2sDZmzntdA15JUKlrmR0z1jcUfSuo02LAaXHtu5znqLkj+dBZLbBJIJ" +
                "IY1xCGUIABwOOXV1VatxGThiVPY6kVbRQKw39tM7qkqEKSN7eGDjnVqy9IfsgSv3zy8u2vXRoWDF" +
                "FLduK90EAY680lrR3dLuH+4oc+AIP0p6qriETwvExIDDGRQcZoKPZy3AcFWxAHXsJE2Rnr4mtfY9" +
                "+mj1Gf792f6E/Gqtpk9DQyxL+kCoMdbgPu/M0/szaGzsJEIwWmZuXVwA+QFBr0UUUBSd0pS9tZxy" +
                "9aJu4Ngj5rjzpyjGedBSYFMMkQHqvnPnXjTVKafbK3tCJQfHHGmaKAqOupooCiiigKKKKBO/sheS" +
                "2pkxuQyiQjtI5U0Fwcjwr1RQFFFFB//Z";
        dataJSON.put("code","1142");
        dataJSON.put("message","AA");
        dataJSON.put("image",image);
        dataJSON.put("count","1");
        jsonObject.put("data",dataJSON);

        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"UTF-8");
        post.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());

    }

    @Test
    public void test_ADJUST_POSISTION() throws Exception {

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://10.13.16.153/signal");
        post.addHeader("Content-Type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sceneId","1");
        jsonObject.put("requestId","11");
        jsonObject.put("type","PROFILE_USERS");
        jsonObject.put("action","set");
        JSONObject dataJSON = new JSONObject();

        String path = "d:/u1.png";
//        String path = "d:/u2.jpg";
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        // base64的常量串太长,通过文件进行读取
        String image = new BASE64Encoder().encode(buffer);
        dataJSON.put("code","1144");
        dataJSON.put("message","AA");
        dataJSON.put("image",image);
        dataJSON.put("count","1");
        jsonObject.put("data",dataJSON);

        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"UTF-8");
        post.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(post);

        System.out.println(response.getStatusLine().getStatusCode());
    }

    @Test
    public void testUPLOAD() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://10.13.16.153/signal");
        post.addHeader("Content-Type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sceneId","1");
        jsonObject.put("requestId","11");
        jsonObject.put("type","PROFILE_USERS");
        jsonObject.put("action","set");
        JSONObject dataJSON = new JSONObject();
        String image = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAd" +
                "Hx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5Ojf/2wBDAQoKCg0MDRoPDxo3JR8lNzc3Nzc3" +
                "Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzf/wAARCACKAGMDASIA" +
                "AhEBAxEB/8QAGwAAAgMBAQEAAAAAAAAAAAAAAAQBAwUGAgf/xABCEAACAQMBBAYHAwoFBQAAAAAB" +
                "AgMABBEFBhIhMRNBUWFxgRQiMkKRocEjUtEHFTNicoKSsbLCFqLS4fAlNDVTdP/EABQBAQAAAAAA" +
                "AAAAAAAAAAAAAAD/xAAUEQEAAAAAAAAAAAAAAAAAAAAA/9oADAMBAAIRAxEAPwD7hRUVNBBIAyTw" +
                "ql7uBAS0gAHXzrzqF3HaQb8nEkhVXGSxPIAVRbxyyMJZx9pzVM5Cf70FhupZf+2gbH35QUHw51Tc" +
                "R6nIv2V3bRn/AOdj/eKfVMcySa9bo7B8KDm5I9qIDvQXNjcge4yMuf5/zrS0fULq6jddSsWs50OC" +
                "N/eR+9Tw+BFadK3kEcxi6WFJVV84YZAPLl50DVFLSxPCnSWo4rzj6mHYOw17trhLiISIeB6uyguo" +
                "oooIooooJqCd0ZPKprH2jkZ7ZLKNiHu3ER3ee7zf/LkeLCgrsCdVvG1DOYFylrw4BeRk8W447FAP" +
                "XW0ihBha8W0K28CRIAqqAAByFW0BRRRQRUMoIwe3NeqW1C49FtWl4ZBAAPXxoGKQnRrK4NzGPsXP" +
                "2ydn647+3tHHq4tWdwl1bpMnJh8Oo1awDKQaAUhgCDkGppa0HRb0B4BOKD9X/b8KZoCiiiggnAJr" +
                "Ets3m0Ukh4x2kW6v7THif8vyFbUmdw45ngKy9nlUx3lwvKW6dVP6qfZj+knzoNaioqaAooqMgY76" +
                "BLULKe6dGh1G4tAoIYRBfWyDx4g8ckfCud13S5t5YRrWpMI4Zrl8unqgKQPd6y3Dwrpbu5SNTlwF" +
                "HM9n/OJ8qyp4JbzTdRnUYlvkFvDn3Yz6o+bMaBHZ+yugZrGTVrxDupcxFdzJSRRnmpzhlbs9qupt" +
                "ozFBHG0rzFVA6STG83ecACsrW19Aez1OIYS0PRTAf+hsAn90hW8A1aVnMJBImcmNyPI8R8iKDzfH" +
                "olS5HOI+t3qef40yDkZFVXib9rKo4kqcUvo0/T2EeeaeofLl8sUDtFFFBTezrbWstw/sxI0jeABP" +
                "0pDZRGTZzTw/tmEM57WPE/MmvO1bFdnr1BzlQRD98hfrTWiYOj2RHIwIfkKBwsAyjtqia5C3CwLx" +
                "fd3iO7kPjx+Bqq9n6GRXIJ3QcAcSTwAHzpLZ/pJI7jUrtvWuHLIx4KsY4LjuwM+B7c0GszCOMtIw" +
                "HaTWYb83N0VgzuL6iEe83vHwAwPEnsrOe8k1y8dYnMenQrvvIOBZeYOe1uY7FGfeFWCY2enNcxwg" +
                "zzKBBCOGAfYXu7T2CgVvJW1TXo9HtWzFbgS3jjkAfZXxP9PiK19SXUAFEF1DZwp7O5bmeQ8OzkPg" +
                "anZvRxpNiRI3SXc7ma5lI4vI3PyHAAdQFcL+V7S9o9Z02aXTGlFnZToDZxpvekLu5aRl94BiF3cH" +
                "2WPHhQdtpt1bXu/atqbXjlSHRhFxHWCFHAeNI2k0mj6vBp87MyOBFFIx9tMncz3j1lPb6p68Vw/5" +
                "ONlPzisuqa7HEJ5IwkUsFmtt0DhhuGPdVfWHrZIHWAc8RXW7YrOdU0yGBs3LgNE5HvxneHkTQdme" +
                "IwaxdEboL+9s26nLr39vyK1qWdwl3aQ3MXsSoHXPYRmkujWPXt48Olh3ge9eHzBPwoNOijFFBj7T" +
                "ENaxxdpaQjuVT9StM6D/AOHtB92ML8OH0pLaNt2Kdzyjt8A97MM/00/o43bIJ91iPr9aDI2oumjt" +
                "dQihfE4iG7jmu9jB+K1DRnXehgtiE0iJF3sH9Pw9VB+p2nrHLgc142q09ZjJeNI6rEUWUZ4GM4z4" +
                "cevsz3YX/JhqAudDnsXcNPp1y8Dke8Oat4EH5UG3f20Vtpno68I5ZB0zdbAnLnxIBHyFNQ2280c1" +
                "wg6UZbH3WPD5DhRJH6VeoG/RWx3iPvSEcPgDnxI7KcoIqi5s7e6ZWnjDOnsuCVZfAjiKYooK1gjB" +
                "U7u8V5FiWI8zXG7azrDtTs4GOFJmLnOMDC8SfjXbV8t2+H5z/KBYWIHSRWtkJJVABALu2Ac/sg4+" +
                "lB2uyV2l1ZXHRDEC3DmDviY7ynzzw7sUzqR6O8tJh7kgU+DHd/k1J6IBbX7W4JO/AjEk+8C2f6hT" +
                "mtIWiYKPW3GI8Rx+lBp0UKQyhhyPEUUGJtYP+lPu+0x+OBWhp5CpKOrpB81U/WkdpDvQFOeEyfN1" +
                "X6mrFl6Gwu5vuRiT+FB/poGL+Pehu1PsyQH4jP4iuEtLj8w7b2V3wSx1fToUuMDAWRSEV/IlV/fz" +
                "1V9CuAHjA573qjzBrgdeiD6Zs7dMqMolmtHDjgVdW592YxQfQ0UKDjrJJr1WNp18ltBDHNKzwMej" +
                "jlkOWVgPZc+R9b48eJ2M9lAVOaivEsqQoXkYKo+fd30FOp39rpen3F/fSrFbW6F5HY8gK+Y7IdNq" +
                "mr32u3ilbm+m3kRj+iQDCL3YUDJ/kSSiW3Wr3Ov65Lp1xMbTT7N23YSQCzKAekkPHlngMHHA8ScU" +
                "7sxMvo7rArdBECDvDJc893B7zkjrJCk+2zB2lkQdajZMlVg3QfF0OfMHPgR1k1r3RDXkCHrz81b8" +
                "Kz7GHcie5b2jIMnOc8QefX1caZuJM6laHtyD5HH1oNGFSkKKfdUD5UVIGBiigx9aG9bXr9jwR/B1" +
                "P91REOn069h7YWQ/w4/Grtfj3NHvXXmMSn90qf7aX0hsy6omf0cpTH8X0IoGNEuTd7PaVdMcma3g" +
                "kPmqn61kR6et/onorFlEGovulDxUb7YI8mB8687C3Jk2E08k5MDmA925MUHyArY0ldy7vVHsySmT" +
                "l+7j/L8+6gwtTSSPZu5eNVLwqk6gcAAjBmPhugjryFHOvelXF/DZme2k+zBA9HkRnXPUBjiCeeBk" +
                "Dsqdaa5/Nl3bRjennPo2FIOWcbvDtALDPnnHCuhhtDapGsIDRqeCjhjJOST1nt86DOg1DaC7bdj0" +
                "a3tUzxmubrPDtCKuT4ErWpbWjI/TXUxnn6mK7qp3KvV8z301U0Hx7anTIv8AGN+8zMCZ42QFeDFl" +
                "UgD73EnhyyBkjhjatjbQ6TMsSIqLCd0L75ZSRnxBLfsnPOQhew1XRLe+ufSJULl1ETqCRlc4zwPY" +
                "TzzWZf7NRxJJP0zMN1x0eAFyx4YHmM8eOO80DtpcGaLVowSRDPwJ5n1VP414dw05mHEQXAJ8Gcf6" +
                "s+VJ7NSia51ZieEzdJ/E0v0ApzQ06aTUonwQrpGQf2Bmg36KAMADOaKCu7gW6tZrd/ZlRkPgRisL" +
                "Z/JvdeQnLi4APj0a/XNdF1VjaTbG01W9V/anUTHzkk/kCooOc2GJi2U1OPPCHUZiO4Flf+6ulsgj" +
                "3U0YLZZpd4g4ON/l3f8AO2sDZmzntdA15JUKlrmR0z1jcUfSuo02LAaXHtu5znqLkj+dBZLbBJIJ" +
                "IY1xCGUIABwOOXV1VatxGThiVPY6kVbRQKw39tM7qkqEKSN7eGDjnVqy9IfsgSv3zy8u2vXRoWDF" +
                "FLduK90EAY680lrR3dLuH+4oc+AIP0p6qriETwvExIDDGRQcZoKPZy3AcFWxAHXsJE2Rnr4mtfY9" +
                "+mj1Gf792f6E/Gqtpk9DQyxL+kCoMdbgPu/M0/szaGzsJEIwWmZuXVwA+QFBr0UUUBSd0pS9tZxy" +
                "9aJu4Ngj5rjzpyjGedBSYFMMkQHqvnPnXjTVKafbK3tCJQfHHGmaKAqOupooCiiigKKKKBO/sheS" +
                "2pkxuQyiQjtI5U0Fwcjwr1RQFFFFB//Z";
        dataJSON.put("code","116");
        dataJSON.put("message","AA");
        dataJSON.put("image",image);
        dataJSON.put("count","1");
        jsonObject.put("data",dataJSON);

        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"UTF-8");
        post.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());

    }
}
