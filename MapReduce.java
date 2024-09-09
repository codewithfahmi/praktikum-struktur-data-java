import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;

class MapReduce {
    public String[] data = {
        "I wanna turn back the time",
        "And held your hand in mine",
        "Had I known you were in pain",
        "I'd be your sunshine in the rain",
        "I will light your darkest days",
        "So trust me baby, let me stay",
        "I promise you'll be okay",
        "'Cause I will be your sunshine in the rain"
    };

    public String[] prepare() {
        String[] data = new String[this.data.length];
        for(int i = 0;i < data.length;i++) {
            String temp = this.data[i].toLowerCase()
                                      .replaceAll("\\p{Punct}", "")
                                      .trim();
            data[i] = temp;
        }

        return data;
    }

    public String[] transform() {
        List<String> data = new ArrayList<>();
        for(String each : this.prepare()) {
            String[] splitted = each.split(" ");
            for(String __each : splitted) {
                data.add(__each);
            }
        }

        return data.toArray(new String[0]);
    }

    public HashMap<String, Integer> reduce() {
        HashMap<String, Integer> result = new HashMap<>();
        for(String each : this.transform()) {
            if(result.containsKey(each)) {
                result.put(each, result.get(each) + 1);
            } else {
                result.put(each, 1);
            }
        }
        return result;
    } 

    public LinkedHashMap<String, Integer> sort() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(this.reduce().entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }

        return sorted;
    }

    public static void main(String[] args) {
        MapReduce mapReduce = new MapReduce();
        System.out.println(mapReduce.sort().entrySet());
    }
}