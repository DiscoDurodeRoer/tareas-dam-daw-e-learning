package programacuerposceletes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {
    
    @Override
    protected void writeStreamHeader() throws IOException {
        // No hace nada
    }
    
    public MiObjectOutputStream() throws IOException{
        super();
    }
    
    public MiObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
    
}
