package learn.services.hash;

import javax.inject.Singleton;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Singleton
public class Sha1HashService implements HashService{
    @Override
    public String hash(String data)
    {
        try {
            MessageDigest md =  MessageDigest.getInstance("SHA");
            md.update(data.getBytes());
            byte[] h = md.digest();
            StringBuilder sb = new StringBuilder();
            for(byte b: h)
            {
                sb.append(Integer.toHexString(b & 0xFF));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);

        }
    }
}
