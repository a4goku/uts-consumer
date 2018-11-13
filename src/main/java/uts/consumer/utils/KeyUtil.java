package uts.consumer.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

public class KeyUtil {
    public static String generatorUUID() {
        TimeBasedGenerator timeBaseGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        return timeBaseGenerator.generate().toString();
    }
}
