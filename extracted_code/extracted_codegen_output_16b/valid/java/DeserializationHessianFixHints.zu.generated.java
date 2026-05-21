import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;

public class Hessian2Deserializer {
    public static Object deserialize(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        Hessian2Input h2in = new Hessian2Input(bais);
        return h2in.readObject();
    }
}