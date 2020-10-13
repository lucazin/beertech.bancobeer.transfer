package br.com.beertech.fusion.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Support {

    public static String getDataAtual() {
        SimpleDateFormat HoraFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = new Date();
        return HoraFormat.format(now);
    }
    public static String getIdentifyDate() {
        SimpleDateFormat HoraFormat = new SimpleDateFormat("ddMMyyyyHHmmss.sss");
        Date now = new Date();
        return HoraFormat.format(now);
    }
    public static Long CreateHash256Sha(long hashOrigem,long hashDestino)
    {
        try{
            String Key= String.valueOf(hashOrigem)+String.valueOf(hashDestino)+getIdentifyDate();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(Key.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            long HexLongNumber = UUID.nameUUIDFromBytes(hexString.toString().getBytes()).getMostSignificantBits();
            if(HexLongNumber < 0 )
                return HexLongNumber * (-1);
            else
                return HexLongNumber;

        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static Long CreateHash256Sha(String hashStr)
    {
        try{
            String Key= hashStr+getIdentifyDate();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(Key.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            long HexLongNumber = UUID.nameUUIDFromBytes(hexString.toString().getBytes()).getMostSignificantBits();
            if(HexLongNumber < 0 )
                return HexLongNumber * (-1);
            else
                return HexLongNumber;

        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
