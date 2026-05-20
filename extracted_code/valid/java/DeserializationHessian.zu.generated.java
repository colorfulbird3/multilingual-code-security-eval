import com.caucho.hessian.io.Hessian2Input;

public class HessianService {
    public Object deserializeUserData(byte[] serializedData) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
        Hessian2Input hi = new Hessian2Input(bais);
        Object obj = hi.readObject();
        hi.close();
        return obj;
    }
}