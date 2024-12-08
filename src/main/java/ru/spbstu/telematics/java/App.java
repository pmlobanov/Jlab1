package ru.spbstu.telematics.java;
import java.lang.StringBuilder;
import java.security.SecureRandom;
class generator_UUID
{
    private  String bytesToBin(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1));
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public String getUUID()
    {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        StringBuilder str_bin = new StringBuilder(bytesToBin(bytes));
        //Вставка варианта (1-ый)
        str_bin.replace(64, 66, "10");
        //Вставка версии (4-ая)
        str_bin.replace(48, 52, "0100");
        //Создали список элементов по сколько 16-ти значных значений должно у нас быть
        String res = "";
        int number[] = {8,4,4,4,12};
        for(int i : number)
        {
            res += Long.toHexString(Long.parseUnsignedLong(str_bin.substring(0,i*4), 2));
            str_bin.delete(0, i*4);
            if(i!= 12) res+= "-";
        }
        return res;
    }
}


public class App 
{

    public static void main( String[] args )
    {
        generator_UUID t = new generator_UUID();
        System.out.println(t.getUUID());
    }
}