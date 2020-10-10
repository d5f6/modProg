import java.util.HashMap;
import java.util.Map;

public aspect DataGeneratorAspect {
    private Map<Integer, Integer> dataCacheMap = new HashMap<>();

    public pointcut generateDataCell(int i) :
        execution(* DataGenerator.getData(int)) && args((i));

    public int around(int i) : generateDataCell(i) {
        int result = 0;

        if (dataCacheMap.containsKey(i)) {
            result = dataCacheMap.get(i);
        } else {
            result = proceed(i);
            dataCacheMap.put(i, result);
        }

        return result;
    }
}